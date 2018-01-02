package com.canauhtli.cfdi.reportes;

import java.math.BigDecimal;

public class ConceptoFactura {

	protected Integer partida;
	protected Integer cantidad;
	protected String unidad;
	protected String codigo;
	protected String descripcion;
	protected BigDecimal precioUnitario;
	protected BigDecimal importe;
	public Integer getPartida() {
		return partida;
	}
	public void setPartida(Integer partida) {
		this.partida = partida;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
}
