package com.canauhtli.cfdi.ui.items;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmpleadoView {

	private StringProperty numEmp = new SimpleStringProperty();
	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty status = new SimpleStringProperty();
	private StringProperty cfdi = new SimpleStringProperty();
	private StringProperty pdf = new SimpleStringProperty();
	private StringProperty correo = new SimpleStringProperty();
	
	public final String getNumEmp() {
		return numEmp.get();
	}
	
	public final void setNumEmp(String numEmp) {
		this.numEmp.set(numEmp);
	}
	
	public StringProperty getNumEmpProperty() {
		return numEmp;
	}
	
	public final String getNombre() {
		return nombre.get();
	}
	
	public final void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	
	public StringProperty getNombreProperty() {
		return nombre;
	}
	
	public final String getStatus() {
		return status.get();
	}
	
	public final void setStatus(String status) {
		this.status.set(status);
	}
	
	public StringProperty getStatusProperty() {
		return status;
	}
	
	public final String getCfdi() {
		return cfdi.get();
	}
	
	public final void setCfdi(String cfdi) {
		this.cfdi.set(cfdi);
	}
	
	public StringProperty getCfdiProperty() {
		return cfdi;
	}
	
	public final String getPdf() {
		return pdf.get();
	}
	
	public final void setPdf(String pdf) {
		this.pdf.set(pdf);
	}
	
	public StringProperty getPdfProperty() {
		return pdf;
	}
	
	public final String getCorreo() {
		return correo.get();
	}
	
	public final void setCorreo(String correo) {
		this.correo.set(correo);
	}
	
	public StringProperty getCorreoProperty() {
		return correo;
	}

}
