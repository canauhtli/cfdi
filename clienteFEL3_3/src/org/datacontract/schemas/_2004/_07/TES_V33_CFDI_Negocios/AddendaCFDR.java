/**
 * AddendaCFDR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class AddendaCFDR  implements java.io.Serializable {
    private java.lang.Boolean ajusteManual;

    private java.lang.String claveDeCFDI;

    private java.lang.Boolean combustible;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConceptoR[] detallesConceptos;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioEmisor;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioReceptor;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioSucursal;

    private java.lang.String etiquetaDescuento;

    private java.lang.String etiquetaSubtotal;

    private java.lang.String etiquetaTotal;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizadaR[] etiquetasPersonalizadas;

    private java.lang.String fechaTipoDeCambio;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLineR[] firmas;

    private java.lang.String formaGeneracion;

    private java.lang.String idiomaPDF;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombreRetencionesLocales;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombresRetenciones;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombresTraslados;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombresTrasladosLocales;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagareR pagare;

    private java.lang.String pagoEnParcialidades;

    private java.math.BigDecimal porcentajeDeDescuento;

    private java.math.BigDecimal subtotalAntesDeDescuento;

    private java.math.BigDecimal subtotalDespuesDescuento;

    private java.lang.String telefonoEmisor;

    private java.lang.String telefonoEmisorSucursal;

    private java.lang.String telefonoReceptor;

    private java.lang.String tipoDeCfdi;

    private java.lang.String tituloPersonalizado;

    public AddendaCFDR() {
    }

    public AddendaCFDR(
           java.lang.Boolean ajusteManual,
           java.lang.String claveDeCFDI,
           java.lang.Boolean combustible,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConceptoR[] detallesConceptos,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioEmisor,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioReceptor,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioSucursal,
           java.lang.String etiquetaDescuento,
           java.lang.String etiquetaSubtotal,
           java.lang.String etiquetaTotal,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizadaR[] etiquetasPersonalizadas,
           java.lang.String fechaTipoDeCambio,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLineR[] firmas,
           java.lang.String formaGeneracion,
           java.lang.String idiomaPDF,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombreRetencionesLocales,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombresRetenciones,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombresTraslados,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombresTrasladosLocales,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagareR pagare,
           java.lang.String pagoEnParcialidades,
           java.math.BigDecimal porcentajeDeDescuento,
           java.math.BigDecimal subtotalAntesDeDescuento,
           java.math.BigDecimal subtotalDespuesDescuento,
           java.lang.String telefonoEmisor,
           java.lang.String telefonoEmisorSucursal,
           java.lang.String telefonoReceptor,
           java.lang.String tipoDeCfdi,
           java.lang.String tituloPersonalizado) {
           this.ajusteManual = ajusteManual;
           this.claveDeCFDI = claveDeCFDI;
           this.combustible = combustible;
           this.detallesConceptos = detallesConceptos;
           this.domicilioEmisor = domicilioEmisor;
           this.domicilioReceptor = domicilioReceptor;
           this.domicilioSucursal = domicilioSucursal;
           this.etiquetaDescuento = etiquetaDescuento;
           this.etiquetaSubtotal = etiquetaSubtotal;
           this.etiquetaTotal = etiquetaTotal;
           this.etiquetasPersonalizadas = etiquetasPersonalizadas;
           this.fechaTipoDeCambio = fechaTipoDeCambio;
           this.firmas = firmas;
           this.formaGeneracion = formaGeneracion;
           this.idiomaPDF = idiomaPDF;
           this.nombreRetencionesLocales = nombreRetencionesLocales;
           this.nombresRetenciones = nombresRetenciones;
           this.nombresTraslados = nombresTraslados;
           this.nombresTrasladosLocales = nombresTrasladosLocales;
           this.pagare = pagare;
           this.pagoEnParcialidades = pagoEnParcialidades;
           this.porcentajeDeDescuento = porcentajeDeDescuento;
           this.subtotalAntesDeDescuento = subtotalAntesDeDescuento;
           this.subtotalDespuesDescuento = subtotalDespuesDescuento;
           this.telefonoEmisor = telefonoEmisor;
           this.telefonoEmisorSucursal = telefonoEmisorSucursal;
           this.telefonoReceptor = telefonoReceptor;
           this.tipoDeCfdi = tipoDeCfdi;
           this.tituloPersonalizado = tituloPersonalizado;
    }


    /**
     * Gets the ajusteManual value for this AddendaCFDR.
     * 
     * @return ajusteManual
     */
    public java.lang.Boolean getAjusteManual() {
        return ajusteManual;
    }


    /**
     * Sets the ajusteManual value for this AddendaCFDR.
     * 
     * @param ajusteManual
     */
    public void setAjusteManual(java.lang.Boolean ajusteManual) {
        this.ajusteManual = ajusteManual;
    }


    /**
     * Gets the claveDeCFDI value for this AddendaCFDR.
     * 
     * @return claveDeCFDI
     */
    public java.lang.String getClaveDeCFDI() {
        return claveDeCFDI;
    }


    /**
     * Sets the claveDeCFDI value for this AddendaCFDR.
     * 
     * @param claveDeCFDI
     */
    public void setClaveDeCFDI(java.lang.String claveDeCFDI) {
        this.claveDeCFDI = claveDeCFDI;
    }


    /**
     * Gets the combustible value for this AddendaCFDR.
     * 
     * @return combustible
     */
    public java.lang.Boolean getCombustible() {
        return combustible;
    }


    /**
     * Sets the combustible value for this AddendaCFDR.
     * 
     * @param combustible
     */
    public void setCombustible(java.lang.Boolean combustible) {
        this.combustible = combustible;
    }


    /**
     * Gets the detallesConceptos value for this AddendaCFDR.
     * 
     * @return detallesConceptos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConceptoR[] getDetallesConceptos() {
        return detallesConceptos;
    }


    /**
     * Sets the detallesConceptos value for this AddendaCFDR.
     * 
     * @param detallesConceptos
     */
    public void setDetallesConceptos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConceptoR[] detallesConceptos) {
        this.detallesConceptos = detallesConceptos;
    }


    /**
     * Gets the domicilioEmisor value for this AddendaCFDR.
     * 
     * @return domicilioEmisor
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR getDomicilioEmisor() {
        return domicilioEmisor;
    }


    /**
     * Sets the domicilioEmisor value for this AddendaCFDR.
     * 
     * @param domicilioEmisor
     */
    public void setDomicilioEmisor(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioEmisor) {
        this.domicilioEmisor = domicilioEmisor;
    }


    /**
     * Gets the domicilioReceptor value for this AddendaCFDR.
     * 
     * @return domicilioReceptor
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR getDomicilioReceptor() {
        return domicilioReceptor;
    }


    /**
     * Sets the domicilioReceptor value for this AddendaCFDR.
     * 
     * @param domicilioReceptor
     */
    public void setDomicilioReceptor(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioReceptor) {
        this.domicilioReceptor = domicilioReceptor;
    }


    /**
     * Gets the domicilioSucursal value for this AddendaCFDR.
     * 
     * @return domicilioSucursal
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR getDomicilioSucursal() {
        return domicilioSucursal;
    }


    /**
     * Sets the domicilioSucursal value for this AddendaCFDR.
     * 
     * @param domicilioSucursal
     */
    public void setDomicilioSucursal(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioSucursal) {
        this.domicilioSucursal = domicilioSucursal;
    }


    /**
     * Gets the etiquetaDescuento value for this AddendaCFDR.
     * 
     * @return etiquetaDescuento
     */
    public java.lang.String getEtiquetaDescuento() {
        return etiquetaDescuento;
    }


    /**
     * Sets the etiquetaDescuento value for this AddendaCFDR.
     * 
     * @param etiquetaDescuento
     */
    public void setEtiquetaDescuento(java.lang.String etiquetaDescuento) {
        this.etiquetaDescuento = etiquetaDescuento;
    }


    /**
     * Gets the etiquetaSubtotal value for this AddendaCFDR.
     * 
     * @return etiquetaSubtotal
     */
    public java.lang.String getEtiquetaSubtotal() {
        return etiquetaSubtotal;
    }


    /**
     * Sets the etiquetaSubtotal value for this AddendaCFDR.
     * 
     * @param etiquetaSubtotal
     */
    public void setEtiquetaSubtotal(java.lang.String etiquetaSubtotal) {
        this.etiquetaSubtotal = etiquetaSubtotal;
    }


    /**
     * Gets the etiquetaTotal value for this AddendaCFDR.
     * 
     * @return etiquetaTotal
     */
    public java.lang.String getEtiquetaTotal() {
        return etiquetaTotal;
    }


    /**
     * Sets the etiquetaTotal value for this AddendaCFDR.
     * 
     * @param etiquetaTotal
     */
    public void setEtiquetaTotal(java.lang.String etiquetaTotal) {
        this.etiquetaTotal = etiquetaTotal;
    }


    /**
     * Gets the etiquetasPersonalizadas value for this AddendaCFDR.
     * 
     * @return etiquetasPersonalizadas
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizadaR[] getEtiquetasPersonalizadas() {
        return etiquetasPersonalizadas;
    }


    /**
     * Sets the etiquetasPersonalizadas value for this AddendaCFDR.
     * 
     * @param etiquetasPersonalizadas
     */
    public void setEtiquetasPersonalizadas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizadaR[] etiquetasPersonalizadas) {
        this.etiquetasPersonalizadas = etiquetasPersonalizadas;
    }


    /**
     * Gets the fechaTipoDeCambio value for this AddendaCFDR.
     * 
     * @return fechaTipoDeCambio
     */
    public java.lang.String getFechaTipoDeCambio() {
        return fechaTipoDeCambio;
    }


    /**
     * Sets the fechaTipoDeCambio value for this AddendaCFDR.
     * 
     * @param fechaTipoDeCambio
     */
    public void setFechaTipoDeCambio(java.lang.String fechaTipoDeCambio) {
        this.fechaTipoDeCambio = fechaTipoDeCambio;
    }


    /**
     * Gets the firmas value for this AddendaCFDR.
     * 
     * @return firmas
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLineR[] getFirmas() {
        return firmas;
    }


    /**
     * Sets the firmas value for this AddendaCFDR.
     * 
     * @param firmas
     */
    public void setFirmas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLineR[] firmas) {
        this.firmas = firmas;
    }


    /**
     * Gets the formaGeneracion value for this AddendaCFDR.
     * 
     * @return formaGeneracion
     */
    public java.lang.String getFormaGeneracion() {
        return formaGeneracion;
    }


    /**
     * Sets the formaGeneracion value for this AddendaCFDR.
     * 
     * @param formaGeneracion
     */
    public void setFormaGeneracion(java.lang.String formaGeneracion) {
        this.formaGeneracion = formaGeneracion;
    }


    /**
     * Gets the idiomaPDF value for this AddendaCFDR.
     * 
     * @return idiomaPDF
     */
    public java.lang.String getIdiomaPDF() {
        return idiomaPDF;
    }


    /**
     * Sets the idiomaPDF value for this AddendaCFDR.
     * 
     * @param idiomaPDF
     */
    public void setIdiomaPDF(java.lang.String idiomaPDF) {
        this.idiomaPDF = idiomaPDF;
    }


    /**
     * Gets the nombreRetencionesLocales value for this AddendaCFDR.
     * 
     * @return nombreRetencionesLocales
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] getNombreRetencionesLocales() {
        return nombreRetencionesLocales;
    }


    /**
     * Sets the nombreRetencionesLocales value for this AddendaCFDR.
     * 
     * @param nombreRetencionesLocales
     */
    public void setNombreRetencionesLocales(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombreRetencionesLocales) {
        this.nombreRetencionesLocales = nombreRetencionesLocales;
    }


    /**
     * Gets the nombresRetenciones value for this AddendaCFDR.
     * 
     * @return nombresRetenciones
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] getNombresRetenciones() {
        return nombresRetenciones;
    }


    /**
     * Sets the nombresRetenciones value for this AddendaCFDR.
     * 
     * @param nombresRetenciones
     */
    public void setNombresRetenciones(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombresRetenciones) {
        this.nombresRetenciones = nombresRetenciones;
    }


    /**
     * Gets the nombresTraslados value for this AddendaCFDR.
     * 
     * @return nombresTraslados
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] getNombresTraslados() {
        return nombresTraslados;
    }


    /**
     * Sets the nombresTraslados value for this AddendaCFDR.
     * 
     * @param nombresTraslados
     */
    public void setNombresTraslados(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombresTraslados) {
        this.nombresTraslados = nombresTraslados;
    }


    /**
     * Gets the nombresTrasladosLocales value for this AddendaCFDR.
     * 
     * @return nombresTrasladosLocales
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] getNombresTrasladosLocales() {
        return nombresTrasladosLocales;
    }


    /**
     * Sets the nombresTrasladosLocales value for this AddendaCFDR.
     * 
     * @param nombresTrasladosLocales
     */
    public void setNombresTrasladosLocales(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NombreImpuestoR[] nombresTrasladosLocales) {
        this.nombresTrasladosLocales = nombresTrasladosLocales;
    }


    /**
     * Gets the pagare value for this AddendaCFDR.
     * 
     * @return pagare
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagareR getPagare() {
        return pagare;
    }


    /**
     * Sets the pagare value for this AddendaCFDR.
     * 
     * @param pagare
     */
    public void setPagare(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagareR pagare) {
        this.pagare = pagare;
    }


    /**
     * Gets the pagoEnParcialidades value for this AddendaCFDR.
     * 
     * @return pagoEnParcialidades
     */
    public java.lang.String getPagoEnParcialidades() {
        return pagoEnParcialidades;
    }


    /**
     * Sets the pagoEnParcialidades value for this AddendaCFDR.
     * 
     * @param pagoEnParcialidades
     */
    public void setPagoEnParcialidades(java.lang.String pagoEnParcialidades) {
        this.pagoEnParcialidades = pagoEnParcialidades;
    }


    /**
     * Gets the porcentajeDeDescuento value for this AddendaCFDR.
     * 
     * @return porcentajeDeDescuento
     */
    public java.math.BigDecimal getPorcentajeDeDescuento() {
        return porcentajeDeDescuento;
    }


    /**
     * Sets the porcentajeDeDescuento value for this AddendaCFDR.
     * 
     * @param porcentajeDeDescuento
     */
    public void setPorcentajeDeDescuento(java.math.BigDecimal porcentajeDeDescuento) {
        this.porcentajeDeDescuento = porcentajeDeDescuento;
    }


    /**
     * Gets the subtotalAntesDeDescuento value for this AddendaCFDR.
     * 
     * @return subtotalAntesDeDescuento
     */
    public java.math.BigDecimal getSubtotalAntesDeDescuento() {
        return subtotalAntesDeDescuento;
    }


    /**
     * Sets the subtotalAntesDeDescuento value for this AddendaCFDR.
     * 
     * @param subtotalAntesDeDescuento
     */
    public void setSubtotalAntesDeDescuento(java.math.BigDecimal subtotalAntesDeDescuento) {
        this.subtotalAntesDeDescuento = subtotalAntesDeDescuento;
    }


    /**
     * Gets the subtotalDespuesDescuento value for this AddendaCFDR.
     * 
     * @return subtotalDespuesDescuento
     */
    public java.math.BigDecimal getSubtotalDespuesDescuento() {
        return subtotalDespuesDescuento;
    }


    /**
     * Sets the subtotalDespuesDescuento value for this AddendaCFDR.
     * 
     * @param subtotalDespuesDescuento
     */
    public void setSubtotalDespuesDescuento(java.math.BigDecimal subtotalDespuesDescuento) {
        this.subtotalDespuesDescuento = subtotalDespuesDescuento;
    }


    /**
     * Gets the telefonoEmisor value for this AddendaCFDR.
     * 
     * @return telefonoEmisor
     */
    public java.lang.String getTelefonoEmisor() {
        return telefonoEmisor;
    }


    /**
     * Sets the telefonoEmisor value for this AddendaCFDR.
     * 
     * @param telefonoEmisor
     */
    public void setTelefonoEmisor(java.lang.String telefonoEmisor) {
        this.telefonoEmisor = telefonoEmisor;
    }


    /**
     * Gets the telefonoEmisorSucursal value for this AddendaCFDR.
     * 
     * @return telefonoEmisorSucursal
     */
    public java.lang.String getTelefonoEmisorSucursal() {
        return telefonoEmisorSucursal;
    }


    /**
     * Sets the telefonoEmisorSucursal value for this AddendaCFDR.
     * 
     * @param telefonoEmisorSucursal
     */
    public void setTelefonoEmisorSucursal(java.lang.String telefonoEmisorSucursal) {
        this.telefonoEmisorSucursal = telefonoEmisorSucursal;
    }


    /**
     * Gets the telefonoReceptor value for this AddendaCFDR.
     * 
     * @return telefonoReceptor
     */
    public java.lang.String getTelefonoReceptor() {
        return telefonoReceptor;
    }


    /**
     * Sets the telefonoReceptor value for this AddendaCFDR.
     * 
     * @param telefonoReceptor
     */
    public void setTelefonoReceptor(java.lang.String telefonoReceptor) {
        this.telefonoReceptor = telefonoReceptor;
    }


    /**
     * Gets the tipoDeCfdi value for this AddendaCFDR.
     * 
     * @return tipoDeCfdi
     */
    public java.lang.String getTipoDeCfdi() {
        return tipoDeCfdi;
    }


    /**
     * Sets the tipoDeCfdi value for this AddendaCFDR.
     * 
     * @param tipoDeCfdi
     */
    public void setTipoDeCfdi(java.lang.String tipoDeCfdi) {
        this.tipoDeCfdi = tipoDeCfdi;
    }


    /**
     * Gets the tituloPersonalizado value for this AddendaCFDR.
     * 
     * @return tituloPersonalizado
     */
    public java.lang.String getTituloPersonalizado() {
        return tituloPersonalizado;
    }


    /**
     * Sets the tituloPersonalizado value for this AddendaCFDR.
     * 
     * @param tituloPersonalizado
     */
    public void setTituloPersonalizado(java.lang.String tituloPersonalizado) {
        this.tituloPersonalizado = tituloPersonalizado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddendaCFDR)) return false;
        AddendaCFDR other = (AddendaCFDR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ajusteManual==null && other.getAjusteManual()==null) || 
             (this.ajusteManual!=null &&
              this.ajusteManual.equals(other.getAjusteManual()))) &&
            ((this.claveDeCFDI==null && other.getClaveDeCFDI()==null) || 
             (this.claveDeCFDI!=null &&
              this.claveDeCFDI.equals(other.getClaveDeCFDI()))) &&
            ((this.combustible==null && other.getCombustible()==null) || 
             (this.combustible!=null &&
              this.combustible.equals(other.getCombustible()))) &&
            ((this.detallesConceptos==null && other.getDetallesConceptos()==null) || 
             (this.detallesConceptos!=null &&
              java.util.Arrays.equals(this.detallesConceptos, other.getDetallesConceptos()))) &&
            ((this.domicilioEmisor==null && other.getDomicilioEmisor()==null) || 
             (this.domicilioEmisor!=null &&
              this.domicilioEmisor.equals(other.getDomicilioEmisor()))) &&
            ((this.domicilioReceptor==null && other.getDomicilioReceptor()==null) || 
             (this.domicilioReceptor!=null &&
              this.domicilioReceptor.equals(other.getDomicilioReceptor()))) &&
            ((this.domicilioSucursal==null && other.getDomicilioSucursal()==null) || 
             (this.domicilioSucursal!=null &&
              this.domicilioSucursal.equals(other.getDomicilioSucursal()))) &&
            ((this.etiquetaDescuento==null && other.getEtiquetaDescuento()==null) || 
             (this.etiquetaDescuento!=null &&
              this.etiquetaDescuento.equals(other.getEtiquetaDescuento()))) &&
            ((this.etiquetaSubtotal==null && other.getEtiquetaSubtotal()==null) || 
             (this.etiquetaSubtotal!=null &&
              this.etiquetaSubtotal.equals(other.getEtiquetaSubtotal()))) &&
            ((this.etiquetaTotal==null && other.getEtiquetaTotal()==null) || 
             (this.etiquetaTotal!=null &&
              this.etiquetaTotal.equals(other.getEtiquetaTotal()))) &&
            ((this.etiquetasPersonalizadas==null && other.getEtiquetasPersonalizadas()==null) || 
             (this.etiquetasPersonalizadas!=null &&
              java.util.Arrays.equals(this.etiquetasPersonalizadas, other.getEtiquetasPersonalizadas()))) &&
            ((this.fechaTipoDeCambio==null && other.getFechaTipoDeCambio()==null) || 
             (this.fechaTipoDeCambio!=null &&
              this.fechaTipoDeCambio.equals(other.getFechaTipoDeCambio()))) &&
            ((this.firmas==null && other.getFirmas()==null) || 
             (this.firmas!=null &&
              java.util.Arrays.equals(this.firmas, other.getFirmas()))) &&
            ((this.formaGeneracion==null && other.getFormaGeneracion()==null) || 
             (this.formaGeneracion!=null &&
              this.formaGeneracion.equals(other.getFormaGeneracion()))) &&
            ((this.idiomaPDF==null && other.getIdiomaPDF()==null) || 
             (this.idiomaPDF!=null &&
              this.idiomaPDF.equals(other.getIdiomaPDF()))) &&
            ((this.nombreRetencionesLocales==null && other.getNombreRetencionesLocales()==null) || 
             (this.nombreRetencionesLocales!=null &&
              java.util.Arrays.equals(this.nombreRetencionesLocales, other.getNombreRetencionesLocales()))) &&
            ((this.nombresRetenciones==null && other.getNombresRetenciones()==null) || 
             (this.nombresRetenciones!=null &&
              java.util.Arrays.equals(this.nombresRetenciones, other.getNombresRetenciones()))) &&
            ((this.nombresTraslados==null && other.getNombresTraslados()==null) || 
             (this.nombresTraslados!=null &&
              java.util.Arrays.equals(this.nombresTraslados, other.getNombresTraslados()))) &&
            ((this.nombresTrasladosLocales==null && other.getNombresTrasladosLocales()==null) || 
             (this.nombresTrasladosLocales!=null &&
              java.util.Arrays.equals(this.nombresTrasladosLocales, other.getNombresTrasladosLocales()))) &&
            ((this.pagare==null && other.getPagare()==null) || 
             (this.pagare!=null &&
              this.pagare.equals(other.getPagare()))) &&
            ((this.pagoEnParcialidades==null && other.getPagoEnParcialidades()==null) || 
             (this.pagoEnParcialidades!=null &&
              this.pagoEnParcialidades.equals(other.getPagoEnParcialidades()))) &&
            ((this.porcentajeDeDescuento==null && other.getPorcentajeDeDescuento()==null) || 
             (this.porcentajeDeDescuento!=null &&
              this.porcentajeDeDescuento.equals(other.getPorcentajeDeDescuento()))) &&
            ((this.subtotalAntesDeDescuento==null && other.getSubtotalAntesDeDescuento()==null) || 
             (this.subtotalAntesDeDescuento!=null &&
              this.subtotalAntesDeDescuento.equals(other.getSubtotalAntesDeDescuento()))) &&
            ((this.subtotalDespuesDescuento==null && other.getSubtotalDespuesDescuento()==null) || 
             (this.subtotalDespuesDescuento!=null &&
              this.subtotalDespuesDescuento.equals(other.getSubtotalDespuesDescuento()))) &&
            ((this.telefonoEmisor==null && other.getTelefonoEmisor()==null) || 
             (this.telefonoEmisor!=null &&
              this.telefonoEmisor.equals(other.getTelefonoEmisor()))) &&
            ((this.telefonoEmisorSucursal==null && other.getTelefonoEmisorSucursal()==null) || 
             (this.telefonoEmisorSucursal!=null &&
              this.telefonoEmisorSucursal.equals(other.getTelefonoEmisorSucursal()))) &&
            ((this.telefonoReceptor==null && other.getTelefonoReceptor()==null) || 
             (this.telefonoReceptor!=null &&
              this.telefonoReceptor.equals(other.getTelefonoReceptor()))) &&
            ((this.tipoDeCfdi==null && other.getTipoDeCfdi()==null) || 
             (this.tipoDeCfdi!=null &&
              this.tipoDeCfdi.equals(other.getTipoDeCfdi()))) &&
            ((this.tituloPersonalizado==null && other.getTituloPersonalizado()==null) || 
             (this.tituloPersonalizado!=null &&
              this.tituloPersonalizado.equals(other.getTituloPersonalizado())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAjusteManual() != null) {
            _hashCode += getAjusteManual().hashCode();
        }
        if (getClaveDeCFDI() != null) {
            _hashCode += getClaveDeCFDI().hashCode();
        }
        if (getCombustible() != null) {
            _hashCode += getCombustible().hashCode();
        }
        if (getDetallesConceptos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDetallesConceptos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDetallesConceptos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDomicilioEmisor() != null) {
            _hashCode += getDomicilioEmisor().hashCode();
        }
        if (getDomicilioReceptor() != null) {
            _hashCode += getDomicilioReceptor().hashCode();
        }
        if (getDomicilioSucursal() != null) {
            _hashCode += getDomicilioSucursal().hashCode();
        }
        if (getEtiquetaDescuento() != null) {
            _hashCode += getEtiquetaDescuento().hashCode();
        }
        if (getEtiquetaSubtotal() != null) {
            _hashCode += getEtiquetaSubtotal().hashCode();
        }
        if (getEtiquetaTotal() != null) {
            _hashCode += getEtiquetaTotal().hashCode();
        }
        if (getEtiquetasPersonalizadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEtiquetasPersonalizadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEtiquetasPersonalizadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFechaTipoDeCambio() != null) {
            _hashCode += getFechaTipoDeCambio().hashCode();
        }
        if (getFirmas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFirmas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFirmas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFormaGeneracion() != null) {
            _hashCode += getFormaGeneracion().hashCode();
        }
        if (getIdiomaPDF() != null) {
            _hashCode += getIdiomaPDF().hashCode();
        }
        if (getNombreRetencionesLocales() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNombreRetencionesLocales());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNombreRetencionesLocales(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNombresRetenciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNombresRetenciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNombresRetenciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNombresTraslados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNombresTraslados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNombresTraslados(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNombresTrasladosLocales() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNombresTrasladosLocales());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNombresTrasladosLocales(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPagare() != null) {
            _hashCode += getPagare().hashCode();
        }
        if (getPagoEnParcialidades() != null) {
            _hashCode += getPagoEnParcialidades().hashCode();
        }
        if (getPorcentajeDeDescuento() != null) {
            _hashCode += getPorcentajeDeDescuento().hashCode();
        }
        if (getSubtotalAntesDeDescuento() != null) {
            _hashCode += getSubtotalAntesDeDescuento().hashCode();
        }
        if (getSubtotalDespuesDescuento() != null) {
            _hashCode += getSubtotalDespuesDescuento().hashCode();
        }
        if (getTelefonoEmisor() != null) {
            _hashCode += getTelefonoEmisor().hashCode();
        }
        if (getTelefonoEmisorSucursal() != null) {
            _hashCode += getTelefonoEmisorSucursal().hashCode();
        }
        if (getTelefonoReceptor() != null) {
            _hashCode += getTelefonoReceptor().hashCode();
        }
        if (getTipoDeCfdi() != null) {
            _hashCode += getTipoDeCfdi().hashCode();
        }
        if (getTituloPersonalizado() != null) {
            _hashCode += getTituloPersonalizado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AddendaCFDR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AddendaCFDR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ajusteManual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AjusteManual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveDeCFDI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveDeCFDI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("combustible");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Combustible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detallesConceptos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConceptos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConceptoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConceptoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioEmisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioEmisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioClienteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioClienteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioSucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioSucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioClienteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetaDescuento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaDescuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetaSubtotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaSubtotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetaTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetasPersonalizadas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetasPersonalizadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaPersonalizadaR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaPersonalizadaR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaTipoDeCambio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaTipoDeCambio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firmas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Firmas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FirmaOnLineR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FirmaOnLineR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formaGeneracion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FormaGeneracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomaPDF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdiomaPDF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreRetencionesLocales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreRetencionesLocales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreImpuestoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreImpuestoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombresRetenciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombresRetenciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreImpuestoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreImpuestoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombresTraslados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombresTraslados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreImpuestoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreImpuestoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombresTrasladosLocales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombresTrasladosLocales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreImpuestoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreImpuestoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagare");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Pagare"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagareR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagoEnParcialidades");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagoEnParcialidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("porcentajeDeDescuento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PorcentajeDeDescuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtotalAntesDeDescuento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubtotalAntesDeDescuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtotalDespuesDescuento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubtotalDespuesDescuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonoEmisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TelefonoEmisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonoEmisorSucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TelefonoEmisorSucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonoReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TelefonoReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDeCfdi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoDeCfdi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tituloPersonalizado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TituloPersonalizado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
