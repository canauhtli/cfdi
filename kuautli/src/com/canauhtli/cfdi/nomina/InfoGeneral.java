package com.canauhtli.cfdi.nomina;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=1)
@Fields({
    @Field(name="infoGeneral", at=0, rid=true, literal="A")
})
public class InfoGeneral {

	@Field(at=1)
	private String numRecibo;
	
	@Field(at=2)
	private String moneda;
	
	@Field(at=3)
	private String metodoPago;
	
	@Field(at=4)
	private String formaPago;
	
	@Field(at=5)
	private String tipoNomina;

	public String getNumRecibo() {
		return numRecibo;
	}

	public void setNumRecibo(String numRecibo) {
		this.numRecibo = numRecibo;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	public String getTipoNomina() {
		return tipoNomina;
	}
	
	public void setTipoNomina(String tipoNomina) {
		this.tipoNomina = tipoNomina;
	}
	
	public String toRecord() {
		StringBuilder sb = new StringBuilder("A|");
		sb.append(numRecibo).append("|")
		  .append(moneda).append("|")
		  .append(metodoPago).append("|")
		  .append(formaPago).append("|")
		  .append(tipoNomina);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("InfoGeneral[");
		sb.append("numRecibo=").append(numRecibo).append(", ")
		  .append("moneda=").append(moneda).append(", ")
		  .append("metodoPago=").append(metodoPago).append(", ")
		  .append("formaPago=").append(formaPago).append(", ")
		  .append("tipoNomina=").append(tipoNomina).append("]");
		return sb.toString();
	}
}
