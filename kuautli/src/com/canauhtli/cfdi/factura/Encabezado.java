package com.canauhtli.cfdi.factura;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=0)
@Fields({
    @Field(name="encabezado", at=0, rid=true, literal="F")
})
public class Encabezado {

	@Field(at=1)
	private String pedido = "";
	
	@Field(at=2)
	private String pedidoCliente = "";
	
	@Field(at=3)
	private String modelo = "";
	
	@Field(at=4)
	private String serie = "";
	
	@Field(at=5)
	private String eco = "";
	
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public String getPedidoCliente() {
		return pedidoCliente;
	}
	public void setPedidoCliente(String pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getEco() {
		return eco;
	}
	public void setEco(String eco) {
		this.eco = eco;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("pedido:").append(pedido)
		  .append(", pedidoCliente:").append(pedidoCliente)
		  .append(", modelo:").append(modelo)
		  .append(", serie:").append(serie)
		  .append(", eco:").append(eco)
		  .append("]");
		
		return sb.toString();
	}
}
