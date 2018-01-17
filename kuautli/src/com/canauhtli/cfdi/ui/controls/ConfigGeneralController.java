package com.canauhtli.cfdi.ui.controls;

import java.io.File;
import java.util.function.UnaryOperator;

import org.controlsfx.control.Notifications;
import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.control.decoration.StyleClassDecoration;

import com.canauhtli.config.ConfigManager;
import com.canauhtli.utils.PrintManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class ConfigGeneralController extends AnchorPane {

	@FXML
	private TextField carpetaSalida;
	
	@FXML
	private TextField plantilla;
	
	@FXML
	private TextField logo;
	
	@FXML
	private TextField iva;
	
	@FXML
	private TextField numCopias;
	
	@FXML
	private Button bCarpetaSalida;
	
	@FXML
	private Button bPlantilla;
	
	@FXML
	private Button bLogo;
	
	@FXML
	private Button bEditar;
	
	@FXML
	private Button bGuardar;
	
	@FXML
	private Button bCancelar;
	
	@FXML
	private ToggleSwitch tsPdf;
	
	@FXML
	private ToggleSwitch tsImprimir;
	
	@FXML
	private ComboBox<String> impresora;
	
	private ConfigManager cm;
	private boolean valido;
	
	public ConfigGeneralController(ConfigManager cm) {
		this.cm = cm;
	}
	
	@FXML
	protected void initialize() {
		carpetaSalida.setText(cm.getGeneralConfig("carpetaSalida"));
		plantilla.setText(cm.getGeneralConfig("plantilla"));
		logo.setText(cm.getGeneralConfig("logo"));
		iva.setText(cm.getGeneralConfig("iva"));
		numCopias.setText(cm.getGeneralConfig("copias"));
		tsPdf.setSelected("1".equals(cm.getGeneralConfig("generarPdf")));
		tsImprimir.setSelected("1".equals(cm.getGeneralConfig("imprimir")));
		
		ObservableList<String> impresoras = FXCollections.observableArrayList(PrintManager.listaImpresoras()); 
		impresora.setItems(impresoras); 
		for (String imp : impresoras) {
			if (imp.equalsIgnoreCase(cm.getGeneralConfig("impresora"))) {
				impresora.setValue(imp);
			}
		}
		
		
		UnaryOperator<Change> filter = change -> {
			String text = change.getText();
			if (text.matches("[0-9]*")) {
				return change;
			}
			return null;
		};
		TextFormatter<String> ivaFormatter = new TextFormatter<>(filter);
		iva.setTextFormatter(ivaFormatter);
		
		TextFormatter<String> copiasFormatter = new TextFormatter<>(filter);
		numCopias.setTextFormatter(copiasFormatter);
	}
	
	@FXML
	private void buscarCarpetaSalida(ActionEvent event) {
		
		DirectoryChooser dc = new DirectoryChooser();
		File dir = dc.showDialog(null);
		if (dir != null) {
			carpetaSalida.setText(dir.getAbsolutePath());
		}
	}
	
	@FXML
	private void buscarPlantilla(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.setTitle("Buscar plantilla...");
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("jasper", "*.jasper"));
		File pFile = fc.showOpenDialog(null);
		if (pFile != null) {
			plantilla.setText(pFile.getAbsolutePath());
		}
	}
	
	@FXML
	private void buscarLogo(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.setTitle("Buscar logo...");
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("jpg", "*.jpg"),
				new FileChooser.ExtensionFilter("png", "*.png")
				);
		File lFile = fc.showOpenDialog(null);
		if (lFile != null) {
			logo.setText(lFile.getAbsolutePath());
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
				.title("Configuración general")
                .position(Pos.CENTER);
		
		if (valido) {
			switchDisable(true);
			removeDecorations();
			
			cm.setGeneralConfig("carpetaSalida", carpetaSalida.getText());
			cm.setGeneralConfig("plantilla", plantilla.getText());
			cm.setGeneralConfig("logo", logo.getText());
			cm.setGeneralConfig("iva", iva.getText().trim());
			cm.setGeneralConfig("copias", numCopias.getText().trim());
			cm.setGeneralConfig("generarPdf", tsPdf.isSelected() ? "1" : "0");
			cm.setGeneralConfig("imprimir", tsImprimir.isSelected() ? "1" : "0");
			cm.setGeneralConfig("impresora", impresora.getValue());
			cm.guardaGeneralConfig();
			notification.text("Configuración general guardada");
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
		
		if ("".equals(carpetaSalida.getText().trim())) {
			Decorator.addDecoration(carpetaSalida, decoration);
			valido = false;
		}
		
		if ("".equals(plantilla.getText().trim())) {
			Decorator.addDecoration(plantilla, decoration);
			valido = false;
		}
		
		if ("".equals(logo.getText().trim())) {
			Decorator.addDecoration(logo, decoration);
			valido = false;
		}
		
		if ("".equals(iva.getText().trim())) {
			Decorator.addDecoration(iva, decoration);
			valido = false;
		}
		
		if (tsImprimir.isSelected()) {
			if ("".equals(numCopias.getText().trim())) {
				Decorator.addDecoration(numCopias, decoration);
				valido = false;
			}
			
			if ((impresora.getValue() == null) || "".equals(impresora.getValue())) {
				Decorator.addDecoration(impresora, decoration);
				valido = false;
			}
		}
		
	}
	
	private void switchDisable(boolean disable) {
		carpetaSalida.setDisable(disable);
		plantilla.setDisable(disable);
		logo.setDisable(disable);
		iva.setDisable(disable);
		numCopias.setDisable(disable);
		bCarpetaSalida.setDisable(disable);
		bPlantilla.setDisable(disable);
		bLogo.setDisable(disable);
		bEditar.setDisable(!disable);
		bGuardar.setDisable(disable);
		bCancelar.setDisable(disable);
		tsPdf.setDisable(disable);
		tsImprimir.setDisable(disable);
		impresora.setDisable(disable);
	}
	
	private void removeDecorations() {
		Decorator.removeAllDecorations(carpetaSalida);
		Decorator.removeAllDecorations(plantilla);
		Decorator.removeAllDecorations(logo);
		Decorator.removeAllDecorations(iva);
		Decorator.removeAllDecorations(numCopias);
		Decorator.removeAllDecorations(impresora);
	}
}
