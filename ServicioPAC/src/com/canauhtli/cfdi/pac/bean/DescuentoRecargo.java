package com.canauhtli.cfdi.pac.bean;

import com.canauhtli.cfdi.pac.types.DesRecTipo;

public class DescuentoRecargo {

	private DesRecTipo tipo;
    private int partida;
    private String descripcion;
    private double tasa;
    private double monto;
    
	public DesRecTipo getTipo() {
		return tipo;
	}
	public void setTipo(DesRecTipo tipo) {
		this.tipo = tipo;
	}
	public int getPartida() {
		return partida;
	}
	public void setPartida(int partida) {
		this.partida = partida;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getTasa() {
		return tasa;
	}
	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
    
    
}
