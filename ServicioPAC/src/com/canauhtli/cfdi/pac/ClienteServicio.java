package com.canauhtli.cfdi.pac;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public abstract class ClienteServicio implements ClienteServicioPAC {
	
	protected URL url = null;
	protected Map<String, String> config;

    public ClienteServicio(Map<String, String> config)  throws ClientePACException {
    	this.config = config;
    	try {
            this.url = new URL(config.get("url"));
        }
        catch (MalformedURLException e) {
            throw new ClientePACException("URL del servicio mal formado", e);
        }
    }

}
