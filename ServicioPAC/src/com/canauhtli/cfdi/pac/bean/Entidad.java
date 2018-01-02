package com.canauhtli.cfdi.pac.bean;

import com.canauhtli.cfdi.pac.types.CodigoPais;

public class Entidad {

	private String razonSocial;
    private String regimenFiscal;
    private String registroPatronal;
    private String rfc;
    private CodigoPais codigoPais;
    private Direccion direccion;
    private String usoCFDI;
    
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getRegimenFiscal() {
		return regimenFiscal;
	}
	public void setRegimenFiscal(String regimenFiscal) {
		this.regimenFiscal = regimenFiscal;
	}
	public String getRegistroPatronal() {
		return registroPatronal;
	}
	public void setRegistroPatronal(String registroPatronal) {
		this.registroPatronal = registroPatronal;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public CodigoPais getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(CodigoPais codigoPais) {
		this.codigoPais = codigoPais;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getUsoCFDI() {
		return usoCFDI;
	}
	public void setUsoCFDI(String usoCFDI) {
		this.usoCFDI = usoCFDI;
	}
    
	public String toString() {
		StringBuilder sb = new StringBuilder("Entidad [");
		sb.append("razonSocial=").append(razonSocial)
		  .append(", regimenFiscal=").append(regimenFiscal)
		  .append(", rfc=").append(rfc)
		  .append(", codigoPais=").append(codigoPais)
		  .append(", ").append(direccion)
		  .append("]");
		 
		return sb.toString();
	}
}
