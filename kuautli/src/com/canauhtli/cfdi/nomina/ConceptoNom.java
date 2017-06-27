package com.canauhtli.cfdi.nomina;


import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=0)
@Fields({
    @Field(name="concepto", at=0, rid=true, literal="C")
})
public class ConceptoNom {

	@Field(at=1, type=Double.class)
	private double cantidad;
	
	@Field(at=2)
	private String unidad;
	
	@Field(at=3)
	private String descripcion;
	
	@Field(at=4, type=Double.class)
	private double precioUnitario;

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public String toRecord() {
		StringBuilder sb = new StringBuilder("C|");
		sb.append(cantidad).append("|")
		  .append(unidad).append("|")
		  .append(descripcion).append("|")
		  .append(precioUnitario);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("Concepto=[");
		sb.append("cantidad= ").append(cantidad).append(", ")
		  .append("unidad= ").append(unidad).append(", ")
		  .append("descripcion= ").append(descripcion).append(", ")
		  .append("precioUnitario= ").append(precioUnitario).append("]");
		return sb.toString();
	}
}
