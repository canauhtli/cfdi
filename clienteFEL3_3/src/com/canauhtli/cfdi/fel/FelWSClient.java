package com.canauhtli.cfdi.fel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.commons.lang3.StringUtils;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionadoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionadosR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConceptoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Pagos10R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosRetencionR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosTrasladoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionConceptoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoConceptoR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tempuri.ConexionRemotaLocator;
import org.tempuri.IConexionRemota;

import com.canauhtli.cfdi.pac.ClientePACException;
import com.canauhtli.cfdi.pac.ClienteServicio;
import com.canauhtli.cfdi.pac.ComprobanteFiscal;
import com.canauhtli.cfdi.pac.bean.Concepto;
import com.canauhtli.cfdi.pac.bean.DocumentoRelacionado;
import com.canauhtli.cfdi.pac.bean.Entidad;
import com.canauhtli.cfdi.pac.bean.ImpuestoConcepto;
import com.canauhtli.cfdi.pac.bean.ImpuestoPago;
import com.canauhtli.cfdi.pac.bean.Pago;
import com.canauhtli.cfdi.pac.bean.Relacionados;
import com.canauhtli.cfdi.pac.types.TipoCFD;

public class FelWSClient extends ClienteServicio {

	private static Logger log = LoggerFactory.getLogger(FelWSClient.class);
	
	private IConexionRemota felws;
    private Credenciales credenciales;
	
	public FelWSClient(Map<String, String> cm) throws ClientePACException {
		super(cm);
    	
    	ConexionRemotaLocator service = new ConexionRemotaLocator();
        try {
			felws = service.getsoapHttpEndpoint(url);
		} catch (ServiceException e) {
			log.error("No pude crear el servicio con la siguiente URL: {}", url);
			throw new ClientePACException("Creando servicio de FEL");
		}
        
        credenciales = new Credenciales();
        credenciales.setCuenta(config.get("cuenta"));
        credenciales.setPassword(config.get("password"));
        credenciales.setUsuario(config.get("rfc"));
        log.debug("Servicio FEL inicializado - {}", this.url);
//        log.debug("usr:{} pwd:{} cta:{}", credenciales.getUsuario(), credenciales.getPassword(), credenciales.getCuenta());
	}

	@Override
	public String generaComprobante(ComprobanteFiscal cf) throws ClientePACException {
		String xml = "";
		Comprobante33R comprobante = new Comprobante33R();
		
		llenaEncabezado(comprobante, cf);
		comprobante.setEmisor(llenarEmisor(cf.getEmisor()));
		comprobante.setReceptor(llenaReceptor(cf.getReceptor()));
		comprobante.setConceptos(llenarConceptos(cf.getConceptos()));
		comprobante.setCfdiRelacionados(llenarRelacionados(cf.getRelacionados()));
		
		if (TipoCFD.PAGO == cf.getTipo()) {
			comprobante.setPagos(llenarPagos(cf.getPagos()));
		}
		
		try {
			RespuestaOperacionCR response = felws.generarCFDI(credenciales, comprobante);
			if (response.getOperacionExitosa()) {
				xml = response.getXML();
			} else {
				log.error("{}", response.getErrorGeneral());
				log.error("{}", response.getErrorDetallado());
				throw new ClientePACException(response.getErrorGeneral());
			}
			log.info("CodigoConfirmacion: " + response.getCodigoConfirmacion());
		} catch (RemoteException e) {
			log.error("No pude generar el CFDI para {}", cf.getReceptor().getRfc(), e);
			throw new ClientePACException(e.getMessage());
		}
		return xml;
	}

	@Override
	public String cancelaComprobante(String var1) throws ClientePACException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> cancelaComprobantes(List<String> var1) throws ClientePACException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Tomado de la documentación de FEL
	 * 
	 * ClaveCFDI (R) -	FAC	Para el caso de emisión de Factura. Función fiscal: Ingreso.
	 * 					HON	Para el caso de emisión de Recibo de Honorarios. Función fiscal: Ingreso.
	 * 					ARR	Para el caso de emisión de Recibo de Arrendamiento. Función fiscal: Ingreso.
	 *			 		PAG	Para el caso de emisión de Recibo de Pago. Función fiscal: Ingreso.
	 *					CAR	Para el caso de emisión de Nota de Cargo. Función fiscal: Ingreso.
	 *					CRE	Para el caso de emisión de Nota de Crédito. Función fiscal: Egreso.
	 *					DEV	Para el caso de emisión de Nota de Devolución. Función fiscal: Egreso.
	 *					POR	Para el caso de emisión de Carta Porte. Función fiscal: Traslado.
	 *					DON	Para el caso de emisión de Donatarias. Función fiscal: Egreso.
	 *					NOM12	Para el caso de emisión de Nomina. Funcion fiscal: Egreso
	 *					CPI	Para el caso de emisión de Carta Porte. Función fiscal: Ingreso.
	 *					ING	Para el caso de emisión de Recibo de Ingreso. Función fiscal: Ingreso.
	 *					CPA	Para el caso de emisión de Complemento de Pagos. Función fiscal: Ingreso.
	 *
	 * CondicionesDePago (O) - Leyenda que indique las condiciones de pago.
	 *	
	 * Fecha (O) - [YYYY-MM-DDTHH:mm:SS] Parámetro para cambiar la fecha de emisión del CFDI,
	 * 			   máximo 24 horas previas a la actual.
	 *
	 * Folio (O) - Parámetro para declarar un Folio para el CFDI.
	 *
	 * FormaDePago	(R) - Pago en una sola exhibición	Leyenda que deberá ir como forma de pago.
	 *					  Parcialidades	Leyenda que deberá ir como forma de pago en caso de parcialidades.  En este caso deberá incluirse la variable "Parcialidades 1/3" por ejemplo.
	 *		
	 * LugarExpedicion	(R) - El lugar donde fue Expedido el CFDI.
	 *
	 * MetodoDePago	(R) - Leyenda que indica el método de pago utilizado de acuerdo al Catálogo del SAT. [c_FormaPago]
	 *					  Si desea agregar más de un método de pago, deberá colocarlo separado por comas y en orden de mayor a menor importe, por ejemplo (01,02,03).
	 *
	 * Moneda (R) - Indicador del tipo de moneda utilizada en el CFDI. [c_Moneda]
	 *	
	 * Referencia (R) - Código único para referenciar el comprobante a timbrar.
	 *		
	 * Serie (O) - Parámetro para declarar la Serie del CFDI.
	 *		
	 * SubTotal	(R) - Cifra decimal que representa el subtotal del CFDI. Ejemplo: 10540.55
	 *		
	 * Total (R) - Cifra decimal que representa el total del CFDI. Ejemplo 12600.00
	 *
	 * R: Requerido
	 * O: Opcional
	 * 
	 * @param comprobante Elemento de FEL con la información del comprobante.
	 * @param cf Datos origen.
	 */
	private void llenaEncabezado(Comprobante33R comprobante, ComprobanteFiscal cf) {
		
		switch (cf.getTipo()) {
			case FACTURA:
				comprobante.setClaveCFDI("FAC");
				break;
			case NOMINA:
				comprobante.setClaveCFDI("NOM12");
				break;
			case PAGO:
				comprobante.setClaveCFDI("PAG");
				break;
			default:
				comprobante.setClaveCFDI("FAC");
				break;
		}
		
		comprobante.setCondicionesDePago(""); // TODO si la usamos se definira el concepto.
		Calendar fecha = Calendar.getInstance();
//		fecha.setTime(cf.getFechaEmision());
		fecha.add(Calendar.HOUR, -6);
		comprobante.setFecha(fecha);
		comprobante.setFolio(StringUtils.left(cf.getFolio(), FelMaxLengths.COMPROBANTE_FOLIO.lenght()));
		comprobante.setFormaPago(cf.getFormaPago());
		comprobante.setLugarExpedicion(cf.getEmisor().getDireccion().getCp());
		comprobante.setMetodoPago(cf.getMetodoPago());
		comprobante.setMoneda(cf.getMoneda());
		comprobante.setTipoCambio(new BigDecimal(cf.getTipoCambio()).setScale(2, RoundingMode.HALF_UP));
		comprobante.setReferencia(""); // TODO definir, por ejemplo el nombre del archivo y agregar el campo correspondiente
		comprobante.setSerie(cf.getSerie());
		comprobante.setSubTotal(new BigDecimal(cf.getSubTotal()).setScale(2, RoundingMode.HALF_UP));
		comprobante.setTotal(new BigDecimal(cf.getTotal()).setScale(2, RoundingMode.HALF_UP));
		comprobante.setDescuento(new BigDecimal(cf.getTotalDescuento()).setScale(2, RoundingMode.HALF_UP));
	}
	
	/**
	 * Tomado de la documentación de FEL
	 * 
	 * Nombre (R) - El nombre comercial del usuario Emisor, que se mostrará en el comprobante a emitir.
	 * 
	 * Régimen Fiscal (R) - Valor del catálogo c_tipoRegimen que otorga el SAT para declarar el Régimen Fiscal
	 * 						del Emisor del comprobante. [c_tipoRegimen]
	 * 
	 * R: Requerido
	 * O: Opcional
	 * 
	 * @param e Datos del emisor
	 * @return Elemento de FEL con los datos del emisor
	 */
	private EmisorR llenarEmisor(Entidad e) {
		EmisorR emisor = new EmisorR();
		emisor.setNombre(e.getRazonSocial());
		emisor.setRegimenFiscal(e.getRegimenFiscal());
		return emisor;
	}
	
	/**
	 * Tomado de la documentación de FEL
	 * 
	 * Nombre (R) - El nombre comercial (arbitrario) de su cliente, el cual será el receptor del CFDI a emitirse.
	 * 				La información que se proporcione sobre el receptor será actualizada al instante siempre que el
	 * 				cliente mencionado ya exista en la base de datos, en caso contrario será dado de alta como nuevo cliente.
	 * 				Esto a nivel interno de su cuenta en FEL.
	 * 
	 * NumRegIDTrib (O) - Si utiliza el complemento de Comercio Exterior, deberá declarar este valor correspondiente 
	 * 					  al Identificador de Exportación.
	 * 
	 * ResidenciaFiscal (O) - Si utiliza el complemento de Comercio Exterior, deberá declarar el valor correspondiente
	 * 						  a la Residencia Fiscal. [c_Pais]
	 * 
	 * Rfc (R) - El RFC del Receptor del CFDI. Será validado de acuerdo a una expresión regular de formato correcto de RFC.
	 * 
	 * UsoCFDI (R) - Paramétro para declarar el uso que se le dará al CFDI. [c_UsoCFDI]
	 * 
	 * R: Requerido
	 * O: Opcional
	 * 
	 * @param r Datos del receptor
	 * @return elemento de FEL con los datos del receptor
	 */
	private ReceptorR llenaReceptor(Entidad r) {
		ReceptorR receptor = new ReceptorR();
		receptor.setNombre(StringUtils.left(r.getRazonSocial(), FelMaxLengths.RECEPTOR_NOMBRE.lenght()));
//		receptor.setNumRegIdTrib(StringUtils.left(r.getNumRegIdTrib(), FelMaxLengths.RECEPTOR_NUMREGIDTRIB.lenght())); // TODO agregar campo al objeto Entidad
//		receptor.setResidenciaFiscal(StringUtils.left(r.residenciaFiscal(), FelMaxLengths.RECEPTOR_RESIDENCIAFISCAL.lenght())); // TODO agregar el campo correcto de Entidad o agregar el campo a Entidad
		receptor.setRfc(StringUtils.left(r.getRfc(), FelMaxLengths.RECEPTOR_RFC.lenght()));
		receptor.setUsoCFDI(StringUtils.left(r.getUsoCFDI(), FelMaxLengths.RECEPTOR_USOCFDI.lenght()));
		return receptor;
	}
	
	/**
	 * Tomado de la documentación de FEL
	 * 
	 * cantidad (R) - Cantidad del concepto
	 * 
	 * ClaveProdServ (R) - Identificador para expresar la clave del producto conforme al catálogo SAT. [c_ClaveProdServ]
	 * 
	 * ClaveUnidad (R) - Identificador para precisar la clave de unidad de medida conforme al catálogo SAT. [c_ClaveUnidad]
	 * 
	 * Descripción (R) - Descripcion del concepto.
	 * 
	 * Importe (R) - Importe del concepto.
	 * 
	 * NoIdentificacion (O) - SKU del concepto.
	 * 
	 * Unidad (R) - Unidad del Concepto (Ejemplo. Kg, Pieza, Servicio)
	 * 
	 * ValorUnitario (R) - Precio unitario del concepto.
	 * 
	 * Impuestos (O) - Impuesto aplicable al concepto
	 * 
	 *  -Base	(R) - Importe Base del impuesto.
	 *
	 *  -Importe (R) - Importe del impuesto.
	 *
	 *  -Impuesto	(R) - Clave del catálogo para declarar el impuesto. [c_Impuesto]
	 *
	 *  -TasaOCuota (R) - Tasa referenciada al catálogo que indica el SAT. [c_TasaOCuota]
	 *
	 *  -TipoFactor (R) - Atributo condicional para señalar el valor de la tasa. [c_TipoFactor]
	 *
	 * R: Requerido
	 * O: Opcional
	 * 
	 * @param conceptos
	 * @return
	 */
	private ConceptoR[] llenarConceptos(ArrayList<Concepto> conceptos) {
		ArrayList<ConceptoR> lstConceptos = new ArrayList<ConceptoR>();
		
		for (Concepto c : conceptos) {
			ConceptoR cr = new ConceptoR();
			cr.setCantidad(new BigDecimal(c.getCantidad()));
			cr.setClaveProdServ(c.getClaveProdServ()); 
			cr.setClaveUnidad(c.getClaveUnidad());
			cr.setDescripcion(c.getDescripcion().trim());
			cr.setImporte(new BigDecimal(c.getImporte()).setScale(2, RoundingMode.HALF_UP));
			cr.setNoIdentificacion(c.getCodigo().trim());
			cr.setUnidad(c.getUnidad());
			cr.setValorUnitario(new BigDecimal(c.getPrecioUnitario()).setScale(2, RoundingMode.HALF_UP));
			cr.setDescuento(new BigDecimal(c.getDescuento()).setScale(2, RoundingMode.HALF_UP));
			
			if (c.getImpuestos() != null) {
				ImpuestosConceptoR imps = new ImpuestosConceptoR();
				ArrayList<RetencionConceptoR> retenciones = new ArrayList<RetencionConceptoR>();
				ArrayList<TrasladoConceptoR> traslados = new ArrayList<TrasladoConceptoR>();
				for (ImpuestoConcepto ic : c.getImpuestos()) {
					if ("R".equalsIgnoreCase(ic.getTipo())) {
						RetencionConceptoR rcr = new RetencionConceptoR();
						rcr.setBase(new BigDecimal(ic.getBase()).setScale(2, RoundingMode.HALF_UP));
						rcr.setImporte(new BigDecimal(ic.getImporte()).setScale(2, RoundingMode.HALF_UP));
						rcr.setImpuesto(ic.getImpuesto());
						rcr.setTasaOCuota(new BigDecimal(ic.getTasaOCuota()).setScale(6, RoundingMode.HALF_UP));
						rcr.setTipoFactor(ic.getTipoFactor());
						retenciones.add(rcr);
					} else if ("T".equalsIgnoreCase(ic.getTipo())) {
						TrasladoConceptoR tcr = new TrasladoConceptoR();
						tcr.setBase(new BigDecimal(ic.getBase()).setScale(2, RoundingMode.HALF_UP));
						tcr.setImporte(new BigDecimal(ic.getImporte()).setScale(2, RoundingMode.HALF_UP));
						tcr.setImpuesto(ic.getImpuesto());
						tcr.setTasaOCuota(new BigDecimal(ic.getTasaOCuota()).setScale(6, RoundingMode.HALF_UP));
						tcr.setTipoFactor(ic.getTipoFactor());
						traslados.add(tcr);
					}
				}
				if (retenciones.size() > 0) {
					imps.setRetenciones(retenciones.toArray(new RetencionConceptoR[retenciones.size()]));
				}
				if (traslados.size() > 0) {
					imps.setTraslados(traslados.toArray(new TrasladoConceptoR[traslados.size()]));
				}
				cr.setImpuestos(imps);
			}
			
			lstConceptos.add(cr);
		}
		
		return lstConceptos.toArray(new ConceptoR[lstConceptos.size()]);
	}
	
	private CfdiRelacionadosR llenarRelacionados(Relacionados relacionados) {
		CfdiRelacionadosR rel = null;
		if (relacionados != null) {
			rel = new CfdiRelacionadosR();
			rel.setTipoRelacion(relacionados.getTipoRelacion());
			rel.setCfdiRelacionado(relacionados.getUuids().toArray(new CfdiRelacionadoR[relacionados.getUuids().size()]));
		}
		return rel;
	}
	
	private Pagos10R llenarPagos(ArrayList<Pago> lstPagos) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		ArrayList<PagosPagoR> pagosR = new ArrayList<PagosPagoR>();
		for (Pago p : lstPagos) {
			PagosPagoR pagoR = new PagosPagoR();
			pagoR.setCadPago(p.getCadPago());
			pagoR.setCertPago(p.getCertPago());
			pagoR.setCtaBeneficiario(p.getCuentaBeneficiario());
			pagoR.setCtaOrdenante(p.getCuentaOrdenante());
			pagoR.setFechaPago(sdf.format(p.getFechaPago()));
			pagoR.setFormaDePagoP(p.getFormaPago());
			pagoR.setMonedaP(p.getMoneda());
			pagoR.setMonto(""+p.getMonto());
			pagoR.setNomBancoOrdExt(p.getBanco());
			pagoR.setNumOperacion(p.getNumOperacion());
			pagoR.setRfcEmisorCtaBen(p.getRfcEmisorCtaBen());
			pagoR.setRfcEmisorCtaOrd(p.getRfcOrdenante());
			pagoR.setSelloPago(p.getSelloPago());
			pagoR.setTipoCadPago(p.getTipoCadenaPago());
			pagoR.setTipoCambioP(new BigDecimal(p.getTipoCambio()).setScale(2, RoundingMode.HALF_UP));
			
			ArrayList<PagosPagoDoctoRelacionadoR> lstDocs = new ArrayList<PagosPagoDoctoRelacionadoR>();
			for (DocumentoRelacionado dr : p.getDocumentos()) {
				PagosPagoDoctoRelacionadoR doc = new PagosPagoDoctoRelacionadoR();
				doc.setFolio(dr.getFolio());
				doc.setIdDocumento(dr.getIdDocumento());
				doc.setImpPagado(new BigDecimal(dr.getImpPagado()).setScale(2, RoundingMode.HALF_UP));
				doc.setImpSaldoAnt(new BigDecimal(dr.getImpSaldoAnt()).setScale(2, RoundingMode.HALF_UP));
				doc.setImpSaldoInsoluto(new BigDecimal(dr.getImpSaldoInsoluto()).setScale(2, RoundingMode.HALF_UP));
				doc.setMetodoDePagoDR(dr.getMetodoPago());
				doc.setMonedaDR(dr.getMoneda());
				doc.setNumParcialidad(""+dr.getNumParcialidad());
				doc.setSerie(dr.getSerie());
				doc.setTipoCambioDR(new BigDecimal(dr.getTipoCambio()).setScale(2, RoundingMode.HALF_UP));
				lstDocs.add(doc);
			}
			pagoR.setDoctoRelacionado(lstDocs.toArray(new PagosPagoDoctoRelacionadoR[lstDocs.size()]));
			
			PagosPagoImpuestosR impuestos = new PagosPagoImpuestosR();
			impuestos.setTotalImpuestosRetenidos(new BigDecimal(p.getTotalImpuestosRetenidos()).setScale(2, RoundingMode.HALF_UP));
			impuestos.setTotalImpuestosTrasladados(new BigDecimal(p.getTotalImpuestosTrasladados()).setScale(2, RoundingMode.HALF_UP));
			ArrayList<PagosPagoImpuestosRetencionR> retenciones = new ArrayList<PagosPagoImpuestosRetencionR>();
			ArrayList<PagosPagoImpuestosTrasladoR> traslados = new ArrayList<PagosPagoImpuestosTrasladoR>();
			for (ImpuestoPago ip : p.getImpuestos()) {
				if ("R".equalsIgnoreCase(ip.getTipo())) {
					PagosPagoImpuestosRetencionR r = new PagosPagoImpuestosRetencionR();
					r.setImporte(""+ip.getImporte());
					r.setImpuesto(ip.getImpuesto());
					retenciones.add(r);
				}
				if ("T".equalsIgnoreCase(ip.getTipo())) {
					PagosPagoImpuestosTrasladoR t = new PagosPagoImpuestosTrasladoR();
					t.setImporte(""+ip.getImporte());
					t.setImpuesto(ip.getImpuesto());
					t.setTasaOCuota(""+ip.getTasaOCuota());
					t.setTipoFactor(ip.getTipoFactor());
					traslados.add(t);
				}
			}
			if (retenciones.size() > 0) {
				impuestos.setRetenciones(retenciones.toArray(new PagosPagoImpuestosRetencionR[retenciones.size()]));
			}
			if (traslados.size() > 0) {
				impuestos.setTraslados(traslados.toArray(new PagosPagoImpuestosTrasladoR[traslados.size()]));
			}
			pagoR.setImpuestos(impuestos);
		}
		
		Pagos10R pagos = new Pagos10R();
		pagos.setPago(pagosR.toArray(new PagosPagoR[pagosR.size()]));
		pagos.setVersion("1.0");
		
		return pagos;
	}
	
}
