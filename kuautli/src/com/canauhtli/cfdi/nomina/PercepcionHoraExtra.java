package com.canauhtli.cfdi.nomina;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=0)
@Fields({
    @Field(name="percepcionHoraExtra", at=0, rid=true, literal="G")
})
public class PercepcionHoraExtra extends Salario {

	public String toRecord() {
		StringBuilder sb = new StringBuilder("G|");
		sb.append(tipo).append("|")
		  .append(clave).append("|")
		  .append(concepto).append("|")
		  .append(importeGravado).append("|")
		  .append(importeExcento);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("PercepcionHoraExtra[");
		sb.append("tipo= ").append(tipo).append(", ")
		  .append("clave= ").append(clave).append(", ")
		  .append("importeGravado= ").append(importeGravado).append(", ")
		  .append("importeExcento= ").append(importeExcento).append("]");
		return sb.toString();
	}
}
