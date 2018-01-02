package com.canauhtli.cfdi;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import org.beanio.builder.DelimitedParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;

import com.canauhtli.cfdi.db.ReciboNomina;
import com.canauhtli.cfdi.db.DBManager;
import com.canauhtli.cfdi.db.Periodo;
import com.canauhtli.cfdi.db.PeriodoStatus;
import com.canauhtli.cfdi.nomina.ConceptoNom;
import com.canauhtli.cfdi.nomina.DeduccionNom;
import com.canauhtli.cfdi.nomina.EmpleadoNom;
import com.canauhtli.cfdi.nomina.ErrorHandler;
import com.canauhtli.cfdi.nomina.HoraExtraNom;
import com.canauhtli.cfdi.nomina.Incapacidad;
import com.canauhtli.cfdi.nomina.InfoGeneral;
import com.canauhtli.cfdi.nomina.OtroPago;
import com.canauhtli.cfdi.nomina.PercepcionHoraExtra;
import com.canauhtli.cfdi.nomina.PercepcionJubilacionPensionRetiro;
import com.canauhtli.cfdi.nomina.PercepcionNom;
import com.canauhtli.cfdi.nomina.PercepcionSeparacionIndemnizacion;
import com.canauhtli.cfdi.nomina.ProcesoNomina;
import com.canauhtli.cfdi.nomina.Receptor;
import com.canauhtli.cfdi.nomina.ReciboNominaEmp;
import com.canauhtli.cfdi.nomina.Salario;
import com.canauhtli.cfdi.nomina.Totales;
import com.canauhtli.cfdi.pac.ClientePACException;
import com.canauhtli.cfdi.pac.ClienteServicioPAC;
import com.canauhtli.cfdi.pac.ComprobanteFiscal;
import com.canauhtli.cfdi.pac.bean.CompensacionSaldoAFavor;
import com.canauhtli.cfdi.pac.bean.Concepto;
import com.canauhtli.cfdi.pac.bean.Direccion;
import com.canauhtli.cfdi.pac.bean.Empleado;
import com.canauhtli.cfdi.pac.bean.Entidad;
import com.canauhtli.cfdi.pac.bean.HoraExtra;
import com.canauhtli.cfdi.pac.bean.JubilacionPensionRetiro;
import com.canauhtli.cfdi.pac.bean.Nomina;
import com.canauhtli.cfdi.pac.bean.Percepcion;
import com.canauhtli.cfdi.pac.bean.SeparacionIndemnizacion;
import com.canauhtli.cfdi.pac.types.Estado;
import com.canauhtli.cfdi.pac.types.TipoCFD;
import com.canauhtli.cfdi.pac.types.TipoDeduccion;
import com.canauhtli.cfdi.pac.types.TipoPercepcion;
import com.canauhtli.cfdi.sat.cfd33.Comprobante;
import com.canauhtli.cfdi.sat.cfd33.Comprobante.Complemento;
import com.canauhtli.cfdi.sat.timbre11.TimbreFiscalDigital;
import com.canauhtli.cfdi.tipo.Estatus;
import com.canauhtli.utils.Bandera;
import com.canauhtli.utils.XMLParser;

public class Generador {

	private static Logger log = LoggerFactory.getLogger(Generador.class);

	private DBManager madb;
	private Periodo periodo;
	private File archivo;
	private ProcesoNomina pn;
	
	private Entidad emisor;

	public Generador(DBManager ma) {
		madb = ma;
	}

	public int inicializa(String peri, File archivo) {
		Periodo p = new Periodo();
		p.setArchivo(archivo.getName());
		p.setPeriodo(peri);
		p.setStatus(PeriodoStatus.NUEVO.getStatus());

		int numres = madb.resetPeriodo(peri);
		log.info("Se desplazaron {} corridas anteriores", numres);

		periodo = madb.registraPeriodo(p);
		log.info("Nuevo ID [{}] para el periodo {}", periodo.getId(),
				periodo.getPeriodo());

		this.archivo = archivo;
		return periodo.getId();
	}

	public void leeEntrada() {
		StreamFactory factory = StreamFactory.newInstance();
		StreamBuilder builder = new StreamBuilder("nomFile");
		builder.format("delimited")
        	.parser(new DelimitedParserBuilder('|'))
        	.addRecord(EmpleadoNom.class)
        	.addRecord(InfoGeneral.class)
        	.addRecord(PercepcionNom.class)
        	.addRecord(DeduccionNom.class)
        	.addRecord(Incapacidad.class)
        	.addRecord(HoraExtraNom.class)
        	.addRecord(Receptor.class)
        	.addRecord(ConceptoNom.class)
        	.addRecord(Totales.class)
        	.addRecord(PercepcionHoraExtra.class)
        	.addRecord(PercepcionJubilacionPensionRetiro.class)
        	.addRecord(PercepcionSeparacionIndemnizacion.class)
        	.addRecord(OtroPago.class)
        	.ignoreUnidentifiedRecords();
		
		factory.define(builder);
		ErrorHandler eh = new ErrorHandler();
		Bandera agregable = new Bandera();
		agregable.setNuevo(true);
		eh.setBandera(agregable);
		BeanReader reader = factory.createReader("nomFile", archivo);
		reader.setErrorHandler(eh);
		pn = new ProcesoNomina();
		ReciboNominaEmp rn =  new ReciboNominaEmp();
		Object record = null;
		eh.setReciboActual(rn);
		try {
		while((record = reader.read()) != null) {
			log.debug("[{}] {}: {}", reader.getLineNumber(), reader.getRecordName(), record);
			if ("empleadoNom".equalsIgnoreCase(reader.getRecordName())) {
				if (!agregable.isNuevo()) {
					rn = new ReciboNominaEmp();
					eh.setReciboActual(rn);
				}
				rn.setEmpleado((EmpleadoNom) record);
				pn.addRecibo(rn);
				agregable.setOn(true);
				agregable.setNuevo(false);
			}
			if (agregable.isOn()) {
				if ("infoGeneral".equalsIgnoreCase(reader.getRecordName())) {
					rn.setGenerales((InfoGeneral) record);
				}
				if ("percepcionNom".equalsIgnoreCase(reader.getRecordName())) {
					rn.addPercepcion((PercepcionNom) record);
				}
				if ("deduccionNom".equalsIgnoreCase(reader.getRecordName())) {
					rn.addDeduccion((DeduccionNom) record);
				}
				if ("incapacidad".equalsIgnoreCase(reader.getRecordName())) {
					rn.addIncapacidad((Incapacidad) record);
				}
				if ("horaExtraNom".equalsIgnoreCase(reader.getRecordName())) {
					rn.addHoraExtra((HoraExtraNom) record);
				}
				if ("receptor".equalsIgnoreCase(reader.getRecordName())) {
					rn.setReceptor((Receptor) record);
				}
				if ("conceptoNom".equalsIgnoreCase(reader.getRecordName())) {
					rn.addConcepto((ConceptoNom) record);
				}
				if ("totales".equalsIgnoreCase(reader.getRecordName())) {
					rn.setTotales((Totales) record);
				}
				if ("percepcionHoraExtra".equalsIgnoreCase(reader.getRecordName())) {
					rn.setPercepcionHoraExtra((PercepcionHoraExtra) record);
				}
				if ("jupere".equalsIgnoreCase(reader.getRecordName())) {
					rn.setJubilacionPensionRetiro((PercepcionJubilacionPensionRetiro) record);
				}
				if ("percepcionSeparacionIndemnizacion".equalsIgnoreCase(reader.getRecordName())) {
					rn.setSeparacionIndemnizacion((PercepcionSeparacionIndemnizacion) record);
				}
				if ("otroPago".equalsIgnoreCase(reader.getRecordName())) {
					rn.addOtroPago((OtroPago) record);
				}
			}
		}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.info("Lei {} registros de empleado que puedo procesar", pn.getRecibos().size());
	}
	
	public void registraEntrada() {
		try {
			JAXBContext jc = JAXBContext.newInstance(ReciboNominaEmp.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty("eclipselink.media-type", "application/json");
			if (pn.tengoRecibos()) {
				for (ReciboNominaEmp rn : pn.getRecibos()) {
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					marshaller.marshal(rn, os);
					ReciboNomina recibo = new ReciboNomina();
					recibo.setIdPeriodo(periodo.getId());
					recibo.setNumEmp(rn.getEmpleado().getNumEmp());
					recibo.setEstatus(Estatus.NUEVO.getEstatus());
					recibo.setComprobanteFiscal("");
					recibo.setUuid("");
					recibo.setRecibo(os.toString());
					madb.registraRecibo(recibo);
					rn.setId(recibo.getIdReciboNomina());
				}
			}
			periodo.setStatus(PeriodoStatus.REGISTRADO.getStatus());
			madb.actualizaPeriodo(periodo);
		} catch (JAXBException e) {
			log.error("No pude definir el contexto para registrar los recibos", e);
		}
	}
	
	public ProcesoNomina generaRecibos(ClienteServicioPAC pac) {
		 if (pn.tengoRecibos()) {
			 for (ReciboNominaEmp rn : pn.getRecibos()) {
				 if (rn.isValido()) {
					 ComprobanteFiscal cf = preparaComprobante(rn);
					 ReciboNomina recibo = madb.obtenReciboNomina(rn.getId());
					 try {
						 String xml = pac.generaComprobante(cf);
						 recibo.setComprobanteFiscal(xml);
						 recibo.setEstatus(Estatus.EMITIDO.getEstatus());
						 rn.setXml(xml);
						 rn.setEstatus(Estatus.EMITIDO);
						 Comprobante cfdi = XMLParser.parseCfdi(xml);
						 rn.setCfdi(cfdi);
						 for (Complemento cp : cfdi.getComplemento()) {
							 for (Object any : cp.getAny()) {
								 Node compl = (Node) any;
								 if ("TimbreFiscalDigital".equalsIgnoreCase(compl.getLocalName())) {
									 TimbreFiscalDigital timbre = XMLParser.parseTimbreFiscal(compl);
									 recibo.setUuid(timbre.getUUID());
									 rn.setTimbre(timbre);
								 }
							 }
						 }
						 madb.actualizaReciboNomina(recibo);
					 } catch (ClientePACException e) {
						 log.error("No pude generar CFDI para {} - {}", rn.getEmpleado().getNumEmp(), periodo.getPeriodo(), e);
						 recibo.setEstatus(Estatus.ERROR.getEstatus());
					 } catch (CFDIException e) {
						log.error("No pude interpretar CFDI para {}", rn.getEmpleado().getNumEmp());
						recibo.setEstatus(Estatus.ERROR.getEstatus());
					}
				 }
			 }
		 }
		 periodo.setStatus(PeriodoStatus.EMITIDO.getStatus());
		 madb.actualizaPeriodo(periodo);
		 
		 return pn;
	}
	
	private ComprobanteFiscal preparaComprobante(ReciboNominaEmp rne) {
		ComprobanteFiscal cf = new ComprobanteFiscal();
		Entidad receptor = new Entidad();
		receptor.setRazonSocial(rne.getReceptor().getNombre());
		receptor.setRfc(rne.getReceptor().getRfc());
		Direccion direccion = new Direccion();
		direccion.setCalle(rne.getReceptor().getCalle());
		direccion.setNumExt(rne.getReceptor().getNumExt());
		direccion.setNumInt(rne.getReceptor().getNumInt());
		direccion.setColonia(rne.getReceptor().getColonia());
		direccion.setMunicipio(rne.getReceptor().getMunicipio());
		direccion.setEstado(Estado.fromClave(rne.getReceptor().getEstado()));
		direccion.setPais(rne.getReceptor().getPais());
		direccion.setCp(rne.getReceptor().getCp());
		receptor.setDireccion(direccion);
		cf.setReceptor(receptor);
		
		cf.setTipo(TipoCFD.NOMINA);
		cf.setFormaPago(rne.getGenerales().getFormaPago());
		cf.setMetodoPago(rne.getGenerales().getMetodoPago());
		cf.setMoneda(rne.getGenerales().getMoneda());
		cf.setImporte("");
		cf.setEmisor(emisor);
		
		for (ConceptoNom c : rne.getConceptos()) {
			Concepto concepto = new Concepto();
			concepto.setCantidad(c.getCantidad());
			concepto.setDescripcion(c.getDescripcion());
			concepto.setUnidad(c.getUnidad());
			concepto.setPrecioUnitario(c.getPrecioUnitario());
			cf.addConcepto(concepto);
		}
		
		cf.setTotalDescuento(rne.getTotales().getTotalDeducciones());
		cf.setTotal(cf.getSubTotal() - cf.getTotalDescuento() - cf.getTotalRetenciones());
		
		Nomina nom = new Nomina();
		nom.setTipoNomina(rne.getGenerales().getTipoNomina());
		nom.setTotalPercepciones(rne.getTotales().getTotalPercepciones());
		nom.setTotalDeducciones(rne.getTotales().getTotalDeducciones());
		nom.setTotalOtrosPagos(rne.getTotales().getTotalOtrosPagos());
		nom.setTotalSueldos(rne.getTotales().getTotalSueldos());
		nom.setTotalSeparacionIndemnizacion(rne.getTotales().getTotalSeparacionIndemnizacion());
		nom.setTotalJubilacionPensionRetiro(rne.getTotales().getTotalJubilacionPensionRetiro());
		nom.setTotalOtrasDeducciones(rne.getTotales().getTotalOtrasDeducciones());
		nom.setTotalImpuestosRetenidos(rne.getTotales().getTotalImpuestosRetenidos());
		nom.setEmpleado(traduceEmpleado(rne.getEmpleado(), rne.getReceptor()));
		if (rne.getPercepciones() != null) {
			for (Salario s : rne.getPercepciones()) {
				Percepcion p = new Percepcion();
				p.setClave(s.getClave());
				p.setConcepto(s.getConcepto());
				p.setImporteExento(s.getImporteExcento());
				p.setImporteGravado(s.getImporteGravado());
				p.setTipoPercepcion(TipoPercepcion.fromClave(s.getTipo()));
				nom.addPercepcion(p);
			}
		}
		if (rne.getDeducciones() != null) {
			for (Salario s : rne.getDeducciones()) {
				Percepcion d = new Percepcion();
				d.setClave(s.getClave());
				d.setConcepto(s.getConcepto());
				d.setImporte(s.getImporteGravado());
				d.setImporteExento(s.getImporteExcento());
				d.setImporteGravado(s.getImporteGravado());
				d.setTipoDeduccion(TipoDeduccion.fromClave(s.getTipo()));
				nom.addDeduccion(d);
			}
		}
		if (rne.getPercepcionHoraExtra() != null) {
			Percepcion he = new Percepcion();
			he.setClave(rne.getPercepcionHoraExtra().getClave());
			he.setConcepto(rne.getPercepcionHoraExtra().getConcepto());
			he.setImporteExento(rne.getPercepcionHoraExtra().getImporteExcento());
			he.setImporteGravado(rne.getPercepcionHoraExtra().getImporteGravado());
			he.setTipoPercepcion(TipoPercepcion.fromClave(rne.getPercepcionHoraExtra().getTipo()));
			nom.setPercepcionHoraExtra(he);
		}
		if (rne.getHorasExtra() != null) {
			for (HoraExtraNom hen : rne.getHorasExtra()) {
				HoraExtra he = new HoraExtra();
				he.setDias(hen.getDias());
				he.setHoras(hen.getHoras());
				he.setTipo(hen.getTipo());
				he.setImportePagado(hen.getImportePagado());
				nom.addHoraExtra(he);
			}
		}
		
		if (rne.getJubilacionPensionRetiro() != null) {
			JubilacionPensionRetiro jpr = new JubilacionPensionRetiro();
			jpr.setIngresoAcumulable(rne.getJubilacionPensionRetiro().getIngresoAcumulable());
			jpr.setIngresoNoAcumulable(rne.getJubilacionPensionRetiro().getIngresoNoAcumulable());
			jpr.setMontoDiario(rne.getJubilacionPensionRetiro().getMontoDiario());
			jpr.setTotalParcialidad(rne.getJubilacionPensionRetiro().getTotalParcialidad());
			jpr.setTotalUnaExhibicion(rne.getJubilacionPensionRetiro().getTotalUnaExhibicion());
			nom.setPercepcionJubilacionPensionRetiro(jpr);
		}
		
		if (rne.getSeparacionIndemnizacion() != null) {
			SeparacionIndemnizacion si = new SeparacionIndemnizacion();
			si.setIngresoAcumulable(rne.getSeparacionIndemnizacion().getIngresoAcumulable());
			si.setIngresoNoAcumulable(rne.getSeparacionIndemnizacion().getIngresoNoAcumulable());
			si.setNumAñosServicio(rne.getSeparacionIndemnizacion().getNumAñosServicio());
			si.setTotalPagado(rne.getSeparacionIndemnizacion().getTotalPagado());
			si.setUltimoSueldoMensOrd(rne.getSeparacionIndemnizacion().getUltimoSueldoMensOrd());
			nom.setPercepcionSeparacionIndemnizacion(si);
		}
		
		if (rne.getIncapacidades() != null) {
			for (Incapacidad i : rne.getIncapacidades()) {
				com.canauhtli.cfdi.pac.bean.Incapacidad inc = new com.canauhtli.cfdi.pac.bean.Incapacidad();
				inc.setDescuento(i.getDescuento());
				inc.setDias(i.getDias());
				inc.setTipo(i.getTipo());
				nom.addIncapacidad(inc);
			}
		}
		
		if (rne.getOtrosPagos() != null) {
			for (OtroPago op : rne.getOtrosPagos()) {
				com.canauhtli.cfdi.pac.bean.OtroPago otroPago = new com.canauhtli.cfdi.pac.bean.OtroPago();
				otroPago.setTipoOtroPago(op.getTipoOtroPago());
				otroPago.setClave(op.getClave());
				otroPago.setConcepto(op.getConcepto());
				otroPago.setImporte(op.getImporte());
				if (op.isSubsidio()) {
					otroPago.setSubsidioCausado(op.getSubsidioCausado());
				}
				if (op.isSaldo()) {
					CompensacionSaldoAFavor saldoFavor = new CompensacionSaldoAFavor();
					saldoFavor.setSaldoAFavor(op.getSaldoAFavor());
					saldoFavor.setAño(op.getAño());
					saldoFavor.setRemanente(op.getRemanente());
					otroPago.setCompensacion(saldoFavor);
				}
			}
		}
		
		cf.setNomina(nom);
		return cf;
	}
	
	private Empleado traduceEmpleado(EmpleadoNom e, Receptor r) {
		Empleado emp = new Empleado();
		emp.setNumEmp(e.getNumEmp());
		emp.setCurp(e.getCurp());
		emp.setRegimen(e.getRegimen());
		emp.setFechaPago(Calendar.getInstance());
		emp.getFechaPago().setTime(e.getFechaPago());
		emp.setFechaIniPago(Calendar.getInstance());
		emp.getFechaIniPago().setTime(e.getFechaIniPago());
		emp.setFechaFinPago(Calendar.getInstance());
		emp.getFechaFinPago().setTime(e.getFechaFinPago());
		emp.setNumDiasPagados(e.getNumDiasPagados());
		emp.setPeriodicidad(e.getPeriodicidad());
		emp.setNss(e.getNss());
		emp.setDepartamento(e.getDepartamento());
		emp.setCuentaBancaria(e.getCuentaBancaria());
		emp.setBanco(e.getBanco());
		emp.setFechaInicioRelLaboral(Calendar.getInstance());
		emp.getFechaInicioRelLaboral().setTime(e.getFechaInicioRelLaboral());
		emp.setCodigoAntiguedad(e.getAntiguedad());
		emp.setPuesto(e.getPuesto());
		emp.setTipoContrato(e.getTipoContrato());
		emp.setTipoJornada(e.getTipoJornada());
		emp.setSalarioBase(e.getSalarioBase());
		emp.setRiesgoPuesto(e.getRiesgoPuesto());
		emp.setSalarioDiarioIntegrado(e.getSalarioDiarioIntegrado());
		emp.setPlaza(e.getPlaza());
		emp.setCorreo(e.getCorreo());
		emp.setSindicalizado(e.getSindicalizado());
		
		Direccion direccion = new Direccion();
		direccion.setCalle(r.getCalle());
		direccion.setCiudad("");
		direccion.setColonia(r.getColonia());
		direccion.setCp(r.getCp());
		direccion.setEstado(Estado.fromClave(r.getEstado()));
		direccion.setMunicipio(r.getMunicipio());
		direccion.setNumExt(r.getNumExt());
		direccion.setNumInt(r.getNumInt());
		direccion.setPais(r.getPais());
		emp.setDireccion(direccion);
		return emp;
	}
	
	public void validaRecibos() {
		if (pn.tengoRecibos()) {
			for (ReciboNominaEmp rn : pn.getRecibos()) {
				 if (rn.isValido()) {
					 // Validar que cuando existen horas extra en percepciones, se tenga el detalle de las horas extra
					 boolean hayTiempoExtra = false;
					 for (Salario p : rn.getPercepciones()) {
						 if (TipoPercepcion._019.getClave().equals(p.getTipo())) {
							 hayTiempoExtra = true;
						 }
					 }
					 if (hayTiempoExtra && ((rn.getHorasExtra() == null) || (rn.getHorasExtra().isEmpty()))) {
						 rn.setValido(false);
						 log.error("Falta detalle de Horas Extra para el empleado {}, no se puede generar recibo", rn.getEmpleado().getNumEmp());
					 }
				 }
			}
		}
	}
	
	public void setEmisor(Entidad emisor) {
		this.emisor = emisor;
	}
}
