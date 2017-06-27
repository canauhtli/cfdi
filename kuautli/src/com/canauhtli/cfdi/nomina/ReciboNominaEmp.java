package com.canauhtli.cfdi.nomina;

import java.util.ArrayList;

import com.canauhtli.cfdi.sat.Comprobante;
import com.canauhtli.cfdi.sat.timbre.TimbreFiscalDigital;
import com.canauhtli.cfdi.tipo.Estatus;

public class ReciboNominaEmp {

	private EmpleadoNom empleado;
	private InfoGeneral generales;
	private Totales totales;
	private Salario percepcionHoraExtra;
	private PercepcionJubilacionPensionRetiro jubilacionPensionRetiro;
	private PercepcionSeparacionIndemnizacion separacionIndemnizacion;
	private ArrayList<Salario> percepciones;
	private ArrayList<Salario> deducciones;
	private ArrayList<Incapacidad> incapacidades;
	private ArrayList<HoraExtraNom> horasExtra;
	private ArrayList<OtroPago> otrosPagos;
	private Receptor receptor;
	private ArrayList<ConceptoNom> conceptos;
	private boolean valido = true;
	private Estatus estatus;
	
	// Datos del cfdi emitido
	private String xml;
	private String pathPdf;
	private Comprobante cfdi;
	private TimbreFiscalDigital timbre;
	
	private int id;
	
	public EmpleadoNom getEmpleado() {
		return empleado;
	}
	public void setEmpleado(EmpleadoNom empleado) {
		this.empleado = empleado;
	}
	public InfoGeneral getGenerales() {
		return generales;
	}
	public void setGenerales(InfoGeneral generales) {
		this.generales = generales;
	}
	public Totales getTotales() {
		return totales;
	}
	public void setTotales(Totales totales) {
		this.totales = totales;
	}
	public Salario getPercepcionHoraExtra() {
		return percepcionHoraExtra;
	}
	public void setPercepcionHoraExtra(Salario percepcionHoraExtra) {
		this.percepcionHoraExtra = percepcionHoraExtra;
	}
	
	public PercepcionJubilacionPensionRetiro getJubilacionPensionRetiro() {
		return jubilacionPensionRetiro;
	}
	public void setJubilacionPensionRetiro(PercepcionJubilacionPensionRetiro jubilacionPensionRetiro) {
		this.jubilacionPensionRetiro = jubilacionPensionRetiro;
	}
	
	public PercepcionSeparacionIndemnizacion getSeparacionIndemnizacion() {
		return separacionIndemnizacion;
	}
	public void setSeparacionIndemnizacion(PercepcionSeparacionIndemnizacion separacionIndemnizacion) {
		this.separacionIndemnizacion = separacionIndemnizacion;
	}
	public ArrayList<Salario> getPercepciones() {
		return percepciones;
	}
	public void setPercepciones(ArrayList<Salario> percepciones) {
		this.percepciones = percepciones;
	}
	public void addPercepcion(Salario percepcion) {
		if (percepciones == null) {
			percepciones = new ArrayList<Salario>();
		}
		percepciones.add(percepcion);
	}
	public ArrayList<Salario> getDeducciones() {
		return deducciones;
	}
	public void setDeducciones(ArrayList<Salario> deducciones) {
		this.deducciones = deducciones;
	}
	public void addDeduccion(Salario deduccion) {
		if (deducciones == null) {
			deducciones = new ArrayList<Salario>();
		}
		deducciones.add(deduccion);
	}
	public ArrayList<Incapacidad> getIncapacidades() {
		return incapacidades;
	}
	public void setIncapacidades(ArrayList<Incapacidad> incapacidades) {
		this.incapacidades = incapacidades;
	}
	public void addIncapacidad(Incapacidad i) {
		if (incapacidades == null) {
			incapacidades = new ArrayList<Incapacidad>();
		}
		incapacidades.add(i);
	}
	public ArrayList<HoraExtraNom> getHorasExtra() {
		return horasExtra;
	}
	public void setHorasExtra(ArrayList<HoraExtraNom> horasExtra) {
		this.horasExtra = horasExtra;
	}
	public void addHoraExtra(HoraExtraNom he) {
		if (horasExtra == null) {
			horasExtra = new ArrayList<HoraExtraNom>();
		}
		horasExtra.add(he);
	}
	public ArrayList<OtroPago> getOtrosPagos() {
		return otrosPagos;
	}
	public void setOtrosPagos(ArrayList<OtroPago> otrosPagos) {
		this.otrosPagos = otrosPagos;
	}
	public void addOtroPago(OtroPago op) {
		if (otrosPagos == null) {
			otrosPagos = new ArrayList<OtroPago>();
		}
		otrosPagos.add(op);
	}
	public Receptor getReceptor() {
		return receptor;
	}
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}
	public ArrayList<ConceptoNom> getConceptos() {
		return conceptos;
	}
	public void setConceptos(ArrayList<ConceptoNom> conceptos) {
		this.conceptos = conceptos;
	}
	public void addConcepto(ConceptoNom c) {
		if (conceptos == null) {
			conceptos = new ArrayList<ConceptoNom>();
		}
		conceptos.add(c);
	}
	public boolean isValido() {
		return valido;
	}
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public Estatus getEstatus() {
		return estatus;
	}
	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}
	public Comprobante getCfdi() {
		return cfdi;
	}
	public void setCfdi(Comprobante cfdi) {
		this.cfdi = cfdi;
	}
	public TimbreFiscalDigital getTimbre() {
		return timbre;
	}
	public void setTimbre(TimbreFiscalDigital timbre) {
		this.timbre = timbre;
	}
	
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public String getPathPdf() {
		return pathPdf;
	}
	public void setPathPdf(String pathPdf) {
		this.pathPdf = pathPdf;
	}
	public String getCadenaOriginal() {
		StringBuilder sb = new StringBuilder("||");
        sb.append(cfdi.getVersion()).append("|")
         .append(timbre.getUUID()).append("|")
         .append(timbre.getFechaTimbrado().toXMLFormat()).append("|")
         .append(timbre.getSelloCFD()).append("|")
         .append(timbre.getNoCertificadoSAT()).append("||");
        return sb.toString();
	}
	
}
