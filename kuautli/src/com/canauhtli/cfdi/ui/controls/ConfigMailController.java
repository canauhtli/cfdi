package com.canauhtli.cfdi.ui.controls;

import java.util.function.UnaryOperator;

import org.controlsfx.control.Notifications;
import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.control.decoration.StyleClassDecoration;

import com.canauhtli.config.ConfigManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.AnchorPane;

public class ConfigMailController extends AnchorPane {

	@FXML
	private TextField servidor;
	
	@FXML
	private TextField puerto;
	
	@FXML
	private TextField remitente;
	
	@FXML
	private TextField asunto;
	
	@FXML
	private TextField usr;
	
	@FXML
	private TextArea mensaje;
	
	@FXML
	private ToggleSwitch tsCorreo;
	
	@FXML
	private ToggleSwitch tsAutenticar;
	
	@FXML
	private PasswordField pwd;
	
	@FXML
	private Button bEditar;
	
	@FXML
	private Button bCancelar;
	
	@FXML
	private Button bGuardar;
	
	private ConfigManager cm;
	private boolean valido;
	
	public ConfigMailController(ConfigManager cm) {
		this.cm = cm;
	}
	
	@FXML
	protected void initialize() {
		servidor.setText(cm.getMailConfig("server"));
		puerto.setText(cm.getMailConfig("puerto"));
		remitente.setText(cm.getMailConfig("remitente"));
		asunto.setText(cm.getMailConfig("asunto"));
		usr.setText(cm.getMailConfig("usr"));
		mensaje.setText(cm.getMailConfig("mensaje"));
		pwd.setText(cm.getMailConfig("pwd"));
		tsCorreo.setSelected("1".equals(cm.getMailConfig("enviarCorreo")));
		tsAutenticar.setSelected("1".equals(cm.getMailConfig("autenticar")));
		
		UnaryOperator<Change> filter = change -> {
			String text = change.getText();
			if (text.matches("[0-9]*")) {
				return change;
			}
			return null;
		};
		TextFormatter<String> puertoFormatter = new TextFormatter<>(filter);
		puerto.setTextFormatter(puertoFormatter);
	}
	
	@FXML
	private void editar(ActionEvent event) {
		switchDisable(false);
	}
	
	@FXML
	private void guardar(ActionEvent event) {
		validar();
		
		Notifications notification = Notifications.create()
				.title("Configuración correo")
                .position(Pos.CENTER);
		
		if (valido) {
			switchDisable(true);
			removeDecorations();
			
			cm.setMailConfig("server", servidor.getText().trim());
			cm.setMailConfig("puerto", puerto.getText().trim());
			cm.setMailConfig("remitente", remitente.getText().trim());
			cm.setMailConfig("asunto", asunto.getText().trim());
			cm.setMailConfig("usr", usr.getText().trim());
			cm.setMailConfig("mensaje", mensaje.getText());
			cm.setMailConfig("pwd", pwd.getText());
			cm.setMailConfig("enviarCorreo", tsCorreo.isSelected() ? "1" : "0");
			cm.setMailConfig("autenticar", tsAutenticar.isSelected() ? "1" : "0");
			cm.guardaMailConfig();
			
			notification.text("Configuración de correo guardada");
			notification.showInformation();
		} else {
			notification.text("Revisar que todos los campos esten definidos");
			notification.showError();
		}
	}
	
	@FXML
	private void cancelar(ActionEvent event) {
		initialize();
		switchDisable(true);
		removeDecorations();
	}
	
	private void validar() {
		valido = true;
		removeDecorations();
		
		StyleClassDecoration decoration = new StyleClassDecoration("decoration-warning");
	
		if (tsCorreo.isSelected()) {
			if ("".equals(servidor.getText().trim())) {
				Decorator.addDecoration(servidor, decoration);
				valido = false;
			}
			
			if ("".equals(puerto.getText().trim())) {
				Decorator.addDecoration(puerto, decoration);
				valido = false;
			}
			
			if ("".equals(remitente.getText().trim())) {
				Decorator.addDecoration(remitente, decoration);
				valido = false;
			}
			
			if ("".equals(asunto.getText().trim())) {
				Decorator.addDecoration(asunto, decoration);
				valido = false;
			}
			
			if ("".equals(mensaje.getText().trim())) {
				Decorator.addDecoration(mensaje, decoration);
				valido = false;
			}
			
			if (tsAutenticar.isSelected()) {
				if ("".equals(usr.getText().trim())) {
					Decorator.addDecoration(usr, decoration);
					valido = false;
				}
				
				if ("".equals(pwd.getText().trim())) {
					Decorator.addDecoration(pwd, decoration);
					valido = false;
				}
			}
		}
	}
	
	private void switchDisable(boolean disable) {
		servidor.setDisable(disable);
		puerto.setDisable(disable);
		remitente.setDisable(disable);
		asunto.setDisable(disable);
		mensaje.setDisable(disable);
		usr.setDisable(disable);
		pwd.setDisable(disable);
		tsCorreo.setDisable(disable);
		tsAutenticar.setDisable(disable);
		bEditar.setDefaultButton(!disable);
		bGuardar.setDisable(disable);
		bCancelar.setDisable(disable);
	}
	
	private void removeDecorations() {
		Decorator.removeAllDecorations(servidor);
		Decorator.removeAllDecorations(puerto);
		Decorator.removeAllDecorations(remitente);
		Decorator.removeAllDecorations(asunto);
		Decorator.removeAllDecorations(mensaje);
		Decorator.removeAllDecorations(usr);
		Decorator.removeAllDecorations(pwd);
	}
}
