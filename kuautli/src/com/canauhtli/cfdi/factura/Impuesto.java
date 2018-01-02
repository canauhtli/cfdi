package com.canauhtli.cfdi.factura;

import java.util.ArrayList;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;
import org.beanio.annotation.Segment;

@Record
@Fields({
    @Field(name="impuesto", at=0, rid=true, literal="I")
})
public class Impuesto {

	@Field(at=1)
	private double totalRetenciones;
	
	@Field(at=2)
	private double totalTraslados;
	
	@Segment(at=3, collection=ArrayList.class, minOccurs=1, maxOccurs=-1)
	private ArrayList<ImpuestoGeneral> impuestos;

	public double getTotalRetenciones() {
		return totalRetenciones;
	}

	public void setTotalRetenciones(double totalRetenciones) {
		this.totalRetenciones = totalRetenciones;
	}

	public double getTotalTraslados() {
		return totalTraslados;
	}

	public void setTotalTraslados(double totalTraslados) {
		this.totalTraslados = totalTraslados;
	}

	public ArrayList<ImpuestoGeneral> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(ArrayList<ImpuestoGeneral> impuestos) {
		this.impuestos = impuestos;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("totalRetenciones:").append(totalRetenciones)
		  .append(", totalTraslados:").append(totalTraslados)
		  .append(", impuestos:");
		if (impuestos != null) {
			for (ImpuestoGeneral ig : impuestos) {
				sb.append("<").append(ig).append(">");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
}
