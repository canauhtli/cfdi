package com.canauhtli.cfdi.factura;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record
@Fields({
    @Field(name="observacion", at=0, rid=true, literal="O")
})
public class Observacion {

	@Field(at=1)
	private String observacion;
	
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public String getObservacion() {
		return observacion;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("observacion:").append(observacion)
		  .append("]");
		
		return sb.toString();
	}
}
