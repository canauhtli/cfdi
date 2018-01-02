package com.canauhtli.cfdi.pac;

import java.util.HashMap;
import java.util.List;

public interface ClienteServicioPAC {

	public String generaComprobante(ComprobanteFiscal cf) throws ClientePACException;
	
	public String cancelaComprobante(String var1) throws ClientePACException;
	
	public HashMap<String, String> cancelaComprobantes(List<String> var1) throws ClientePACException;
	
	/**
	 * 

    public ComprobanteFiscal extraeComprobante(String var1) throws CFDIException;

    public String buscaXML(String var1) throws CFDIException;
	 */
}
