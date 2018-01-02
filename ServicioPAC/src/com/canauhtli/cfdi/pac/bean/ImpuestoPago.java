package com.canauhtli.cfdi.pac.bean;

public class ImpuestoPago {


	private String tipo;
	private String impuesto;
	private String tipoFactor;
	private double tasaOCuota;
	private double importe;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
	public String getTipoFactor() {
		return tipoFactor;
	}
	public void setTipoFactor(String tipoFactor) {
		this.tipoFactor = tipoFactor;
	}
	public double getTasaOCuota() {
		return tasaOCuota;
	}
	public void setTasaOCuota(double tasaOCuota) {
		this.tasaOCuota = tasaOCuota;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}

}
