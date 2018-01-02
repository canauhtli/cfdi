package com.canauhtli.cfdi.factura;

import java.util.Date;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=1)
@Fields({
    @Field(name="generales", at=0, rid=true, literal="E")
})
public class Generales {

	@Field(at=1)
	private String tipo;
	
	@Field(at=2, type=java.util.Date.class, format="dd/MM/yyyy HH:mm:ss")
	private Date fecha;
	
	@Field(at=3)
	private String serie;
	
	@Field(at=4)
	private String sentido;
	
	@Field(at=5)
	private String moneda;
	
	@Field(at=6)
	private double tipoCambio;
	
	@Field(at=7)
	private String formaPago;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSentido() {
		return sentido;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
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

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("tipo:").append(tipo)
		  .append(", fecha:").append(fecha)
		  .append(", serie:").append(serie)
		  .append(", sentido:").append(sentido)
		  .append(", moneda:").append(moneda)
		  .append(", tipoCambio:").append(tipoCambio)
		  .append(", formaPago:").append(formaPago)
		  .append("]");
		
		return sb.toString();
	}
	
}
