package com.canauhtli.cfdi.ui.controls;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.cfdi.db.DBManager;
import com.canauhtli.config.ConfigManager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PrincipalController extends BorderPane implements Initializable {

	private static Logger log = LoggerFactory.getLogger(PrincipalController.class);
	
	// Menu Monitor
	@FXML
	private Menu mMonitor;
	
	@FXML
	private MenuItem mPeriodos;
	
	@FXML
	private MenuItem mFacturas;
	
	@FXML
	private MenuItem mSalir;
	
	// Menu Configuracion
	@FXML
	private Menu mConfiguracion;
	
	@FXML
	private MenuItem mEmisor;
	
	@FXML
	private MenuItem mGeneral;
	
	@FXML
	private MenuItem mProveedor;
	
	@FXML
	private MenuItem mCertificados;
	
	@FXML
	private MenuItem mBD;
	
	// Menu Ayuda
	@FXML
	private Menu mAyuda;
	
	@FXML
	private MenuItem mAcercaDe;
	
	@FXML
	private Pane contenido;
	
	private AnchorPane listadoPeriodo;
	private AnchorPane listadoFacturas;
	private AnchorPane configEmisor;
	private AnchorPane configGeneral;
	private AnchorPane configMail;
	private AnchorPane configProveedor;
	private AnchorPane configCertificados;
	private AnchorPane configDB;
	
	private ListadoPeriodoController lpc;
	private FacturasController fc;
	private ConfigEmisorController cec;
	private ConfigGeneralController cgc;
	private ConfigMailController cmc;
	private ConfigProveedorController cpc;
	private ConfigDBController cdbc;
	
	private DBManager dbm;
	private ConfigManager cm;
	
	public PrincipalController(DBManager dbm, ConfigManager cm) {
		this.dbm = dbm;
		this.cm = cm;
		lpc = new ListadoPeriodoController(dbm);
		fc = new FacturasController(dbm);
		cec = new ConfigEmisorController(cm);
		cgc = new ConfigGeneralController(cm);
		cmc = new ConfigMailController(cm);
		cpc = new ConfigProveedorController(cm);
		cdbc = new ConfigDBController(this);
	}
	
	public Pane getContenido() {
		return contenido;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			log.debug("Creando nodo ListadoPeriodo");
			FXMLLoader loader = new FXMLLoader(PrincipalController.class.getResource("/com/canauhtli/cfdi/ui/ListadoPeriodo.fxml"));
			loader.setController(lpc);
			listadoPeriodo = loader.load();
			
			log.debug("Creando nodo ListadoFacturas");
			loader = new FXMLLoader(PrincipalController.class.getResource("/com/canauhtli/cfdi/ui/ListadoFacturas.fxml"));
			loader.setController(fc);
			listadoFacturas = loader.load();
			
			log.debug("Creando nodo ConfigEmisor");
			loader = new FXMLLoader(PrincipalController.class.getResource("/com/canauhtli/cfdi/ui/ConfigEmisor.fxml"));
			loader.setController(cec);
			configEmisor = loader.load();
			
			log.debug("Creando nodo ConfigGeneral");
			loader = new FXMLLoader(PrincipalController.class.getResource("/com/canauhtli/cfdi/ui/ConfigGeneral.fxml"));
			loader.setController(cgc);
			configGeneral = loader.load();
			
			log.debug("Creando nodo ConfigMail");
			loader = new FXMLLoader(PrincipalController.class.getResource("/com/canauhtli/cfdi/ui/ConfigMail.fxml"));
			loader.setController(cmc);
			configMail = loader.load();
			
			log.debug("Creando nodo ConfigProveedor");
			loader = new FXMLLoader(PrincipalController.class.getResource("/com/canauhtli/cfdi/ui/ConfigProveedor.fxml"));
			loader.setController(cpc);
			configProveedor = loader.load();
			
			log.debug("Creando nodo ConfigDB");
			loader = new FXMLLoader(PrincipalController.class.getResource("/com/canauhtli/cfdi/ui/ConfigDB.fxml"));
			loader.setController(cdbc);
			configDB = loader.load();
			
			if (dbm.isConectado()) {
				log.debug("Mostrar nodo Facturas");
				contenido.getChildren().add(listadoFacturas);
			} else {
				mMonitor.setDisable(true);
				mConfiguracion.setDisable(true);
				log.debug("Mostrar nodo de configuracion de BD");
				contenido.getChildren().add(configDB);
			}
		} catch (IOException ioe) {
			log.error("No pude inicializar correctamente los controles graficos", ioe);
		}
	}
	
	@FXML
	private void salir(ActionEvent event) {
		Platform.exit();
	}
	
	@FXML
	private void cambiaContenido(ActionEvent event) {
		MenuItem m = (MenuItem) event.getSource();
		
		if ("mPeriodos".equals(m.getId())) {
			contenido.getChildren().remove(0);
			contenido.getChildren().add(listadoPeriodo);
		}
		
		if ("mFacturas".equals(m.getId())) {
			contenido.getChildren().remove(0);
			contenido.getChildren().add(listadoFacturas);
		}
		
		if ("mEmisor".equals(m.getId())) {
			contenido.getChildren().remove(0);
			contenido.getChildren().add(configEmisor);
		}
		
		if ("mGeneral".equals(m.getId())) {
			contenido.getChildren().remove(0);
			contenido.getChildren().add(configGeneral);
		}
		
		if ("mCorreo".equals(m.getId())) {
			contenido.getChildren().remove(0);
			contenido.getChildren().add(configMail);
		}
		
		if ("mProveedor".equals(m.getId())) {
			contenido.getChildren().remove(0);
			contenido.getChildren().add(configProveedor);
		}
		
		if ("mCertificados".equals(m.getId())) {
			contenido.getChildren().remove(0);
			contenido.getChildren().add(configCertificados);
		}
		
		if ("mBD".equals(m.getId())) {
			contenido.getChildren().remove(0);
			contenido.getChildren().add(configDB);
		}
		
	}
	
	public void activa() {
		mMonitor.setDisable(false);
		mConfiguracion.setDisable(false);
		cm = new ConfigManager(dbm);
	}

}
