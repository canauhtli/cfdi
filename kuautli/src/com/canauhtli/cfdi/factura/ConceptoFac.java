package com.canauhtli.cfdi.factura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record(minOccurs=1)
@Fields({
    @Field(name="concepto", at=0, rid=true, literal="D")
})
public class ConceptoFac {

	@Field(at=1, trim=true)
	private int partida;
	
	@Field(at=2, trim=true)
	private double cantidad;
	
	@Field(at=3)
	private String unidad;
	
	@Field(at=4)
	private String codigo;
	
	@Field(at=5)
	private String descripcion;
	
	@Field(at=6)
	private double precio;
	
	@Field(at=7)
	private double importe;
	
	@Field(at=8, minOccurs=0)
	private String comentario;
	
	@Field(at=9)
	private String claveProdServ;
	
	@Field(at=10)
	private String claveUnidad;
	
	@Field(at=11, minOccurs=0)
	private double descuento;

	private ArrayList<ImpuestoConceptoFac> impuestos;
	private ArrayList<Comentario> comentarios;
	private ArrayList<DescuentoRecargo> descRecs;
	
	public int getPartida() {
		return partida;
	}

	public void setPartida(int partida) {
		this.partida = partida;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getClaveProdServ() {
		return claveProdServ;
	}

	public void setClaveProdServ(String claveProdServ) {
		this.claveProdServ = claveProdServ;
	}

	public String getClaveUnidad() {
		return claveUnidad;
	}

	public void setClaveUnidad(String claveUnidad) {
		this.claveUnidad = claveUnidad;
	}
	
	public double getDescuento() {
		return descuento;
	}
	
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public List<ImpuestoConceptoFac> getImpuestos() {
		return impuestos;
	}
	
	public void setImpuestos(ArrayList<ImpuestoConceptoFac> impuestos) {
		this.impuestos = impuestos;
	}
	
	public void addImpuesto(ImpuestoConceptoFac impuesto) {
		if (impuestos == null) {
			impuestos = new ArrayList<ImpuestoConceptoFac>();
		}
		impuestos.add(impuesto);
	}
	
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void addComentario(Comentario comentario) {
		if (comentarios == null) {
			comentarios = new ArrayList<Comentario>();
		}
		comentarios.add(comentario);
	}
	
	public ArrayList<DescuentoRecargo> getDescRecs() {
		return descRecs;
	}
	
	public void setDescRecs(ArrayList<DescuentoRecargo> descRecs) {
		this.descRecs = descRecs;
	}
	
	public void addDescRec(DescuentoRecargo descuentoRecargo) {
		if (descRecs == null) {
			descRecs = new ArrayList<DescuentoRecargo>();
		}
		descRecs.add(descuentoRecargo);
	}
	
	public ArrayList<Comentario> getPreComs() {
		ArrayList<Comentario> coms = new ArrayList<Comentario>();
		if (this.comentarios != null) {
			for (Comentario c : this.comentarios) {
				if (!c.isPosicion()) {
					coms.add(c);
				}
			}
		}
		Collections.sort(coms);
		return coms;
	}
	
	public ArrayList<Comentario> getPostComs() {
		ArrayList<Comentario> coms = new ArrayList<Comentario>();
		if (this.comentarios != null) {
			for (Comentario c : this.comentarios) {
				if (c.isPosicion()) {
					coms.add(c);
				}
			}
		}
		Collections.sort(coms);
		return coms;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("partida:").append(partida)
		  .append(", cantidad:").append(cantidad)
		  .append(", unidad:").append(unidad)
		  .append(", codigo:").append(codigo)
		  .append(", descripcion:").append(descripcion)
		  .append(", precio:").append(precio)
		  .append(", importe:").append(importe)
		  .append(", comentario:").append(comentario)
		  .append(", claveProdServ:").append(claveProdServ)
		  .append(", claveUnidad:").append(claveUnidad)
		  .append(", descuento:").append(descuento)
		  .append("]");
		
		return sb.toString();
	}
}
