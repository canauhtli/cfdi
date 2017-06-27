package com.canauhtli.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.canauhtli.cfdi.db.Config;
import com.canauhtli.cfdi.db.DBManager;

public class ConfigManager {

	private DBManager dbm;
	private HashMap<String, String> configuracion;
	
	public ConfigManager(DBManager dbm) {
		this.dbm = dbm;
		
		loadConfig();
	}
	
	private void loadConfig() {
		configuracion = new HashMap<String,String>();
		if (dbm.isConectado()) {
			List<Config> lst = dbm.obtenConfiguracion();
			for (Config c : lst) {
				configuracion.put(c.getCampo(), c.getValor());
			}
		}
	}
	
	private void guardaConfig(String tipo) {
		if (configuracion != null) {
			for (String k : configuracion.keySet()) {
				if (k.startsWith(tipo + ".")) {
					dbm.actualizaValorConfig(k, configuracion.get(k));
				}
			}
		}
	}
	
	public String getEmisorConfig(String campo) {
		String valor = "";
		if ((configuracion != null) && (configuracion.containsKey("emisor." + campo))) {
			valor = configuracion.get("emisor." + campo);
		}
		return valor;
	}
	
	public String getMailConfig(String campo) {
		String valor = "";
		if ((configuracion != null) && (configuracion.containsKey("mail." + campo))) {
			valor = configuracion.get("mail." + campo);
		}
		return valor;
	}
	
	public String getGeneralConfig(String campo) {
		String valor = "";
		if ((configuracion != null) && (configuracion.containsKey("general." + campo))) {
			valor = configuracion.get("general." + campo);
		}
		return valor;
	}
	
	public void setEmisorConfig(String campo, String valor) {
		if (configuracion != null) {
			configuracion.remove("emisor." + campo);
			configuracion.put("emisor." + campo, valor);
		}
	}
	
	public void setMailConfig(String campo, String valor) {
		if (configuracion != null) {
			configuracion.remove("mail." + campo);
			configuracion.put("mail." + campo, valor);
		}
	}
	
	public void setGeneralConfig(String campo, String valor) {
		if (configuracion != null) {
			configuracion.remove("general." + campo);
			configuracion.put("general." + campo, valor);
		}
	}
	
	public void setProveedorConfig(String campo, String valor) {
		if (configuracion != null) {
			configuracion.remove(getProveedor() + "." + campo);
			configuracion.put(getProveedor() + "." + campo, valor);
		}
	}
	
	public void guardaEmisorConfig() {
		guardaConfig("emisor");
	}
	
	public void guardaGeneralConfig() {
		guardaConfig("general");
	}
	
	public void guardaMailConfig() {
		guardaConfig("mail");
	}
	
	public void guardaProveedorConfig() {
		dbm.actualizaValorConfig("proveedor", getProveedor());
		guardaConfig(getProveedor());
	}
	
	public String getProveedor() {
		String proveedor = "";
		if ((configuracion != null) && (configuracion.containsKey("proveedor"))) {
			proveedor = configuracion.get("proveedor");
		}
		return proveedor;
	}
	
	public void setProveedor(String proveedor) {
		if (configuracion != null) {
			configuracion.remove("proveedor");
			configuracion.put("proveedor", proveedor);
		}
	}
	
	public Map<String, String> getProveedorConfig(String proveedor) {
		HashMap<String, String> pConfig = new HashMap<String, String>();
		for (String k : configuracion.keySet()) {
			if (k.startsWith(proveedor+".")) {
				pConfig.put(k.substring(k.indexOf('.')+1), configuracion.get(k));
			}
		}
		return pConfig;
	}
	
	public String getProveedorConfigVal(String campo) {
		String valor = "";
		if (configuracion != null) {
			valor = configuracion.get(getProveedor() + "." + campo);
		}
		return valor;
	}
	
	public List<String> listaProveedores() {
		ArrayList<String> lstProvs = new ArrayList<String>();
		if ((configuracion != null) && (configuracion.containsKey("proveedores"))) {
			String provs[] = configuracion.get("proveedores").split(",");
			for (String prov : provs) {
				lstProvs.add(prov);
			}
		}
		return lstProvs;
	}
	
}
