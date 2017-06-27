package com.canauhtli.utils;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

public class JsonTools {
	
	private JAXBContext jc;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	@SuppressWarnings("rawtypes")
	private Class cls;
	
	@SuppressWarnings("rawtypes")
	public JsonTools(Class cls) throws JAXBException {
		this.cls = cls;
		jc = JAXBContext.newInstance(cls);
		marshaller = jc.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller = jc.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
	}

	public String toJsonString(Object element) throws JAXBException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		marshaller.marshal(element, stream);
		return stream.toString();
		
	}
	
	@SuppressWarnings("unchecked")
	public Object fromJsonString(String json) throws JAXBException {
		StreamSource src = new StreamSource(new StringReader(json));
		Object rne = unmarshaller.unmarshal(src, cls).getValue();
		return rne;
	}
}
