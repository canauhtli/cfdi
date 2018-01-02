package com.canauhtli.cfdi.db;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="cfdi_factura")
@NamedQueries({
	@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f"),
	@NamedQuery(name="Factura.findByCodigo", query="SELECT f FROM Factura f WHERE f.codigo = :codigo"),
	@NamedQuery(name="Factura.findPorId", query="SELECT f FROM Factura f WHERE f.idFactura = :id"),
	@NamedQuery(name="Factura.findByCliente", query="SELECT f FROM Factura f WHERE f.cliente = :cliente"),
	@NamedQuery(name="Factura.findByUUID", query="SELECT f FROM Factura f WHERE f.uuid = :uuid"),
	@NamedQuery(name="Factura.findByFecha", query="SELECT f FROM Factura f WHERE f.fechaProceso >= :fini AND f.fechaProceso <= :ffin")
})
public class Factura implements Serializable {

	private static final long serialVersionUID = 4517241356594536238L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FACTURA")
	private long idFactura;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="cliente")
	private long cliente;
	
	@Column(name="ESTATUS")
	private char estatus;
	
	@Column(name="FECHA_PROCESO")
	private Date fechaProceso;
	
	@Column(name="FECHA_STATUS")
	private Date fechaEstatus;
	
	@Column(name="UUID")
	private String uuid;
	
	@Lob
	@Column(name="FACTURA")
	private String factura;
	
	@Lob
	@Column(name="COMPROBANTE_FISCAL")
	private String comprobanteFiscal;

	public long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public long getCliente() {
		return cliente;
	}
	
	public void setCliente(long cliente) {
		this.cliente = cliente;
	}

	public char getEstatus() {
		return estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	public Date getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public Date getFechaEstatus() {
		return fechaEstatus;
	}

	public void setFechaEstatus(Date fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getComprobanteFiscal() {
		return comprobanteFiscal;
	}

	public void setComprobanteFiscal(String comprobanteFiscal) {
		this.comprobanteFiscal = comprobanteFiscal;
	}
	
}
