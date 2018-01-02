package com.canauhtli.cfdi.pac.bean;

public class CompensacionSaldoAFavor {
	private double saldoAFavor;
	private short año;
	private double remanente;
	
	public double getSaldoAFavor() {
		return saldoAFavor;
	}
	public void setSaldoAFavor(double saldoAFavor) {
		this.saldoAFavor = saldoAFavor;
	}
	public short getAño() {
		return año;
	}
	public void setAño(short año) {
		this.año = año;
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
		  .append(", año=").append(año)
		  .append(", remanente=").append(remanente)
		  .append("]");
		return sb.toString();
	}
}
