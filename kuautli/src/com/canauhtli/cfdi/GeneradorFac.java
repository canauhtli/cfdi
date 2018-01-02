package com.canauhtli.cfdi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import org.beanio.builder.DelimitedParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;

import com.canauhtli.cfdi.factura.Receptor;
import com.canauhtli.cfdi.factura.Totales;
import com.canauhtli.cfdi.factura.UuidRelacionado;
import com.canauhtli.cfdi.factura.Comentario;
import com.canauhtli.cfdi.factura.ConceptoFac;
import com.canauhtli.cfdi.factura.DescuentoRecargo;
import com.canauhtli.cfdi.factura.DocumentoRelacionado;
import com.canauhtli.cfdi.factura.Encabezado;
import com.canauhtli.cfdi.factura.ErrorHandler;
import com.canauhtli.cfdi.factura.Extras;
import com.canauhtli.cfdi.factura.Factura;
import com.canauhtli.cfdi.factura.Generales;
import com.canauhtli.cfdi.factura.Impuesto;
import com.canauhtli.cfdi.factura.ImpuestoConceptoFac;
import com.canauhtli.cfdi.factura.ImpuestoPago;
import com.canauhtli.cfdi.factura.ImpuestoPagoDetalle;
import com.canauhtli.cfdi.factura.Observacion;
import com.canauhtli.cfdi.factura.Pago;
import com.canauhtli.cfdi.pac.ClientePACException;
import com.canauhtli.cfdi.pac.ClienteServicioPAC;
import com.canauhtli.cfdi.pac.ComprobanteFiscal;
import com.canauhtli.cfdi.pac.bean.Concepto;
import com.canauhtli.cfdi.pac.bean.Direccion;
import com.canauhtli.cfdi.pac.bean.Entidad;
import com.canauhtli.cfdi.pac.bean.ImpuestoConcepto;
import com.canauhtli.cfdi.pac.bean.Relacionados;
import com.canauhtli.cfdi.pac.types.Estado;
import com.canauhtli.cfdi.pac.types.TipoCFD;
import com.canauhtli.cfdi.sat.cfd33.Comprobante;
import com.canauhtli.cfdi.sat.cfd33.Comprobante.Complemento;
import com.canauhtli.cfdi.sat.timbre11.TimbreFiscalDigital;
import com.canauhtli.cfdi.tipo.Estatus;
import com.canauhtli.utils.XMLParser;

public class GeneradorFac {

	private static Logger log = LoggerFactory.getLogger(GeneradorFac.class);
	
	private Entidad emisor;
	private Factura factura;
	
	public void setEmisor(Entidad emisor) {
		this.emisor = emisor;
	}
	
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	public void leeEntrada(File archivo) {
		StreamFactory factory = StreamFactory.newInstance();
		StreamBuilder builder = new StreamBuilder("facFile");
		builder.format("delimited")
			.parser(new DelimitedParserBuilder('|'))
			.addRecord(Receptor.class)
			.addRecord(ConceptoFac.class)
			.addRecord(Generales.class)
			.addRecord(ImpuestoConceptoFac.class)
			.addRecord(Encabezado.class)
			.addRecord(Comentario.class)
			.addRecord(Impuesto.class)
			.addRecord(Totales.class)
			.addRecord(Observacion.class)
			.addRecord(DescuentoRecargo.class)
			.addRecord(Extras.class)
			.addRecord(UuidRelacionado.class)
			.addRecord(Pago.class)
			.addRecord(DocumentoRelacionado.class)
			
			.ignoreUnidentifiedRecords();
		
		factory.define(builder);
		ErrorHandler eh = new ErrorHandler();
		BeanReader reader = factory.createReader("facFile", archivo);
		reader.setErrorHandler(eh);
		
		Object record = null;
		while ((record = reader.read()) != null) {
			if ("receptor".equalsIgnoreCase(reader.getRecordName())) {
				factura.setReceptor((Receptor) record); 
				log.debug("Receptor: {}", record );
			}
			if ("conceptoFac".equalsIgnoreCase(reader.getRecordName())) {
				factura.addConcepto((ConceptoFac) record);
				log.debug("Concepto: {}", record);
			}
			if ("generales".equalsIgnoreCase(reader.getRecordName())) {
				factura.setGenerales((Generales) record);
				log.debug("Generales: {}", record);
			}
			if ("impuestoConceptoFac".equalsIgnoreCase(reader.getRecordName())) {
				factura.addImpuestoConcepto((ImpuestoConceptoFac) record);
				log.debug("impuestoConcepto: {}", record);
			}
			if ("encabezado".equalsIgnoreCase(reader.getRecordName())) {
				factura.setEncabezado((Encabezado) record);
				log.debug("encabezado: {}", record);
			}
			if ("comentario".equalsIgnoreCase(reader.getRecordName())) {
				factura.addComentario((Comentario) record);
				log.debug("comentario: {}", record);
			}
			if ("impuesto".equalsIgnoreCase(reader.getRecordName())) {
				factura.setImpuesto((Impuesto) record);
				log.debug("impuesto: {}", record);
			}
			if ("totales".equalsIgnoreCase(reader.getRecordName())) {
				factura.setTotales((Totales) record);
				log.debug("totales: {}", record);
			}
			if ("observacion".equalsIgnoreCase(reader.getRecordName())) {
				factura.addObservacion((Observacion) record);
				log.debug("observacion: {}", record);
			}
			if ("descRec".equalsIgnoreCase(reader.getRecordName())) {
				factura.addDescuento((DescuentoRecargo) record);
				log.debug("descRec: {}", record);
			}
			if ("extras".equalsIgnoreCase(reader.getRecordName())) {
				factura.setExtras((Extras) record);
				log.debug("extras: {}", record);
			}
			if ("uuidRelacionado".equalsIgnoreCase(reader.getRecordName())) {
				factura.setUuidRelacionado((UuidRelacionado) record);
				log.debug("uuidRelacionado: {}", record);
			}
			if ("pago".equalsIgnoreCase(reader.getRecordName())) {
				factura.addPago((Pago) record);
				log.debug("pago: {}", record);
			}
			if ("documentoRelacionado".equalsIgnoreCase(reader.getRecordName())) {
				factura.addDocumento((DocumentoRelacionado) record);
				log.debug("documentoRelacionado: {}", record);
			}
			if ("impuestoPago".equalsIgnoreCase(reader.getRecordName())) {
				factura.addImpuestoPago((ImpuestoPago) record);
				log.debug("impuestoPago: {}", record);
			}
			
		}
		reader.close();
		
		factura.ajustaFactura();
	}
	
	public boolean generaComprobante(ClienteServicioPAC pac) {
		boolean generado = false;
		try {
			ComprobanteFiscal cf = preparaComprobante();
			String xml = pac.generaComprobante(cf);
			System.out.println("XML: " + xml);
			factura.setXml(xml);
			Comprobante cfdi = XMLParser.parseCfdi(xml);
			for (Complemento cp : cfdi.getComplemento()) {
				for (Object any : cp.getAny()) {
					Node compl = (Node) any;
					if ("TimbreFiscalDigital".equalsIgnoreCase(compl.getLocalName())) {
						TimbreFiscalDigital timbre = XMLParser.parseTimbreFiscal(compl);
						factura.setUuid(timbre.getUUID());
						factura.setCertSAT(timbre.getNoCertificadoSAT());
						factura.setFechaTimbrado(timbre.getFechaTimbrado().toGregorianCalendar().getTime());
						factura.setSelloSAT(timbre.getSelloSAT());
					}
				}
			}
			factura.setCfdi(cfdi);
			factura.setEstatus(Estatus.EMITIDO);
			generado = true;
		} catch (ClientePACException e) {
			log.error("No pude generar CFDI para {} ", factura.getCodigo(), e);
		} catch (CFDIException e) {
			log.error("No pude interpretar el CFDI para {} ", factura.getCodigo(), e);
		} 
		
		return generado;
	}
	
	
	
	private ComprobanteFiscal preparaComprobante() {
		ComprobanteFiscal cf = new ComprobanteFiscal();
		
		Entidad receptor = new Entidad();
		receptor.setRazonSocial(factura.getReceptor().getRazonSocial());
		receptor.setRfc(factura.getReceptor().getRfc());
		receptor.setUsoCFDI(factura.getReceptor().getUsoCfdi());
		Direccion direccion = new Direccion();
		direccion.setCalle(factura.getReceptor().getCalle());
		direccion.setNumExt(factura.getReceptor().getNumExt());
		direccion.setNumInt(factura.getReceptor().getNumInt());
		direccion.setColonia(factura.getReceptor().getColonia());
		direccion.setMunicipio(factura.getReceptor().getMunicipio());
		direccion.setEstado(Estado.fromClave(factura.getReceptor().getEstado()));
		direccion.setPais(factura.getReceptor().getPais());
		direccion.setCp(factura.getReceptor().getCp());
		receptor.setDireccion(direccion);
		cf.setReceptor(receptor);
		
		cf.setTipo(TipoCFD.fromTipo(factura.getGenerales().getTipo()));
		cf.setFormaPago(factura.getGenerales().getFormaPago());
		cf.setMetodoPago(factura.getTotales().getMetodoPago());
		cf.setMoneda(factura.getGenerales().getMoneda());
		cf.setTipoCambio(factura.getGenerales().getTipoCambio());
		cf.setImporte(factura.getTotales().getImporteLetra());
		cf.setEmisor(emisor);
		
		for (ConceptoFac c : factura.getConceptos()) {
			Concepto concepto = new Concepto();
			concepto.setCantidad(c.getCantidad());
			concepto.setClaveProdServ(c.getClaveProdServ());
			concepto.setClaveUnidad(c.getClaveUnidad());
			concepto.setCodigo(c.getCodigo());
			concepto.setDescripcion(c.getDescripcion());
			concepto.setDescuento(c.getDescuento());
			concepto.setImporte(c.getImporte());
			concepto.setPartida(c.getPartida());
			concepto.setPrecioUnitario(c.getPrecio());
			concepto.setUnidad(c.getUnidad());
			if (c.getImpuestos() != null) {
				for (ImpuestoConceptoFac icf : c.getImpuestos()) {
					ImpuestoConcepto ic = new ImpuestoConcepto();
					ic.setBase(icf.getBase());
					ic.setImporte(icf.getImporte());
					ic.setImpuesto(icf.getImpuesto());
					ic.setTasaOCuota(icf.getTasaOCuota());
					ic.setTipo(icf.getTipo());
					ic.setTipoFactor(icf.getTipoFactor());
					concepto.addImpuesto(ic);
				}
			}
			cf.addConcepto(concepto);
		}
		
		cf.setFechaEmision(factura.getGenerales().getFecha());
		cf.setFormaPago(factura.getGenerales().getFormaPago());
		cf.setMetodoPago(factura.getTotales().getMetodoPago());
		cf.setMoneda(factura.getGenerales().getMoneda());
		cf.setSerie(factura.getGenerales().getSerie());
		cf.setTotal(factura.getTotales().getTotal());
		cf.setSubTotal(factura.getTotales().getSubTotal());
		cf.setTotalDescuento(factura.getTotales().getDescuento());
		
		if (factura.getUuidRelacionado() != null) {
			Relacionados relacionados = new Relacionados();
			relacionados.setTipoRelacion(factura.getUuidRelacionado().getTipoRelacion());
			relacionados.setUuids(factura.getUuidRelacionado().getLstUuids());
			cf.setRelacionados(relacionados);
		}
		
		if (TipoCFD.PAGO == cf.getTipo()) {
			for (Pago p : factura.getPagos()) {
				com.canauhtli.cfdi.pac.bean.Pago pago = new com.canauhtli.cfdi.pac.bean.Pago();
				pago.setBanco(p.getBanco());
				pago.setCadPago(p.getCadPago());
				pago.setCertPago(p.getCertPago());
				pago.setCuentaBeneficiario(p.getCuentaBeneficiario());
				pago.setCuentaOrdenante(p.getCuentaOrdenante());
				pago.setFechaPago(p.getFechaPago());
				pago.setFormaPago(p.getFormaPago());
				pago.setMoneda(p.getMoneda());
				pago.setMonto(p.getMonto());
				pago.setNumOperacion(p.getNumOperacion());
				pago.setRfcEmisorCtaBen(p.getRfcEmisorCtaBen());
				pago.setRfcOrdenante(p.getRfcOrdenante());
				pago.setSelloPago(p.getSelloPago());
				pago.setTipoCadenaPago(p.getTipoCadenaPago());
				pago.setTipoCambio(p.getTipoCambio());
				pago.setTotalImpuestosRetenidos(p.getImpuestoPago().getTotalImpuestosRetenidos());
				pago.setTotalImpuestosTrasladados(p.getImpuestoPago().getTotalImpuestosTrasladados());
				
				for (DocumentoRelacionado dr : p.getDocumentos()) {
					com.canauhtli.cfdi.pac.bean.DocumentoRelacionado documento = new com.canauhtli.cfdi.pac.bean.DocumentoRelacionado();
					documento.setFolio(dr.getFolio());
					documento.setIdDocumento(dr.getIdDocumento());
					documento.setImpPagado(dr.getImpPagado());
					documento.setImpSaldoAnt(dr.getImpSaldoAnt());
					documento.setImpSaldoInsoluto(dr.getImpSaldoInsoluto());
					documento.setMetodoPago(dr.getMetodoPago());
					documento.setMoneda(dr.getMoneda());
					documento.setNumParcialidad(dr.getNumParcialidad());
					documento.setSerie(dr.getSerie());
					documento.setTipoCambio(dr.getTipoCambio());
					pago.addDocumento(documento);
				}
				
				for (ImpuestoPagoDetalle ipd : p.getImpuestoPago().getImpuestos()) {
					com.canauhtli.cfdi.pac.bean.ImpuestoPago impuesto = new com.canauhtli.cfdi.pac.bean.ImpuestoPago();
					impuesto.setTipo(ipd.getTipo());
					impuesto.setImporte(ipd.getImporte());
					impuesto.setImpuesto(ipd.getImpuesto());
					impuesto.setTasaOCuota(ipd.getTasaOCuota());
					impuesto.setTipoFactor(ipd.getTipoFactor());
					pago.addImpuesto(impuesto);
				}
			}
		}
		
		return cf;
	}
}
