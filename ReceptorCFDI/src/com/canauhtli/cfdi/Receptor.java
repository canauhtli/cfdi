package com.canauhtli.cfdi;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;

import com.canauhtli.cfdi.db.Concepto;
import com.canauhtli.cfdi.db.Factura;
import com.canauhtli.cfdi.db.RecibidasDAO;
import com.canauhtli.cfdi.sat.cfd33.Comprobante;
import com.canauhtli.cfdi.sat.cfd33.Comprobante.Complemento;
import com.canauhtli.cfdi.sat.timbre11.TimbreFiscalDigital;

public class Receptor {
	private static Logger log = LoggerFactory.getLogger(Receptor.class);
	private ResourceBundle props = ResourceBundle.getBundle("configuracion.config");
	private File entrada;
	private File salida;
	private RecibidasDAO dao;
	
	private boolean inicializado;
	
	public Receptor() {
		try {
			inicializa();
			inicializado = dao.isConectado();
		} catch (Exception e) {
			log.error("No fue posible iniciar el proceso - {}", e.getMessage(), e);
		}
	}
	
	private void inicializa() throws Exception {
		entrada = new File(props.getString("directorio.entrada"));
		salida = new File(props.getString("directorio.procesadas"));
		
		if (!entrada.isDirectory()) {
			throw new Exception(entrada.getName() + " No es un directorio valido");
		}
		if (!salida.isDirectory()) {
			throw new Exception(salida.getName() + " No es un directorio valido");
		}
		if (!salida.canWrite()) {
			throw new Exception(salida.getName() + " No es accesible para escritura");
		}
		
		dao = new RecibidasDAO(props);
		dao.conectar();
	}
	
	public void procesaRecibida(String pedido, String cfdi) throws Exception {
		File recibido = new File(entrada.getAbsolutePath() + System.getProperty("file.separator") + cfdi);
		if (recibido.isFile() && recibido.canRead()) {
			Comprobante comprobante = null;
			TimbreFiscalDigital timbreFiscal = null;
			try {
				JAXBContext context = JAXBContext.newInstance(Comprobante.class.getPackage().getName());
				Unmarshaller um = context.createUnmarshaller();
				comprobante = (Comprobante)um.unmarshal(new FileInputStream(recibido));
				
				for (Complemento cp : comprobante.getComplemento()) {
					for (Object any : cp.getAny()) {
						Node compl = (Node) any;
						if ("TimbreFiscalDigital".equalsIgnoreCase(compl.getLocalName())) {
							context = JAXBContext.newInstance(TimbreFiscalDigital.class.getPackage().getName());
							um = context.createUnmarshaller();
							timbreFiscal = (TimbreFiscalDigital) um.unmarshal(compl);
						}
					}
				}
				
				registraCFDIRecibido(comprobante, timbreFiscal, pedido, cfdi);
				recibido.renameTo(new File(salida.getAbsolutePath() + System.getProperty("file.separator") + cfdi));
			} catch (JAXBException e) {
				log.error("Leyendo cfdi - {}", e);
				throw new Exception("No pude interpretar el cfdi solicitado");
			}
			
			
		} else {
			throw new Exception("No fue posible leer el CFDI " + cfdi);
		}
	}
	
	public boolean validaPedido(String pedido) {
		Factura factura = dao.buscaFactura(pedido);
		return factura == null;
	}
	
	private void registraCFDIRecibido(Comprobante comprobante, TimbreFiscalDigital timbre, String pedido, String cfdi) {
		Factura factura = new Factura();
		factura.setArchivo(cfdi);
		factura.setDescuento(comprobante.getDescuento());
		factura.setFecha(new Timestamp(comprobante.getFecha().toGregorianCalendar().getTimeInMillis()));
		factura.setFolio(Integer.parseInt(comprobante.getFolio()));
		factura.setMoneda(comprobante.getMoneda().value());
		factura.setNumeroPedido(pedido);
		factura.setRfcEmisor(comprobante.getEmisor().getRfc());
		factura.setSerie(comprobante.getSerie());
		factura.setSubtotal(comprobante.getSubTotal());
		factura.setTipoCambio(comprobante.getTipoCambio());
		factura.setTotal(comprobante.getTotal());
		factura.setTotalImpuestos(comprobante.getImpuestos().getTotalImpuestosTrasladados());
		factura.setUuid(timbre.getUUID());
		
		factura = dao.registraFactura(factura);
		for (com.canauhtli.cfdi.sat.cfd33.Comprobante.Conceptos.Concepto c :comprobante.getConceptos().getConcepto()) {
			Concepto concepto = new Concepto();
			concepto.setCantidad(c.getCantidad());
			concepto.setClaveProdServ(c.getClaveProdServ());
			concepto.setClaveUnidad(c.getClaveUnidad());
			concepto.setDescripcion(c.getDescripcion());
			concepto.setDescuento(c.getDescuento());
			concepto.setIdFactura(factura.getIdFactura());
			concepto.setImporte(c.getImporte());
			concepto.setNumIdentificacion(c.getNoIdentificacion());
			concepto.setUnidad(c.getUnidad());
			concepto.setValorUnitario(c.getValorUnitario());
			concepto = dao.registraConcepto(concepto);
		}
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			printUso();
			System.exit(1);
		}
		String pedido = args[0];
		String cfdiXML = args[1];

		Receptor receptor = new Receptor();
		if (receptor.isInicializado()) {
			try {
				if (receptor.validaPedido(pedido)) {
					receptor.procesaRecibida(pedido, cfdiXML);
				} else {
					log.info("Ya existe un registro con el número de pedido {}", pedido);
				}
			} catch (Exception e) {
				log.error("Problema al ejecutar el proceso - {}", e.getMessage(), e);
			}
		}
	}
	
	public boolean isInicializado() {
		return inicializado;
	}
	
	public static void printUso() {
		System.out.println("Uso: java Receptor <num_pedido> <cfdi.xml>");
	}

}
