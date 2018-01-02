package com.canauhtli.cfdi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.cfdi.db.DBManager;
import com.canauhtli.cfdi.pac.bean.Direccion;
import com.canauhtli.cfdi.pac.bean.Entidad;
import com.canauhtli.cfdi.pac.types.CodigoPais;
import com.canauhtli.cfdi.pac.types.Estado;
import com.canauhtli.config.AppConfig;
import com.canauhtli.config.ConfigManager;

public class CFDIDocumento {

	private static Logger log = LoggerFactory.getLogger(CFDIDocumento.class);
	
	protected DBManager madb;
	protected ConfigManager cm;
	
	public CFDIDocumento() {
		try {
			validaDB();
			madb = new DBManager();
			cm = new ConfigManager(madb);
		} catch(CFDIException cfdie) {
			escribeError(cfdie.getMessage());
			System.exit(1);
		}
	}
	
	protected Entidad initEmisor() {
		Entidad emisor = new Entidad();
		emisor.setRazonSocial(cm.getEmisorConfig("razonSocial"));
		emisor.setRegimenFiscal(cm.getEmisorConfig("regimenFiscal"));
		emisor.setRegistroPatronal(cm.getEmisorConfig("registroPatronal"));
		emisor.setRfc(cm.getEmisorConfig("rfc"));
		emisor.setCodigoPais(CodigoPais.MX);
		Direccion direccion = new Direccion();
		direccion.setCalle(cm.getEmisorConfig("calle"));
		direccion.setCiudad(cm.getEmisorConfig("ciudad"));
		direccion.setColonia(cm.getEmisorConfig("colonia"));
		direccion.setCp(cm.getEmisorConfig("cp"));
		direccion.setEstado(Estado.fromEstado(cm.getEmisorConfig("estado")));
		direccion.setMunicipio(cm.getEmisorConfig("municipio"));
		direccion.setNumExt(cm.getEmisorConfig("numeroExterior"));
		direccion.setNumInt(cm.getEmisorConfig("numeroInterior"));
		direccion.setPais(cm.getEmisorConfig("pais"));
		emisor.setDireccion(direccion);
		return emisor;
	}
	
	protected void validaDB() throws CFDIException {
		if ("".equals(AppConfig.getUserVal("dbUsr"))) {
			throw new CFDIException("No se ha configurado el usuario de la BD");
		}
		if ("".equals(AppConfig.getUserValEnc("dbPwd"))) {
			throw new CFDIException("No se ha configurado el password de la BD");
		}
		if ("".equals(AppConfig.getUserVal("dbServer"))) {
			throw new CFDIException("No se ha configurado el servidor de la BD");
		}
		if ("".equals(AppConfig.getUserVal("dbName"))) {
			throw new CFDIException("No se ha configurado el nombre de la BD");
		}
	}
	
	protected static void escribeError(String msg) {
		BufferedWriter bw = null;
		log.error(msg);
		try {
			bw = new BufferedWriter(new FileWriter(new File("salida.txt")));
			bw.write("0");
			bw.newLine();
			bw.write(msg);
			bw.flush();
		} catch (IOException e) {
			log.error("No pude escribir salida de error", e);
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e1) {
				log.warn("cerrando salida err");
			}
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				log.warn("cerrando salida err");
			}
		}
	}
	
	protected static String printUso() {
		String nl = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder(nl);
		sb.append("Se debe idicar la acción a realizar: G | C | B | E")
		  .append(nl).append(nl)
		  .append("Generar: G <archivo factura>").append(nl)
		  .append("\t Ruta del archivo con los datos de la factura").append(nl)
		  .append("Cancelar: C <Serie> <Folio>").append(nl)
		  .append("\t Serie y núm. Folio de la factura a cancelar").append(nl)
		  .append("Buscar: B <archvio busqueda>").append(nl)
		  .append("\t Ruta del archivo con los datos de la busqueda").append(nl)
		  .append("Extraer: E <Serie> <Folio>").append(nl)
		  .append("\t Serie y núm. Folio de la factura a extraer").append(nl);
		return sb.toString();
	}
}
