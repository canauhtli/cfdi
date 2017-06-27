package com.canauhtli.cfdi.ui.controls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

import com.canauhtli.cfdi.db.DBManager;
import com.canauhtli.cfdi.db.Periodo;
import com.canauhtli.cfdi.db.ReciboNomina;
import com.canauhtli.cfdi.nomina.ReciboNominaEmp;
import com.canauhtli.cfdi.tipo.Estatus;
import com.canauhtli.cfdi.ui.items.EmpleadoView;
import com.canauhtli.utils.JsonTools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ListadoPeriodoController extends AnchorPane {
	
	private static Logger log = LoggerFactory.getLogger(ListadoPeriodoController.class);

	@FXML
	private Button buscar;
	
	@FXML
	private TextField periodo;
	
	@FXML
	private Label msg;
	
	@FXML
	private TableView<EmpleadoView> tvEmps;
	
	@FXML
	private TableColumn<EmpleadoView, Integer> empCol = new TableColumn<EmpleadoView, Integer>();
	
	@FXML
	private TableColumn<EmpleadoView, String> nombreCol= new TableColumn<EmpleadoView, String>();
	
	@FXML
	private TableColumn<EmpleadoView, String> statusCol = new TableColumn<EmpleadoView, String>();
	
	@FXML
	private TableColumn<EmpleadoView, String> cfdiCol = new TableColumn<EmpleadoView, String>();
	
	@FXML
	private TableColumn<EmpleadoView, String> pdfCol = new TableColumn<EmpleadoView, String>();
	
	@FXML
	private TableColumn<EmpleadoView, String> correoCol = new TableColumn<EmpleadoView, String>();
	
	
	private DBManager dbm;
	
	public ListadoPeriodoController(DBManager dbm) {
		this.dbm = dbm;
	}
	
	@FXML
	private void initialize() {
		empCol.setCellValueFactory(new PropertyValueFactory<EmpleadoView, Integer>("numEmp"));
		nombreCol.setCellValueFactory(new PropertyValueFactory<EmpleadoView, String>("nombre"));
		statusCol.setCellValueFactory(new PropertyValueFactory<EmpleadoView, String>("status"));
		cfdiCol.setCellValueFactory(new PropertyValueFactory<EmpleadoView, String>("cfdi"));
		pdfCol.setCellValueFactory(new PropertyValueFactory<EmpleadoView, String>("pdf"));
		correoCol.setCellValueFactory(new PropertyValueFactory<EmpleadoView, String>("correo"));
	}
	
	@FXML
	private void buscarPeriodo(ActionEvent event) {
		log.debug("Buscando registros del periodo {}", periodo.getText());
		if (!"".equals(periodo.getText().trim())) {
			Periodo p = dbm.buscaPeriodoActivo(periodo.getText().trim().toUpperCase());
			if (p != null) {
				log.debug("El periodo {} corresponde al id {}", periodo.getText(), p.getId());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date fc = new Date(p.getFechaCreacion().getTime());
				msg.setText("Listando recibos del periodo " + p.getPeriodo() + " cargado el " + sdf.format(fc));
				
				ObservableList<EmpleadoView> lstEmps = FXCollections.observableList(obtenListaEmps(p.getId()));
				tvEmps.setItems(lstEmps);
			} else {
				msg.setText("No existe un proceso de nómina en el periodo " + periodo.getText());
			}
		}
		periodo.setText("");
	}
	
	private List<EmpleadoView> obtenListaEmps(int idPeriodo) {
		ArrayList<EmpleadoView> listaEmps = new ArrayList<EmpleadoView>();
		List<ReciboNomina> lstRn = dbm.obtenRecibosPeriodo(idPeriodo);
		try {
			JsonTools jtools = new JsonTools(ReciboNominaEmp.class);
			for (ReciboNomina rn : lstRn) {
				ReciboNominaEmp rne = (ReciboNominaEmp) jtools.fromJsonString(rn.getRecibo());
				EmpleadoView ev = new EmpleadoView();
				ev.setNumEmp(rne.getEmpleado().getNumEmp());
				ev.setNombre(rne.getReceptor().getNombre());
				ev.setStatus(Estatus.fromEstatus(rn.getEstatus()).name());
				if ((rn.getUuid() != null) && (!"".equals(rn.getUuid()))) {
					ev.setCfdi(rn.getUuid());
				}
				if (Estatus.ENVIADO.getEstatus() == rn.getEstatus()) {
					ev.setCorreo(rne.getEmpleado().getCorreo());
				}
				if ((Estatus.ENVIADO.getEstatus() == rn.getEstatus()) || (Estatus.EMITIDO.getEstatus() == rn.getEstatus())) {
					ev.setPdf(rne.getEmpleado().getNumEmp() + ".pdf");
				}
				
				listaEmps.add(ev);
			}
		} catch (JAXBException e) {
			log.error("No pude interpretar correctamente un registro del periodo {}", idPeriodo);
		}
		
		return listaEmps;
	}
	
	public void setDBManager(DBManager dbm) {
		this.dbm = dbm;
	}
}
