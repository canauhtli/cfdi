package com.canauhtli.cfdi.db;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CFDI_CONCEPTO_RECIBIDA")
@NamedQueries({
	@NamedQuery(name="Concepto.findAll", query="SELECT c FROM Concepto c"),
	@NamedQuery(name="Factura.findByFactura", query="SELECT c FROM Concepto c WHERE c.idFactura = :factura")
})
public class Concepto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CONCEPTO_RECIBIDA")
	private long idConcepto;
	
	@Column(name="ID_FACTURA_RECIBIDA")
	private int idFactura;
	
	@Column(name="CLAVEPRODSERV")
	private String claveProdServ;
	
	@Column(name="NUMIDENTIFICACION")
	private String numIdentificacion;
	
	@Column(name="CANTIDAD")
	private BigDecimal cantidad;
	  
	@Column(name="CLAVEUNIDAD")
	private String claveUnidad;
	  
	@Column(name="UNIDAD")
	private String unidad;
	  
	@Column(name="DESCRIPCION")
	private String descripcion;
	  
	@Column(name="VALORUNITARIO")
	private BigDecimal valorUnitario;
	  
	@Column(name="IMPORTE")
	private BigDecimal importe;
	  
	@Column(name="DESCUENTO")
	private BigDecimal descuento;

	public long getIdConcepto() {
		return idConcepto;
	}

	public void setIdConcepto(long idConcepto) {
		this.idConcepto = idConcepto;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getClaveProdServ() {
		return claveProdServ;
	}

	public void setClaveProdServ(String claveProdServ) {
		this.claveProdServ = claveProdServ;
	}

	public String getNumIdentificacion() {
		return numIdentificacion;
	}

	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public String getClaveUnidad() {
		return claveUnidad;
	}

	public void setClaveUnidad(String claveUnidad) {
		this.claveUnidad = claveUnidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
	
}
