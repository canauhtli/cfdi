/**
 * NombreImpuestoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class NombreImpuestoR  implements java.io.Serializable {
    private java.lang.String nombreImpuesto;

    public NombreImpuestoR() {
    }

    public NombreImpuestoR(
           java.lang.String nombreImpuesto) {
           this.nombreImpuesto = nombreImpuesto;
    }


    /**
     * Gets the nombreImpuesto value for this NombreImpuestoR.
     * 
     * @return nombreImpuesto
     */
    public java.lang.String getNombreImpuesto() {
        return nombreImpuesto;
    }


    /**
     * Sets the nombreImpuesto value for this NombreImpuestoR.
     * 
     * @param nombreImpuesto
     */
    public void setNombreImpuesto(java.lang.String nombreImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NombreImpuestoR)) return false;
        NombreImpuestoR other = (NombreImpuestoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nombreImpuesto==null && other.getNombreImpuesto()==null) || 
             (this.nombreImpuesto!=null &&
              this.nombreImpuesto.equals(other.getNombreImpuesto())));
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
        if (getNombreImpuesto() != null) {
            _hashCode += getNombreImpuesto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NombreImpuestoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreImpuestoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreImpuesto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreImpuesto"));
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
