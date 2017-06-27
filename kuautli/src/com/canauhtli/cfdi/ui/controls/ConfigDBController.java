package com.canauhtli.cfdi.ui.controls;

import org.controlsfx.control.Notifications;
import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.control.decoration.StyleClassDecoration;

import com.canauhtli.cfdi.db.DBManager;
import com.canauhtli.config.AppConfig;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ConfigDBController extends AnchorPane {

	private PrincipalController principal;
	
	@FXML
	private TextField server;
	
	@FXML
	private TextField dbname;
	
	@FXML
	private TextField usr;
	
	@FXML
	private PasswordField pwd;
	
	@FXML
	private Button bProbar;
	
	@FXML
	private Button bEditar;
	
	@FXML
	private Button bGuardar;
	
	@FXML
	private Button bCancelar;
	
	@FXML
	private Label msg;
	
	private boolean valido;
	
	public ConfigDBController(PrincipalController principal) {
		this.principal = principal;
	}
	
	@FXML
	protected void initialize() {
		
		server.setText(AppConfig.getUserVal("dbServer"));
		dbname.setText(AppConfig.getUserVal("dbName"));
		usr.setText(AppConfig.getUserVal("dbUsr"));
		pwd.setText(AppConfig.getUserValEnc("dbPwd"));
		
	}
	
	@FXML
	private void probarConexion(ActionEvent event) {
		validar();
		
		Notifications notification = Notifications.create()
				.title("Probar conexión")
                .position(Pos.CENTER);
		
		if (valido) {
			if (probarConexion()) {
				notification.text("Conexión exitosa!!");
				notification.showInformation();
			} else {
				notification.text("No me puedo conectar a la BD");
				notification.showError();
			}
		} else {
			notification.text("Revisar que todos los campos esten definidos");
			notification.showError();
		}
		
		
	}
	
	private boolean probarConexion() {
		DBManager dbm = new DBManager(server.getText().trim(), dbname.getText().trim(), usr.getText().trim(), pwd.getText().trim());
		return dbm.test();
	}
	
	private void removeAllDecorations() {
		Decorator.removeAllDecorations(server);
		Decorator.removeAllDecorations(dbname);
		Decorator.removeAllDecorations(usr);
		Decorator.removeAllDecorations(pwd);
	}
	
	private void validar() {
		valido = true;
		removeAllDecorations();
		
		StyleClassDecoration decoration = new StyleClassDecoration("decoration-warning");
		
		if ("".equals(server.getText().trim())) {
			Decorator.addDecoration(server, decoration);
			valido = false;
		}
		
		if ("".equals(dbname.getText().trim())) {
			Decorator.addDecoration(dbname, decoration);
			valido = false;
		}
		
		if ("".equals(usr.getText().trim())) {
			Decorator.addDecoration(usr, decoration);
			valido = false;
		}
		
		if ("".equals(pwd.getText().trim())) {
			Decorator.addDecoration(pwd, decoration);
			valido = false;
		}
	}
	
	@FXML
	private void editar(ActionEvent event) {
		switchDisable(false);
	}
	
	@FXML
	private void guardar(ActionEvent event) {
		validar();
		
		Notifications notification = Notifications.create()
				.title("Guardar configuración")
                .position(Pos.CENTER);
		
		if (valido) {
			if (probarConexion()) {
				// Guardar
				AppConfig.setUserVal("dbServer", server.getText().trim());
				AppConfig.setUserVal("dbName", dbname.getText().trim());
				AppConfig.setUserVal("dbUsr", usr.getText().trim());
				AppConfig.setUserValEnc("dbPwd", pwd.getText().trim());
				
				// Desactivar controles
				switchDisable(true);
								
				notification.text("Configuración de Base de Datos guardada");
				notification.showInformation();
			} else {
				notification.text("No me puedo conectar a la BD");
				notification.showError();
			}
		} else {
			notification.text("Revisar que todos los campos esten definidos");
			notification.showError();
		}
		
		
		
	}
	
	@FXML
	private void cancelar(ActionEvent event) {
		removeAllDecorations();
		
		server.setText(AppConfig.getUserVal("dbServer"));
		dbname.setText(AppConfig.getUserVal("dbName"));
		usr.setText(AppConfig.getUserVal("dbUsr"));
		pwd.setText(AppConfig.getUserValEnc("dbPwd"));
		msg.setText("");
		
		switchDisable(true);
	}
	
	private void switchDisable(boolean disable) {
		server.setDisable(disable);
		dbname.setDisable(disable);
		usr.setDisable(disable);
		pwd.setDisable(disable);
		bProbar.setDisable(disable);
		bGuardar.setDisable(disable);
		bCancelar.setDisable(disable);
		bEditar.setDisable(!disable);
	}
}
