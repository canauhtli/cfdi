package com.canauhtli.cfdi.factura;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record
@Fields({
    @Field(name="descRec", at=0, rid=true, literal="S")
})
public class DescuentoRecargo {
	
	@Field(at=1)
	private String tipo;
	
	@Field(at=2)
	private int partida;
	
	@Field(at=3)
	private String descripcion;
	
	@Field(at=4)
	private double tasa;
	
	@Field(at=5)
	private double monto;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("tipo:").append(tipo)
		  .append(", partida:").append(partida)
		  .append(", descripcion:").append(descripcion)
		  .append(", tasa:").append(tasa)
		  .append(", monto:").append(monto)
		  .append("]");
		 
		return sb.toString();
	}

}
