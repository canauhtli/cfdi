/**
 * InformacionFiscalTerceroR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class InformacionFiscalTerceroR  implements java.io.Serializable {
    private java.lang.String calle;

    private java.lang.String codigoPostal;

    private java.lang.String colonia;

    private java.lang.String estado;

    private java.lang.String localidad;

    private java.lang.String municipio;

    private java.lang.String noExterior;

    private java.lang.String noInterior;

    private java.lang.String pais;

    private java.lang.String referencia;

    public InformacionFiscalTerceroR() {
    }

    public InformacionFiscalTerceroR(
           java.lang.String calle,
           java.lang.String codigoPostal,
           java.lang.String colonia,
           java.lang.String estado,
           java.lang.String localidad,
           java.lang.String municipio,
           java.lang.String noExterior,
           java.lang.String noInterior,
           java.lang.String pais,
           java.lang.String referencia) {
           this.calle = calle;
           this.codigoPostal = codigoPostal;
           this.colonia = colonia;
           this.estado = estado;
           this.localidad = localidad;
           this.municipio = municipio;
           this.noExterior = noExterior;
           this.noInterior = noInterior;
           this.pais = pais;
           this.referencia = referencia;
    }


    /**
     * Gets the calle value for this InformacionFiscalTerceroR.
     * 
     * @return calle
     */
    public java.lang.String getCalle() {
        return calle;
    }


    /**
     * Sets the calle value for this InformacionFiscalTerceroR.
     * 
     * @param calle
     */
    public void setCalle(java.lang.String calle) {
        this.calle = calle;
    }


    /**
     * Gets the codigoPostal value for this InformacionFiscalTerceroR.
     * 
     * @return codigoPostal
     */
    public java.lang.String getCodigoPostal() {
        return codigoPostal;
    }


    /**
     * Sets the codigoPostal value for this InformacionFiscalTerceroR.
     * 
     * @param codigoPostal
     */
    public void setCodigoPostal(java.lang.String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    /**
     * Gets the colonia value for this InformacionFiscalTerceroR.
     * 
     * @return colonia
     */
    public java.lang.String getColonia() {
        return colonia;
    }


    /**
     * Sets the colonia value for this InformacionFiscalTerceroR.
     * 
     * @param colonia
     */
    public void setColonia(java.lang.String colonia) {
        this.colonia = colonia;
    }


    /**
     * Gets the estado value for this InformacionFiscalTerceroR.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this InformacionFiscalTerceroR.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the localidad value for this InformacionFiscalTerceroR.
     * 
     * @return localidad
     */
    public java.lang.String getLocalidad() {
        return localidad;
    }


    /**
     * Sets the localidad value for this InformacionFiscalTerceroR.
     * 
     * @param localidad
     */
    public void setLocalidad(java.lang.String localidad) {
        this.localidad = localidad;
    }


    /**
     * Gets the municipio value for this InformacionFiscalTerceroR.
     * 
     * @return municipio
     */
    public java.lang.String getMunicipio() {
        return municipio;
    }


    /**
     * Sets the municipio value for this InformacionFiscalTerceroR.
     * 
     * @param municipio
     */
    public void setMunicipio(java.lang.String municipio) {
        this.municipio = municipio;
    }


    /**
     * Gets the noExterior value for this InformacionFiscalTerceroR.
     * 
     * @return noExterior
     */
    public java.lang.String getNoExterior() {
        return noExterior;
    }


    /**
     * Sets the noExterior value for this InformacionFiscalTerceroR.
     * 
     * @param noExterior
     */
    public void setNoExterior(java.lang.String noExterior) {
        this.noExterior = noExterior;
    }


    /**
     * Gets the noInterior value for this InformacionFiscalTerceroR.
     * 
     * @return noInterior
     */
    public java.lang.String getNoInterior() {
        return noInterior;
    }


    /**
     * Sets the noInterior value for this InformacionFiscalTerceroR.
     * 
     * @param noInterior
     */
    public void setNoInterior(java.lang.String noInterior) {
        this.noInterior = noInterior;
    }


    /**
     * Gets the pais value for this InformacionFiscalTerceroR.
     * 
     * @return pais
     */
    public java.lang.String getPais() {
        return pais;
    }


    /**
     * Sets the pais value for this InformacionFiscalTerceroR.
     * 
     * @param pais
     */
    public void setPais(java.lang.String pais) {
        this.pais = pais;
    }


    /**
     * Gets the referencia value for this InformacionFiscalTerceroR.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this InformacionFiscalTerceroR.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InformacionFiscalTerceroR)) return false;
        InformacionFiscalTerceroR other = (InformacionFiscalTerceroR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.calle==null && other.getCalle()==null) || 
             (this.calle!=null &&
              this.calle.equals(other.getCalle()))) &&
            ((this.codigoPostal==null && other.getCodigoPostal()==null) || 
             (this.codigoPostal!=null &&
              this.codigoPostal.equals(other.getCodigoPostal()))) &&
            ((this.colonia==null && other.getColonia()==null) || 
             (this.colonia!=null &&
              this.colonia.equals(other.getColonia()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.localidad==null && other.getLocalidad()==null) || 
             (this.localidad!=null &&
              this.localidad.equals(other.getLocalidad()))) &&
            ((this.municipio==null && other.getMunicipio()==null) || 
             (this.municipio!=null &&
              this.municipio.equals(other.getMunicipio()))) &&
            ((this.noExterior==null && other.getNoExterior()==null) || 
             (this.noExterior!=null &&
              this.noExterior.equals(other.getNoExterior()))) &&
            ((this.noInterior==null && other.getNoInterior()==null) || 
             (this.noInterior!=null &&
              this.noInterior.equals(other.getNoInterior()))) &&
            ((this.pais==null && other.getPais()==null) || 
             (this.pais!=null &&
              this.pais.equals(other.getPais()))) &&
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia())));
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
        if (getCalle() != null) {
            _hashCode += getCalle().hashCode();
        }
        if (getCodigoPostal() != null) {
            _hashCode += getCodigoPostal().hashCode();
        }
        if (getColonia() != null) {
            _hashCode += getColonia().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getLocalidad() != null) {
            _hashCode += getLocalidad().hashCode();
        }
        if (getMunicipio() != null) {
            _hashCode += getMunicipio().hashCode();
        }
        if (getNoExterior() != null) {
            _hashCode += getNoExterior().hashCode();
        }
        if (getNoInterior() != null) {
            _hashCode += getNoInterior().hashCode();
        }
        if (getPais() != null) {
            _hashCode += getPais().hashCode();
        }
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InformacionFiscalTerceroR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionFiscalTerceroR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "calle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoPostal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "codigoPostal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("colonia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "colonia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "localidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("municipio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "municipio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noExterior");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "noExterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noInterior");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "noInterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pais");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "pais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "referencia"));
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
