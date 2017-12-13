package com.canauhtli.cfdi.nomina;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=1)
@Fields({
    @Field(name="receptor", at=0, rid=true, literal="R")
})
public class Receptor {

	// tnvmtop.per_nom
	@Field(at=1)
	private String nombre;
	
	@Field(at=2)
	private String rfc;
	
	@Field(at=3)
	private String calle;
	
	@Field(at=4)
	private String numInt;
	
	@Field(at=5)
	private String numExt;
	
	@Field(at=6)
	private String colonia;
	
	@Field(at=7)
	private String municipio;
	
	@Field(at=8)
	private String estado;
	
	@Field(at=9)
	private String pais;
	
	@Field(at=10)
	private String cp;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
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
	
	public String toRecord() {
		StringBuilder sb = new StringBuilder("R|");
		sb.append(nombre).append("|")
			.append(rfc).append("|")
			.append(calle).append("|")
			.append(numInt).append("|")
			.append(numExt).append("|")
			.append(colonia).append("|")
			.append(municipio).append("|")
			.append(estado).append("|")
			.append(pais).append("|")
			.append(cp);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("Receptor=[");
		sb.append("nombre= ").append(nombre).append(", ")
		  .append("rfc= ").append(rfc).append(", ")
		  .append("calle= ").append(calle).append(", ")
		  .append("numInt= ").append(numInt).append(", ")
		  .append("numExt= ").append(numExt).append(", ")
		  .append("colonia= ").append(colonia).append(", ")
		  .append("municipio= ").append(municipio).append(", ")
		  .append("estado= ").append(estado).append(", ")
		  .append("pais= ").append(pais).append(", ")
		  .append("cp= ").append(cp).append("]");
		return sb.toString();
	}
}
