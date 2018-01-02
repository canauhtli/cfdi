package com.canauhtli.cfdi.pac.bean;

public class OtroPago {
	private String tipoOtroPago;
	private String clave;
	private String concepto;
	private double importe;
	private Double subsidioCausado;
	private CompensacionSaldoAFavor compensacion;
	
	public String getTipoOtroPago() {
		return tipoOtroPago;
	}
	public void setTipoOtroPago(String tipoOtroPago) {
		this.tipoOtroPago = tipoOtroPago;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Double getSubsidioCausado() {
		return subsidioCausado;
	}
	public void setSubsidioCausado(Double subsidioCausado) {
		this.subsidioCausado = subsidioCausado;
	}
	public CompensacionSaldoAFavor getCompensacion() {
		return compensacion;
	}
	public void setCompensacion(CompensacionSaldoAFavor compensacion) {
		this.compensacion = compensacion;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("OtroPago=[");
		sb.append("tipoOtroPago=").append(tipoOtroPago)
		  .append(", clave=").append(clave)
		  .append(", concepto=").append(concepto)
		  .append(", importe=").append(importe)
		  .append(", subsidioCausado=").append(subsidioCausado)
		  .append(", ").append(compensacion)
		  .append("]");
		
		return sb.toString();
	}
}
