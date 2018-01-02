package com.canauhtli.cfdi.pac.bean;

public class Comentario implements Comparable<Comentario> {

	private int partida;
    private boolean posicion;
    private int orden;
    private String comentario;
    
    public int getPartida() {
		return partida;
	}

    public void setPartida(int partida) {
		this.partida = partida;
	}

	public boolean isPosicion() {
		return posicion;
	}

	public void setPosicion(boolean posicion) {
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

	@Override
	public int compareTo(Comentario o) {
		return this.orden > o.getOrden() ? 1 : (this.orden == o.getOrden() ? 0 : -1);
	}

}
