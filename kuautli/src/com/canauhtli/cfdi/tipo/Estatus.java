package com.canauhtli.cfdi.tipo;

public enum Estatus {

	NUEVO('N'),
	EMITIDO('D'),
	ENVIADO('E'),
	ERROR('X'),
	CANCELADO('C');
	
	private char estatus;
	
	private Estatus(char e) {
		this.estatus = e;
	}
	
	public char getEstatus() {
		return estatus;
	}
	
	public static Estatus fromEstatus(char e) {
		Estatus es = null;
		for (Estatus est : Estatus.values()) {
			if (est.getEstatus() == e) {
				es = est;
				break;
			}
		}
		return es;
	}
}
