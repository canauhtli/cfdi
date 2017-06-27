package com.canauhtli.cfdi.db;

public enum PeriodoStatus {

	NUEVO(1),
	DESPLAZADO(2),
	REGISTRADO(3),
	EMITIDO(4),
	PDFS(5);
	
	private int status;
	
	private PeriodoStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
}
