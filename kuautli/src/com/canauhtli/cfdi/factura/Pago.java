package com.canauhtli.cfdi.factura;

import java.util.ArrayList;
import java.util.Date;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=0)
@Fields({
    @Field(name="pago", at=0, rid=true, literal="P")
})
public class Pago {

	@Field(at=1)
	private int numPago;
	
	@Field(at=2, type=java.util.Date.class, format="dd/MM/yyyy HH:mm:ss")
	private Date fechaPago;
	
	@Field(at=3)
	private String formaPago;
	
	@Field(at=4)
	private String moneda;
	
	@Field(at=5)
	private double tipoCambio;
	
	@Field(at=6)
	private double monto;
	
	@Field(at=7)
	private String numOperacion;
	
	@Field(at=8)
	private String rfcOrdenante;
	
	@Field(at=9)
	private String banco;
	
	@Field(at=10)
	private String cuentaOrdenante;
	
	@Field(at=11)
	private String rfcEmisorCtaBen;
	
	@Field(at=12)
	private String cuentaBeneficiario;
	
	@Field(at=13, minOccurs=0)
	private String tipoCadenaPago;
	
	@Field(at=14, minOccurs=0)
	private String certPago;
	
	@Field(at=15, minOccurs=0)
	private String cadPago;
	
	@Field(at=16, minOccurs=0)
	private String selloPago;
	
	private ArrayList<DocumentoRelacionado> documentos = new ArrayList<DocumentoRelacionado>();
	private ImpuestoPago impuesto;

	public int getNumPago() {
		return numPago;
	}

	public void setNumPago(int numPago) {
		this.numPago = numPago;
	}

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
	
	public ImpuestoPago getImpuestoPago() {
		return impuesto;
	}
	
	public void setImpuestoPago(ImpuestoPago impuesto) {
		this.impuesto = impuesto;
	}
	
	public void addDocumento(DocumentoRelacionado doc) {
		documentos.add(doc);
	}
	
	public ArrayList<DocumentoRelacionado> getDocumentos() {
		return documentos;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("numPago:").append(numPago)
		  .append(", fechaPago:").append(fechaPago)
		  .append(", formaPago:").append(formaPago)
		  .append(", moneda:").append(moneda)
		  .append(", tipoCambio:").append(tipoCambio)
		  .append(", monto:").append(monto)
		  .append(", numOperacion:").append(numOperacion)
		  .append(", rfcOrdenante:").append(rfcOrdenante)
		  .append(", banco:").append(banco)
		  .append(", cuentaOrdenante:").append(cuentaOrdenante)
		  .append(", rfcEmisorCtaBen:").append(rfcEmisorCtaBen)
		  .append(", cuentaBeneficiario:").append(cuentaBeneficiario)
		  .append("]");
		
		return sb.toString();
	}
}
