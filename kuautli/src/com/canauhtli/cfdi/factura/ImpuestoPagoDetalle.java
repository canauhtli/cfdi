package com.canauhtli.cfdi.factura;

import org.beanio.annotation.Field;

public class ImpuestoPagoDetalle {

	@Field(at=0)
	private String tipo;
	
	@Field(at=1)
	private String impuesto;
	
	@Field(at=2)
	private String tipoFactor;
	
	@Field(at=3)
	private double tasaOCuota;
	
	@Field(at=4)
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("tipo:").append(tipo)
		  .append(", impuesto:").append(impuesto)
		  .append(", tipoFactor:").append(tipoFactor)
		  .append(", tasaOCuota:").append(tasaOCuota)
		  .append(", importe:").append(importe)
		  .append("]");
		
		return sb.toString();
	}
}
