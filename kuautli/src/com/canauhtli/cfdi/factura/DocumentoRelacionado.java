package com.canauhtli.cfdi.factura;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=0)
@Fields({
    @Field(name="docRel", at=0, rid=true, literal="Q")
})
public class DocumentoRelacionado {

	@Field(at=1)
	private int numPago;
	
	@Field(at=2)
	private String idDocumento;
	
	@Field(at=3)
	private String serie;
	
	@Field(at=4)
	private String folio;
	
	@Field(at=5)
	private String moneda;
	
	@Field(at=6)
	private double tipoCambio;
	
	@Field(at=7)
	private String metodoPago;
	
	@Field(at=8)
	private int numParcialidad;
	
	@Field(at=9)
	private double impSaldoAnt;
	
	@Field(at=10)
	private double impPagado;
	
	@Field(at=11)
	private double impSaldoInsoluto;

	public int getNumPago() {
		return numPago;
	}

	public void setNumPago(int numPago) {
		this.numPago = numPago;
	}

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
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("numPago:").append(numPago)
		  .append(", idDocumento:").append(idDocumento)
		  .append(", serie:").append(serie)
		  .append(", folio:").append(folio)
		  .append(", moneda:").append(moneda)
		  .append(", tipoCambio:").append(tipoCambio)
		  .append(", metodoPago:").append(metodoPago)
		  .append(", numParcialidad:").append(numParcialidad)
		  .append(", impSaldoAnt:").append(impSaldoAnt)
		  .append(", impPagado:").append(impPagado)
		  .append(", impSaldoInsoluto:").append(impSaldoInsoluto)
		  .append("]");
		
		return sb.toString();
	}
}
