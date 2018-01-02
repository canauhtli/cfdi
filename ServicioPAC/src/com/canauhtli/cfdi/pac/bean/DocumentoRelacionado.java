package com.canauhtli.cfdi.pac.bean;

public class DocumentoRelacionado {


	private String idDocumento;
	private String serie;
	private String folio;
	private String moneda;
	private double tipoCambio;
	private String metodoPago;
	private int numParcialidad;
	private double impSaldoAnt;
	private double impPagado;
	private double impSaldoInsoluto;
	
	public String getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public int getNumParcialidad() {
		return numParcialidad;
	}
	public void setNumParcialidad(int numParcialidad) {
		this.numParcialidad = numParcialidad;
	}
	public double getImpSaldoAnt() {
		return impSaldoAnt;
	}
	public void setImpSaldoAnt(double impSaldoAnt) {
		this.impSaldoAnt = impSaldoAnt;
	}
	public double getImpPagado() {
		return impPagado;
	}
	public void setImpPagado(double impPagado) {
		this.impPagado = impPagado;
	}
	public double getImpSaldoInsoluto() {
		return impSaldoInsoluto;
	}
	public void setImpSaldoInsoluto(double impSaldoInsoluto) {
		this.impSaldoInsoluto = impSaldoInsoluto;
	}
	
}
