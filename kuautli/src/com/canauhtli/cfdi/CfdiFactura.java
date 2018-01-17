package com.canauhtli.cfdi;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.cfdi.factura.Comentario;
import com.canauhtli.cfdi.factura.ConceptoFac;
import com.canauhtli.cfdi.factura.Factura;
import com.canauhtli.cfdi.factura.FacturaCorreo;
import com.canauhtli.cfdi.pac.ClienteFactory;
import com.canauhtli.cfdi.pac.ClientePACException;
import com.canauhtli.cfdi.pac.ClienteServicioPAC;
import com.canauhtli.cfdi.reportes.ConceptoFactura;
import com.canauhtli.cfdi.reportes.DocumentoPDF;
import com.canauhtli.cfdi.tipo.Accion;
import com.canauhtli.cfdi.tipo.Estatus;
import com.canauhtli.utils.ClienteSMTP;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;

public class CfdiFactura extends CFDIDocumento {

	private static Logger log = LoggerFactory.getLogger(CfdiFactura.class);
	
	public CfdiFactura() {
		super();
	}
	
	public static void main(String[] args) {
		if (args.length == 0) {
			escribeError("No se indico la acci�n" + printUso());
			System.exit(1);
		}
		Accion acc = Accion.fromArg(args[0]);
		if (acc == null) {
			escribeError("Accion no reconocida" + printUso());
			log.error("La accion <{}> no es reconocida", args[0]);
			System.exit(1);
		}
		
		CfdiFactura cfdi = new CfdiFactura();
		try {
			switch (acc) {
				case GENERAR:
					log.debug("Generar factura");
					cfdi.generar(args);
					break;
				default:
					break;
			}
		} catch (CFDIException cfdie) {
			log.error("Ejecutando operacion {}", acc, cfdie);
			escribeError(cfdie.getMessage());
		}
	}

	private void generar(String args[]) throws CFDIException {
		if (args.length < 2) {
			throw new CFDIException("No se especific� el archivo origen");
		}
		File fact = new File(args[1]);
		if ((!fact.isFile()) && (!fact.canRead())) {
			throw new CFDIException("No se puede leer el archivo origen");
		}
		
		try {
			ClienteServicioPAC pac = ClienteFactory.getCliente(cm.getProveedorConfig(cm.getProveedor()));
			
			Factura factura = new Factura();
			factura.setCodigo(fact.getName().substring(0, fact.getName().indexOf(".")));
			factura.setEstatus(Estatus.NUEVO);
			GeneradorFac genFac = new GeneradorFac();
			genFac.setFactura(factura);
			genFac.setEmisor(initEmisor());
			genFac.leeEntrada(fact);
			registraEntrada(factura);
			if (genFac.generaComprobante(pac)) {
				actualizaFactura(factura);
				guardaXML(factura);
				if ("1".equals(cm.getGeneralConfig("generarPdf"))) {
					generaPDF(factura);
				}
				if (("1".equals(cm.getMailConfig("enviarCorreo"))) && (factura.getExtras().getCorreo() != null) && (!"".equals(factura.getExtras().getCorreo().trim()))) {
					if (enviaFactura(factura)) {
						factura.setEstatus(Estatus.ENVIADO);
						actualizaFactura(factura);
					}
				}
			}
		} catch (ClientePACException e) {
			log.error("No fue posible inicializar al proveedor {}", cm.getProveedor(), e);
		}
	}
	
private void guardaXML(Factura factura) throws CFDIException {
		
		String path = cm.getGeneralConfig("carpetaSalida") + "/" + factura.getNombreArchivo() + ".xml";
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			osw = new OutputStreamWriter(new FileOutputStream(path), "UTF-8");
			bw = new BufferedWriter(osw);
			bw.write(factura.getXml());
		} catch (IOException e) {
			log.error("Guardando xml", e);
			throw new CFDIException("No pude escribir el archivo "
					+ path);
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (osw != null) {
					osw.close();
				}
			} catch (IOException e) {
				log.warn("cerrando xml", e);
			}
		}
	}

	private void generaPDF(Factura factura) throws CFDIException {
		ArrayList<ConceptoFactura> conceptos = new ArrayList<ConceptoFactura>();
		for (ConceptoFac cf : factura.getConceptos()) {
			for (Comentario c : cf.getPreComs()) {
				ConceptoFactura cfac = new ConceptoFactura();
				cfac.setDescripcion(c.getComentario());
				conceptos.add(cfac);
			}
			
			ConceptoFactura cfac = new ConceptoFactura();
			cfac.setCantidad(Integer.valueOf((int) cf.getCantidad()));
			cfac.setCodigo(cf.getCodigo() + "/" + cf.getClaveProdServ());
			cfac.setDescripcion(cf.getDescripcion());
			cfac.setImporte(new BigDecimal(cf.getImporte()));
			cfac.setPartida(Integer.valueOf(cf.getPartida()));
			cfac.setPrecioUnitario(new BigDecimal(cf.getPrecio()));
			cfac.setUnidad(cf.getUnidad() + "/" + cf.getClaveUnidad());
			conceptos.add(cfac);
			
			for (Comentario c : cf.getPostComs()) {
				ConceptoFactura cfacs = new ConceptoFactura();
				cfacs.setDescripcion(c.getComentario());
				conceptos.add(cfacs);
			}
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		DocumentoPDF dpdf = new DocumentoPDF();
		dpdf.setNombre(cm.getGeneralConfig("carpetaSalida") + "/" + factura.getNombreArchivo() + ".pdf");
		dpdf.setCopias(Integer.parseInt(cm.getGeneralConfig("copias")));
		dpdf.setImprimir(cm.getGeneralConfig("imprimir").equals("1"));
		dpdf.setPlantilla(cm.getGeneralConfig("plantilla"));
		dpdf.setImpresora(cm.getGeneralConfig("impresora"));
		dpdf.addParam("receptor", factura.getReceptor().getRazonSocial());
		dpdf.addParam("dir1", factura.getReceptor().getCalle()
				+ " " + factura.getReceptor().getNumExt()
				+ " " + factura.getReceptor().getNumInt());
		dpdf.addParam("dir2", factura.getReceptor().getColonia());
		dpdf.addParam("dir3", factura.getReceptor().getMunicipio()
				+ ", " + factura.getReceptor().getEstado());
		dpdf.addParam("dir4", factura.getReceptor().getPais()
				+ ", C.P. " + factura.getReceptor().getCp());
		dpdf.addParam("rfc", factura.getReceptor().getRfc());
		dpdf.addParam("tipoCFD", factura.getGenerales().getTipo());
		dpdf.addParam("uuid", factura.getUuid());
		dpdf.addParam("serie", factura.getGenerales().getSerie());
		dpdf.addParam("folio", factura.getCfdi().getFolio());
		dpdf.addParam("cerSAT", factura.getCertSAT());
		dpdf.addParam("cerEmi", factura.getCfdi().getCertificado());
		dpdf.addParam("fechaCert", sdf.format(factura.getFechaTimbrado()));
		dpdf.addParam("fechaCfdi", sdf.format(factura.getCfdi().getFecha().toGregorianCalendar().getTime()));
		dpdf.addParam("subtotal", new BigDecimal(factura.getTotales().getSubTotal()));
		if (factura.getTotales().getDescuento() > 0) { 
			dpdf.addParam("descuentos", new BigDecimal(factura.getTotales().getDescuento()));
			dpdf.addParam("tasaDesc", new BigDecimal(factura.getTotales().getPorcentajeDescuento()));
		} else {
			dpdf.addParam("tasaDesc", new BigDecimal("0.0"));
		}
		dpdf.addParam("tasaIva", new BigDecimal(cm.getGeneralConfig("iva")));
		dpdf.addParam("iva", new BigDecimal(factura.getImpuesto().getTotalTraslados()));
		dpdf.addParam("total", new BigDecimal(factura.getTotales().getTotal()));
		dpdf.addParam("formaPago", factura.getGenerales().getFormaPago() + " " + factura.getExtras().getFormaPago());
		dpdf.addParam("metodoPago", factura.getTotales().getMetodoPago() + " " + factura.getExtras().getMetodoPago());
		dpdf.addParam("usoCfdi", factura.getReceptor().getUsoCfdi() + " " + factura.getExtras().getUsoCFDI());
		dpdf.addParam("importeLetra", factura.getTotales().getImporteLetra());
		if ((factura.getObservaciones() != null) && (factura.getObservaciones().size() > 0)) {
			dpdf.addParam("observacion1", factura.getObservaciones().get(0).getObservacion());
		}
		dpdf.addParam("selloSAT", factura.getSelloSAT());
		dpdf.addParam("selloEmisor", factura.getCfdi().getSello());
		dpdf.addParam("cadenaOriginal", "||"
				+ factura.getCfdi().getVersion() + "|"
				+ factura.getUuid() + "|"
				+ factura.getFechaTimbrado() + "|"
				+ factura.getCfdi().getSello() + "|"
				+ factura.getCertSAT() + "||");
		dpdf.addParam("logo", cm.getGeneralConfig("logo"));

		dpdf.addParam("pedido", factura.getEncabezado().getPedido());
		dpdf.addParam("pedidoCliente", factura.getEncabezado().getPedidoCliente());
		dpdf.addParam("modelo", factura.getEncabezado().getModelo());
		dpdf.addParam("noserie", factura.getEncabezado().getSerie());
		dpdf.addParam("eco", factura.getEncabezado().getEco());
		try {
			String qrCode = "?re=" + cm.getEmisorConfig("rfc") + "&rr="
					+ factura.getReceptor().getRfc() + "&tt="
					+ factura.getTotales().getTotal() + "&id="
					+ factura.getUuid();
			BufferedImage bi = MatrixToImageWriter
					.toBufferedImage(new QRCodeWriter().encode(qrCode,
							BarcodeFormat.QR_CODE, 125, 125));
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(bi, "gif", os);
			InputStream is = new ByteArrayInputStream(os.toByteArray());
			dpdf.addParam("qrCode", is);
		} catch (WriterException we) {
			log.error("generando QRCode", we);
			throw new CFDIException("No fue posible generare el QRCode para el PDF");
		} catch (IOException ioe) {
			log.error("generando gif deQRCode", ioe);
			throw new CFDIException("No fue posible generar la imagen del QRCode para el PDF");
		}
		dpdf.generaFactura(conceptos);
		
	}
	
	private boolean enviaFactura(Factura factura) {
		ClienteSMTP smtp = new ClienteSMTP(cm);
		FacturaCorreo fc = new FacturaCorreo();
		fc.setCorreo(factura.getExtras().getCorreo());
		fc.setMsg(cm.getMailConfig("mensaje"));
		fc.setNombre(factura.getReceptor().getRazonSocial());
		fc.setNumCliente(""+factura.getReceptor().getNumCliente());
		fc.setPathPdf(cm.getGeneralConfig("carpetaSalida") + "/" + factura.getNombreArchivo() + ".pdf");
		fc.setFactura(factura.getCodigo());
		fc.setXml(factura.getXml());
		smtp.enviaFactura(fc);
		return fc.isEnviado();
	}

	private void actualizaFactura(Factura factura) {
		com.canauhtli.cfdi.db.Factura fac = madb.obtenFactura(factura.getIdFactura());
		fac.setComprobanteFiscal(factura.getXml());
		fac.setUuid(factura.getUuid());
		fac.setFechaProceso(new Date());
		fac.setEstatus(factura.getEstatus().getEstatus());
		madb.actualizaFactura(fac);
	}

	private void registraEntrada(Factura factura) {
		try {
			JAXBContext jc = JAXBContext.newInstance(Factura.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty("eclipselink.media-type", "application/json");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			marshaller.marshal(factura, os);
			com.canauhtli.cfdi.db.Factura fac = new com.canauhtli.cfdi.db.Factura();
			fac.setCodigo(factura.getCodigo());
			fac.setFolio(factura.getGenerales().getFolio());
			fac.setCliente(factura.getReceptor().getNumCliente());
			fac.setEstatus(Estatus.NUEVO.getEstatus());
			fac.setFactura(os.toString());
			fac.setFechaEstatus(new Date());
			fac.setFechaEstatus(new Date());
			fac = madb.registraFactura(fac);
			factura.setIdFactura(fac.getIdFactura());
		} catch (JAXBException e) {
			log.error("No pude generar el contexto para registrar la factura", e);
		}
		
	}
	
	
	
}
