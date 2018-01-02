package com.canauhtli.cfdi.factura;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record
@Fields({
    @Field(name="impuestoConcepto", at=0, rid=true, literal="J")
})
public class ImpuestoConceptoFac {

	@Field(at=1)
	private int partida;
	
	@Field(at=2)
	private String tipo;
	
	@Field(at=3)
	private double base;
	
	@Field(at=4)
	private double importe;
	
	@Field(at=5)
	private String impuesto;
	
	@Field(at=6)
	private String tasaOCuota;
	
	@Field(at=7)
	private String tipoFactor;

	public int getPartida() {
		return partida;
	}

	public void setPartida(int partida) {
		this.partida = partida;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}

	public String getTasaOCuota() {
		return tasaOCuota;
	}

	public void setTasaOCuota(String tasaOCuota) {
		this.tasaOCuota = tasaOCuota;
	}

	public String getTipoFactor() {
		return tipoFactor;
	}

	public void setTipoFactor(String tipoFactor) {
		this.tipoFactor = tipoFactor;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append("partida:").append(partida)
		  .append(", tipo:").append(tipo)
		  .append(", base:").append(base)
		  .append(", importe:").append(importe)
		  .append(", impuesto:").append(impuesto)
		  .append(", tasaOCuota:").append(tasaOCuota)
		  .append(", tipoFactor:").append(tipoFactor)
		  .append("]");
	
		return sb.toString();
	}
}
