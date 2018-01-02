package com.canauhtli.cfdi.pac.bean;

public class Incapacidad {

	private int dias;
    private String tipo;
    private double descuento;
    
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
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
    
	 public String toString() {
		 StringBuilder sb = new StringBuilder("Incapacidad [");
		 sb.append("dias=").append(dias)
		   .append(", tipo=").append(tipo)
		   .append(", descuento=").append(descuento)
		   .append("]");
		 return sb.toString();
	    }
}
