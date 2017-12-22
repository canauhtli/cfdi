package com.canauhtli.cfdi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.sql.Timestamp;

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
import com.canauhtli.cfdi.utils.AppConfig;

public class Recolector {

	private static Logger log = LoggerFactory.getLogger(Recolector.class);
	
	private File entrada;
	private File procesadas;
	private FilenameFilter filtro;
	private RecibidasDAO dao;
	
	public Recolector() {
		entrada = new File(AppConfig.getUserVal("directorio.entrada"));
		procesadas = new File(AppConfig.getUserVal("directorio.procesadas"));
		dao = RecibidasDAO.getInstance();
		
		filtro = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				String lowercaseName = name.toLowerCase();
				if (lowercaseName.endsWith(".xml")) {
					return true;
				} else {
					return false;
				}
			}
		};
	}
	
	public void actualizaDirectorios() {
		entrada = new File(AppConfig.getUserVal("directorio.entrada"));
		procesadas = new File(AppConfig.getUserVal("directorio.procesadas"));
	}
	
	public void leeArchivos() {
		
		File archivos[] = entrada.listFiles(filtro);
		for (File arch : archivos) {
			procesaRecibido(arch);
		}
	}
	
	private void procesaRecibido(File archivo) {
		if (archivo.isFile() && archivo.canRead()) {
			Comprobante comprobante = null;
			TimbreFiscalDigital timbreFiscal = null;
			try {
				JAXBContext context = JAXBContext.newInstance(Comprobante.class.getPackage().getName());
				Unmarshaller um = context.createUnmarshaller();
				comprobante = (Comprobante)um.unmarshal(new FileInputStream(archivo));
				
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
				
				registraCFDIRecibido(comprobante, timbreFiscal, archivo.getName());
				archivo.renameTo(new File(procesadas.getAbsolutePath() + System.getProperty("file.separator") + archivo.getName()));
			} catch (JAXBException e) {
				log.error("Leyendo cfdi - {}", archivo.getName(), e);
			} catch (FileNotFoundException e) {
				log.error("Archivo no accesible {}", archivo.getName(), e);
			}
			
			
		} else {
			log.error("No fue posible leer el CFDI " + archivo.getName());
		}
	}
	
	private void registraCFDIRecibido(Comprobante comprobante, TimbreFiscalDigital timbre, String cfdi) {
		Factura factura = new Factura();
		factura.setArchivo(cfdi);
		factura.setDescuento(comprobante.getDescuento());
		factura.setFecha(new Timestamp(comprobante.getFecha().toGregorianCalendar().getTimeInMillis()));
		factura.setFolio(Integer.parseInt(comprobante.getFolio()));
		factura.setMoneda(comprobante.getMoneda().value());
		factura.setNumeroPedido(null);
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
	
	private static class RecolectorHolder {
		private static final Recolector INSTANCE = new Recolector();
	}
	
	public static Recolector getInstance() {
		return RecolectorHolder.INSTANCE;
	}
	
}
