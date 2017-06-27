package com.canauhtli.cfdi.nomina;

import org.beanio.annotation.Field;

public class Salario {

	@Field(at=1)
	protected String tipo;
	
	@Field(at=2)
	protected String clave;
	
	@Field(at=3)
	protected String concepto;
	
	@Field(at=4, type=Double.class)
	protected double importeGravado;
	
	@Field(at=5, type=Double.class)
	protected double importeExcento;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getImporteGravado() {
		return importeGravado;
	}

	public void setImporteGravado(double importeGravado) {
		this.importeGravado = importeGravado;
	}

	public double getImporteExcento() {
		return importeExcento;
	}

	public void setImporteExcento(double importeExcento) {
		this.importeExcento = importeExcento;
	}
	
}
