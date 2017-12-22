package com.canauhtli.cfdi.ui.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.cfdi.Recolector;
import com.canauhtli.cfdi.db.Concepto;
import com.canauhtli.cfdi.db.Factura;
import com.canauhtli.cfdi.db.RecibidasDAO;
import com.canauhtli.cfdi.ui.item.ConceptoView;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

public class Recibidas extends AnchorPane implements Initializable {

	private static Logger log = LoggerFactory.getLogger(Recibidas.class);
	
	@FXML private SplitPane spRecibidas;
	@FXML private AnchorPane apIzq;
	@FXML private ToolBar tbAcciones;
	
	@FXML private Button btHist;
	@FXML private Button btRefresh;
	@FXML private Button btGuardar;
	@FXML private DatePicker dpFecha;
	
	@FXML private TextField tfArchivo;
	@FXML private TextField tfSerie;
	@FXML private TextField tfFolio;
	@FXML private TextField tfFecha;
	@FXML private TextField tfUuid;
	@FXML private TextField tfPedido;
	
	@FXML private ListView<Factura> lvFacturas = new ListView<>();
	
	@FXML private TableView<ConceptoView> tvConceptos;
	@FXML private TableColumn<ConceptoView, String> tcCveSat = new TableColumn<ConceptoView, String>();
	@FXML private TableColumn<ConceptoView, String> tcCodigo = new TableColumn<ConceptoView, String>();
	@FXML private TableColumn<ConceptoView, String> tcCantidad = new TableColumn<ConceptoView, String>();
	@FXML private TableColumn<ConceptoView, String> tcCveUnidad = new TableColumn<ConceptoView, String>();
	@FXML private TableColumn<ConceptoView, String> tcUnidad = new TableColumn<ConceptoView, String>();
	@FXML private TableColumn<ConceptoView, String> tcDescripcion = new TableColumn<ConceptoView, String>();
	@FXML private TableColumn<ConceptoView, String> tcPrecio = new TableColumn<ConceptoView, String>();
	
	private RecibidasDAO dao = RecibidasDAO.getInstance();
	private Recolector recolector = Recolector.getInstance();
	private Factura facturaActual;
	
	@FXML
	private void recargaArchivos(ActionEvent event) {
		
		recolector.leeArchivos();
		
		List<Factura> pendientes = dao.buscaPendientes();
		cambiaContenido(pendientes);
	}
	
	@FXML
	private void guardar(ActionEvent event) {
		if (!"".equals(tfPedido.getText().trim()) && (facturaActual != null) &&
				!tfPedido.getText().trim().equals(facturaActual.getNumeroPedido())) {
			facturaActual.setNumeroPedido(tfPedido.getText().trim());
			dao.actualizaFactura(facturaActual);
			lvFacturas.refresh();
		}
	}
	
	@FXML
	private void cargarHistorico(ActionEvent event) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			Date fechaIni = sdf.parse(dpFecha.getEditor().getText() + " 00:00:00");
			Date fechaFin = sdf.parse(dpFecha.getEditor().getText() + " 23:59:59");
			List<Factura> facturas = dao.buscaPorFecha(fechaIni, fechaFin);
			lvFacturas.getItems().removeAll(lvFacturas.getItems());
			lvFacturas.setItems(FXCollections.observableArrayList(facturas));
			lvFacturas.refresh();
			
			cambiaContenido(facturas);
		} catch (ParseException e) {
			log.error("Fecha incorrecta {}", dpFecha.getEditor().getText(), e);
		}
	}
	
	private void cambiaContenido(List<Factura> facturas) {
		lvFacturas.getItems().removeAll(lvFacturas.getItems());
		lvFacturas.setItems(FXCollections.observableArrayList(facturas));
		lvFacturas.refresh();
		
		tfArchivo.setText("");
		tfSerie.setText("");
		tfFolio.setText("");
		tfFecha.setText("");
		tfUuid.setText("");
		tfPedido.setText("");
		tvConceptos.getItems().clear();
		tvConceptos.refresh();
	}
	
	@FXML
	private void mostrarFactura(MouseEvent event) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		facturaActual = lvFacturas.getSelectionModel().getSelectedItem();
		if (facturaActual != null) {
			tfArchivo.setText(facturaActual.getArchivo());
			tfSerie.setText(facturaActual.getSerie());
			tfFolio.setText(""+facturaActual.getFolio());
			tfFecha.setText(sdf.format(new Date(facturaActual.getFecha().getTime())));
			tfUuid.setText(facturaActual.getUuid());
			tfPedido.setText(facturaActual.getNumeroPedido());
		
			tvConceptos.getItems().removeAll(tvConceptos.getItems());
			DecimalFormat df = new DecimalFormat("#,##0.00");
			List<Concepto> conceptos = dao.listaConceptos(facturaActual.getIdFactura());
			for (Concepto c : conceptos) {
				ConceptoView cv = new ConceptoView();
				cv.setCantidad(""+c.getCantidad());
				cv.setCodigo(c.getNumIdentificacion());
				cv.setCveSat(c.getClaveProdServ());
				cv.setCveUnidad(c.getClaveUnidad());
				cv.setDescripcion(c.getDescripcion());
				cv.setPrecio(df.format(c.getValorUnitario().doubleValue()));
				cv.setUnidad(c.getUnidad());
				tvConceptos.getItems().add(cv);
			}
			tvConceptos.refresh();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		tbAcciones.prefWidthProperty().bind(apIzq.widthProperty());
		if (!dao.isConectado()) {
			spRecibidas.setDisable(true);
		}
		
		dpFecha.setConverter(new StringConverter<LocalDate>() {
			 String pattern = "dd/MM/yyyy";
			 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			 {
			     dpFecha.setPromptText(pattern.toLowerCase());
			 }

			 @Override public String toString(LocalDate date) {
			     if (date != null) {
			         return dateFormatter.format(date);
			     } else {
			         return "";
			     }
			 }

			 @Override public LocalDate fromString(String string) {
			     if (string != null && !string.isEmpty()) {
			         return LocalDate.parse(string, dateFormatter);
			     } else {
			         return null;
			     }
			 }
			});
		
		tcCveSat.setCellValueFactory(new PropertyValueFactory<ConceptoView, String>("cveSat"));
		tcCodigo.setCellValueFactory(new PropertyValueFactory<ConceptoView, String>("codigo"));
		tcCantidad.setCellValueFactory(new PropertyValueFactory<ConceptoView, String>("cantidad"));
		tcCveUnidad.setCellValueFactory(new PropertyValueFactory<ConceptoView, String>("cveUnidad"));
		tcUnidad.setCellValueFactory(new PropertyValueFactory<ConceptoView, String>("unidad"));
		tcDescripcion.setCellValueFactory(new PropertyValueFactory<ConceptoView, String>("descripcion"));
		tcPrecio.setCellValueFactory(new PropertyValueFactory<ConceptoView, String>("precio"));
		
		recolector.leeArchivos();
		List<Factura> pendientes = dao.buscaPendientes();
		cambiaContenido(pendientes);
	}
	
	public void habilidar() {
		spRecibidas.setDisable(false);
	}
}
