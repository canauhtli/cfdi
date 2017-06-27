package com.canauhtli.cfdi.db;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cfdi_recibo_nomina database table.
 * 
 */
@Entity
@Table(name="cfdi_recibo_nomina")
@NamedQueries({
	@NamedQuery(name="ReciboNomina.findAll", query="SELECT r FROM ReciboNomina r"),
	@NamedQuery(name="ReciboNomina.findByPeriodo", query="SELECT r FROM ReciboNomina r WHERE r.idPeriodo = :periodo")
})
public class ReciboNomina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RECIBO_NOMINA")
	private int idReciboNomina;

	@Column(name="ID_PERIODO")
	private int idPeriodo;

	@Column(name="NUM_EMP")
	private String numEmp;
	
	@Column(name="ESTATUS")
	private char estatus;
	
	@Lob 
	@Column(name="COMPROBANTE_FISCAL")
	private String comprobanteFiscal;
	
	@Column(name="UUID")
	private String uuid;
	
	@Lob
	private String recibo;

	public ReciboNomina() {
	}

	public int getIdReciboNomina() {
		return this.idReciboNomina;
	}

	public void setIdReciboNomina(int idReciboNomina) {
		this.idReciboNomina = idReciboNomina;
	}

	public int getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	
	public String getNumEmp() {
		return numEmp;
	}
	
	public void setNumEmp(String numEmp) {
		this.numEmp = numEmp;
	}
	
	public char getEstatus() {
		return estatus;
	}
	
	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}
	
	public String getComprobanteFiscal() {
		return comprobanteFiscal;
	}
	
	public void setComprobanteFiscal(String comprobanteFiscal) {
		this.comprobanteFiscal = comprobanteFiscal;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getRecibo() {
		return this.recibo;
	}

	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}

}