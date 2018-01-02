package com.canauhtli.cfdi.ui.controls;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canauhtli.cfdi.db.DBManager;
import com.canauhtli.cfdi.db.Factura;
import com.canauhtli.cfdi.tipo.Estatus;
import com.canauhtli.cfdi.ui.items.FacturaView;
import com.canauhtli.utils.JsonTools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class FacturasController extends AnchorPane {

	private static Logger log = LoggerFactory.getLogger(FacturasController.class);
	
	@FXML
	private Button bBuscar;
	
	@FXML
	private ToggleGroup filtro;
	
	@FXML
	private RadioButton rbCodigo;
	
	@FXML
	private RadioButton rbUuid;
	
	@FXML
	private RadioButton rbFecha;
	
	@FXML
	private RadioButton rbCliente;
	
	@FXML
	private TextField tCodigo;
	
	@FXML
	private TextField tUuid;

	@FXML
	private TextField tCliente;
	
	@FXML
	private DatePicker dFecha;
		
	@FXML
	private TableView<FacturaView> tvFacturas;
	
	@FXML
	private TableColumn<FacturaView, String> codigoCol = new TableColumn<FacturaView, String>();
	
	@FXML
	private TableColumn<FacturaView, String> rfcCol = new TableColumn<FacturaView, String>();
	
	@FXML
	private TableColumn<FacturaView, String> statusCol = new TableColumn<FacturaView, String>();
	
	@FXML
	private TableColumn<FacturaView, String> cfdiCol = new TableColumn<FacturaView, String>();
	
	@FXML
	private TableColumn<FacturaView, String> pdfCol = new TableColumn<FacturaView, String>();
	
	@FXML
	private TableColumn<FacturaView, String> correoCol = new TableColumn<FacturaView, String>();
	
	private DBManager dbm;
	
	public FacturasController(DBManager dbm) {
		this.dbm = dbm;
	}
	
	@FXML
	private void initialize() {
		codigoCol.setCellValueFactory(new PropertyValueFactory<FacturaView, String>("codigo"));
		rfcCol.setCellValueFactory(new PropertyValueFactory<FacturaView, String>("rfc"));
		statusCol.setCellValueFactory(new PropertyValueFactory<FacturaView, String>("status"));
		cfdiCol.setCellValueFactory(new PropertyValueFactory<FacturaView, String>("cfdi"));
		pdfCol.setCellValueFactory(new PropertyValueFactory<FacturaView, String>("pdf"));
		correoCol.setCellValueFactory(new PropertyValueFactory<FacturaView, String>("correo"));
	}
	
	@FXML
	private void buscaFacturas(ActionEvent ae) {
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		if (rbCodigo.isSelected()) {
			log.debug("Buscar facturas por codigo: {}", tCodigo.getText());
			facturas.addAll(dbm.obtenFacturaCodigo(tCodigo.getText().trim()));
		} else if (rbUuid.isSelected()) {
			log.debug("Buscar facturas por UUID: {}", tUuid.getText());
			facturas.add(dbm.obtenFacturaUuid(tUuid.getText().trim()));
		} else if (rbCliente.isSelected()) {
			log.debug("Buscar facturas por cliente: {}", tCliente.getText());
			facturas.addAll(dbm.obtenFacturaCliente(Long.parseLong(tCliente.getText().trim())));
		} else if (rbFecha.isSelected()) {
			log.debug("Buscar facturas por fecha: {}", dFecha.getEditor().getText());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			try {
				Date fechaIni = sdf.parse(dFecha.getEditor().getText().trim() + " 00:00:00");
				Date fechaFin = sdf.parse(dFecha.getEditor().getText().trim() + " 23:59:59");
				facturas.addAll(dbm.obtenFacturaFecha(fechaIni, fechaFin));
			} catch (ParseException e) {
				log.error("Formato de fecha incorrecto", e);
				// TODO mostrar mensaje en pantalla.
			}
		}
		
		ObservableList<FacturaView> lstFactVs = FXCollections.observableList(obtenFacturas(facturas));
		tvFacturas.setItems(lstFactVs);
	}
	
	private List<FacturaView> obtenFacturas(List<Factura> facturas) {
		ArrayList<FacturaView> lstFacs = new ArrayList<FacturaView>();
		try {
			JsonTools jtools = new JsonTools(com.canauhtli.cfdi.factura.Factura.class);
			for (Factura f : facturas) {
				com.canauhtli.cfdi.factura.Factura jFac = (com.canauhtli.cfdi.factura.Factura) jtools.fromJsonString(f.getFactura());
				
				FacturaView fv = new FacturaView();
				fv.setCodigo(f.getCodigo());
				fv.setRfc(jFac.getReceptor().getRfc());
				fv.setStatus(Estatus.fromEstatus(f.getEstatus()).name());
				if ((f.getUuid() != null) && (!"".equals(f.getUuid().trim()))) {
					fv.setCfdi(f.getUuid());
				}
				if (Estatus.ENVIADO.getEstatus() == f.getEstatus()) {
					fv.setCorreo(jFac.getExtras().getCorreo());
					fv.setPdf(f.getCodigo() + ".pdf");
				}
				if (Estatus.EMITIDO.getEstatus() == f.getEstatus()) {
					fv.setPdf(f.getCodigo() + ".pdf");
				}
				lstFacs.add(fv);
			}
		} catch (JAXBException e) {
			log.error("No pude interpretar correctamente un registro de factura", e);
		}
		
		return lstFacs;
	}
	
	public void setDBManager(DBManager dbm) {
		this.dbm = dbm;
	}
}
