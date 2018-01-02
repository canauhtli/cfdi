package com.canauhtli.cfdi;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




import com.canauhtli.cfdi.db.DBManager;
import com.canauhtli.cfdi.db.ReciboNomina;
import com.canauhtli.cfdi.nomina.HoraExtraNom;
import com.canauhtli.cfdi.nomina.OtroPago;
import com.canauhtli.cfdi.nomina.ProcesoNomina;
import com.canauhtli.cfdi.nomina.ReciboCorreo;
import com.canauhtli.cfdi.nomina.ReciboNominaEmp;
import com.canauhtli.cfdi.nomina.Salario;
import com.canauhtli.cfdi.pac.ClienteFactory;
import com.canauhtli.cfdi.pac.ClientePACException;
import com.canauhtli.cfdi.pac.ClienteServicioPAC;
import com.canauhtli.cfdi.pac.bean.Direccion;
import com.canauhtli.cfdi.pac.bean.Entidad;
import com.canauhtli.cfdi.pac.types.CodigoPais;
import com.canauhtli.cfdi.pac.types.Estado;
import com.canauhtli.cfdi.reportes.DocumentoPDF;
import com.canauhtli.cfdi.reportes.PercepcionDeduccion;
import com.canauhtli.cfdi.tipo.Accion;
import com.canauhtli.cfdi.tipo.Estatus;
import com.canauhtli.config.AppConfig;
import com.canauhtli.config.ConfigManager;
import com.canauhtli.utils.ClienteSMTP;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class CfdiNomina {

	private static Logger log = LoggerFactory.getLogger(CfdiNomina.class);
	
	private DBManager madb;
	private ConfigManager cm;
	
	public CfdiNomina() {
		try {
			validaDB();
			madb = new DBManager();
			cm = new ConfigManager(madb);
		} catch(CFDIException cfdie) {
			escribeError(cfdie.getMessage());
			System.exit(1);
		}
		
	}
	
	public static void main(String[] args) {
		
		if (args.length == 0) {
			escribeError("No se indico la acción" + printUso());
			System.exit(1);
		}
		Accion acc = Accion.fromArg(args[0]);
		if (acc == null) {
			escribeError("Accion no reconocida" + printUso());
			log.error("La accion <{}> no es reconocida", args[0]);
			System.exit(1);
		}
		
		CfdiNomina nom = new CfdiNomina();
		try {
			switch (acc) {
			case EXTRAER:
				log.debug("Extraer factura");
//				int folioExt = con.validaCanExt(args);
//				String serieExt = args[1];
//				String ref = args[3];
//				con.extrae(serieExt, folioExt, ref);
				break;
			case CANCELAR:
				log.debug("Cancelar recibos de nomina");
				nom.canclear(args);
				break;
			case GENERAR:
				log.debug("Inicia emisión proceso de nómina");
				nom.generar(args);
				break;
			case BUSCAR:
				log.debug("Buscar factura");
				break;
			case IMPRESORAS:
				log.debug("Mostrar impresoras");
//				muestraImpresoras();
			}
		} catch (CFDIException fe) {
			escribeError(fe.getMessage());
		} 

	}
	
	private void generar(String args[]) throws CFDIException {
		if (args.length < 3) {
			throw new CFDIException("Parametros incorrectos al invocar Generar");
		}
		
		File entrada = new File(args[2]);
		if ((!entrada.isFile()) && (!entrada.canRead())) {
			throw new CFDIException("No se puede leer el archivo origen");
		}
		String periodo = args[1];
		log.info("Generar proceso para periodo {} con el archivo de entrada {}", periodo, entrada.getName());
		
		try {
			ClienteServicioPAC pac = ClienteFactory.getCliente(cm.getProveedorConfig(cm.getProveedor()));
			
			Generador gen = new Generador(madb);
			gen.setEmisor(initEmisor());
			int pid = gen.inicializa(periodo, entrada);
			gen.leeEntrada();
			gen.registraEntrada();
			gen.validaRecibos();
			ProcesoNomina pn = gen.generaRecibos(pac);
			if (pn.tengoRecibos()) {
				generaPdf(periodo, pid, pn.getRecibos());
				escribeResultado(periodo, pn.getRecibos());
				if ("1".equals(cm.getMailConfig("enviarCorreo"))) {
					enviaRecibos(periodo, pn.getRecibos());
				}
			}
		} catch (ClientePACException e) {
			log.error("No fue posible inicializar al proveedor {}", cm.getProveedor(), e);
		}
	}
	
	private void canclear(String args[]) throws CFDIException {
		if (args.length < 2) {
			throw new  CFDIException("Parametros incorrectos al invocar Cancelar");
		}
		
		File entrada = new File(args[1]);
		if ((!entrada.isFile()) && (!entrada.canRead())) {
			throw new CFDIException("No se puede leer el archivo origen");
		}
		
		log.info("Inicia proceso de cancelación con el archivo de entrada {}", entrada.getName());
		
		try {
			ClienteServicioPAC pac = ClienteFactory.getCliente(cm.getProveedorConfig(cm.getProveedor()));
			Cancelador cancelador = new Cancelador(madb);
			cancelador.leerArchivo(entrada);
			cancelador.cancelar(pac);
		} catch (ClientePACException e) {
			log.error("No fue posible inicializar al proveedor {}", cm.getProveedor(), e);
		}
	}
	
	private void enviaRecibos(String periodo, ArrayList<ReciboNominaEmp> recibos) {
		ClienteSMTP smtp = new ClienteSMTP(cm);
		for (ReciboNominaEmp recibo : recibos) {
			if (!"".equals(recibo.getEmpleado().getCorreo())) {
				ReciboCorreo rc = new ReciboCorreo();
				rc.setCorreo(recibo.getEmpleado().getCorreo());
				rc.setMsg(cm.getMailConfig("mensaje"));
				rc.setNombre(recibo.getReceptor().getNombre());
				rc.setNumEmp(recibo.getEmpleado().getNumEmp());
				rc.setPathPdf(recibo.getPathPdf());
				rc.setXml(recibo.getXml());
				smtp.addRecibo(rc);
			}
		}
		log.info("Tengo {} correos para enviar", smtp.getRecibos().size());
		try {
			smtp.enviaCorreos();
		} catch (CFDIException e) {
			log.error("No me fue posible eviar correctemente los recibos por correo", e);
		}
		for (ReciboCorreo rc : smtp.getRecibos()) {
			if (rc.isEnviado()) {
				for (ReciboNominaEmp recibo : recibos) {
					if (recibo.getEmpleado().getNumEmp() == rc.getNumEmp()) {
						ReciboNomina rn = madb.obtenReciboNomina(recibo.getId());
						rn.setEstatus(Estatus.ENVIADO.getEstatus());
						madb.actualizaReciboNomina(rn);
						continue;
					}
				}
			}
		}
	}
	
	private void generaPdf(String periodo, int pid, ArrayList<ReciboNominaEmp> recibos) {
		DocumentoPDF dpdf = new DocumentoPDF();
        dpdf.setCopias(Integer.parseInt(cm.getGeneralConfig("copias")));
        dpdf.setImpresora(cm.getGeneralConfig("impresora"));
        dpdf.setImprimir(cm.getGeneralConfig("imprimir").equals("1"));
        dpdf.setPlantilla(cm.getGeneralConfig("plantilla"));
        String path = cm.getGeneralConfig("carpetaSalida") + "/" + periodo + "_" + pid;
        File carpetaDir = new File(path);
        if (!carpetaDir.exists()) {
        	carpetaDir.mkdirs();
        }
        
        for (ReciboNominaEmp recibo : recibos) {
        	if (Estatus.EMITIDO == recibo.getEstatus()) {
        		dpdf.resetParams();
        		String pdffn = path + "/" + recibo.getEmpleado().getNumEmp() + ".pdf";
        		recibo.setPathPdf(pdffn);
        		dpdf.setNombre(pdffn);
        		try {
					llenaParametros(dpdf, recibo);
					ArrayList<PercepcionDeduccion> lstpd = generaListaPerDed(recibo.getPercepciones(), recibo.getDeducciones(), recibo.getOtrosPagos());
	                dpdf.generaReciboNomina(lstpd);
				} catch (CFDIException e) {
					log.error("No pude generar recibo PDF para {}", recibo.getEmpleado().getNumEmp());
				}
        	}
        }
	}
	
	private void llenaParametros(DocumentoPDF dpdf, ReciboNominaEmp recibo) throws CFDIException {
        SimpleDateFormat sdfcfdi = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfnom = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.00");
        dpdf.addParam("patLogo", cm.getGeneralConfig("logo"));
        dpdf.addParam("patRFC", cm.getEmisorConfig("rfc"));
        dpdf.addParam("patRegPat", cm.getEmisorConfig("registroPatronal"));
        dpdf.addParam("cfdiFolio", recibo.getTimbre().getUUID());
        dpdf.addParam("cfdiSerieSAT", recibo.getTimbre().getNoCertificadoSAT());
        dpdf.addParam("cfdiSerieEmisor", recibo.getCfdi().getNoCertificado());
        Calendar fcert = Calendar.getInstance();
        fcert.setTimeInMillis(recibo.getTimbre().getFechaTimbrado().toGregorianCalendar().getTimeInMillis());
        dpdf.addParam("cfdiFechaCertificacion", sdfcfdi.format(fcert.getTime()));
        Calendar femision = Calendar.getInstance();
        femision.setTimeInMillis(recibo.getCfdi().getFecha().toGregorianCalendar().getTimeInMillis());
        dpdf.addParam("cfdiFechaEmision", sdfcfdi.format(femision.getTime()));
        dpdf.addParam("numRecibo", recibo.getGenerales().getNumRecibo());
        dpdf.addParam("fechaPago", sdfnom.format(recibo.getEmpleado().getFechaPago()));
        dpdf.addParam("empNum", "" + recibo.getEmpleado().getNumEmp());
        dpdf.addParam("empDepto", recibo.getEmpleado().getDepartamento());
        dpdf.addParam("empNombre", recibo.getReceptor().getNombre());
        dpdf.addParam("empIMSS", recibo.getEmpleado().getNss());
        dpdf.addParam("empRFC", recibo.getReceptor().getRfc());
        dpdf.addParam("empDias", "" + recibo.getEmpleado().getNumDiasPagados());
        int he = 0;
        if (recibo.getHorasExtra() != null) {
            for (HoraExtraNom h : recibo.getHorasExtra()) {
                he += h.getHoras();
            }
        }
        dpdf.addParam("empHExt", "" + he);
        dpdf.addParam("empPeriodicidad", recibo.getEmpleado().getPeriodicidad());
        dpdf.addParam("empFechaIni", sdfnom.format(recibo.getEmpleado().getFechaIniPago()));
        dpdf.addParam("empFechaFin", sdfnom.format(recibo.getEmpleado().getFechaFinPago()));
        dpdf.addParam("totalPercepciones", df.format(recibo.getTotales().getTotalPercepciones()));
        dpdf.addParam("totalDeducciones", df.format(recibo.getTotales().getTotalDeducciones()));
        dpdf.addParam("totalPagar", recibo.getTotales().getTotalPercepciones() - recibo.getTotales().getTotalDeducciones());
        StringBuilder qrCode = new StringBuilder("?re=").append(cm.getEmisorConfig("rfc"));
        qrCode.append("&rr=").append(recibo.getReceptor().getRfc());
        qrCode.append("&tt=").append(""+ (recibo.getTotales().getTotalPercepciones() - recibo.getTotales().getTotalDeducciones()));
        qrCode.append("&id=").append(recibo.getTimbre().getUUID());
        dpdf.addParam("qrCode", genQRCode(qrCode.toString(), recibo.getEmpleado().getNumEmp()));
        dpdf.addParam("selloEmisor", recibo.getTimbre().getSelloCFD());
        dpdf.addParam("selloSAT", recibo.getTimbre().getSelloSAT());
        dpdf.addParam("cadenaOriginal", recibo.getCadenaOriginal());
    }
	
	private ArrayList<PercepcionDeduccion> generaListaPerDed(ArrayList<Salario> percepciones, ArrayList<Salario> deducciones, ArrayList<OtroPago> otrosPagos) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        ArrayList<PercepcionDeduccion> lst = new ArrayList<PercepcionDeduccion>();
        
        if (percepciones != null) {
        	for (Salario p : percepciones) {
        		PercepcionDeduccion pd = new PercepcionDeduccion();
        		pd.setPerClave(p.getClave());
                pd.setPerConcepto(p.getConcepto());
                if (p.getImporteExcento() > 0) {
                	pd.setPerImporte(df.format(p.getImporteExcento()));
                } else if (p.getImporteGravado() > 0) {
                	pd.setPerImporte(df.format(p.getImporteGravado()));
                }
                lst.add(pd);
        	}
        }
        
//        if (otrosPagos != null) {
//        	for (OtroPago op : otrosPagos) {
//        		PercepcionDeduccion pd = new PercepcionDeduccion();
//        		pd.setPerClave(op.getClave());
//        		pd.setPerConcepto(op.getConcepto());
//        		pd.setPerImporte(df.format(op.getImporte()));
//        		lst.add(pd);
//        	}
//        }
        
        if (deducciones != null) {
        	int i = 0;
        	while (i < deducciones.size()) {
        		PercepcionDeduccion pd = null;
        		if (i >= lst.size()) {
        			pd = new PercepcionDeduccion();
        			lst.add(pd);
        		} else {
        			pd = lst.get(i);
        		}
        		 pd.setDedClave(deducciones.get(i).getClave());
                 pd.setDedConcepto(deducciones.get(i).getConcepto());
                 if (deducciones.get(i).getImporteExcento() > 0) {
                 	pd.setDedImporte(df.format(deducciones.get(i).getImporteExcento()));
                 } else if (deducciones.get(i).getImporteGravado() > 0) {
                 	pd.setDedImporte(df.format(deducciones.get(i).getImporteGravado()));
                 }
                 i++;
        	}
        }
        
        return lst;
    }
	
	private InputStream genQRCode(String qrString, String numEmp) throws CFDIException {
        ByteArrayInputStream is = null;
        try {
            BufferedImage bi = MatrixToImageWriter.toBufferedImage((BitMatrix)new QRCodeWriter().encode(qrString, BarcodeFormat.QR_CODE, 125, 125));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage)bi, "gif", os);
            is = new ByteArrayInputStream(os.toByteArray());
        }
        catch (WriterException we) {
            log.error("No fue posible generar QRCode", we);
            throw new CFDIException("Generando QRCode para el empleado " + numEmp);
        }
        catch (IOException ioe) {
            log.error("No fue posible generar QRCode", ioe);
            throw new CFDIException("Generando QRCode para el empleado " + numEmp);
        }
        return is;
    }

	private Entidad initEmisor() {
		Entidad emisor = new Entidad();
		emisor.setRazonSocial(cm.getEmisorConfig("razonSocial"));
		emisor.setRegimenFiscal(cm.getEmisorConfig("regimenFiscal"));
		emisor.setRegistroPatronal(cm.getEmisorConfig("registroPatronal"));
		emisor.setRfc(cm.getEmisorConfig("rfc"));
		emisor.setCodigoPais(CodigoPais.MX);
		Direccion direccion = new Direccion();
		direccion.setCalle(cm.getEmisorConfig("calle"));
		direccion.setCiudad(cm.getEmisorConfig("ciudad"));
		direccion.setColonia(cm.getEmisorConfig("colonia"));
		direccion.setCp(cm.getEmisorConfig("cp"));
		direccion.setEstado(Estado.fromEstado(cm.getEmisorConfig("estado")));
		direccion.setMunicipio(cm.getEmisorConfig("municipio"));
		direccion.setNumExt(cm.getEmisorConfig("numeroExterior"));
		direccion.setNumInt(cm.getEmisorConfig("numeroInterior"));
		direccion.setPais(cm.getEmisorConfig("pais"));
		emisor.setDireccion(direccion);
		return emisor;
	}
	
	private void validaDB() throws CFDIException {
		if ("".equals(AppConfig.getUserVal("dbUsr"))) {
			throw new CFDIException("No se ha configurado el usuario de la BD");
		}
		if ("".equals(AppConfig.getUserValEnc("dbPwd"))) {
			throw new CFDIException("No se ha configurado el password de la BD");
		}
		if ("".equals(AppConfig.getUserVal("dbServer"))) {
			throw new CFDIException("No se ha configurado el servidor de la BD");
		}
		if ("".equals(AppConfig.getUserVal("dbName"))) {
			throw new CFDIException("No se ha configurado el nombre de la BD");
		}
	}
	
	private void escribeResultado(String periodo, ArrayList<ReciboNominaEmp> recibos) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmm");
        String path = cm.getGeneralConfig("carpetaSalida");
        BufferedWriter bw = null;
        Calendar fres = Calendar.getInstance();
        try {
        	bw = new BufferedWriter(new FileWriter(new File(path + "/" + periodo + "_" + sdf.format(fres.getTime()) + ".sal")));
        	for (ReciboNominaEmp recibo : recibos) {
        		bw.write(recibo.getEmpleado().getNumEmp() + " " + recibo.getEstatus()); 
        		if (recibo.getTimbre() != null) {
        			bw.write(" - " + recibo.getTimbre().getUUID());
        		}
        		bw.newLine();
        	}
                
        } catch (IOException e) {
        	log.error("Problema para generar archivo de salida", e);
        } finally {
            try {
                if (bw != null) { bw.close(); }
            } catch (IOException e) {
                log.warn("cerrando archivo", e);
            }
        }
    }
	
	private static void escribeError(String msg) {
		BufferedWriter bw = null;
		log.error(msg);
		try {
			bw = new BufferedWriter(new FileWriter(new File("salida.txt")));
			bw.write("0");
			bw.newLine();
			bw.write(msg);
			bw.flush();
		} catch (IOException e) {
			log.error("No pude escribir salida de error", e);
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e1) {
				log.warn("cerrando salida err");
			}
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				log.warn("cerrando salida err");
			}
		}
	}
	
	private static String printUso() {
		String nl = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder(nl);
		sb.append("Se debe idicar la acción a realizar: G | C | B | E")
		  .append(nl).append(nl)
		  .append("Generar: G <archivo factura>").append(nl)
		  .append("\t Ruta del archivo con los datos de la factura").append(nl)
		  .append("Cancelar: C <Serie> <Folio>").append(nl)
		  .append("\t Serie y núm. Folio de la factura a cancelar").append(nl)
		  .append("Buscar: B <archvio busqueda>").append(nl)
		  .append("\t Ruta del archivo con los datos de la busqueda").append(nl)
		  .append("Extraer: E <Serie> <Folio>").append(nl)
		  .append("\t Serie y núm. Folio de la factura a extraer").append(nl);
		return sb.toString();
	}
	
}
