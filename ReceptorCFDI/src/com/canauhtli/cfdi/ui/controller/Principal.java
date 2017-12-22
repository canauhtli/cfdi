package com.canauhtli.cfdi.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.cfdi.db.RecibidasDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Principal extends BorderPane implements Initializable {

	private static Logger log = LoggerFactory.getLogger(Principal.class);
			
	@FXML private Pane pContenido;
	@FXML private ToolBar tbNav;
	@FXML private Button bnRecibidas;
	@FXML private Button bnConfig;
	
	private RecibidasDAO dao = RecibidasDAO.getInstance();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dao.conectar();
		tbNav.prefWidthProperty().bind(pContenido.widthProperty());
		if (dao.isConectado()) {
			defineContenido(Contenido.RECIBIDAS);
		} else {
			defineContenido(Contenido.CONFIGURACION);
		}
	}
	
	@FXML private void cambiaContenido(ActionEvent event) {
		Button srcBtn = (Button) event.getSource();
		Contenido contenido = null;
		if (srcBtn == bnRecibidas) {
			contenido = Contenido.RECIBIDAS;
		} else if (srcBtn == bnConfig) {
			contenido = Contenido.CONFIGURACION;
		}
		defineContenido(contenido);
	}
	
	private void defineContenido(Contenido contenido) {
		pContenido.getChildren().clear();
		
		FXMLLoader loader = null;
		String fxmlResource = "";
		Object controller = null;
		
		switch (contenido) {
			case RECIBIDAS:
				fxmlResource = "/com/canauhtli/cfdi/ui/Recibidas.fxml";
				controller = new Recibidas();
				break;
			case CONFIGURACION:
				fxmlResource = "/com/canauhtli/cfdi/ui/Configuracion.fxml";
				controller = new Configuracion();
				break;
			default:
				break;
		}
		
		loader = new FXMLLoader(Principal.class.getResource(fxmlResource));
		loader.setController(controller);
		try {
			AnchorPane apCont = loader.load();
			pContenido.getChildren().add(apCont);
		} catch (IOException ioe) {
			log.error("Cargando contenido {}", contenido, ioe);
		}
	}
	
	
}
