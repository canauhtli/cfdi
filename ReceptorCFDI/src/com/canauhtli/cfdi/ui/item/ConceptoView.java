package com.canauhtli.cfdi.ui.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConceptoView {

	private StringProperty cveSat = new SimpleStringProperty();
	private StringProperty codigo = new SimpleStringProperty();
	private StringProperty cantidad = new SimpleStringProperty();
	private StringProperty cveUnidad = new SimpleStringProperty();
	private StringProperty unidad = new SimpleStringProperty();
	private StringProperty descripcion = new SimpleStringProperty();
	private StringProperty precio = new SimpleStringProperty();
	
	public final StringProperty cveSatProperty() {
		return this.cveSat;
	}
	
	public final String getCveSat() {
		return this.cveSatProperty().get();
	}
	
	public final void setCveSat(final String cveSat) {
		this.cveSatProperty().set(cveSat);
	}
	
	public final StringProperty codigoProperty() {
		return this.codigo;
	}
	
	public final String getCodigo() {
		return this.codigoProperty().get();
	}
	
	public final void setCodigo(final String codigo) {
		this.codigoProperty().set(codigo);
	}
	
	public final StringProperty cantidadProperty() {
		return this.cantidad;
	}
	
	public final String getCantidad() {
		return this.cantidadProperty().get();
	}
	
	public final void setCantidad(final String cantidad) {
		this.cantidadProperty().set(cantidad);
	}
	
	public final StringProperty cveUnidadProperty() {
		return this.cveUnidad;
	}
	
	public final String getCveUnidad() {
		return this.cveUnidadProperty().get();
	}
	
	public final void setCveUnidad(final String cveUnidad) {
		this.cveUnidadProperty().set(cveUnidad);
	}
	
	public final StringProperty unidadProperty() {
		return this.unidad;
	}
	
	public final String getUnidad() {
		return this.unidadProperty().get();
	}
	
	public final void setUnidad(final String unidad) {
		this.unidadProperty().set(unidad);
	}
	
	public final StringProperty descripcionProperty() {
		return this.descripcion;
	}
	
	public final String getDescripcion() {
		return this.descripcionProperty().get();
	}
	
	public final void setDescripcion(final String descripcion) {
		this.descripcionProperty().set(descripcion);
	}
	
	public final StringProperty precioProperty() {
		return this.precio;
	}
	
	public final String getPrecio() {
		return this.precioProperty().get();
	}
	
	public final void setPrecio(final String precio) {
		this.precioProperty().set(precio);
	}
	
	
}
