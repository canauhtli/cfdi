package com.canauhtli.cfdi.ui.controls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class LogViewerController extends AnchorPane {

	private static Logger log = LoggerFactory.getLogger(LogViewerController.class);
	private static final String HEAD = "<html><head>"
			+ "</head><body style=\"font-family: Lucida, Console, Monospace; font-size: 10px;\">"
			+ "<table border=0>";
	private static final String FOOT = "</table></body></html>";
	private String logFileName;
	private WebEngine webEngine;
	
	@FXML Button btRefresh;
	@FXML WebView wvLog;
	
	public LogViewerController() {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		ch.qos.logback.classic.Logger rootLogger = context.getLogger("com.canauhtli.cfdi");
        Appender<ILoggingEvent> appender = rootLogger.getAppender("CFDI");
		RollingFileAppender<ILoggingEvent> rfa = (RollingFileAppender<ILoggingEvent>) appender;
		logFileName = rfa.getFile();
	}
	
	@FXML
	private void recargar(ActionEvent ae) {
		
		webEngine.loadContent(cargarLog(), "text/html");
	}
	
	@FXML
	private void initialize() {
		webEngine = wvLog.getEngine();
		webEngine.loadContent(cargarLog(), "text/html");
	}
	
	private String cargarLog() {
		StringBuilder sb = new StringBuilder(HEAD);
		
		File logFile = new File(logFileName);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(logFile));
			String linea = "";
			while ((linea = reader.readLine()) != null) {
				if (linea.startsWith("ERROR")) {
					sb.append("<div style=\"color: red;\">").append(linea).append("</div><br>");
				} else if (linea.startsWith("INFO")) {
					sb.append("<div style=\"color: blue;\">").append(linea).append("</div><br>");
				} else {
					sb.append(linea).append("<br>");
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			log.error("No fue posible abrir el log {}", logFileName, e);
		} catch (IOException e) {
			log.error("No fue posible leer el log {}", logFileName, e);
		}
		
		
		sb.append(FOOT);
		return sb.toString();
	}
}
