package com.canauhtli.cfdi.pac.bean;

import java.util.ArrayList;

public class Relacionados {

	private String tipoRelacion;
	private ArrayList<String> uuids;
	
	public String getTipoRelacion() {
		return tipoRelacion;
	}
	public void setTipoRelacion(String tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}
	public ArrayList<String> getUuids() {
		return uuids;
	}
	public void setUuids(ArrayList<String> uuids) {
		this.uuids = uuids;
	}
	
	
}
