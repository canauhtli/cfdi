package com.canauhtli.cfdi.db;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CFDI_FACTURA_RECIBIDA")
@NamedQueries({
	@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f"),
	@NamedQuery(name="Factura.findByUUID", query="SELECT f FROM Factura f WHERE f.uuid = :uuid"),
	@NamedQuery(name="Factura.findByPedido", query="SELECT f FROM Factura f WHERE f.numeroPedido = :pedido")
})
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FACTURA_RECIBIDA")
	private int idFactura;
	
	@Column(name="NUMERO_PEDIDO")
	private String numeroPedido;
	
	@Column(name="ARCHIVO")
	private String archivo;
	
	@Column(name="SERIE")
	private String serie;
	
	@Column(name="FOLIO")
	private int folio;
	
	@Column(name="FECHA")
	private Timestamp fecha;

	@Column(name="SUBTOTAL")
	private BigDecimal subtotal;
	
	@Column(name="DESCUENTO")
	private BigDecimal descuento;
	
	@Column(name="TOTAL")
	private BigDecimal total;
	
	@Column(name="TOTALIMPUESTOS")
	private BigDecimal totalImpuestos;
	
	@Column(name="MONEDA")
	private String moneda;
	
	@Column(name="TIPOCAMBIO")
	private BigDecimal tipoCambio;

	@Column(name="RFCEMISOR")
	private String rfcEmisor;
	
	@Column(name="UUID")
	private String uuid;

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTotalImpuestos() {
		return totalImpuestos;
	}

	public void setTotalImpuestos(BigDecimal totalImpuestos) {
		this.totalImpuestos = totalImpuestos;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public String getRfcEmisor() {
		return rfcEmisor;
	}

	public void setRfcEmisor(String rfcEmisor) {
		this.rfcEmisor = rfcEmisor;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
