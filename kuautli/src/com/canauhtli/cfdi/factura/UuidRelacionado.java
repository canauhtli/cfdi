package com.canauhtli.cfdi.factura;

import java.util.ArrayList;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record
@Fields({
    @Field(name="relacionado", at=0, rid=true, literal="A")
})
public class UuidRelacionado {

	@Field(at=1, trim=true)
	private String tipoRelacion;
	
	@Field(at=2, collection=ArrayList.class, minOccurs=1, maxOccurs=-1)
	private ArrayList<String> lstUuids;

	public String getTipoRelacion() {
		return tipoRelacion;
	}

	public void setTipoRelacion(String tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}

	public ArrayList<String> getLstUuids() {
		return lstUuids;
	}

	public void setLstUuids(ArrayList<String> lstUuids) {
		this.lstUuids = lstUuids;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("tipoRelacion:").append(tipoRelacion);
		if (lstUuids != null) {
			for (String uuid : lstUuids) {
				sb.append(uuid).append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
}
