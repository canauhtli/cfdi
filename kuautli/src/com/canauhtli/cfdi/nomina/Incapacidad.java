package com.canauhtli.cfdi.nomina;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=0)
@Fields({
    @Field(name="incapacidad", at=0, rid=true, literal="I")
})
public class Incapacidad {

	@Field(at=1, type=Integer.class)
	private int dias;
	
	@Field(at=2)
	private String tipo;
	
	@Field(at=3, type=Double.class)
	private double descuento;

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

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public String toRecord() {
		StringBuilder sb = new StringBuilder("I|");
		sb.append(dias).append("|")
		  .append(tipo).append("|")
		  .append(descuento);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("Incapacidad=[");
		sb.append("dias= ").append(dias).append(", ")
		  .append("tipo= ").append(tipo).append(", ")
		  .append("descuento= ").append(descuento).append("]");
		return sb.toString();
	}
}
