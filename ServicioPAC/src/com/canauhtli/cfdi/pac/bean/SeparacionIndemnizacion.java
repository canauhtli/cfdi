package com.canauhtli.cfdi.pac.bean;

public class SeparacionIndemnizacion {

	private double totalPagado;
	private int numAñosServicio;
	private double ultimoSueldoMensOrd;
	private double ingresoAcumulable;
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
	
}
