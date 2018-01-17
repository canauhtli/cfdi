package com.canauhtli.cfdi.factura;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record
@Fields({
    @Field(name="comentario", at=0, rid=true, literal="C")
})
public class Comentario implements Comparable<Comentario> {

	@Field(at=1, trim=true)
	private int partida;
	
	@Field(at=2)
	private int posicion;
	
	@Field(at=3, trim=true)
	private int orden;
	
	@Field(at=4)
	private String comentario;
	
	public int getPartida() {
		return partida;
	}
	public void setPartida(int partida) {
		this.partida = partida;
	}
	public boolean isPosicion() {
		return posicion == 1;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("partida:").append(partida)
		  .append(", posicion:").append(posicion)
		  .append(", orden:").append(orden)
		  .append(", comentario:").append(comentario)
		  .append("]");
		
		return sb.toString();
	}
	
	public int compareTo(Comentario o) {
		return this.orden > o.getOrden() ? 1 : this.orden == o.getOrden() ? 0 : -1;
	}
}
