package com.canauhtli.cfdi.reportes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.PrinterName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

public class DocumentoPDF {

	private static Logger log = LoggerFactory.getLogger(DocumentoPDF.class);
	
	private String plantilla;
    private String nombre;
    private HashMap<String, Object> params;
    private int copias = 2;
    private boolean imprimir = true;
    private String impresora = "";

    public void generaReciboNomina(ArrayList<PercepcionDeduccion> percepciones) {
        try {
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(percepciones);
            JasperPrint jp = JasperFillManager.fillReport((String)this.plantilla, this.params, (JRDataSource)ds);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jp, (String)this.nombre);
            if (imprimir) {
                imprimePDF(jp);
            }
        }
        catch (JRException e) {
            log.error("Generando PDF", e);
        }
    }
    
    public void generaFactura(ArrayList<ConceptoFactura> conceptos) {
    	try {
    		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(conceptos);
    		JasperPrint jp = JasperFillManager.fillReport((String) plantilla, params, (JRDataSource) ds);
    		JasperExportManager.exportReportToPdfFile((JasperPrint) jp, nombre);
    		if (imprimir) {
    			imprimePDF(jp);
    		}
    	} catch (JRException e) {
    		log.error("Generando PDF", e);
    	}
    }

    private void imprimePDF(JasperPrint jp) {
        boolean printDialog = false;
        HashPrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
        attrs.add(new Copies(this.copias));
        attrs.add(new JobName(this.nombre.substring(0, this.nombre.indexOf(".")), null));
        HashPrintServiceAttributeSet psAttrs = new HashPrintServiceAttributeSet();
        if ("".equals(this.impresora)) {
            printDialog = true;
        } else if ("default".equalsIgnoreCase(this.impresora)) {
        	PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
            psAttrs.add(new PrinterName(ps.getName(), null));
        } else {
            psAttrs.add(new PrinterName(this.impresora, null));
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, psAttrs);
            if (ps.length <= 0) {
                printDialog = true;
                psAttrs.remove(PrinterName.class);
            }
        }
        JRPrintServiceExporter printService = new JRPrintServiceExporter();
        printService.setParameter(JRExporterParameter.JASPER_PRINT, (Object)jp);
        printService.setParameter((JRExporterParameter)JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, (Object)attrs);
        printService.setParameter((JRExporterParameter)JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, (Object)psAttrs);
        printService.setParameter((JRExporterParameter)JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, (Object)Boolean.FALSE);
        printService.setParameter((JRExporterParameter)JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, (Object)printDialog);
        try {
            printService.exportReport();
        }
        catch (JRException e) {
            log.error("Problema para imprimir PDF", e);
        }
    }

    public String getPlantilla() {
        return this.plantilla;
    }

    public void setPlantilla(String plantilla) {
        this.plantilla = plantilla;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Object> getParams() {
        return this.params;
    }

    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }

    public void addParam(String k, Object v) {
        if (this.params == null) {
            this.params = new HashMap<String, Object>();
        }
        this.params.put(k, v);
    }

    public void resetParams() {
        if (this.params != null) {
            this.params.clear();
            this.params = null;
        }
    }

    public int getCopias() {
        return this.copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public boolean isImprimir() {
        return this.imprimir;
    }

    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }

    public String getImpresora() {
        return this.impresora;
    }

    public void setImpresora(String impresora) {
        this.impresora = impresora;
    }
}
