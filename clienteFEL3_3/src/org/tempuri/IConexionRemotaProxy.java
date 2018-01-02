package org.tempuri;

public class IConexionRemotaProxy implements org.tempuri.IConexionRemota {
  private String _endpoint = null;
  private org.tempuri.IConexionRemota iConexionRemota = null;
  
  public IConexionRemotaProxy() {
    _initIConexionRemotaProxy();
  }
  
  public IConexionRemotaProxy(String endpoint) {
    _endpoint = endpoint;
    _initIConexionRemotaProxy();
  }
  
  private void _initIConexionRemotaProxy() {
    try {
      iConexionRemota = (new org.tempuri.ConexionRemotaLocator()).getsoapHttpEndpoint();
      if (iConexionRemota != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iConexionRemota)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iConexionRemota)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iConexionRemota != null)
      ((javax.xml.rpc.Stub)iConexionRemota)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.IConexionRemota getIConexionRemota() {
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota;
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIs(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String[] uuids) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.cancelarCFDIs(credenciales, uuids);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR generarCFDI(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R cfdi) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.generarCFDI(credenciales, cfdi);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR generarTicket(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R ticket) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.generarTicket(credenciales, ticket);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR enviarCFDI(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String email, java.lang.String titulo, java.lang.String mensaje, java.lang.String nombrePlantilla) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.enviarCFDI(credenciales, uuid, email, titulo, mensaje, nombrePlantilla);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerPDF(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String nombrePlantilla) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerPDF(credenciales, uuid, nombrePlantilla);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorReferencia(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String referencia) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerXMLPorReferencia(credenciales, referencia);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorUUID(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales crendeciales, java.lang.String uuid) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerXMLPorUUID(crendeciales, uuid);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR obtenerNumerosCreditos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerNumerosCreditos(credenciales);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR obtenerComprobantes(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerComprobantes(credenciales, fechaInicial, fechaFinal, filaInicial);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerAcuseEnvio(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerAcuseEnvio(credenciales, uuid);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerAcuseCancelacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerAcuseCancelacion(credenciales, uuid);
  }
  
  
}