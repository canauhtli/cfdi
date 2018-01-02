/**
 * Comprobante33R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class Comprobante33R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AddendaCFDR addenda;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AerolineasR aerolineas;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CFDIRegistroFiscalR CFDIRegistroFiscal;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionR certificadoDestruccion;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionadosR cfdiRelacionados;

    private java.lang.String claveCFDI;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExterior11R comercioExterior;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoR[] conceptos;

    private java.lang.String condicionesDePago;

    private java.lang.String confirmacion;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConsumoDeCombustiblesR consumoDeCombustibles;

    private java.math.BigDecimal descuento;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DivisaR divisas;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DonatariasR donatarias;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorR emisor;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleR estadoDeCuentaCombustible;

    private java.util.Calendar fecha;

    private java.lang.String folio;

    private java.lang.String formaPago;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.INER INE;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IntegranteCoordinadoR integranteCoordinado;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.LeyendaFiscalR leyendasFiscales;

    private java.lang.String lugarExpedicion;

    private java.lang.String metodoPago;

    private java.lang.String moneda;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Nomina12R[] nomina;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NotariosPublicosR notariosPublicos;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ObrasArteAntiguedadesR obrasArteAntiguedades;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagoEnEspecieR pagoEnEspecie;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Pagos10R pagos;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ParcialesConstruccionR parcialesconstruccion;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorR receptor;

    private java.lang.String referencia;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionYSustitucionVehiculosR renovacionYSustitucionVehiculos;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SPEIR SPEI;

    private java.lang.String serie;

    private java.math.BigDecimal subTotal;

    private java.math.BigDecimal tipoCambio;

    private java.math.BigDecimal total;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TuristaPasajeroExtranjeroR turistaPasajeroExtranjero;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ValesDeDespensaR valesDeDespensa;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VehiculoUsadoR vehiculoUsado;

    public Comprobante33R() {
    }

    public Comprobante33R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AddendaCFDR addenda,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AerolineasR aerolineas,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CFDIRegistroFiscalR CFDIRegistroFiscal,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionR certificadoDestruccion,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionadosR cfdiRelacionados,
           java.lang.String claveCFDI,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExterior11R comercioExterior,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoR[] conceptos,
           java.lang.String condicionesDePago,
           java.lang.String confirmacion,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConsumoDeCombustiblesR consumoDeCombustibles,
           java.math.BigDecimal descuento,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DivisaR divisas,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DonatariasR donatarias,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorR emisor,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleR estadoDeCuentaCombustible,
           java.util.Calendar fecha,
           java.lang.String folio,
           java.lang.String formaPago,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.INER INE,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IntegranteCoordinadoR integranteCoordinado,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.LeyendaFiscalR leyendasFiscales,
           java.lang.String lugarExpedicion,
           java.lang.String metodoPago,
           java.lang.String moneda,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Nomina12R[] nomina,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NotariosPublicosR notariosPublicos,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ObrasArteAntiguedadesR obrasArteAntiguedades,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagoEnEspecieR pagoEnEspecie,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Pagos10R pagos,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ParcialesConstruccionR parcialesconstruccion,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorR receptor,
           java.lang.String referencia,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionYSustitucionVehiculosR renovacionYSustitucionVehiculos,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SPEIR SPEI,
           java.lang.String serie,
           java.math.BigDecimal subTotal,
           java.math.BigDecimal tipoCambio,
           java.math.BigDecimal total,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TuristaPasajeroExtranjeroR turistaPasajeroExtranjero,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ValesDeDespensaR valesDeDespensa,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VehiculoUsadoR vehiculoUsado) {
           this.addenda = addenda;
           this.aerolineas = aerolineas;
           this.CFDIRegistroFiscal = CFDIRegistroFiscal;
           this.certificadoDestruccion = certificadoDestruccion;
           this.cfdiRelacionados = cfdiRelacionados;
           this.claveCFDI = claveCFDI;
           this.comercioExterior = comercioExterior;
           this.conceptos = conceptos;
           this.condicionesDePago = condicionesDePago;
           this.confirmacion = confirmacion;
           this.consumoDeCombustibles = consumoDeCombustibles;
           this.descuento = descuento;
           this.divisas = divisas;
           this.donatarias = donatarias;
           this.emisor = emisor;
           this.estadoDeCuentaCombustible = estadoDeCuentaCombustible;
           this.fecha = fecha;
           this.folio = folio;
           this.formaPago = formaPago;
           this.INE = INE;
           this.integranteCoordinado = integranteCoordinado;
           this.leyendasFiscales = leyendasFiscales;
           this.lugarExpedicion = lugarExpedicion;
           this.metodoPago = metodoPago;
           this.moneda = moneda;
           this.nomina = nomina;
           this.notariosPublicos = notariosPublicos;
           this.obrasArteAntiguedades = obrasArteAntiguedades;
           this.pagoEnEspecie = pagoEnEspecie;
           this.pagos = pagos;
           this.parcialesconstruccion = parcialesconstruccion;
           this.receptor = receptor;
           this.referencia = referencia;
           this.renovacionYSustitucionVehiculos = renovacionYSustitucionVehiculos;
           this.SPEI = SPEI;
           this.serie = serie;
           this.subTotal = subTotal;
           this.tipoCambio = tipoCambio;
           this.total = total;
           this.turistaPasajeroExtranjero = turistaPasajeroExtranjero;
           this.valesDeDespensa = valesDeDespensa;
           this.vehiculoUsado = vehiculoUsado;
    }


    /**
     * Gets the addenda value for this Comprobante33R.
     * 
     * @return addenda
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AddendaCFDR getAddenda() {
        return addenda;
    }


    /**
     * Sets the addenda value for this Comprobante33R.
     * 
     * @param addenda
     */
    public void setAddenda(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AddendaCFDR addenda) {
        this.addenda = addenda;
    }


    /**
     * Gets the aerolineas value for this Comprobante33R.
     * 
     * @return aerolineas
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AerolineasR getAerolineas() {
        return aerolineas;
    }


    /**
     * Sets the aerolineas value for this Comprobante33R.
     * 
     * @param aerolineas
     */
    public void setAerolineas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AerolineasR aerolineas) {
        this.aerolineas = aerolineas;
    }


    /**
     * Gets the CFDIRegistroFiscal value for this Comprobante33R.
     * 
     * @return CFDIRegistroFiscal
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CFDIRegistroFiscalR getCFDIRegistroFiscal() {
        return CFDIRegistroFiscal;
    }


    /**
     * Sets the CFDIRegistroFiscal value for this Comprobante33R.
     * 
     * @param CFDIRegistroFiscal
     */
    public void setCFDIRegistroFiscal(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CFDIRegistroFiscalR CFDIRegistroFiscal) {
        this.CFDIRegistroFiscal = CFDIRegistroFiscal;
    }


    /**
     * Gets the certificadoDestruccion value for this Comprobante33R.
     * 
     * @return certificadoDestruccion
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionR getCertificadoDestruccion() {
        return certificadoDestruccion;
    }


    /**
     * Sets the certificadoDestruccion value for this Comprobante33R.
     * 
     * @param certificadoDestruccion
     */
    public void setCertificadoDestruccion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionR certificadoDestruccion) {
        this.certificadoDestruccion = certificadoDestruccion;
    }


    /**
     * Gets the cfdiRelacionados value for this Comprobante33R.
     * 
     * @return cfdiRelacionados
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionadosR getCfdiRelacionados() {
        return cfdiRelacionados;
    }


    /**
     * Sets the cfdiRelacionados value for this Comprobante33R.
     * 
     * @param cfdiRelacionados
     */
    public void setCfdiRelacionados(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionadosR cfdiRelacionados) {
        this.cfdiRelacionados = cfdiRelacionados;
    }


    /**
     * Gets the claveCFDI value for this Comprobante33R.
     * 
     * @return claveCFDI
     */
    public java.lang.String getClaveCFDI() {
        return claveCFDI;
    }


    /**
     * Sets the claveCFDI value for this Comprobante33R.
     * 
     * @param claveCFDI
     */
    public void setClaveCFDI(java.lang.String claveCFDI) {
        this.claveCFDI = claveCFDI;
    }


    /**
     * Gets the comercioExterior value for this Comprobante33R.
     * 
     * @return comercioExterior
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExterior11R getComercioExterior() {
        return comercioExterior;
    }


    /**
     * Sets the comercioExterior value for this Comprobante33R.
     * 
     * @param comercioExterior
     */
    public void setComercioExterior(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExterior11R comercioExterior) {
        this.comercioExterior = comercioExterior;
    }


    /**
     * Gets the conceptos value for this Comprobante33R.
     * 
     * @return conceptos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoR[] getConceptos() {
        return conceptos;
    }


    /**
     * Sets the conceptos value for this Comprobante33R.
     * 
     * @param conceptos
     */
    public void setConceptos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoR[] conceptos) {
        this.conceptos = conceptos;
    }


    /**
     * Gets the condicionesDePago value for this Comprobante33R.
     * 
     * @return condicionesDePago
     */
    public java.lang.String getCondicionesDePago() {
        return condicionesDePago;
    }


    /**
     * Sets the condicionesDePago value for this Comprobante33R.
     * 
     * @param condicionesDePago
     */
    public void setCondicionesDePago(java.lang.String condicionesDePago) {
        this.condicionesDePago = condicionesDePago;
    }


    /**
     * Gets the confirmacion value for this Comprobante33R.
     * 
     * @return confirmacion
     */
    public java.lang.String getConfirmacion() {
        return confirmacion;
    }


    /**
     * Sets the confirmacion value for this Comprobante33R.
     * 
     * @param confirmacion
     */
    public void setConfirmacion(java.lang.String confirmacion) {
        this.confirmacion = confirmacion;
    }


    /**
     * Gets the consumoDeCombustibles value for this Comprobante33R.
     * 
     * @return consumoDeCombustibles
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConsumoDeCombustiblesR getConsumoDeCombustibles() {
        return consumoDeCombustibles;
    }


    /**
     * Sets the consumoDeCombustibles value for this Comprobante33R.
     * 
     * @param consumoDeCombustibles
     */
    public void setConsumoDeCombustibles(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConsumoDeCombustiblesR consumoDeCombustibles) {
        this.consumoDeCombustibles = consumoDeCombustibles;
    }


    /**
     * Gets the descuento value for this Comprobante33R.
     * 
     * @return descuento
     */
    public java.math.BigDecimal getDescuento() {
        return descuento;
    }


    /**
     * Sets the descuento value for this Comprobante33R.
     * 
     * @param descuento
     */
    public void setDescuento(java.math.BigDecimal descuento) {
        this.descuento = descuento;
    }


    /**
     * Gets the divisas value for this Comprobante33R.
     * 
     * @return divisas
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DivisaR getDivisas() {
        return divisas;
    }


    /**
     * Sets the divisas value for this Comprobante33R.
     * 
     * @param divisas
     */
    public void setDivisas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DivisaR divisas) {
        this.divisas = divisas;
    }


    /**
     * Gets the donatarias value for this Comprobante33R.
     * 
     * @return donatarias
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DonatariasR getDonatarias() {
        return donatarias;
    }


    /**
     * Sets the donatarias value for this Comprobante33R.
     * 
     * @param donatarias
     */
    public void setDonatarias(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DonatariasR donatarias) {
        this.donatarias = donatarias;
    }


    /**
     * Gets the emisor value for this Comprobante33R.
     * 
     * @return emisor
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorR getEmisor() {
        return emisor;
    }


    /**
     * Sets the emisor value for this Comprobante33R.
     * 
     * @param emisor
     */
    public void setEmisor(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorR emisor) {
        this.emisor = emisor;
    }


    /**
     * Gets the estadoDeCuentaCombustible value for this Comprobante33R.
     * 
     * @return estadoDeCuentaCombustible
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleR getEstadoDeCuentaCombustible() {
        return estadoDeCuentaCombustible;
    }


    /**
     * Sets the estadoDeCuentaCombustible value for this Comprobante33R.
     * 
     * @param estadoDeCuentaCombustible
     */
    public void setEstadoDeCuentaCombustible(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleR estadoDeCuentaCombustible) {
        this.estadoDeCuentaCombustible = estadoDeCuentaCombustible;
    }


    /**
     * Gets the fecha value for this Comprobante33R.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this Comprobante33R.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the folio value for this Comprobante33R.
     * 
     * @return folio
     */
    public java.lang.String getFolio() {
        return folio;
    }


    /**
     * Sets the folio value for this Comprobante33R.
     * 
     * @param folio
     */
    public void setFolio(java.lang.String folio) {
        this.folio = folio;
    }


    /**
     * Gets the formaPago value for this Comprobante33R.
     * 
     * @return formaPago
     */
    public java.lang.String getFormaPago() {
        return formaPago;
    }


    /**
     * Sets the formaPago value for this Comprobante33R.
     * 
     * @param formaPago
     */
    public void setFormaPago(java.lang.String formaPago) {
        this.formaPago = formaPago;
    }


    /**
     * Gets the INE value for this Comprobante33R.
     * 
     * @return INE
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.INER getINE() {
        return INE;
    }


    /**
     * Sets the INE value for this Comprobante33R.
     * 
     * @param INE
     */
    public void setINE(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.INER INE) {
        this.INE = INE;
    }


    /**
     * Gets the integranteCoordinado value for this Comprobante33R.
     * 
     * @return integranteCoordinado
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IntegranteCoordinadoR getIntegranteCoordinado() {
        return integranteCoordinado;
    }


    /**
     * Sets the integranteCoordinado value for this Comprobante33R.
     * 
     * @param integranteCoordinado
     */
    public void setIntegranteCoordinado(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IntegranteCoordinadoR integranteCoordinado) {
        this.integranteCoordinado = integranteCoordinado;
    }


    /**
     * Gets the leyendasFiscales value for this Comprobante33R.
     * 
     * @return leyendasFiscales
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.LeyendaFiscalR getLeyendasFiscales() {
        return leyendasFiscales;
    }


    /**
     * Sets the leyendasFiscales value for this Comprobante33R.
     * 
     * @param leyendasFiscales
     */
    public void setLeyendasFiscales(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.LeyendaFiscalR leyendasFiscales) {
        this.leyendasFiscales = leyendasFiscales;
    }


    /**
     * Gets the lugarExpedicion value for this Comprobante33R.
     * 
     * @return lugarExpedicion
     */
    public java.lang.String getLugarExpedicion() {
        return lugarExpedicion;
    }


    /**
     * Sets the lugarExpedicion value for this Comprobante33R.
     * 
     * @param lugarExpedicion
     */
    public void setLugarExpedicion(java.lang.String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }


    /**
     * Gets the metodoPago value for this Comprobante33R.
     * 
     * @return metodoPago
     */
    public java.lang.String getMetodoPago() {
        return metodoPago;
    }


    /**
     * Sets the metodoPago value for this Comprobante33R.
     * 
     * @param metodoPago
     */
    public void setMetodoPago(java.lang.String metodoPago) {
        this.metodoPago = metodoPago;
    }


    /**
     * Gets the moneda value for this Comprobante33R.
     * 
     * @return moneda
     */
    public java.lang.String getMoneda() {
        return moneda;
    }


    /**
     * Sets the moneda value for this Comprobante33R.
     * 
     * @param moneda
     */
    public void setMoneda(java.lang.String moneda) {
        this.moneda = moneda;
    }


    /**
     * Gets the nomina value for this Comprobante33R.
     * 
     * @return nomina
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Nomina12R[] getNomina() {
        return nomina;
    }


    /**
     * Sets the nomina value for this Comprobante33R.
     * 
     * @param nomina
     */
    public void setNomina(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Nomina12R[] nomina) {
        this.nomina = nomina;
    }


    /**
     * Gets the notariosPublicos value for this Comprobante33R.
     * 
     * @return notariosPublicos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NotariosPublicosR getNotariosPublicos() {
        return notariosPublicos;
    }


    /**
     * Sets the notariosPublicos value for this Comprobante33R.
     * 
     * @param notariosPublicos
     */
    public void setNotariosPublicos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NotariosPublicosR notariosPublicos) {
        this.notariosPublicos = notariosPublicos;
    }


    /**
     * Gets the obrasArteAntiguedades value for this Comprobante33R.
     * 
     * @return obrasArteAntiguedades
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ObrasArteAntiguedadesR getObrasArteAntiguedades() {
        return obrasArteAntiguedades;
    }


    /**
     * Sets the obrasArteAntiguedades value for this Comprobante33R.
     * 
     * @param obrasArteAntiguedades
     */
    public void setObrasArteAntiguedades(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ObrasArteAntiguedadesR obrasArteAntiguedades) {
        this.obrasArteAntiguedades = obrasArteAntiguedades;
    }


    /**
     * Gets the pagoEnEspecie value for this Comprobante33R.
     * 
     * @return pagoEnEspecie
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagoEnEspecieR getPagoEnEspecie() {
        return pagoEnEspecie;
    }


    /**
     * Sets the pagoEnEspecie value for this Comprobante33R.
     * 
     * @param pagoEnEspecie
     */
    public void setPagoEnEspecie(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagoEnEspecieR pagoEnEspecie) {
        this.pagoEnEspecie = pagoEnEspecie;
    }


    /**
     * Gets the pagos value for this Comprobante33R.
     * 
     * @return pagos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Pagos10R getPagos() {
        return pagos;
    }


    /**
     * Sets the pagos value for this Comprobante33R.
     * 
     * @param pagos
     */
    public void setPagos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Pagos10R pagos) {
        this.pagos = pagos;
    }


    /**
     * Gets the parcialesconstruccion value for this Comprobante33R.
     * 
     * @return parcialesconstruccion
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ParcialesConstruccionR getParcialesconstruccion() {
        return parcialesconstruccion;
    }


    /**
     * Sets the parcialesconstruccion value for this Comprobante33R.
     * 
     * @param parcialesconstruccion
     */
    public void setParcialesconstruccion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ParcialesConstruccionR parcialesconstruccion) {
        this.parcialesconstruccion = parcialesconstruccion;
    }


    /**
     * Gets the receptor value for this Comprobante33R.
     * 
     * @return receptor
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorR getReceptor() {
        return receptor;
    }


    /**
     * Sets the receptor value for this Comprobante33R.
     * 
     * @param receptor
     */
    public void setReceptor(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorR receptor) {
        this.receptor = receptor;
    }


    /**
     * Gets the referencia value for this Comprobante33R.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this Comprobante33R.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the renovacionYSustitucionVehiculos value for this Comprobante33R.
     * 
     * @return renovacionYSustitucionVehiculos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionYSustitucionVehiculosR getRenovacionYSustitucionVehiculos() {
        return renovacionYSustitucionVehiculos;
    }


    /**
     * Sets the renovacionYSustitucionVehiculos value for this Comprobante33R.
     * 
     * @param renovacionYSustitucionVehiculos
     */
    public void setRenovacionYSustitucionVehiculos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionYSustitucionVehiculosR renovacionYSustitucionVehiculos) {
        this.renovacionYSustitucionVehiculos = renovacionYSustitucionVehiculos;
    }


    /**
     * Gets the SPEI value for this Comprobante33R.
     * 
     * @return SPEI
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SPEIR getSPEI() {
        return SPEI;
    }


    /**
     * Sets the SPEI value for this Comprobante33R.
     * 
     * @param SPEI
     */
    public void setSPEI(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SPEIR SPEI) {
        this.SPEI = SPEI;
    }


    /**
     * Gets the serie value for this Comprobante33R.
     * 
     * @return serie
     */
    public java.lang.String getSerie() {
        return serie;
    }


    /**
     * Sets the serie value for this Comprobante33R.
     * 
     * @param serie
     */
    public void setSerie(java.lang.String serie) {
        this.serie = serie;
    }


    /**
     * Gets the subTotal value for this Comprobante33R.
     * 
     * @return subTotal
     */
    public java.math.BigDecimal getSubTotal() {
        return subTotal;
    }


    /**
     * Sets the subTotal value for this Comprobante33R.
     * 
     * @param subTotal
     */
    public void setSubTotal(java.math.BigDecimal subTotal) {
        this.subTotal = subTotal;
    }


    /**
     * Gets the tipoCambio value for this Comprobante33R.
     * 
     * @return tipoCambio
     */
    public java.math.BigDecimal getTipoCambio() {
        return tipoCambio;
    }


    /**
     * Sets the tipoCambio value for this Comprobante33R.
     * 
     * @param tipoCambio
     */
    public void setTipoCambio(java.math.BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }


    /**
     * Gets the total value for this Comprobante33R.
     * 
     * @return total
     */
    public java.math.BigDecimal getTotal() {
        return total;
    }


    /**
     * Sets the total value for this Comprobante33R.
     * 
     * @param total
     */
    public void setTotal(java.math.BigDecimal total) {
        this.total = total;
    }


    /**
     * Gets the turistaPasajeroExtranjero value for this Comprobante33R.
     * 
     * @return turistaPasajeroExtranjero
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TuristaPasajeroExtranjeroR getTuristaPasajeroExtranjero() {
        return turistaPasajeroExtranjero;
    }


    /**
     * Sets the turistaPasajeroExtranjero value for this Comprobante33R.
     * 
     * @param turistaPasajeroExtranjero
     */
    public void setTuristaPasajeroExtranjero(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TuristaPasajeroExtranjeroR turistaPasajeroExtranjero) {
        this.turistaPasajeroExtranjero = turistaPasajeroExtranjero;
    }


    /**
     * Gets the valesDeDespensa value for this Comprobante33R.
     * 
     * @return valesDeDespensa
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ValesDeDespensaR getValesDeDespensa() {
        return valesDeDespensa;
    }


    /**
     * Sets the valesDeDespensa value for this Comprobante33R.
     * 
     * @param valesDeDespensa
     */
    public void setValesDeDespensa(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ValesDeDespensaR valesDeDespensa) {
        this.valesDeDespensa = valesDeDespensa;
    }


    /**
     * Gets the vehiculoUsado value for this Comprobante33R.
     * 
     * @return vehiculoUsado
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VehiculoUsadoR getVehiculoUsado() {
        return vehiculoUsado;
    }


    /**
     * Sets the vehiculoUsado value for this Comprobante33R.
     * 
     * @param vehiculoUsado
     */
    public void setVehiculoUsado(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VehiculoUsadoR vehiculoUsado) {
        this.vehiculoUsado = vehiculoUsado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Comprobante33R)) return false;
        Comprobante33R other = (Comprobante33R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.addenda==null && other.getAddenda()==null) || 
             (this.addenda!=null &&
              this.addenda.equals(other.getAddenda()))) &&
            ((this.aerolineas==null && other.getAerolineas()==null) || 
             (this.aerolineas!=null &&
              this.aerolineas.equals(other.getAerolineas()))) &&
            ((this.CFDIRegistroFiscal==null && other.getCFDIRegistroFiscal()==null) || 
             (this.CFDIRegistroFiscal!=null &&
              this.CFDIRegistroFiscal.equals(other.getCFDIRegistroFiscal()))) &&
            ((this.certificadoDestruccion==null && other.getCertificadoDestruccion()==null) || 
             (this.certificadoDestruccion!=null &&
              this.certificadoDestruccion.equals(other.getCertificadoDestruccion()))) &&
            ((this.cfdiRelacionados==null && other.getCfdiRelacionados()==null) || 
             (this.cfdiRelacionados!=null &&
              this.cfdiRelacionados.equals(other.getCfdiRelacionados()))) &&
            ((this.claveCFDI==null && other.getClaveCFDI()==null) || 
             (this.claveCFDI!=null &&
              this.claveCFDI.equals(other.getClaveCFDI()))) &&
            ((this.comercioExterior==null && other.getComercioExterior()==null) || 
             (this.comercioExterior!=null &&
              this.comercioExterior.equals(other.getComercioExterior()))) &&
            ((this.conceptos==null && other.getConceptos()==null) || 
             (this.conceptos!=null &&
              java.util.Arrays.equals(this.conceptos, other.getConceptos()))) &&
            ((this.condicionesDePago==null && other.getCondicionesDePago()==null) || 
             (this.condicionesDePago!=null &&
              this.condicionesDePago.equals(other.getCondicionesDePago()))) &&
            ((this.confirmacion==null && other.getConfirmacion()==null) || 
             (this.confirmacion!=null &&
              this.confirmacion.equals(other.getConfirmacion()))) &&
            ((this.consumoDeCombustibles==null && other.getConsumoDeCombustibles()==null) || 
             (this.consumoDeCombustibles!=null &&
              this.consumoDeCombustibles.equals(other.getConsumoDeCombustibles()))) &&
            ((this.descuento==null && other.getDescuento()==null) || 
             (this.descuento!=null &&
              this.descuento.equals(other.getDescuento()))) &&
            ((this.divisas==null && other.getDivisas()==null) || 
             (this.divisas!=null &&
              this.divisas.equals(other.getDivisas()))) &&
            ((this.donatarias==null && other.getDonatarias()==null) || 
             (this.donatarias!=null &&
              this.donatarias.equals(other.getDonatarias()))) &&
            ((this.emisor==null && other.getEmisor()==null) || 
             (this.emisor!=null &&
              this.emisor.equals(other.getEmisor()))) &&
            ((this.estadoDeCuentaCombustible==null && other.getEstadoDeCuentaCombustible()==null) || 
             (this.estadoDeCuentaCombustible!=null &&
              this.estadoDeCuentaCombustible.equals(other.getEstadoDeCuentaCombustible()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.folio==null && other.getFolio()==null) || 
             (this.folio!=null &&
              this.folio.equals(other.getFolio()))) &&
            ((this.formaPago==null && other.getFormaPago()==null) || 
             (this.formaPago!=null &&
              this.formaPago.equals(other.getFormaPago()))) &&
            ((this.INE==null && other.getINE()==null) || 
             (this.INE!=null &&
              this.INE.equals(other.getINE()))) &&
            ((this.integranteCoordinado==null && other.getIntegranteCoordinado()==null) || 
             (this.integranteCoordinado!=null &&
              this.integranteCoordinado.equals(other.getIntegranteCoordinado()))) &&
            ((this.leyendasFiscales==null && other.getLeyendasFiscales()==null) || 
             (this.leyendasFiscales!=null &&
              this.leyendasFiscales.equals(other.getLeyendasFiscales()))) &&
            ((this.lugarExpedicion==null && other.getLugarExpedicion()==null) || 
             (this.lugarExpedicion!=null &&
              this.lugarExpedicion.equals(other.getLugarExpedicion()))) &&
            ((this.metodoPago==null && other.getMetodoPago()==null) || 
             (this.metodoPago!=null &&
              this.metodoPago.equals(other.getMetodoPago()))) &&
            ((this.moneda==null && other.getMoneda()==null) || 
             (this.moneda!=null &&
              this.moneda.equals(other.getMoneda()))) &&
            ((this.nomina==null && other.getNomina()==null) || 
             (this.nomina!=null &&
              java.util.Arrays.equals(this.nomina, other.getNomina()))) &&
            ((this.notariosPublicos==null && other.getNotariosPublicos()==null) || 
             (this.notariosPublicos!=null &&
              this.notariosPublicos.equals(other.getNotariosPublicos()))) &&
            ((this.obrasArteAntiguedades==null && other.getObrasArteAntiguedades()==null) || 
             (this.obrasArteAntiguedades!=null &&
              this.obrasArteAntiguedades.equals(other.getObrasArteAntiguedades()))) &&
            ((this.pagoEnEspecie==null && other.getPagoEnEspecie()==null) || 
             (this.pagoEnEspecie!=null &&
              this.pagoEnEspecie.equals(other.getPagoEnEspecie()))) &&
            ((this.pagos==null && other.getPagos()==null) || 
             (this.pagos!=null &&
              this.pagos.equals(other.getPagos()))) &&
            ((this.parcialesconstruccion==null && other.getParcialesconstruccion()==null) || 
             (this.parcialesconstruccion!=null &&
              this.parcialesconstruccion.equals(other.getParcialesconstruccion()))) &&
            ((this.receptor==null && other.getReceptor()==null) || 
             (this.receptor!=null &&
              this.receptor.equals(other.getReceptor()))) &&
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia()))) &&
            ((this.renovacionYSustitucionVehiculos==null && other.getRenovacionYSustitucionVehiculos()==null) || 
             (this.renovacionYSustitucionVehiculos!=null &&
              this.renovacionYSustitucionVehiculos.equals(other.getRenovacionYSustitucionVehiculos()))) &&
            ((this.SPEI==null && other.getSPEI()==null) || 
             (this.SPEI!=null &&
              this.SPEI.equals(other.getSPEI()))) &&
            ((this.serie==null && other.getSerie()==null) || 
             (this.serie!=null &&
              this.serie.equals(other.getSerie()))) &&
            ((this.subTotal==null && other.getSubTotal()==null) || 
             (this.subTotal!=null &&
              this.subTotal.equals(other.getSubTotal()))) &&
            ((this.tipoCambio==null && other.getTipoCambio()==null) || 
             (this.tipoCambio!=null &&
              this.tipoCambio.equals(other.getTipoCambio()))) &&
            ((this.total==null && other.getTotal()==null) || 
             (this.total!=null &&
              this.total.equals(other.getTotal()))) &&
            ((this.turistaPasajeroExtranjero==null && other.getTuristaPasajeroExtranjero()==null) || 
             (this.turistaPasajeroExtranjero!=null &&
              this.turistaPasajeroExtranjero.equals(other.getTuristaPasajeroExtranjero()))) &&
            ((this.valesDeDespensa==null && other.getValesDeDespensa()==null) || 
             (this.valesDeDespensa!=null &&
              this.valesDeDespensa.equals(other.getValesDeDespensa()))) &&
            ((this.vehiculoUsado==null && other.getVehiculoUsado()==null) || 
             (this.vehiculoUsado!=null &&
              this.vehiculoUsado.equals(other.getVehiculoUsado())));
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
        if (getAddenda() != null) {
            _hashCode += getAddenda().hashCode();
        }
        if (getAerolineas() != null) {
            _hashCode += getAerolineas().hashCode();
        }
        if (getCFDIRegistroFiscal() != null) {
            _hashCode += getCFDIRegistroFiscal().hashCode();
        }
        if (getCertificadoDestruccion() != null) {
            _hashCode += getCertificadoDestruccion().hashCode();
        }
        if (getCfdiRelacionados() != null) {
            _hashCode += getCfdiRelacionados().hashCode();
        }
        if (getClaveCFDI() != null) {
            _hashCode += getClaveCFDI().hashCode();
        }
        if (getComercioExterior() != null) {
            _hashCode += getComercioExterior().hashCode();
        }
        if (getConceptos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConceptos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConceptos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCondicionesDePago() != null) {
            _hashCode += getCondicionesDePago().hashCode();
        }
        if (getConfirmacion() != null) {
            _hashCode += getConfirmacion().hashCode();
        }
        if (getConsumoDeCombustibles() != null) {
            _hashCode += getConsumoDeCombustibles().hashCode();
        }
        if (getDescuento() != null) {
            _hashCode += getDescuento().hashCode();
        }
        if (getDivisas() != null) {
            _hashCode += getDivisas().hashCode();
        }
        if (getDonatarias() != null) {
            _hashCode += getDonatarias().hashCode();
        }
        if (getEmisor() != null) {
            _hashCode += getEmisor().hashCode();
        }
        if (getEstadoDeCuentaCombustible() != null) {
            _hashCode += getEstadoDeCuentaCombustible().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getFolio() != null) {
            _hashCode += getFolio().hashCode();
        }
        if (getFormaPago() != null) {
            _hashCode += getFormaPago().hashCode();
        }
        if (getINE() != null) {
            _hashCode += getINE().hashCode();
        }
        if (getIntegranteCoordinado() != null) {
            _hashCode += getIntegranteCoordinado().hashCode();
        }
        if (getLeyendasFiscales() != null) {
            _hashCode += getLeyendasFiscales().hashCode();
        }
        if (getLugarExpedicion() != null) {
            _hashCode += getLugarExpedicion().hashCode();
        }
        if (getMetodoPago() != null) {
            _hashCode += getMetodoPago().hashCode();
        }
        if (getMoneda() != null) {
            _hashCode += getMoneda().hashCode();
        }
        if (getNomina() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNomina());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNomina(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNotariosPublicos() != null) {
            _hashCode += getNotariosPublicos().hashCode();
        }
        if (getObrasArteAntiguedades() != null) {
            _hashCode += getObrasArteAntiguedades().hashCode();
        }
        if (getPagoEnEspecie() != null) {
            _hashCode += getPagoEnEspecie().hashCode();
        }
        if (getPagos() != null) {
            _hashCode += getPagos().hashCode();
        }
        if (getParcialesconstruccion() != null) {
            _hashCode += getParcialesconstruccion().hashCode();
        }
        if (getReceptor() != null) {
            _hashCode += getReceptor().hashCode();
        }
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        if (getRenovacionYSustitucionVehiculos() != null) {
            _hashCode += getRenovacionYSustitucionVehiculos().hashCode();
        }
        if (getSPEI() != null) {
            _hashCode += getSPEI().hashCode();
        }
        if (getSerie() != null) {
            _hashCode += getSerie().hashCode();
        }
        if (getSubTotal() != null) {
            _hashCode += getSubTotal().hashCode();
        }
        if (getTipoCambio() != null) {
            _hashCode += getTipoCambio().hashCode();
        }
        if (getTotal() != null) {
            _hashCode += getTotal().hashCode();
        }
        if (getTuristaPasajeroExtranjero() != null) {
            _hashCode += getTuristaPasajeroExtranjero().hashCode();
        }
        if (getValesDeDespensa() != null) {
            _hashCode += getValesDeDespensa().hashCode();
        }
        if (getVehiculoUsado() != null) {
            _hashCode += getVehiculoUsado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Comprobante33R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Comprobante33R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addenda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Addenda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AddendaCFDR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aerolineas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Aerolineas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AerolineasR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CFDIRegistroFiscal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CFDIRegistroFiscal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CFDIRegistroFiscalR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("certificadoDestruccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertificadoDestruccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertificadoDestruccionR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfdiRelacionados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionadosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveCFDI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveCFDI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comercioExterior");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExterior11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conceptos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Conceptos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condicionesDePago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CondicionesDePago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Confirmacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consumoDeCombustibles");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConsumoDeCombustibles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConsumoDeCombustiblesR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descuento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Descuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("divisas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Divisas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DivisaR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("donatarias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Donatarias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DonatariasR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Emisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EmisorR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoDeCuentaCombustible");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Folio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formaPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FormaPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "INE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "INER"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("integranteCoordinado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IntegranteCoordinado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IntegranteCoordinadoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leyendasFiscales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "LeyendasFiscales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "LeyendaFiscalR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lugarExpedicion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "LugarExpedicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metodoPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MetodoPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moneda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Moneda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomina");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Nomina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Nomina12R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Nomina12R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notariosPublicos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NotariosPublicos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NotariosPublicosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obrasArteAntiguedades");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ObrasArteAntiguedades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ObrasArteAntiguedadesR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagoEnEspecie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagoEnEspecie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagoEnEspecieR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Pagos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Pagos10R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parcialesconstruccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Parcialesconstruccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ParcialesConstruccionR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Receptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ReceptorR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Referencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renovacionYSustitucionVehiculos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RenovacionYSustitucionVehiculos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RenovacionYSustitucionVehiculosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SPEI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SPEI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SPEIR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Serie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCambio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoCambio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Total"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("turistaPasajeroExtranjero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TuristaPasajeroExtranjero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TuristaPasajeroExtranjeroR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valesDeDespensa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ValesDeDespensa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ValesDeDespensaR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculoUsado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoUsado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoUsadoR"));
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
