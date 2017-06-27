package com.canauhtli.cfdi.ui.controls;

import org.controlsfx.control.Notifications;
import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.control.decoration.StyleClassDecoration;

import com.canauhtli.config.ConfigManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ConfigEmisorController extends AnchorPane {

	private ConfigManager cm;
	
	@FXML
	private Button bEditar;
	
	@FXML
	private Button bGuardar;
	
	@FXML
	private Button bCancelar;
	
	@FXML
	private TextField razonSocial;
	
	@FXML
	private TextField rfc;
	
	@FXML
	private TextField registroPatronal;
	
	@FXML
	private TextField regimenFiscal;
	
	@FXML
	private TextField calle;
	
	@FXML
	private TextField numExt;
	
	@FXML
	private TextField numInt;
	
	@FXML
	private TextField colonia;
	
	@FXML
	private TextField municipio;
	
	@FXML
	private TextField cp;
	
	@FXML
	private TextField ciudad;
	
	@FXML
	private TextField estado;
	
	@FXML
	private TextField pais;
	
	private boolean valido;
	
	public ConfigEmisorController(ConfigManager cm) {
		this.cm = cm;
	}
	
	@FXML
	protected void initialize() {
		razonSocial.setText(cm.getEmisorConfig("razonSocial"));
		rfc.setText(cm.getEmisorConfig("rfc"));
		registroPatronal.setText(cm.getEmisorConfig("registroPatronal"));
		regimenFiscal.setText(cm.getEmisorConfig("regimenFiscal"));
		calle.setText(cm.getEmisorConfig("calle"));
		numExt.setText(cm.getEmisorConfig("numeroExterior"));
		numInt.setText(cm.getEmisorConfig("numeroInterior"));
		colonia.setText(cm.getEmisorConfig("colonia"));
		municipio.setText(cm.getEmisorConfig("municipio"));
		cp.setText(cm.getEmisorConfig("cp"));
		ciudad.setText(cm.getEmisorConfig("ciudad"));
		estado.setText(cm.getEmisorConfig("estado"));
		pais.setText(cm.getEmisorConfig("pais"));
	}
	
	@FXML
	private void editar(ActionEvent event) {
		switchDisable(false);
	}
	
	@FXML
	private void guardar(ActionEvent event) {
		valida();
		
		Notifications notification = Notifications.create()
				.title("Configuración general")
                .position(Pos.CENTER);
		if (valido) {
			cm.setEmisorConfig("razonSocial", razonSocial.getText().trim());
			cm.setEmisorConfig("rfc", rfc.getText().trim());
			cm.setEmisorConfig("registroPatronal", registroPatronal.getText().trim());
			cm.setEmisorConfig("regimenFiscal", regimenFiscal.getText().trim());
			cm.setEmisorConfig("calle", calle.getText().trim());
			cm.setEmisorConfig("numeroExterior", numExt.getText().trim());
			cm.setEmisorConfig("numeroInterior", numInt.getText().trim());
			cm.setEmisorConfig("colonia", colonia.getText().trim());
			cm.setEmisorConfig("municipio", municipio.getText().trim());
			cm.setEmisorConfig("cp", cp.getText().trim());
			cm.setEmisorConfig("ciudad", ciudad.getText().trim());
			cm.setEmisorConfig("estado", estado.getText().trim());
			cm.setEmisorConfig("pais", pais.getText().trim());
			cm.guardaEmisorConfig();
			
			switchDisable(true);
			removeDecorations();
			
			notification.text("Configuración general guardada");
			notification.showInformation();
		} else {
			notification.text("Revisar que todos los campos requeridos esten definidos");
			notification.showError();
		}
	}
	
	@FXML
	private void cancelar(ActionEvent event) {
		switchDisable(true);
		removeDecorations();
		razonSocial.setText(cm.getEmisorConfig("razonSocial"));
		rfc.setText(cm.getEmisorConfig("rfc"));
		registroPatronal.setText(cm.getEmisorConfig("registroPatronal"));
		regimenFiscal.setText(cm.getEmisorConfig("regimenFiscal"));
		calle.setText(cm.getEmisorConfig("calle"));
		numExt.setText(cm.getEmisorConfig("numeroExterior"));
		numInt.setText(cm.getEmisorConfig("numeroInterior"));
		colonia.setText(cm.getEmisorConfig("colonia"));
		municipio.setText(cm.getEmisorConfig("municipio"));
		cp.setText(cm.getEmisorConfig("cp"));
		ciudad.setText(cm.getEmisorConfig("ciudad"));
		estado.setText(cm.getEmisorConfig("estado"));
		pais.setText(cm.getEmisorConfig("pais"));
	}
	
	private void switchDisable(boolean disable) {
		razonSocial.setDisable(disable);
		rfc.setDisable(disable);
		registroPatronal.setDisable(disable);
		regimenFiscal.setDisable(disable);
		calle.setDisable(disable);
		numExt.setDisable(disable);
		numInt.setDisable(disable);
		colonia.setDisable(disable);
		municipio.setDisable(disable);
		cp.setDisable(disable);
		ciudad.setDisable(disable);
		estado.setDisable(disable);
		pais.setDisable(disable);
		bCancelar.setDisable(disable);
		bGuardar.setDisable(disable);
		bEditar.setDisable(!disable);
	}
	
	private void valida() {
		valido = true;
		removeDecorations();
		
		StyleClassDecoration decoration = new StyleClassDecoration("decoration-warning");
		
		if ("".equals(razonSocial.getText().trim())) {
			Decorator.addDecoration(razonSocial, decoration);
			valido = false;
		}
		
		if ("".equals(rfc.getText().trim())) {
			Decorator.addDecoration(rfc, decoration);
			valido = false;
		}
		
		if ("".equals(registroPatronal.getText().trim())) {
			Decorator.addDecoration(registroPatronal, decoration);
			valido = false;
		}
		
		if ("".equals(regimenFiscal.getText().trim())) {
			Decorator.addDecoration(regimenFiscal, decoration);
			valido = false;
		}
		
		if ("".equals(calle.getText().trim())) {
			Decorator.addDecoration(calle, decoration);
			valido = false;
		}
		
		if ("".equals(numExt.getText().trim())) {
			Decorator.addDecoration(numExt, decoration);
			valido = false;
		}
		
		if ("".equals(colonia.getText().trim())) {
			Decorator.addDecoration(colonia, decoration);
			valido = false;
		}
		
		if ("".equals(municipio.getText().trim())) {
			Decorator.addDecoration(municipio, decoration);
			valido = false;
		}
		
		if ("".equals(cp.getText().trim())) {
			Decorator.addDecoration(cp, decoration);
			valido = false;
		}
		
		if ("".equals(estado.getText().trim())) {
			Decorator.addDecoration(estado, decoration);
			valido = false;
		}
		
		if ("".equals(pais.getText().trim())) {
			Decorator.addDecoration(pais, decoration);
			valido = false;
		}
	}
	
	private void removeDecorations() {
		Decorator.removeAllDecorations(razonSocial);
		Decorator.removeAllDecorations(rfc);
		Decorator.removeAllDecorations(registroPatronal);
		Decorator.removeAllDecorations(regimenFiscal);
		Decorator.removeAllDecorations(calle);
		Decorator.removeAllDecorations(numExt);
		Decorator.removeAllDecorations(colonia);
		Decorator.removeAllDecorations(municipio);
		Decorator.removeAllDecorations(cp);
		Decorator.removeAllDecorations(estado);
		Decorator.removeAllDecorations(pais);
	}
	
}
