package com.canauhtli.cfdi.pac.bean;

public class HoraExtra {

	private int dias;
    private String tipo;
    private int horas;
    private double importePagado;
    
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public double getImportePagado() {
		return importePagado;
	}
	public void setImportePagado(double importePagado) {
		this.importePagado = importePagado;
	}
    
	 public String toString() {
		 StringBuilder sb = new StringBuilder("HoraExtra [");
		 sb.append("dias=").append(dias)
		   .append(", tipo=").append(tipo)
		   .append(", horas=").append(horas)
		   .append(", importePagado=").append(importePagado)
		   .append("]");
		 return sb.toString();
	 }
}
