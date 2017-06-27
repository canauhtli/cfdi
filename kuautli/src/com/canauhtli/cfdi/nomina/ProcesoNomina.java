package com.canauhtli.cfdi.nomina;

import java.util.ArrayList;

public class ProcesoNomina {

	private ArrayList<ReciboNominaEmp> recibos = new ArrayList<ReciboNominaEmp>();
	
	public void addRecibo(ReciboNominaEmp rn) {
		recibos.add(rn);
	}
	
	public ArrayList<ReciboNominaEmp> getRecibos() {
		return recibos;
	}
	
	public boolean tengoRecibos() {
		return (recibos != null) && (recibos.size() > 0);
	}
}
