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
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CompensacionSaldosAFavorR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionNomina12R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionesNomina12R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorNomina12R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.HorasExtra12R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConceptoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IncapacidadNomina12R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.JubilacionPensionRetiroR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Nomina12R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtroPagoNomina12R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Pagos10R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosRetencionR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosTrasladoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Percepcion12R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PercepcionesNomina12R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorNomina12R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionConceptoR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SeparacionIndemnizacionR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubsidioAlEmpleoR;
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
import com.canauhtli.cfdi.pac.bean.HoraExtra;
import com.canauhtli.cfdi.pac.bean.ImpuestoConcepto;
import com.canauhtli.cfdi.pac.bean.ImpuestoPago;
import com.canauhtli.cfdi.pac.bean.Incapacidad;
import com.canauhtli.cfdi.pac.bean.Nomina;
import com.canauhtli.cfdi.pac.bean.OtroPago;
import com.canauhtli.cfdi.pac.bean.Pago;
import com.canauhtli.cfdi.pac.bean.Percepcion;
import com.canauhtli.cfdi.pac.bean.Relacionados;
import com.canauhtli.cfdi.pac.types.TipoCFD;
import com.canauhtli.cfdi.pac.types.TipoDeduccion;
import com.canauhtli.cfdi.pac.types.TipoPercepcion;

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
		
		if (TipoCFD.NOMINA == cf.getTipo()) {
			comprobante.setNomina(llenarNomina(cf.getNomina(), cf.getEmisor().getRegistroPatronal()));
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
			log.info("CodigoConfirmacion: " + response.getFolioGenerado());
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
	 * Tomado de la documentaci�n de FEL
	 * 
	 * ClaveCFDI (R) -	FAC	Para el caso de emisi�n de Factura. Funci�n fiscal: Ingreso.
	 * 					HON	Para el caso de emisi�n de Recibo de Honorarios. Funci�n fiscal: Ingreso.
	 * 					ARR	Para el caso de emisi�n de Recibo de Arrendamiento. Funci�n fiscal: Ingreso.
	 *			 		PAG	Para el caso de emisi�n de Recibo de Pago. Funci�n fiscal: Ingreso.
	 *					CAR	Para el caso de emisi�n de Nota de Cargo. Funci�n fiscal: Ingreso.
	 *					CRE	Para el caso de emisi�n de Nota de Cr�dito. Funci�n fiscal: Egreso.
	 *					DEV	Para el caso de emisi�n de Nota de Devoluci�n. Funci�n fiscal: Egreso.
	 *					POR	Para el caso de emisi�n de Carta Porte. Funci�n fiscal: Traslado.
	 *					DON	Para el caso de emisi�n de Donatarias. Funci�n fiscal: Egreso.
	 *					NOM12	Para el caso de emisi�n de Nomina. Funcion fiscal: Egreso
	 *					CPI	Para el caso de emisi�n de Carta Porte. Funci�n fiscal: Ingreso.
	 *					ING	Para el caso de emisi�n de Recibo de Ingreso. Funci�n fiscal: Ingreso.
	 *					CPA	Para el caso de emisi�n de Complemento de Pagos. Funci�n fiscal: Ingreso.
	 *
	 * CondicionesDePago (O) - Leyenda que indique las condiciones de pago.
	 *	
	 * Fecha (O) - [YYYY-MM-DDTHH:mm:SS] Par�metro para cambiar la fecha de emisi�n del CFDI,
	 * 			   m�ximo 24 horas previas a la actual.
	 *
	 * Folio (O) - Par�metro para declarar un Folio para el CFDI.
	 *
	 * FormaDePago	(R) - Pago en una sola exhibici�n	Leyenda que deber� ir como forma de pago.
	 *					  Parcialidades	Leyenda que deber� ir como forma de pago en caso de parcialidades.  En este caso deber� incluirse la variable "Parcialidades 1/3" por ejemplo.
	 *		
	 * LugarExpedicion	(R) - El lugar donde fue Expedido el CFDI.
	 *
	 * MetodoDePago	(R) - Leyenda que indica el m�todo de pago utilizado de acuerdo al Cat�logo del SAT. [c_FormaPago]
	 *					  Si desea agregar m�s de un m�todo de pago, deber� colocarlo separado por comas y en orden de mayor a menor importe, por ejemplo (01,02,03).
	 *
	 * Moneda (R) - Indicador del tipo de moneda utilizada en el CFDI. [c_Moneda]
	 *	
	 * Referencia (R) - C�digo �nico para referenciar el comprobante a timbrar.
	 *		
	 * Serie (O) - Par�metro para declarar la Serie del CFDI.
	 *		
	 * SubTotal	(R) - Cifra decimal que representa el subtotal del CFDI. Ejemplo: 10540.55
	 *		
	 * Total (R) - Cifra decimal que representa el total del CFDI. Ejemplo 12600.00
	 *
	 * R: Requerido
	 * O: Opcional
	 * 
	 * @param comprobante Elemento de FEL con la informaci�n del comprobante.
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
		if ("MXN".equalsIgnoreCase(cf.getMoneda())) {
			comprobante.setTipoCambio(BigDecimal.ONE);
		} else {
			comprobante.setTipoCambio(new BigDecimal(cf.getTipoCambio()).setScale(2, RoundingMode.HALF_UP));
		}
		comprobante.setReferencia(""); // TODO definir, por ejemplo el nombre del archivo y agregar el campo correspondiente
		comprobante.setSerie(cf.getSerie());
		comprobante.setSubTotal(new BigDecimal(cf.getSubTotal()).setScale(2, RoundingMode.HALF_UP));
		comprobante.setTotal(new BigDecimal(cf.getTotal()).setScale(2, RoundingMode.HALF_UP));
		comprobante.setDescuento(new BigDecimal(cf.getTotalDescuento()).setScale(2, RoundingMode.HALF_UP));
	}
	
	/**
	 * Tomado de la documentaci�n de FEL
	 * 
	 * Nombre (R) - El nombre comercial del usuario Emisor, que se mostrar� en el comprobante a emitir.
	 * 
	 * R�gimen Fiscal (R) - Valor del cat�logo c_tipoRegimen que otorga el SAT para declarar el R�gimen Fiscal
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
	 * Tomado de la documentaci�n de FEL
	 * 
	 * Nombre (R) - El nombre comercial (arbitrario) de su cliente, el cual ser� el receptor del CFDI a emitirse.
	 * 				La informaci�n que se proporcione sobre el receptor ser� actualizada al instante siempre que el
	 * 				cliente mencionado ya exista en la base de datos, en caso contrario ser� dado de alta como nuevo cliente.
	 * 				Esto a nivel interno de su cuenta en FEL.
	 * 
	 * NumRegIDTrib (O) - Si utiliza el complemento de Comercio Exterior, deber� declarar este valor correspondiente 
	 * 					  al Identificador de Exportaci�n.
	 * 
	 * ResidenciaFiscal (O) - Si utiliza el complemento de Comercio Exterior, deber� declarar el valor correspondiente
	 * 						  a la Residencia Fiscal. [c_Pais]
	 * 
	 * Rfc (R) - El RFC del Receptor del CFDI. Ser� validado de acuerdo a una expresi�n regular de formato correcto de RFC.
	 * 
	 * UsoCFDI (R) - Param�tro para declarar el uso que se le dar� al CFDI. [c_UsoCFDI]
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
	 * Tomado de la documentaci�n de FEL
	 * 
	 * cantidad (R) - Cantidad del concepto
	 * 
	 * ClaveProdServ (R) - Identificador para expresar la clave del producto conforme al cat�logo SAT. [c_ClaveProdServ]
	 * 
	 * ClaveUnidad (R) - Identificador para precisar la clave de unidad de medida conforme al cat�logo SAT. [c_ClaveUnidad]
	 * 
	 * Descripci�n (R) - Descripcion del concepto.
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
	 *  -Impuesto	(R) - Clave del cat�logo para declarar el impuesto. [c_Impuesto]
	 *
	 *  -TasaOCuota (R) - Tasa referenciada al cat�logo que indica el SAT. [c_TasaOCuota]
	 *
	 *  -TipoFactor (R) - Atributo condicional para se�alar el valor de la tasa. [c_TipoFactor]
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
	
	public Nomina12R[] llenarNomina(Nomina nom, String regPat) {
		Nomina12R nomina = new Nomina12R();
		nomina.setTipoNomina(nom.getTipoNomina());
		nomina.setFechaPago(nom.getEmpleado().getFechaPago());
		nomina.setFechaInicialPago(nom.getEmpleado().getFechaIniPago());
		nomina.setFechaFinalPago(nom.getEmpleado().getFechaFinPago());
		nomina.setNumDiasPagados(new BigDecimal(nom.getEmpleado().getNumDiasPagados()));
		
		EmisorNomina12R emisor = new EmisorNomina12R();
		emisor.setRegistroPatronal(regPat);
		nomina.setEmisorNomina12R(emisor);
		
		ReceptorNomina12R receptor = new ReceptorNomina12R();
		receptor.setCURP(nom.getEmpleado().getCurp());
		receptor.setNumSeguridadSocial(nom.getEmpleado().getNss());
		receptor.setFechaInicioRelLaboral(nom.getEmpleado().getFechaInicioRelLaboral());
		receptor.setAntiguedad(nom.getEmpleado().getAntiguedad());
		receptor.setTipoContrato(nom.getEmpleado().getTipoContrato());
		if ("S".equalsIgnoreCase(nom.getEmpleado().getSindicalizado())) {
			receptor.setSindicalizado("SI");
		}
		receptor.setTipoJornada(nom.getEmpleado().getTipoJornada());
		receptor.setTipoRegimen(nom.getEmpleado().getRegimen());
		receptor.setNumEmpleado(nom.getEmpleado().getNumEmp());
		receptor.setDepartamento(nom.getEmpleado().getDepartamento());
		receptor.setPuesto(nom.getEmpleado().getPuesto());
		receptor.setRiesgoPuesto(nom.getEmpleado().getRiesgoPuesto());
		receptor.setPeriodicidadPago(nom.getEmpleado().getPeriodicidad());
		receptor.setBanco(nom.getEmpleado().getBanco());
		receptor.setCuentaBancaria(nom.getEmpleado().getCuentaBancaria());
		receptor.setSalarioBaseCotApor(new BigDecimal(nom.getEmpleado().getSalarioBase()).setScale(2, RoundingMode.HALF_UP));
		receptor.setSalarioDiarioIntegrado(new BigDecimal(nom.getEmpleado().getSalarioDiarioIntegrado()).setScale(2, RoundingMode.HALF_UP));
		receptor.setClaveEntFed(nom.getEmpleado().getDireccion().getEstado().getClave());
		nomina.setReceptorNomina12R(receptor);
		
		// Percepciones
		if ((nom.getPercepciones() != null) && !nom.getPercepciones().isEmpty()) {
			nomina.setTotalPercepciones(new BigDecimal(nom.getTotalPercepciones()).setScale(2, RoundingMode.HALF_UP));
			PercepcionesNomina12R percepciones = new PercepcionesNomina12R();
			percepciones.setTotalSueldos(new BigDecimal(nom.getTotalSueldos()).setScale(2, RoundingMode.HALF_UP));
			percepciones.setTotalGravado(new BigDecimal(nom.getTotalGravadoPercepcion()).setScale(2, RoundingMode.HALF_UP));
			percepciones.setTotalExento(new BigDecimal(nom.getTotalExcentoPercepcion()).setScale(2, RoundingMode.HALF_UP));
			
			boolean separacionIndemnizacion = false;
			boolean jubilacionPensionRetiro = false;
			Percepcion12R percepcionHE = null;
			ArrayList<Percepcion12R> lstPercepciones = new ArrayList<Percepcion12R>();
			for (Percepcion p : nom.getPercepciones()) {
				if (p.getTipoPercepcion() == TipoPercepcion._019) {
					if (percepcionHE == null) {
						percepcionHE = new Percepcion12R();
						percepcionHE.setTipoPercepcion(TipoPercepcion._019.getClave());
						percepcionHE.setClave(p.getClave());
						percepcionHE.setConcepto(p.getConcepto());
						percepcionHE.setImporteGravado(new BigDecimal(p.getImporteGravado()).setScale(2, 4));
						percepcionHE.setImporteExento(new BigDecimal(p.getImporteExento()).setScale(2, 4));
						lstPercepciones.add(percepcionHE);
						ArrayList<HorasExtra12R> lstHE = new ArrayList<HorasExtra12R>();
						for (HoraExtra he : nom.getHorasExtra()) {
							HorasExtra12R her = new HorasExtra12R();
							her.setDias(he.getDias());
							her.setHorasExtra(he.getHoras());
							her.setImportePagado(new BigDecimal(he.getImportePagado()).setScale(2, 4));
							her.setTipoHoras(he.getTipo());
							lstHE.add(her);
						}
						percepcionHE.setHorasExtra(lstHE.toArray(new HorasExtra12R[lstHE.size()]));
					} else {
						percepcionHE.setImporteGravado(percepcionHE.getImporteGravado().add(new BigDecimal(p.getImporteGravado()).setScale(2, 4)));
						percepcionHE.setImporteExento(percepcionHE.getImporteExento().add(new BigDecimal(p.getImporteExento()).setScale(2, 4)));
					}
					
				} else {
					Percepcion12R percepcion = new Percepcion12R();
					percepcion.setTipoPercepcion(StringUtils.leftPad((String)p.getTipoPercepcion().getClave(), 3, "0"));
					percepcion.setClave(p.getClave());
					percepcion.setConcepto(p.getConcepto());
					percepcion.setImporteGravado(new BigDecimal(p.getImporteGravado()).setScale(2, 4));
					percepcion.setImporteExento(new BigDecimal(p.getImporteExento()).setScale(2, 4));
					lstPercepciones.add(percepcion);
				
					if ("022".equals(percepcion.getTipoPercepcion()) ||
						"023".equals(percepcion.getTipoPercepcion()) || 
						"025".equals(percepcion.getTipoPercepcion())) {
						separacionIndemnizacion = true;
					}
					if ("039".equals(percepcion.getTipoPercepcion()) ||
						"044".equals(percepcion.getTipoPercepcion())) {
						jubilacionPensionRetiro = true;
					}
				}
			}
			
			if (separacionIndemnizacion) {
				percepciones.setTotalSeparacionIndemnizacion(new BigDecimal(nom.getTotalSeparacionIndemnizacion()).setScale(2, RoundingMode.HALF_UP));
			}
			if (jubilacionPensionRetiro) {
				percepciones.setTotalJubilacionPensionRetiro(new BigDecimal(nom.getTotalJubilacionPensionRetiro()).setScale(2, RoundingMode.HALF_UP));
			}
			
			percepciones.setListaPercepciones(lstPercepciones.toArray(new Percepcion12R[lstPercepciones.size()]));
			nomina.setPercepcionesNomina12R(percepciones);
		}
		
		// Jubilacion Pension Retiro
		if (nom.getPercepcionJubilacionPensionRetiro() != null) {
			PercepcionesNomina12R percepciones = nomina.getPercepcionesNomina12R() != null ? nomina.getPercepcionesNomina12R() : new PercepcionesNomina12R();
			JubilacionPensionRetiroR jubilacionPensionRetiro = new JubilacionPensionRetiroR();
			jubilacionPensionRetiro.setIngresoAcumulable(new BigDecimal(nom.getPercepcionJubilacionPensionRetiro().getIngresoAcumulable()).setScale(2, RoundingMode.HALF_UP));
			jubilacionPensionRetiro.setIngresoNoAcumulable(new BigDecimal(nom.getPercepcionJubilacionPensionRetiro().getIngresoNoAcumulable()).setScale(2, RoundingMode.HALF_UP));
			jubilacionPensionRetiro.setMontoDiario(new BigDecimal(nom.getPercepcionJubilacionPensionRetiro().getMontoDiario()).setScale(2, RoundingMode.HALF_UP));
			jubilacionPensionRetiro.setTotalParcialidad(new BigDecimal(nom.getPercepcionJubilacionPensionRetiro().getTotalParcialidad()).setScale(2, RoundingMode.HALF_UP));
			jubilacionPensionRetiro.setTotalUnaExhibicion(new BigDecimal(nom.getPercepcionJubilacionPensionRetiro().getTotalUnaExhibicion()).setScale(2, RoundingMode.HALF_UP));
			percepciones.setJubilacionPensionRetiroR(jubilacionPensionRetiro);
		}
				
		// Separacion Indemnizacion
		if (nom.getPercepcionSeparacionIndemnizacion() != null) {
			PercepcionesNomina12R percepciones = nomina.getPercepcionesNomina12R() != null ? nomina.getPercepcionesNomina12R() : new PercepcionesNomina12R();
			SeparacionIndemnizacionR separacionIndemnizacion = new SeparacionIndemnizacionR();
			separacionIndemnizacion.setIngresoAcumulable(new BigDecimal(nom.getPercepcionSeparacionIndemnizacion().getIngresoAcumulable()).setScale(2, RoundingMode.HALF_UP));
			separacionIndemnizacion.setIngresoNoAcumulable(new BigDecimal(nom.getPercepcionSeparacionIndemnizacion().getIngresoNoAcumulable()).setScale(2, RoundingMode.HALF_UP));
			separacionIndemnizacion.setNumAñosServicio(nom.getPercepcionSeparacionIndemnizacion().getNumAñosServicio());
			separacionIndemnizacion.setTotalPagado(new BigDecimal(nom.getPercepcionSeparacionIndemnizacion().getTotalPagado()).setScale(2, RoundingMode.HALF_UP));
			separacionIndemnizacion.setUltimoSueldoMensOrd(new BigDecimal(nom.getPercepcionSeparacionIndemnizacion().getUltimoSueldoMensOrd()).setScale(2, RoundingMode.HALF_UP));
			percepciones.setSeparacionIndemnizacionR(separacionIndemnizacion);
		}
		
		// Deducciones
		if ((nom.getDeducciones() != null) && !nom.getDeducciones().isEmpty()) {
			nomina.setTotalDeducciones(new BigDecimal(nom.getTotalDeducciones()).setScale(2, RoundingMode.HALF_UP));
			DeduccionesNomina12R deducciones = new DeduccionesNomina12R();
			deducciones.setTotalOtrasDeducciones(new BigDecimal(nom.getTotalOtrasDeducciones()).setScale(2, RoundingMode.HALF_UP));
			boolean retenciones = false;
			ArrayList<DeduccionNomina12R> lstDeducciones = new ArrayList<DeduccionNomina12R>();
			for (Percepcion d : nom.getDeducciones()) {
				DeduccionNomina12R deduccion = new DeduccionNomina12R();
				deduccion.setTipoDeduccion(StringUtils.leftPad((String)d.getTipoDeduccion().getClave(), 3, "0"));
				deduccion.setClave(d.getClave());
				deduccion.setConcepto(d.getConcepto());
				deduccion.setImporte(new BigDecimal(d.getImporte()).setScale(2, RoundingMode.HALF_UP));
				lstDeducciones.add(deduccion);
				if (d.getTipoDeduccion() == TipoDeduccion._002) {
					retenciones = true;
				}
			}
			
			if (retenciones) {
				deducciones.setTotalImpuestosRetenidos(new BigDecimal(nom.getTotalImpuestosRetenidos()).setScale(2, RoundingMode.HALF_UP));
			}
			deducciones.setListaDeducciones(lstDeducciones.toArray(new DeduccionNomina12R[lstDeducciones.size()]));
			nomina.setDeduccionesNomina12R(deducciones);
		}
		
		// Incapacidades
		if ((nom.getIncapacidades() != null) && !nom.getIncapacidades().isEmpty()) {
			ArrayList<IncapacidadNomina12R> incapacidades	 = new ArrayList<IncapacidadNomina12R>();	
			for (Incapacidad i : nom.getIncapacidades()) {
				IncapacidadNomina12R incapacidad = new IncapacidadNomina12R();
				incapacidad.setDiasIncapacidad(i.getDias());
				incapacidad.setTipoIncapacidad(i.getTipo());
				incapacidad.setImporteMonetario(new BigDecimal(i.getDescuento()).setScale(2, RoundingMode.HALF_UP));
				incapacidades.add(incapacidad);
			}
			nomina.setIncapacidadesNomina(incapacidades.toArray(new IncapacidadNomina12R[incapacidades.size()]));
		}
		
		// otros pagos
		if ((nom.getOtrosPagos() != null) && !nom.getOtrosPagos().isEmpty()) {
			ArrayList<OtroPagoNomina12R> otrosPagos = new ArrayList<OtroPagoNomina12R>();
			for (OtroPago op : nom.getOtrosPagos()) {
				OtroPagoNomina12R otroPago = new OtroPagoNomina12R();
				otroPago.setTipoOtroPago(op.getTipoOtroPago());
				otroPago.setClave(op.getClave());
				otroPago.setConcepto(op.getConcepto());
				otroPago.setImporte(new BigDecimal(op.getImporte()).setScale(2, RoundingMode.HALF_UP));
						
				if (op.getSubsidioCausado() != null) {
					SubsidioAlEmpleoR subsidio = new SubsidioAlEmpleoR();
					subsidio.setSubsidioCausado(new BigDecimal(op.getSubsidioCausado()).setScale(2, RoundingMode.HALF_UP));
					otroPago.setSubsidioAlEmpleoR(subsidio);
				}
						
				if (op.getCompensacion() != null) {
					CompensacionSaldosAFavorR compensacion = new CompensacionSaldosAFavorR();
					compensacion.setSaldoAFavor(new BigDecimal(op.getCompensacion().getSaldoAFavor()).setScale(2, RoundingMode.HALF_UP));
					compensacion.setAño(op.getCompensacion().getAño());
					compensacion.setRemanenteSalFav(new BigDecimal(op.getCompensacion().getRemanente()).setScale(2, RoundingMode.HALF_UP));
					otroPago.setCompensacionSaldosAFavorR(compensacion);
				}
						
				otrosPagos.add(otroPago);
			}
			nomina.setOtrosPagos(otrosPagos.toArray(new OtroPagoNomina12R[otrosPagos.size()]));
		}
		
		Nomina12R n[] = new Nomina12R[1];
		n[0] = nomina;
		return n;
	}
	
}
