package com.canauhtli.cfdi.db;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the cfdi_periodo database table.
 * 
 */
@Entity
@Table(name="cfdi_periodo")
@NamedQueries({
	@NamedQuery(name="Periodo.findAll", query="SELECT p FROM Periodo p"),
	@NamedQuery(name="Periodo.findByPeriodo", query="SELECT p FROM Periodo p WHERE p.periodo = :periodo AND p.status <> :status")
})
public class Periodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String archivo;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_STATUS")
	private Timestamp fechaStatus;

	private String periodo;

	private int status;

	public Periodo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArchivo() {
		return this.archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaStatus() {
		return this.fechaStatus;
	}

	public void setFechaStatus(Timestamp fechaStatus) {
		this.fechaStatus = fechaStatus;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}