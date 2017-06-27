package com.canauhtli.cfdi.ui.controls;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.canauhtli.cfdi.ui.items.ProveedorView;
import com.canauhtli.config.ConfigManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

public class ConfigProveedorController extends AnchorPane {

	@FXML
	private ComboBox<String> pac;
	
	@FXML
	private TableView<ProveedorView> tvPacProps;
	
	@FXML
	private TableColumn<ProveedorView, String> tcPropiedad = new TableColumn<ProveedorView, String>();
	
	@FXML
	private TableColumn<ProveedorView, String> tcValor = new TableColumn<ProveedorView, String>();
	
	@FXML
	private Button bEditar;
	
	@FXML
	private Button bGuardar;
	
	@FXML
	private Button bCancelar;
	
	private ConfigManager cm;
	
	public ConfigProveedorController(ConfigManager cm) {
		this.cm = cm;
	}
	
	@FXML
	protected void initialize() {
		tcPropiedad.setCellValueFactory(new PropertyValueFactory<ProveedorView, String>("campo"));
		tcValor.setCellValueFactory(new PropertyValueFactory<ProveedorView, String>("valor"));
		tcValor.setCellFactory(TextFieldTableCell.forTableColumn());
		
		ObservableList<String> lstProveedores =  FXCollections.observableArrayList(cm.listaProveedores());
		pac.setItems(lstProveedores);
		pac.setValue(cm.getProveedor());
		
		ObservableList<ProveedorView> config = FXCollections.observableList(listaConfigProv(cm.getProveedor()));
		tvPacProps.setItems(config);
	}
	
	@FXML
	private void cambiaPac(ActionEvent event) {
		ObservableList<ProveedorView> config = FXCollections.observableList(listaConfigProv(pac.getValue()));
		tvPacProps.setItems(config);
	}
	
	@FXML
	private void editar(ActionEvent event) {
		switchDisable(false);
	}
	
	@FXML
	private void editarValor(TableColumn.CellEditEvent<ProveedorView, String> event) {
		event.getRowValue().setValor(event.getNewValue());
	}
	
	@FXML
	private void cancelarValor(TableColumn.CellEditEvent<ProveedorView, String> event) {
		
	}
	
	@FXML
	private void guardar(ActionEvent event) {
		cm.setProveedor(pac.getValue());
		for (ProveedorView pv : tvPacProps.getItems()) {
			cm.setProveedorConfig(pv.getCampo(), pv.getValor());
		}
		cm.guardaProveedorConfig();
		
		switchDisable(true);
	}
	
	@FXML
	private void cancelar(ActionEvent event) {
		switchDisable(true);
		pac.setValue(cm.getProveedor());
		tvPacProps.setItems(FXCollections.observableList(listaConfigProv(cm.getProveedor())));
	}
	
	@FXML
	private void validar(ActionEvent event) {
		System.out.println("Validar...");
	}
	
	private List<ProveedorView> listaConfigProv(String proveedor) {
		Map<String, String> provConfig = cm.getProveedorConfig(proveedor);
		List<ProveedorView> lstConfig = new ArrayList<ProveedorView>();
		for (String k : provConfig.keySet()) {
			ProveedorView pv = new ProveedorView();
			pv.setCampo(k);
			pv.setValor(provConfig.get(k));
			lstConfig.add(pv);
		}
		return lstConfig;
	}
	
	private void switchDisable(boolean disable) {
		pac.setDisable(disable);
		tvPacProps.setDisable(disable);
		bEditar.setDisable(!disable);
		bGuardar.setDisable(disable);
		bCancelar.setDisable(disable);
	}
}
