package com.canauhtli.cfdi.db;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cfdi_config database table.
 * 
 */
@Entity
@Table(name="cfdi_config")
@NamedQueries({
	@NamedQuery(name="Config.findAll", query="SELECT c FROM Config c"),
	@NamedQuery(name="Config.findByGrupo", query="SELECT c FROM Config c WHERE c.campo LIKE :grupo"),
	@NamedQuery(name="Config.findByCampo", query="SELECT c.valor FROM Config c WHERE c.campo = :campo")
})
public class Config implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String campo;

	private String valor;

	public Config() {
	}

	public String getCampo() {
		return this.campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}