package com.canauhtli.cfdi.nomina;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=0)
@Fields({
    @Field(name="jupere", at=0, rid=true, literal="J")
})
public class PercepcionJubilacionPensionRetiro {

	@Field(at=1, type=Double.class)
	private double totalUnaExhibicion;
	
	@Field(at=2, type=Double.class)
	private double totalParcialidad;
	
	@Field(at=3, type=Double.class)
	private double montoDiario;
	
	@Field(at=4, type=Double.class)
	private double ingresoAcumulable;
	
	@Field(at=5, type=Double.class)
	private double ingresoNoAcumulable;

	public double getTotalUnaExhibicion() {
		return totalUnaExhibicion;
	}

	public void setTotalUnaExhibicion(double totalUnaExhibicion) {
		this.totalUnaExhibicion = totalUnaExhibicion;
	}

	public double getTotalParcialidad() {
		return totalParcialidad;
	}

	public void setTotalParcialidad(double totalParcialidad) {
		this.totalParcialidad = totalParcialidad;
	}

	public double getMontoDiario() {
		return montoDiario;
	}

	public void setMontoDiario(double montoDiario) {
		this.montoDiario = montoDiario;
	}

	public double getIngresoAcumulable() {
		return ingresoAcumulable;
	}

	public void setIngresoAcumulable(double ingresoAcumulable) {
		this.ingresoAcumulable = ingresoAcumulable;
	}

	public double getIngresoNoAcumulable() {
		return ingresoNoAcumulable;
	}

	public void setIngresoNoAcumulable(double ingresoNoAcumulable) {
		this.ingresoNoAcumulable = ingresoNoAcumulable;
	}
	
	public String toRecord() {
		StringBuilder sb = new StringBuilder("J|");
		sb.append(totalUnaExhibicion).append("|")
		  .append(totalParcialidad).append("|")
		  .append(montoDiario).append("|")
		  .append(ingresoAcumulable).append("|")
		  .append(ingresoNoAcumulable);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("JubPenRet[");
		sb.append("totalUnaExhibicion=").append(totalUnaExhibicion).append(", ")
		  .append("totalParcialidad=").append(totalParcialidad).append(", ")
		  .append("montoDiario=").append(montoDiario).append(", ")
		  .append("ingresoAcumulable=").append(ingresoAcumulable).append(", ")
		  .append("ingresoNoAcumulable=").append(ingresoNoAcumulable).append("]");
		return sb.toString();
	}
}
