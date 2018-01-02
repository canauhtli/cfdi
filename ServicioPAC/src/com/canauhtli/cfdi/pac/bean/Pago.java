package com.canauhtli.cfdi.pac.bean;

import java.util.ArrayList;
import java.util.Date;

public class Pago {

	private Date fechaPago;
	private String formaPago;
	private String moneda;
	private double tipoCambio;
	private double monto;
	private String numOperacion;
	private String rfcOrdenante;
	private String banco;
	private String cuentaOrdenante;
	private String rfcEmisorCtaBen;
	private String cuentaBeneficiario;
	private String tipoCadenaPago;
	private String certPago;
	private String cadPago;
	private String selloPago;
	
	private double totalImpuestosRetenidos;
	private double totalImpuestosTrasladados;
	
	private ArrayList<DocumentoRelacionado> documentos = new ArrayList<DocumentoRelacionado>();
	private ArrayList<ImpuestoPago> impuestos = new ArrayList<ImpuestoPago>();
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
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
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getNumOperacion() {
		return numOperacion;
	}
	public void setNumOperacion(String numOperacion) {
		this.numOperacion = numOperacion;
	}
	public String getRfcOrdenante() {
		return rfcOrdenante;
	}
	public void setRfcOrdenante(String rfcOrdenante) {
		this.rfcOrdenante = rfcOrdenante;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getCuentaOrdenante() {
		return cuentaOrdenante;
	}
	public void setCuentaOrdenante(String cuentaOrdenante) {
		this.cuentaOrdenante = cuentaOrdenante;
	}
	public String getRfcEmisorCtaBen() {
		return rfcEmisorCtaBen;
	}
	public void setRfcEmisorCtaBen(String rfcEmisorCtaBen) {
		this.rfcEmisorCtaBen = rfcEmisorCtaBen;
	}
	public String getCuentaBeneficiario() {
		return cuentaBeneficiario;
	}
	public void setCuentaBeneficiario(String cuentaBeneficiario) {
		this.cuentaBeneficiario = cuentaBeneficiario;
	}
	public String getTipoCadenaPago() {
		return tipoCadenaPago;
	}
	public void setTipoCadenaPago(String tipoCadenaPago) {
		this.tipoCadenaPago = tipoCadenaPago;
	}
	public String getCertPago() {
		return certPago;
	}
	public void setCertPago(String certPago) {
		this.certPago = certPago;
	}
	public String getCadPago() {
		return cadPago;
	}
	public void setCadPago(String cadPago) {
		this.cadPago = cadPago;
	}
	public String getSelloPago() {
		return selloPago;
	}
	public void setSelloPago(String selloPago) {
		this.selloPago = selloPago;
	}
	public double getTotalImpuestosRetenidos() {
		return totalImpuestosRetenidos;
	}
	public void setTotalImpuestosRetenidos(double totalImpuestosRetenidos) {
		this.totalImpuestosRetenidos = totalImpuestosRetenidos;
	}
	public double getTotalImpuestosTrasladados() {
		return totalImpuestosTrasladados;
	}
	public void setTotalImpuestosTrasladados(double totalImpuestosTrasladados) {
		this.totalImpuestosTrasladados = totalImpuestosTrasladados;
	}
	public ArrayList<DocumentoRelacionado> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(ArrayList<DocumentoRelacionado> documentos) {
		this.documentos = documentos;
	}
	public ArrayList<ImpuestoPago> getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(ArrayList<ImpuestoPago> impuestos) {
		this.impuestos = impuestos;
	}
	
	public void addDocumento(DocumentoRelacionado documento) {
		if (documentos == null) {
			documentos = new ArrayList<DocumentoRelacionado>();
		}
		documentos.add(documento);
	}
	
	public void addImpuesto(ImpuestoPago impuesto) {
		if (impuestos == null) {
			impuestos = new ArrayList<ImpuestoPago>();
		}
		impuestos.add(impuesto);
	}
}
