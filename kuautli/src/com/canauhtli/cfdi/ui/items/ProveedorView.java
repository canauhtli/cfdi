package com.canauhtli.cfdi.ui.items;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProveedorView {

	private StringProperty campo = new SimpleStringProperty(); 
	private StringProperty valor = new SimpleStringProperty();
	
	public final String getCampo() {
		return campo.get();
	}
	
	public final void setCampo(String campo) {
		this.campo.set(campo);
	}
	
	public StringProperty getCampoProperty() {
		return campo;
	}
	
	public final String getValor() {
		return valor.get();
	}
	
	public final void setValor(String valor) {
		this.valor.set(valor);
	}
	
	public StringProperty getValorProperty() {
		return valor;
	}
}
