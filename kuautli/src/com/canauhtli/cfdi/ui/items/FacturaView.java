package com.canauhtli.cfdi.ui.items;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FacturaView {

	private long idFactura;
	private StringProperty codigo = new SimpleStringProperty();
	private StringProperty rfc = new SimpleStringProperty();
	private StringProperty status = new SimpleStringProperty();
	private StringProperty cfdi = new SimpleStringProperty();
	private StringProperty pdf = new SimpleStringProperty();
	private StringProperty correo = new SimpleStringProperty();
	
	public long getIdFactura() {
		return idFactura;
	}
	
	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}
	
	public final StringProperty codigoProperty() {
		return this.codigo;
	}
	
	public final String getCodigo() {
		return this.codigoProperty().get();
	}
	
	public final void setCodigo(final String codigo) {
		this.codigoProperty().set(codigo);
	}
	
	public final StringProperty rfcProperty() {
		return this.rfc;
	}
	
	public final String getRfc() {
		return this.rfcProperty().get();
	}
	
	public final void setRfc(final String rfc) {
		this.rfcProperty().set(rfc);
	}
	
	public final StringProperty statusProperty() {
		return this.status;
	}
	
	public final String getStatus() {
		return this.statusProperty().get();
	}
	
	public final void setStatus(final String status) {
		this.statusProperty().set(status);
	}
	
	public final StringProperty cfdiProperty() {
		return this.cfdi;
	}
	
	public final String getCfdi() {
		return this.cfdiProperty().get();
	}
	
	public final void setCfdi(final String cfdi) {
		this.cfdiProperty().set(cfdi);
	}
	
	public final StringProperty pdfProperty() {
		return this.pdf;
	}
	
	public final String getPdf() {
		return this.pdfProperty().get();
	}
	
	public final void setPdf(final String pdf) {
		this.pdfProperty().set(pdf);
	}
	
	public final StringProperty correoProperty() {
		return this.correo;
	}
	
	public final String getCorreo() {
		return this.correoProperty().get();
	}
	
	public final void setCorreo(final String correo) {
		this.correoProperty().set(correo);
	}
	
}
