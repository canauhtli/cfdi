package com.canauhtli.cfdi.nomina;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;


@Record(minOccurs=0)
@Fields({
    @Field(name="otroPago", at=0, rid=true, literal="O")
})
public class OtroPago {

	@Field(at=1)
	private String tipoOtroPago;
	
	@Field(at=2)
	private String clave;
	
	@Field(at=3)
	private String concepto;
	
	@Field(at=4, type=Double.class)
	private double importe;
	
	@Field(at=5, type=Boolean.class)
	private boolean subsidio;
	
	@Field(at=6, type=Double.class)
	private double subsidioCausado;
	
	@Field(at=7, type=Boolean.class)
	private boolean saldo;
	
	@Field(at=8, type=Double.class)
	private double saldoAFavor;
	
	@Field(at=9, type=Short.class)
	private short año;
	
	@Field(at=10, type=Double.class)
	private double remanente;

	public String getTipoOtroPago() {
		return tipoOtroPago;
	}

	public void setTipoOtroPago(String tipoOtroPago) {
		this.tipoOtroPago = tipoOtroPago;
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

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public boolean isSubsidio() {
		return subsidio;
	}

	public void setSubsidio(boolean subsidio) {
		this.subsidio = subsidio;
	}

	public double getSubsidioCausado() {
		return subsidioCausado;
	}

	public void setSubsidioCausado(double subsidioCausado) {
		this.subsidioCausado = subsidioCausado;
	}

	public boolean isSaldo() {
		return saldo;
	}

	public void setSaldo(boolean saldo) {
		this.saldo = saldo;
	}

	public double getSaldoAFavor() {
		return saldoAFavor;
	}

	public void setSaldoAFavor(double saldoAFavor) {
		this.saldoAFavor = saldoAFavor;
	}

	public short getAño() {
		return año;
	}

	public void setAño(short año) {
		this.año = año;
	}

	public double getRemanente() {
		return remanente;
	}

	public void setRemanente(double remanente) {
		this.remanente = remanente;
	}
	
	public String toRecord() {
		StringBuilder sb = new StringBuilder("O|");
		sb.append(tipoOtroPago).append("|")
		  .append(clave).append("|")
		  .append(concepto).append("|")
		  .append(importe).append("|")
		  .append(subsidio).append("|")
		  .append(subsidioCausado).append("|")
		  .append(saldo).append("|")
		  .append(saldoAFavor).append("|")
		  .append(año).append("|")
		  .append(remanente);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("OtroPago=[");
		sb.append("tipoOtroPago=").append(tipoOtroPago).append(", ")
		  .append("clave=").append(clave).append(", ")
		  .append("concepto=").append(concepto).append(", ")
		  .append("importe=").append(importe).append(", ")
		  .append("subsidio=").append(subsidio).append(", ")
		  .append("subsidioCausado=").append(subsidioCausado).append(", ")
		  .append("saldo=").append(saldo).append(", ")
		  .append("saldoAFavor=").append(saldoAFavor).append(", ")
		  .append("año=").append(año).append(", ")
		  .append("remanente=").append(remanente).append("]");
		return sb.toString();
	}
}
