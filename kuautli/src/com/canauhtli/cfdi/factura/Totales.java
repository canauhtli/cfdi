package com.canauhtli.cfdi.factura;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record
@Fields({
    @Field(name="totales", at=0, rid=true, literal="T")
})
public class Totales {

	@Field(at=1)
	private double subTotal;
	
	@Field(at=2)
	private double total;
	
	@Field(at=3)
	private double descuento;
	
	@Field(at=4)
	private String porcentajeDescuento;
	
	@Field(at=5)
	private String importeLetra;
	
	@Field(at=6)
	private String metodoPago;
	
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public String getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	public void setPorcentajeDescuento(String porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	public String getImporteLetra() {
		return importeLetra;
	}
	public void setImporteLetra(String importeLetra) {
		this.importeLetra = importeLetra;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("subTotal:").append(subTotal)
		  .append(", total:").append(total)
		  .append(", descuento:").append(descuento)
		  .append(", porcentajeDescuento:").append(porcentajeDescuento)
		  .append(", importeLetra:").append(importeLetra)
		  .append(", metodoPago:").append(metodoPago)
		  .append("]");
		
		return sb.toString();
	}
}
