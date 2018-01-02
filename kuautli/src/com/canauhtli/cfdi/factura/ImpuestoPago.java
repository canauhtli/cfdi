package com.canauhtli.cfdi.factura;

import java.util.ArrayList;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=0)
@Fields({
    @Field(name="impuestoPago", at=0, rid=true, literal="K")
})
public class ImpuestoPago {

	@Field(at=1)
	private int numPago;
	
	@Field(at=2)
	private double totalImpuestosRetenidos;
	
	@Field(at=3)
	private double totalImpuestosTrasladados;
	
	@Field(at=4, collection=ArrayList.class, minOccurs=1, maxOccurs=-1)
	private ArrayList<ImpuestoPagoDetalle> impuestos;

	public int getNumPago() {
		return numPago;
	}

	public void setNumPago(int numPago) {
		this.numPago = numPago;
	}

	public double getTotalImpuestosRetenidos() {
		return totalImpuestosRetenidos;
	}

	public void setTotalImpuestosRetenidos(double totalImpuestosRetenidos) {
		this.totalImpuestosRetenidos = totalImpuestosRetenidos;
	}

	public double getTotalImpuestosTrasladados() {
		return totalImpuestosTrasladados;
	}

	public void setTotalImpuestosTrasladados(double totalImpuestosTrasladados) {
		this.totalImpuestosTrasladados = totalImpuestosTrasladados;
	}

	public ArrayList<ImpuestoPagoDetalle> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(ArrayList<ImpuestoPagoDetalle> impuestos) {
		this.impuestos = impuestos;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("numPago:").append(numPago)
		  .append(", totalImpuestosRetenidos:").append(totalImpuestosRetenidos)
		  .append(", totalImpuestosTrasladados:").append(totalImpuestosTrasladados)
		  .append(", impuestos:");
		for (ImpuestoPagoDetalle i : impuestos) {
			sb.append("<").append(i).append(">");
		}
		sb.append("]");
		
		return sb.toString();
	}
}
