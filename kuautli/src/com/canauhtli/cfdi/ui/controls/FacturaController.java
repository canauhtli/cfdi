package com.canauhtli.cfdi.ui.controls;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Base64;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.controlsfx.control.Notifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.html.HTMLPreElement;
import org.xml.sax.InputSource;

import com.canauhtli.cfdi.CFDIException;
import com.canauhtli.cfdi.db.DBManager;
import com.canauhtli.cfdi.db.Factura;
import com.canauhtli.cfdi.factura.Comentario;
import com.canauhtli.cfdi.factura.ConceptoFac;
import com.canauhtli.cfdi.factura.DocumentoRelacionado;
import com.canauhtli.cfdi.factura.FacturaCorreo;
import com.canauhtli.cfdi.factura.ImpuestoConceptoFac;
import com.canauhtli.cfdi.factura.Observacion;
import com.canauhtli.cfdi.factura.Pago;
import com.canauhtli.cfdi.sat.cfd33.Comprobante;
import com.canauhtli.cfdi.tipo.Estatus;
import com.canauhtli.config.ConfigManager;
import com.canauhtli.utils.ClienteSMTP;
import com.canauhtli.utils.JsonTools;
import com.canauhtli.utils.XMLParser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class FacturaController extends AnchorPane {

	private static Logger log = LoggerFactory.getLogger(FacturaController.class);
	
	@FXML private TextField tfFactura;
	@FXML private TextField tfCodigo;
	@FXML private TextField tfEstatus;
	@FXML private TextField tfNumCliente;
	@FXML private TextField tfCliente;
	@FXML private TextField tfUuid;
	
	@FXML private Button btTxt;
	@FXML private Button btPdf;
	@FXML private Button btXml;
	@FXML private Button btMail;
	
	@FXML private WebView wvTxt;
	@FXML private WebView wvPdf;
	@FXML private WebView wvXml;
	@FXML private Pane pTxt;
	@FXML private Pane pPdf;
	@FXML private Pane pXml;
	
	private DBManager dbm;
	private ConfigManager cm;
	private long idFactura;
	private Factura factura;
	private com.canauhtli.cfdi.factura.Factura facturaBase;
	private WebEngine engineTxt;
	private WebEngine enginePdf;
	private WebEngine engineXml;
	
	public FacturaController(DBManager dbm, ConfigManager cm) {
		this.dbm = dbm;
		this.cm = cm;
	}
	
	@FXML
	private void initialize() {
		engineTxt = wvTxt.getEngine();
		enginePdf = wvPdf.getEngine();
		engineXml = wvXml.getEngine();
		
	}
	
	@FXML
	private void muestraTexto(ActionEvent ae) {
		pTxt.toFront();
	}
	
	@FXML
	private void muestraPdf(ActionEvent ae) {
		pPdf.toFront();
	}
	
	@FXML
	private void muestraXml(ActionEvent ae) {
		pXml.toFront();
		
	}
	
	@FXML
	private void enviarCorreo(ActionEvent ae) {
		ClienteSMTP smtp = new ClienteSMTP(cm);
		FacturaCorreo fc = new FacturaCorreo();
		fc.setCorreo(facturaBase.getExtras().getCorreo());
		fc.setMsg(cm.getMailConfig("mensaje"));
		fc.setNombre(facturaBase.getReceptor().getRazonSocial());
		fc.setNumCliente(""+facturaBase.getReceptor().getNumCliente());
		fc.setPathPdf(cm.getGeneralConfig("carpetaSalida") + "/" + facturaBase.getNombreArchivo() + ".pdf");
		fc.setFactura(factura.getCodigo());
		fc.setXml(factura.getComprobanteFiscal());
		smtp.enviaFactura(fc);
		
		Notifications notification = Notifications.create()
				.title("Envio de Factura")
                .position(Pos.CENTER);
		if (fc.isEnviado()) {
			notification.text("Factura enviada a: " + facturaBase.getExtras().getCorreo());
			notification.showInformation();
		} else {
			notification.text("No fue posible enviar la factura");
			notification.showError();
		}
	}
	
	private static void enableFirebug(final WebEngine engine) {
	    engine.executeScript("if (!document.getElementById('FirebugLite')){E = document['createElement' + 'NS'] && document.documentElement.namespaceURI;E = E ? document['createElement' + 'NS'](E, 'script') : document['createElement']('script');E['setAttribute']('id', 'FirebugLite');E['setAttribute']('src', 'https://getfirebug.com/' + 'firebug-lite.js' + '#startOpened');E['setAttribute']('FirebugLite', '4');(document['getElementsByTagName']('head')[0] || document['getElementsByTagName']('body')[0]).appendChild(E);E = new Image;E['setAttribute']('src', 'https://getfirebug.com/' + '#startOpened');}"); 
	}
	
	
	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}
	
	public void cargaFactura() {
		factura = dbm.obtenFactura(idFactura);
		facturaBase = decodificaFactura(factura.getFactura());
		
		if ((factura.getComprobanteFiscal() != null) && (!"".equals(factura.getComprobanteFiscal().trim()))) {
			try {
				Comprobante cfdi = XMLParser.parseCfdi(factura.getComprobanteFiscal());
				facturaBase.setCfdi(cfdi);
			} catch (CFDIException e) {
				log.error("No pude interpretar correctamente el XML", e);
			}
		}
		
		tfCliente.setText(facturaBase.getReceptor().getRazonSocial());
		tfCodigo.setText(factura.getCodigo());
		tfEstatus.setText(Estatus.fromEstatus(factura.getEstatus()).name());
		tfFactura.setText(""+factura.getFolio());
		tfNumCliente.setText(""+factura.getCliente());
		tfUuid.setText(factura.getUuid());
		
		// TXT
		engineTxt.loadContent(htmlTxt(), "text/html");
				
		// PDF
		File pdfFile = new File(cm.getGeneralConfig("carpetaSalida") + "/" + facturaBase.getNombreArchivo() + ".pdf");
		if (pdfFile.exists()) {
			String url = getClass().getResource("/resources/web/viewer.html").toExternalForm();
			enginePdf.setJavaScriptEnabled(true);
			
			enginePdf.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
			    if (newState == State.SUCCEEDED) {
					try {
						byte[] data = FileUtils.readFileToByteArray(pdfFile);
						String base64 = Base64.getEncoder().encodeToString(data);
						enginePdf.executeScript("openFileFromBase64('" + base64 + "')");
					} catch (IOException e) {
						log.error("No fue posible abrir el PDF", e);
					}
			    }
			});
			
//			enginePdf.documentProperty().addListener(new ChangeListener<Document>() {
//		    	  @Override public void changed(ObservableValue<? extends Document> prop, Document oldDoc, Document newDoc) {
//		      	enableFirebug(engine);
//		     	 }
//			});
			enginePdf.load(url);
		} else {
			StringBuilder noPdf = new StringBuilder("<html><head></head><body>No existe el archivo PDF");
			noPdf.append(cm.getGeneralConfig("carpetaSalida")).append("/").append(facturaBase.getNombreArchivo()).append(".pdf")		
				 .append("</body></html>");
			enginePdf.loadContent(noPdf.toString(), "text/html");
		}
				
		// XML
		if ((factura != null) && (factura.getComprobanteFiscal() != null) && (!"".equals(factura.getComprobanteFiscal().trim()))) {
			engineXml.setUserStyleSheetLocation(getClass().getResource("/resources/css/prettify.css").toExternalForm());
			engineXml.setJavaScriptEnabled(true);
			
			StringWriter stringWriter = new StringWriter();
			try {
				Document document = DocumentBuilderFactory.newInstance()
			        .newDocumentBuilder()
			        .parse(new InputSource(new ByteArrayInputStream(factura.getComprobanteFiscal().getBytes("utf-8"))));
					
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				transformerFactory.setAttribute("indent-number", 2);
				Transformer transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
						
			} catch (Exception e) {
				log.error("Problema para formatear XML", e);
			}

			engineXml.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
			    if (newState == State.SUCCEEDED) {
			        Document doc = engineXml.getDocument();
			        HTMLPreElement preElement = (HTMLPreElement) doc.getElementById("xml");
			        preElement.setTextContent(stringWriter.toString());
			        engineXml.executeScript("PR.prettyPrint()");
			    }
			});
					
			String urlXml = getClass().getResource("/resources/web/xmlViewer.html").toExternalForm();
			engineXml.load(urlXml);
					
//			engine.documentProperty().addListener(new ChangeListener<Document>() {
//			      @Override public void changed(ObservableValue<? extends Document> prop, Document oldDoc, Document newDoc) {
//			        enableFirebug(engine);
//			      }
//			});
		} else {
			String noXml = "<html><head></head><body>No existe XML</body></html>";
			engineXml.loadContent(noXml, "text/html");
		}
		
		pTxt.toFront();
	}
	
	private com.canauhtli.cfdi.factura.Factura decodificaFactura(String src) {
		com.canauhtli.cfdi.factura.Factura jFac = null;
		try {
			JsonTools jtools = new JsonTools(com.canauhtli.cfdi.factura.Factura.class);
			jFac = (com.canauhtli.cfdi.factura.Factura) jtools.fromJsonString(src);
		} catch (JAXBException e) {
			log.error("No pude decodificar factura", e);
		}
		
		return jFac;
	}
	
	private String htmlTxt() {
		StringBuilder html = new StringBuilder("<html><head></head><body style=\"font-family: Lucida, Console, Monospace; font-size: 10px;\">");
		
		html.append("<table border=\"0\">")
			.append("<tr><td valign=\"top\">Generales:</td><td>")
			.append(facturaBase.getGenerales()).append("</td></tr>")
			.append("<tr><td valign=\"top\">Encabezado:</td><td>")
			.append(facturaBase.getEncabezado()).append("</td></tr>")
		    .append("<tr><td valign=\"top\">Receptor:</td><td>")
		    .append(facturaBase.getReceptor()).append("</td></tr>");
		    
		
		for (ConceptoFac con : facturaBase.getConceptos()) {
			html.append("<tr><td valign=\"top\">Concepto:</td><td>")
				.append(con);
			if (con.getImpuestos() != null) {
				for (ImpuestoConceptoFac icf : con.getImpuestos()) {
					html.append("<br>=>&nbsp;Impuesto:&nbsp;&nbsp;").append(icf);
				}
			}
			if (con.getComentarios() != null) {
				for (Comentario c : con.getComentarios()) {
					html.append("<br>=>&nbsp;Comentario:&nbsp;&bnbs;").append(c);
				}
			}
			html.append("</td></tr>");
		}
		
		html.append("<tr><td valign=\"top\">Impuestos:</td><td>")
			.append(facturaBase.getImpuesto()).append("</td></tr>")
			.append("<tr><td valign=\"top\">Totales:</td><td>")
			.append(facturaBase.getTotales()).append("</td></tr>");
		
		if (facturaBase.getObservaciones() != null) {
			for (Observacion o : facturaBase.getObservaciones()) {
				html.append("<tr><td valign=\\\"top\">Observacion:</td><td>")
					.append(o).append("</td></tr>");
			}
		}
		
		html.append("<tr><td valign=\"top\">Extras:</td><td>").append(facturaBase.getExtras()).append("</td></tr>");
		html.append("<tr><td valign=\"top\">CFDI Relacionado:</td><td>").append(facturaBase.getUuidRelacionado()).append("</td></tr>");
		
		if (facturaBase.getPagos() != null) {
			for (Pago p : facturaBase.getPagos()) {
				html.append("<tr><td valign=\"top\">Pago:</td><td>")
					.append(p);
				if (p.getImpuestoPago() != null) {
					html.append("<br>&nbsp;Impuesto:&nbsp;&nbsp;").append(p.getImpuestoPago());
				}
				if (p.getDocumentos() != null) {
					for (DocumentoRelacionado dr : p.getDocumentos()) {
						html.append("<br>&nbsp;Documento Relacionado:&nbsp;&nbsp;").append(dr);
					}
				}
				html.append("</td></tr>");
			}
		}
		
		html.append("</table>");
		
		html.append("</body></html>");
		return html.toString();
	}
}
