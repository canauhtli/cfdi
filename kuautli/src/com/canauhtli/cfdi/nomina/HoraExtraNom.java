package com.canauhtli.cfdi.nomina;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;

@Record(minOccurs=0)
@Fields({
    @Field(name="horaExtra", at=0, rid=true, literal="H")
})
public class HoraExtraNom {

	@Field(at=1, type=Integer.class, align=Align.RIGHT, trim=true)
	private int dias;
	
	@Field(at=2)
	private String tipo;
	
	@Field(at=3, type=Integer.class, align=Align.RIGHT, trim=true)
	private int horas;
	
	@Field(at=4, type=Double.class)
	private double importePagado;

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

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public double getImportePagado() {
		return importePagado;
	}

	public void setImportePagado(double importePagado) {
		this.importePagado = importePagado;
	}
	
	public String toRecord() {
		StringBuilder sb = new StringBuilder("H|");
		sb.append(dias).append("|")
		  .append(tipo).append("|")
		  .append(horas).append("|")
		  .append(importePagado);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("HoraExtra=[");
		sb.append("dias= ").append(dias).append(", ")
		  .append("tipo= ").append(tipo).append(", ")
		  .append("horas= ").append(horas).append(", ")
		  .append("importePagado= ").append(importePagado).append("]");
		return sb.toString();
	}
}
