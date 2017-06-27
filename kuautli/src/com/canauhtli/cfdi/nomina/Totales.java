package com.canauhtli.cfdi.nomina;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=1)
@Fields({
    @Field(name="totales", at=0, rid=true, literal="T")
})
public class Totales {

	@Field(at=1, type=Double.class)
	private double totalPercepciones;
	
	@Field(at=2, type=Double.class)
	private double totalDeducciones;
	
	@Field(at=3, type=Double.class)
	private double totalOtrosPagos;
	
	@Field(at=4, type=Double.class)
	private double totalSueldos;

	@Field(at=5, type=Double.class)
	private double totalSeparacionIndemnizacion;
	
	@Field(at=6, type=Double.class)
	private double totalJubilacionPensionRetiro;
	
	@Field(at=7, type=Double.class)
	private double totalOtrasDeducciones;
	
	@Field(at=8, type=Double.class)
	private double totalImpuestosRetenidos;
	
	public double getTotalPercepciones() {
		return totalPercepciones;
	}

	public void setTotalPercepciones(double totalPercepciones) {
		this.totalPercepciones = totalPercepciones;
	}

	public double getTotalDeducciones() {
		return totalDeducciones;
	}

	public void setTotalDeducciones(double totalDeducciones) {
		this.totalDeducciones = totalDeducciones;
	}

	public double getTotalOtrosPagos() {
		return totalOtrosPagos;
	}

	public void setTotalOtrosPagos(double totalOtrosPagos) {
		this.totalOtrosPagos = totalOtrosPagos;
	}
	
	public double getTotalSueldos() {
		return totalSueldos;
	}

	public void setTotalSueldos(double totalSueldos) {
		this.totalSueldos = totalSueldos;
	}

	public double getTotalSeparacionIndemnizacion() {
		return totalSeparacionIndemnizacion;
	}

	public void setTotalSeparacionIndemnizacion(double totalSeparacionIndemnizacion) {
		this.totalSeparacionIndemnizacion = totalSeparacionIndemnizacion;
	}

	public double getTotalJubilacionPensionRetiro() {
		return totalJubilacionPensionRetiro;
	}

	public void setTotalJubilacionPensionRetiro(double totalJubilacionPensionRetiro) {
		this.totalJubilacionPensionRetiro = totalJubilacionPensionRetiro;
	}

	public double getTotalOtrasDeducciones() {
		return totalOtrasDeducciones;
	}

	public void setTotalOtrasDeducciones(double totalOtrasDeducciones) {
		this.totalOtrasDeducciones = totalOtrasDeducciones;
	}

	public double getTotalImpuestosRetenidos() {
		return totalImpuestosRetenidos;
	}

	public void setTotalImpuestosRetenidos(double totalImpuestosRetenidos) {
		this.totalImpuestosRetenidos = totalImpuestosRetenidos;
	}

	public String toRecord() {
		StringBuilder sb = new StringBuilder("T|");
		sb.append(totalPercepciones).append("|")
		  .append(totalDeducciones).append("|")
		  .append(totalOtrosPagos).append("|")
		  .append(totalSueldos).append("|")
		  .append(totalSeparacionIndemnizacion).append("|")
		  .append(totalJubilacionPensionRetiro).append("|")
		  .append(totalOtrasDeducciones).append("|")
		  .append(totalImpuestosRetenidos);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("Totales[");
		sb.append("totalPercepciones=").append(totalPercepciones).append(", ")
		  .append("totalDeducciones=").append(totalDeducciones).append(", ")
		  .append("totalOtrosPagos=").append(totalOtrosPagos).append(", ")
		  .append("totalSueldos=").append(totalSueldos).append(", ")
		  .append("totalSeparacionIndemnizacion=").append(totalSeparacionIndemnizacion).append(", ")
		  .append("totalJubilacionPensionRetiro=").append(totalJubilacionPensionRetiro).append(", ")
		  .append("totalOtrasDeducciones=").append(totalOtrasDeducciones).append(", ")
		  .append("totalImpuestosRetenidos=").append(totalImpuestosRetenidos).append("]");
		return sb.toString();
	}
}
