package com.canauhtli.cfdi.ui.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.cfdi.Recolector;
import com.canauhtli.cfdi.db.RecibidasDAO;
import com.canauhtli.cfdi.utils.AppConfig;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

public class Configuracion extends AnchorPane implements Initializable {

	private static Logger log = LoggerFactory.getLogger(Principal.class);
	
	@FXML private TextField tfEntrada;
	@FXML private TextField tfProcesadas;
	@FXML private TextField tfServidor;
	@FXML private TextField tfNombre;
	@FXML private TextField tfUsuario;
	@FXML private PasswordField pfPassword;
	@FXML private Button btEntrada;
	@FXML private Button btProcesadas;
	@FXML private Button btEditar;
	@FXML private Button btConectar;
	@FXML private Button btGuardar;
	@FXML private Button btCancelar;
	
	private RecibidasDAO dao = RecibidasDAO.getInstance();
	private String decoration = "decoration-warning";
	
	@FXML
	private void editar(ActionEvent event) {
		
		editable(true);
	}
	
	@FXML
	private void conectar(ActionEvent event) {
	
		Notifications notification = Notifications.create()
				.title("Conexión a base de datos...")
				.position(Pos.CENTER);
		
		if (validar()) {

			dao.conectar(tfServidor.getText().trim(), tfNombre.getText().trim(), tfUsuario.getText().trim(), pfPassword.getText().trim());
			if (dao.isConectado()) {
				notification.text("Conectado a la base de datos");
				notification.showInformation();
			} else {
				notification.text("No fue posible conectarse a la base de datos");
				notification.showError();
			}
		} else {
			notification.text("Revisar que todos los campos esten definidos");
			notification.showError();
		}
	}
	
	@FXML
	private void cancelar(ActionEvent event) {
		editable(false);
	}
	
	@FXML
	private void guardar(ActionEvent event) {
		AppConfig.setUserVal("directorio.entrada", tfEntrada.getText().trim());
		AppConfig.setUserVal("directorio.procesadas", tfProcesadas.getText().trim());
		AppConfig.setUserVal("db.server", tfServidor.getText().trim());
		AppConfig.setUserVal("db.name", tfNombre.getText().trim());
		AppConfig.setUserVal("db.usr", tfUsuario.getText().trim());
		AppConfig.setUserValEnc("db.pwd", pfPassword.getText().trim());
		
		Recolector.getInstance().actualizaDirectorios();
		
		Notifications notification = Notifications.create().title("").position(Pos.CENTER);
		notification.text("Configuración guardada");
		notification.showInformation();
		editable(false);
	}
	
	@FXML
	private void seleccionaEntrada(ActionEvent event) {
		DirectoryChooser dc = new DirectoryChooser();
		File dir = dc.showDialog(null);
		if (dir != null) {
			tfEntrada.setText(dir.getAbsolutePath());
		}
	}
	
	@FXML
	private void seleccionaProcesadas(ActionEvent event) {
		DirectoryChooser dc = new DirectoryChooser();
		File dir = dc.showDialog(null);
		if (dir != null) {
			tfProcesadas.setText(dir.getAbsolutePath());
		} 
	}
	
	private void editable(boolean edita) {
		tfServidor.setEditable(edita);
		tfNombre.setEditable(edita);
		tfUsuario.setEditable(edita);
		pfPassword.setEditable(edita);
		btEntrada.setDisable(!edita);
		btProcesadas.setDisable(!edita);
		btConectar.setDisable(!edita);
		btGuardar.setDisable(!edita);
		btCancelar.setDisable(!edita);
	}
	
	private boolean validar() {
		boolean valida = true;
		removeDecorations();
		
		if ("".equals(tfEntrada.getText().trim())) {
			tfEntrada.getStyleClass().add(decoration);
			valida = false;
		}
		
		if ("".equals(tfProcesadas.getText().trim())) {
			tfProcesadas.getStyleClass().add(decoration);
			valida = false;
		}
		
		if ("".equals(tfServidor.getText().trim())) {
			tfServidor.getStyleClass().add(decoration);
			valida = false;
		}
		
		if ("".equals(tfNombre.getText().trim())) {
			tfNombre.getStyleClass().add(decoration);
			valida = false;
		}
		
		if ("".equals(tfUsuario.getText().trim())) {
			tfUsuario.getStyleClass().add(decoration);
			valida = false;
		}
		
		if ("".equals(pfPassword.getText().trim())) {
			pfPassword.getStyleClass().add(decoration);
			valida = false;
		}
		
		return valida;
	}
	
	private void removeDecorations() {
		tfEntrada.getStyleClass().remove(decoration);
		tfProcesadas.getStyleClass().remove(decoration);
		tfServidor.getStyleClass().remove(decoration);
		tfNombre.getStyleClass().remove(decoration);
		tfUsuario.getStyleClass().remove(decoration);
		pfPassword.getStyleClass().remove(decoration);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tfEntrada.setText(AppConfig.getUserVal("directorio.entrada"));
		tfProcesadas.setText(AppConfig.getUserVal("directorio.procesadas"));
		tfServidor.setText(AppConfig.getUserVal("db.server"));
		tfNombre.setText(AppConfig.getUserVal("db.name"));
		tfUsuario.setText(AppConfig.getUserVal("db.usr"));
		pfPassword.setText(AppConfig.getUserValEnc("db.pwd"));
		
	}
}
