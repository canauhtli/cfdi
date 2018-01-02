package com.canauhtli.cfdi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.cfdi.db.DBManager;
import com.canauhtli.cfdi.db.ReciboNomina;
import com.canauhtli.cfdi.pac.ClientePACException;
import com.canauhtli.cfdi.pac.ClienteServicioPAC;
import com.canauhtli.cfdi.tipo.Estatus;

public class Cancelador {

	private static Logger log = LoggerFactory.getLogger(Cancelador.class);
	
	private DBManager madb;
	private ArrayList<String> lstUUID;
	
	public Cancelador(DBManager ma) {
		madb = ma;
	}
	
	public void cancelar(ClienteServicioPAC pac) {
		if ((lstUUID != null) && (lstUUID.size() > 0)) {
			try {
				HashMap<String, String> cancelados = pac.cancelaComprobantes(lstUUID);
				for (String k : cancelados.keySet()) {
					if ("".equals(cancelados.get(k))) {
						log.info("{} Cancelado", k);
						ReciboNomina rn = madb.obtenerReciboNominaPorUUID(k);
						rn.setEstatus(Estatus.CANCELADO.getEstatus());
						madb.actualizaReciboNomina(rn);
					} else {
						log.info("{} - {}", k, cancelados.get(k));
					}
				}
			} catch (ClientePACException e) {
				log.error("No pude cancelar los UUID solicitados", e);
			}
		}
	}
	
	public void leerArchivo(File entrada) {
		lstUUID = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(entrada));
			String linea = "";
			while ((linea = br.readLine()) != null) {
				lstUUID.add(linea);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			log.error("No encontre el archivo de entrada {}", entrada.getName(), e);
		} catch (IOException e) {
			log.error("No pude leer correctamente el archivo de entrada {}", entrada.getName(), e);
		}
		
		log.info("El archivo de entrada contiene {} UUIDs para cancelar", lstUUID.size());
	}
}
