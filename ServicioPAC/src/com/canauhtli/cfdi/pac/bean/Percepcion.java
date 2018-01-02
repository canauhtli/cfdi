package com.canauhtli.cfdi.pac.bean;

import com.canauhtli.cfdi.pac.types.TipoDeduccion;
import com.canauhtli.cfdi.pac.types.TipoPercepcion;

public class Percepcion {

	private TipoDeduccion tipoDeduccion;
    private TipoPercepcion tipoPercepcion;
    private String clave;
    private String concepto;
    private double importeGravado;
    private double importeExento;
    private double importe;
    private boolean deduccion;
	public TipoDeduccion getTipoDeduccion() {
		return tipoDeduccion;
	}
	public void setTipoDeduccion(TipoDeduccion tipoDeduccion) {
		this.tipoDeduccion = tipoDeduccion;
	}
	public TipoPercepcion getTipoPercepcion() {
		return tipoPercepcion;
	}
	public void setTipoPercepcion(TipoPercepcion tipoPercepcion) {
		this.tipoPercepcion = tipoPercepcion;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getImporteGravado() {
		return importeGravado;
	}
	public void setImporteGravado(double importeGravado) {
		this.importeGravado = importeGravado;
	}
	public double getImporteExento() {
		return importeExento;
	}
	public void setImporteExento(double importeExento) {
		this.importeExento = importeExento;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public boolean isDeduccion() {
		return deduccion;
	}
	public void setDeduccion(boolean deduccion) {
		this.deduccion = deduccion;
	}
    
    
}
