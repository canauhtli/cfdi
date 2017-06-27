package com.canauhtli.cfdi.nomina;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=0)
@Fields({
    @Field(name="percepcion", at=0, rid=true, literal="P")
})
public class PercepcionNom extends Salario {

	public String toRecord() {
		StringBuilder sb = new StringBuilder("P|");
		sb.append(tipo).append("|")
		  .append(clave).append("|")
		  .append(concepto).append("|")
		  .append(importeGravado).append("|")
		  .append(importeExcento);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("Percepcion[");
		sb.append("tipo= ").append(tipo).append(", ")
		  .append("clave= ").append(clave).append(", ")
		  .append("importeGravado= ").append(importeGravado).append(", ")
		  .append("importeExcento= ").append(importeExcento).append("]");
		return sb.toString();
	}
}
