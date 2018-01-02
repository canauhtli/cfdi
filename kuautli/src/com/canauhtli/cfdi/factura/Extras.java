package com.canauhtli.cfdi.factura;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=1)
@Fields({
    @Field(name="extras", at=0, rid=true, literal="M")
})
public class Extras {

	@Field(at=1)
	private String correo;
	
	@Field(at=2)
	private String formaPago;
	
	@Field(at=3)
	private String metodoPago;
	
	@Field(at=4)
	private String usoCFDI;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	
	public String getUsoCFDI() {
		return usoCFDI;
	}
	
	public void setUsoCFDI(String usoCFDI) {
		this.usoCFDI = usoCFDI;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("correo:").append(correo)
		  .append(", formaPago:").append(formaPago)
		  .append(", metodoPago:").append(metodoPago)
		  .append(", usoCFDI:").append(usoCFDI)
		  .append("]");
		
		return sb.toString();
	}
}
