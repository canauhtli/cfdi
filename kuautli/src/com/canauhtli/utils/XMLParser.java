package com.canauhtli.utils;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Node;

import com.canauhtli.cfdi.CFDIException;
import com.canauhtli.cfdi.sat.cfd33.Comprobante;
import com.canauhtli.cfdi.sat.timbre11.TimbreFiscalDigital;

public class XMLParser {

	public static Comprobante parseCfdi(String cfdi) throws CFDIException {
		Comprobante comprobante = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Comprobante.class.getPackage().getName());
			Unmarshaller um = context.createUnmarshaller();
			comprobante = (Comprobante)um.unmarshal(new StringReader(cfdi));
		} catch (JAXBException e) {
			throw new CFDIException("No pude interpretar el cfdi solicitado");
		}
		
		return comprobante;
	}
	
	public static TimbreFiscalDigital parseTimbreFiscal(Node timbre) throws CFDIException {
		TimbreFiscalDigital timbreFiscal = null;
		try {
			JAXBContext context = JAXBContext.newInstance(TimbreFiscalDigital.class.getPackage().getName());
			Unmarshaller um = context.createUnmarshaller();
			timbreFiscal = (TimbreFiscalDigital) um.unmarshal(timbre);
		} catch (JAXBException e) {
			throw new CFDIException("No pude interpretar el timbre fical solicitado");
		}
		
		return timbreFiscal;
	}
}
