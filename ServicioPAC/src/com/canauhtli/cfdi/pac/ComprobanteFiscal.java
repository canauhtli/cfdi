package com.canauhtli.cfdi.pac;

import java.util.ArrayList;
import java.util.Date;

import com.canauhtli.cfdi.pac.bean.Concepto;
import com.canauhtli.cfdi.pac.bean.DescuentoRecargo;
import com.canauhtli.cfdi.pac.bean.Entidad;
import com.canauhtli.cfdi.pac.bean.Impuesto;
import com.canauhtli.cfdi.pac.bean.Nomina;
import com.canauhtli.cfdi.pac.bean.Pago;
import com.canauhtli.cfdi.pac.bean.Relacionados;
import com.canauhtli.cfdi.pac.bean.Subencabezado;
import com.canauhtli.cfdi.pac.types.DesRecTipo;
import com.canauhtli.cfdi.pac.types.TipoCFD;

public class ComprobanteFiscal {

	private TipoCFD tipo;
    private Date fechaEmision;
    private String serie;
    private String folio;
    private String cadenaOriginal;
    private String tipoComprobante;
    private String moneda;
    private double tipoCambio;
    private String formaPago;
    private String metodoPago;
    private ArrayList<Concepto> conceptos;
    private ArrayList<DescuentoRecargo> descRecs;
    private ArrayList<Impuesto> retenciones;
    private ArrayList<Impuesto> deducciones;
    private double subTotal = 0.0;
    private double total = 0.0;
    private double totalDescuento = 0.0;
    private String importe;
    private ArrayList<String> observaciones;
    private Subencabezado subencabezado;
    private Entidad emisor;
    private Entidad receptor;
    private Relacionados relacionados;
    private ArrayList<Pago> pagos;
    private boolean completo; 
    private String msg;
    private Nomina nomina;

    public Entidad getEmisor() {
        return this.emisor;
    }

    public void setEmisor(Entidad emisor) {
        this.emisor = emisor;
    }

    public Entidad getReceptor() {
        return this.receptor;
    }

    public void setReceptor(Entidad receptor) {
        this.receptor = receptor;
    }
    
    public Relacionados getRelacionados() {
    	return relacionados;
    }
    
    public void setRelacionados(Relacionados relacionados) {
    	this.relacionados = relacionados;
    }

    public ArrayList<Concepto> getConceptos() {
        return this.conceptos;
    }

    public void setConceptos(ArrayList<Concepto> conceptos) {
        this.conceptos = conceptos;
    }

    public void addConcepto(Concepto concepto) {
        if (this.conceptos == null) {
            this.conceptos = new ArrayList<Concepto>();
        }
        this.conceptos.add(concepto);
        this.subTotal += concepto.getImporte();
    }

    public Nomina getNomina() {
        return this.nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }

    public boolean isCompleto() {
        return this.completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public TipoCFD getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoCFD tipo) {
        this.tipo = tipo;
    }

    public Date getFechaEmision() {
        return this.fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFolio() {
        return this.folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getCadenaOriginal() {
        return this.cadenaOriginal;
    }

    public void setCadenaOriginal(String cadenaOriginal) {
        this.cadenaOriginal = cadenaOriginal;
    }

    public String getTipoComprobante() {
        return this.tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    
    public double getTipoCambio() {
    	return tipoCambio;
    }
    
    public void setTipoCambio(double tipoCambio) {
    	this.tipoCambio = tipoCambio;
    }

    public String getFormaPago() {
        return this.formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getMetodoPago() {
        return this.metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public ArrayList<DescuentoRecargo> getDescRecs() {
        return this.descRecs;
    }

    public void setDescRecs(ArrayList<DescuentoRecargo> descRecs) {
        this.descRecs = descRecs;
    }

    public void addDescRecs(DescuentoRecargo dr) {
        if (this.descRecs == null) {
            this.descRecs = new ArrayList<DescuentoRecargo>();
        }
        this.descRecs.add(dr);
        totalDescuento += dr.getMonto();
    }

    public ArrayList<Impuesto> getRetenciones() {
        return this.retenciones;
    }

    public void setRetenciones(ArrayList<Impuesto> retenciones) {
        this.retenciones = retenciones;
    }

    public void addRetencion(Impuesto retencion) {
        if (this.retenciones == null) {
            this.retenciones = new ArrayList<Impuesto>();
        }
        this.retenciones.add(retencion);
    }

    public ArrayList<Impuesto> getDeducciones() {
        return this.deducciones;
    }

    public void setDeducciones(ArrayList<Impuesto> deducciones) {
        this.deducciones = deducciones;
    }

    public void addDeduccion(Impuesto deduccion) {
        if (this.deducciones == null) {
            this.deducciones = new ArrayList<Impuesto>();
        }
        this.deducciones.add(deduccion);
    }

    public double getSubTotal() {
        return this.subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getImporte() {
        return this.importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public ArrayList<String> getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(ArrayList<String> observaciones) {
        this.observaciones = observaciones;
    }

    public Subencabezado getSubencabezado() {
        return this.subencabezado;
    }

    public void setSubencabezado(Subencabezado subencabezado) {
        this.subencabezado = subencabezado;
    }
    
    public ArrayList<Pago> getPagos() {
    	return pagos;
    }
    
    public void addPago(Pago pago) {
    	if (pagos == null) {
    		pagos = new ArrayList<Pago>();
    	}
    	pagos.add(pago);
    }

//    public String getXml() {
//        return this.xml;
//    }
//
//    public void setXml(String xml) {
//        this.xml = xml;
//    }
//
//    public String getPdf() {
//        return this.pdf;
//    }
//
//    public void setPdf(String pdf) {
//        this.pdf = pdf;
//    }
//
//    public int getAnioAprovacion() {
//        return this.anioAprovacion;
//    }
//
//    public void setAnioAprovacion(int anioAprovacion) {
//        this.anioAprovacion = anioAprovacion;
//    }
//
//    public int getNumAprovacion() {
//        return this.numAprovacion;
//    }
//
//    public void setNumAprovacion(int numAprovacion) {
//        this.numAprovacion = numAprovacion;
//    }
//
//    public String getCertificado() {
//        return this.certificado;
//    }
//
//    public void setCertificado(String certificado) {
//        this.certificado = certificado;
//    }
//
//    public String getNumCertificado() {
//        return this.numCertificado;
//    }
//
//    public void setNumCertificado(String numCertificado) {
//        this.numCertificado = numCertificado;
//    }
//
//    public TimbreFiscalDigital getTimbre() {
//        return this.timbre;
//    }
//
//    public void setTimbre(TimbreFiscalDigital timbre) {
//        this.timbre = timbre;
//    }
//
//    public Comprobante getCfdi() {
//        return this.cfdi;
//    }
//
//    public void setCfdi(Comprobante cfdi) {
//        this.cfdi = cfdi;
//    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    public String getPathPdf() {
//        return this.pathPdf;
//    }
//
//    public void setPathPdf(String pathPdf) {
//        this.pathPdf = pathPdf;
//    }
//
//    public String getPathXml() {
//        return this.pathXml;
//    }
//
//    public void setPathXml(String pathXml) {
//        this.pathXml = pathXml;
//    }

    public void setTotalDescuento(double descuento) {
    	this.totalDescuento = descuento;
    }
    
    public double getTotalDescuento() {
    	return totalDescuento;
    }
    
//    public double getTotalDescuento() {
//        double descuento = 0.0;
//        if (descRecs != null) {
//        	for (DescuentoRecargo dr : this.descRecs) {
//        		if (dr.getTipo() != DesRecTipo.DESCUENTO) continue;
//        		descuento += dr.getMonto();
//        	}
//        }
//        return descuento;
//    }

    public double getTotalRecargos() {
        double recargo = 0.0;
        if (descRecs != null) {
        	for (DescuentoRecargo dr : this.descRecs) {
        		if (dr.getTipo() != DesRecTipo.RECARGO) continue;
        		recargo += dr.getMonto();
        	}
        }
        return recargo;
    }

    public double getTotalDeducciones() {
        double tot = 0.0;
        if (this.deducciones != null) {
            for (Impuesto i : this.deducciones) {
                tot += i.getMonto();
            }
        }
        return tot;
    }

    public double getTotalRetenciones() {
        double tot = 0.0;
        if (this.retenciones != null) {
            for (Impuesto i : this.retenciones) {
                tot += i.getMonto();
            }
        }
        return tot;
    }

//    public void armaCadenaOriginal() {
//        StringBuilder sb = new StringBuilder("||");
//        sb.append(String.valueOf(Config.getVal("cfdi.version")) + "|");
//        sb.append(String.valueOf(this.timbre.getUUID()) + "|");
//        sb.append(String.valueOf(this.timbre.getFechaTimbrado().toXMLFormat()) + "|");
//        sb.append(String.valueOf(this.timbre.getSelloCFD()) + "|");
//        sb.append(String.valueOf(this.timbre.getNoCertificadoSAT()) + "||");
//        this.cadenaOriginal = sb.toString();
//    }

    public void validaPreEmision() {
        if (this.nomina.getPercepciones() == null || this.nomina.getPercepciones().size() == 0) {
            this.completo = false;
            this.msg = "No se cargo ninguna percepci\u00f3n";
        }
        if (this.nomina.getDeducciones() == null || this.nomina.getDeducciones().size() == 0) {
            this.completo = false;
            this.msg = "No se cargo ninguna deducci\u00f3n";
        }
    }

//    public String toString() {
//        return "ComprobanteFiscal [tipo=" + (Object)((Object)this.tipo) + ", fechaEmision=" + this.fechaEmision + ", serie=" + this.serie + ", folio=" + this.folio + ", cadenaOriginal=" + this.cadenaOriginal + ", tipoComprobante=" + this.tipoComprobante + ", moneda=" + this.moneda + ", formaPago=" + this.formaPago + ", metodoPago=" + this.metodoPago + ", conceptos=" + this.conceptos + ", descRecs=" + this.descRecs + ", retenciones=" + this.retenciones + ", deducciones=" + this.deducciones + ", subTotal=" + this.subTotal + ", total=" + this.total + ", importe=" + this.importe + ", observaciones=" + this.observaciones + ", subencabezado=" + this.subencabezado + ", emisor=" + this.emisor + ", receptor=" + this.receptor + ", cfdi=" + this.cfdi + ", xml=" + this.xml + ", pdf=" + this.pdf + ", anioAprovacion=" + this.anioAprovacion + ", numAprovacion=" + this.numAprovacion + ", certificado=" + this.certificado + ", numCertificado=" + this.numCertificado + ", timbre=" + this.timbre + ", completo=" + this.completo + ", msg=" + this.msg + ", nomina=" + this.nomina + "]";
//    }
}
