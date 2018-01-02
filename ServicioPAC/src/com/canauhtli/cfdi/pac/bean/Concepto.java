package com.canauhtli.cfdi.pac.bean;

import java.util.ArrayList;
import java.util.List;

public class Concepto {

	private double cantidad;
    private String unidad;
    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private int partida;
    private double precioLista;
    private double importeLista;
    private double importe;
    
    private ArrayList<Comentario> comentarios;
    private ArrayList<DescuentoRecargo> descRecs;
    
    private double descuento;
    private String claveProdServ;
    private String claveUnidad;
    
    private ArrayList<ImpuestoConcepto> impuestos;
    
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
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getPartida() {
		return partida;
	}
	public void setPartida(int partida) {
		this.partida = partida;
	}
	public double getPrecioLista() {
		return precioLista;
	}
	public void setPrecioLista(double precioLista) {
		this.precioLista = precioLista;
	}
	public double getImporteLista() {
		return importeLista;
	}
	public void setImporteLista(double importeLista) {
		this.importeLista = importeLista;
	}
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public ArrayList<DescuentoRecargo> getDescRecs() {
		return descRecs;
	}
	public void setDescRecs(ArrayList<DescuentoRecargo> descRecs) {
		this.descRecs = descRecs;
	}
    public double getDescuento() {
    	return descuento;
    }
    public void setDescuento(double descuento) {
    	this.descuento = descuento;
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
	
	public void addComentario(Comentario comentario) {
        if (this.comentarios == null) {
            this.comentarios = new ArrayList<Comentario>();
        }
        this.comentarios.add(comentario);
    }
	
	public void addDescRecs(DescuentoRecargo descRec) {
        if (this.descRecs == null) {
            this.descRecs = new ArrayList<DescuentoRecargo>();
        }
        this.descRecs.add(descRec);
    }

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public double getImporte() {
        return importe;
    }
	
	public void setImpuestos(ArrayList<ImpuestoConcepto> impuestos) {
		this.impuestos = impuestos; 
	}
	
	public List<ImpuestoConcepto> getImpuestos() {
		return impuestos;
	}
	
	public void addImpuesto(ImpuestoConcepto impuesto) {
		if (impuestos == null) {
			impuestos = new ArrayList<ImpuestoConcepto>();
		}
		impuestos.add(impuesto);
	}
	
    public String toString() {
    	StringBuilder sb = new StringBuilder("Concepto [");
    	sb.append("cantidad=").append(cantidad)
    	  .append(", unidad=").append(unidad)
    	  .append(", descripcion=").append(descripcion)
    	  .append(", valorUnitario=").append(precioUnitario).append("]");
    	return sb.toString();
    }
}
