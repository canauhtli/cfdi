package com.canauhtli.cfdi.pac.bean;

import com.canauhtli.cfdi.pac.types.Estado;

public class Direccion {

	private String calle;
    private String numInt;
    private String numExt;
    private String colonia;
    private String municipio;
    private String ciudad;
    private Estado estado;
    private String pais;
    private String cp;
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumInt() {
		return numInt;
	}
	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}
	public String getNumExt() {
		return numExt;
	}
	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
    
	public String toString() {
		StringBuilder sb = new StringBuilder("Direccion=[");
		sb.append("calle=").append(calle)
		  .append(", numInt=").append(numInt)
		  .append(", numExt=").append(numExt)
		  .append(", colonia=").append(colonia)
		  .append(", municipio=").append(municipio)
		  .append(", estado=").append(estado)
		  .append(", pais=").append(pais)
		  .append(", cp=").append(cp)
		  .append("]");
		 
		return sb.toString();
	}
}
