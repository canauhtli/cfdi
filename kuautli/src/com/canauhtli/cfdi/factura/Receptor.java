package com.canauhtli.cfdi.factura;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=1)
@Fields({
    @Field(name="receptor", at=0, rid=true, literal="R")
})
public class Receptor {

	@Field(at=1, required=true, regex="^[A-ZÑ&]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])((\\D|\\d){2})[0-9A-NP-Z]$")
	private String rfc;
	
	@Field(at=2, required=true)
	private String razonSocial;
	
	@Field(at=3)
	private String calle;
	
	@Field(at=4)
	private String numExt;
	
	@Field(at=5)
	private String numInt;
	
	@Field(at=6)
	private String colonia;
	
	@Field(at=7)
	private String municipio;
	
	@Field(at=8)
	private String ciudad;
	
	@Field(at=9)
	private String estado;
	
	@Field(at=10)
	private String cp;
	
	@Field(at=11)
	private String pais;
	
	@Field(at=12)
	private String codigoPais;
	
	@Field(at=13, required=true)
	private String usoCfdi;
	
	@Field(at=14)
	private long numCliente;

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumExt() {
		return numExt;
	}

	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}

	public String getNumInt() {
		return numInt;
	}

	public void setNumInt(String numInt) {
		this.numInt = numInt;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getUsoCfdi() {
		return usoCfdi;
	}

	public void setUsoCfdi(String usoCfdi) {
		this.usoCfdi = usoCfdi;
	}
	
	public long getNumCliente() {
		return numCliente;
	}
	
	public void setNumCliente(long numCliente) {
		this.numCliente = numCliente;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("rfc:").append(rfc)
		  .append(", razonSocial:").append(razonSocial)
		  .append(", calle:").append(calle)
		  .append(", numExt:").append(numExt)
		  .append(", numInt:").append(numInt)
		  .append(", colonia:").append(colonia)
		  .append(", municipio:").append(municipio)
		  .append(", ciudad:").append(ciudad)
		  .append(", estado:").append(estado)
		  .append(", cp:").append(cp)
		  .append(", pais:").append(pais)
		  .append(", codigoPais:").append(codigoPais)
		  .append("]");
		
		return sb.toString();
	}
	
}
