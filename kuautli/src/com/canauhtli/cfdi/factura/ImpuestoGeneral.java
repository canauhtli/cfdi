package com.canauhtli.cfdi.factura;

import org.beanio.annotation.Field;

public class ImpuestoGeneral {

	@Field(at=0)
	private String tipo;
	
	@Field(at=1)
	private String impuesto;
	
	@Field(at=2)
	private double tasa;
	
	@Field(at=3)
	private double monto;
	
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
	public double getTasa() {
		return tasa;
	}
	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("tipo:").append(tipo)
		  .append(", impuesto:").append(impuesto)
		  .append(", tasa:").append(tasa)
		  .append(", monto:").append(monto)
		  .append("]");
		
		return sb.toString();
	}
	
}
