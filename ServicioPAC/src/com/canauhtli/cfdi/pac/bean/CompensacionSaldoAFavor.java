package com.canauhtli.cfdi.pac.bean;

public class CompensacionSaldoAFavor {
	private double saldoAFavor;
	private short a�o;
	private double remanente;
	
	public double getSaldoAFavor() {
		return saldoAFavor;
	}
	public void setSaldoAFavor(double saldoAFavor) {
		this.saldoAFavor = saldoAFavor;
	}
	public short getA�o() {
		return a�o;
	}
	public void setA�o(short a�o) {
		this.a�o = a�o;
	}
	public double getRemanente() {
		return remanente;
	}
	public void setRemanente(double remanente) {
		this.remanente = remanente;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("CompensacionSaldoAFavor=[");
		sb.append("saldoAFavor=").append(saldoAFavor)
		  .append(", a�o=").append(a�o)
		  .append(", remanente=").append(remanente)
		  .append("]");
		return sb.toString();
	}
}
