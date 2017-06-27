package com.canauhtli.cfdi.nomina;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=0)
@Fields({
    @Field(name="sepind", at=0, rid=true, literal="S")
})
public class PercepcionSeparacionIndemnizacion {

	@Field(at=1, type=Double.class)
	private double totalPagado;
	
	@Field(at=2, type=Integer.class)
	private int numAñosServicio;
	
	@Field(at=3, type=Double.class)
	private double ultimoSueldoMensOrd;
	
	@Field(at=4, type=Double.class)
	private double ingresoAcumulable;
	
	@Field(at=5, type=Double.class)
	private double ingresoNoAcumulable;

	public double getTotalPagado() {
		return totalPagado;
	}

	public void setTotalPagado(double totalPagado) {
		this.totalPagado = totalPagado;
	}

	public int getNumAñosServicio() {
		return numAñosServicio;
	}

	public void setNumAñosServicio(int numAñosServicio) {
		this.numAñosServicio = numAñosServicio;
	}

	public double getUltimoSueldoMensOrd() {
		return ultimoSueldoMensOrd;
	}

	public void setUltimoSueldoMensOrd(double ultimoSueldoMensOrd) {
		this.ultimoSueldoMensOrd = ultimoSueldoMensOrd;
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
		sb.append(totalPagado).append("|")
		  .append(numAñosServicio).append("|")
		  .append(ultimoSueldoMensOrd).append("|")
		  .append(ingresoAcumulable).append("|")
		  .append(ingresoNoAcumulable);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("SeparaqcionIndemn[");
		sb.append("totalPagado=").append(totalPagado).append(", ")
		  .append("numAñosServicio=").append(numAñosServicio).append(", ")
		  .append("ultimoSueldoMensOrd=").append(ultimoSueldoMensOrd).append(", ")
		  .append("ingresoAcumulable=").append(ingresoAcumulable).append(", ")
		  .append("ingresoNoAcumulable=").append(ingresoNoAcumulable).append("]");
		return sb.toString();
	}
}
