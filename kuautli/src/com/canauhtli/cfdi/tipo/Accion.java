package com.canauhtli.cfdi.tipo;

public enum Accion {

	GENERAR("G"), 
	CANCELAR("C"), 
	BUSCAR("B"), 
	EXTRAER("E"), 
	IMPRESORAS("I");

	private String a;

	private Accion(String a) {
		this.a = a;
	}

	public String getAccion() {
		return this.a;
	}

	public static Accion fromArg(String a) {
		Accion accion = null;
		for (Accion acc : values()) {
			if (acc.a.equalsIgnoreCase(a)) {
				accion = acc;
				break;
			}
		}
		return accion;
	}
}
