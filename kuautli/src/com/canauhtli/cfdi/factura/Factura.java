package com.canauhtli.cfdi.factura;

import java.util.ArrayList;
import java.util.Date;

import com.canauhtli.cfdi.sat.cfd33.Comprobante;
import com.canauhtli.cfdi.tipo.Estatus;

public class Factura {

	private long idFactura;
	private String codigo;
	private Generales generales;
	private Receptor receptor;
	private Encabezado encabezado;
	private Impuesto impuesto;
	private Totales totales;
	private Extras extras;
	private ArrayList<ConceptoFac> conceptos = new ArrayList<ConceptoFac>();
	private ArrayList<ImpuestoConceptoFac> impuestos  = new ArrayList<ImpuestoConceptoFac>();
	private ArrayList<Comentario> comentarios  = new ArrayList<Comentario>();
	private ArrayList<Observacion> observaciones  = new ArrayList<Observacion>();
	private ArrayList<DescuentoRecargo> descuentos  = new ArrayList<DescuentoRecargo>();
	private ArrayList<Pago> pagos  = new ArrayList<Pago>();
	private ArrayList<DocumentoRelacionado> documentos  = new ArrayList<DocumentoRelacionado>();
	private ArrayList<ImpuestoPago> impuestosPago  = new ArrayList<ImpuestoPago>();
	private UuidRelacionado uuidRelacionado;
	private Estatus estatus;
	private String xml;
	private String uuid;
	private Comprobante cfdi;
	private String certSAT;
	private String selloSAT;
	private Date fechaTimbrado;
	
	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}
	
	public long getIdFactura() {
		return idFactura;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setGenerales(Generales generales) {
		this.generales = generales;
	}
	
	public Generales getGenerales() {
		return generales;
	}
	
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}
	
	public Receptor getReceptor() {
		return receptor;
	}
	
	public void setEncabezado(Encabezado encabezado) {
		this.encabezado = encabezado;
	}
	
	public Encabezado getEncabezado() {
		return encabezado;
	}
	
	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}
	
	public Impuesto getImpuesto() {
		return impuesto;
	}
	
	public void setTotales(Totales totales) {
		this.totales = totales;
	}
	
	public Totales getTotales() {
		return totales;
	}
	
	public void setExtras(Extras extras) {
		this.extras = extras;
	}
	
	public Extras getExtras() {
		return extras;
	}
	
	public void setConceptos(ArrayList<ConceptoFac> conceptos) {
		this.conceptos = conceptos;
	}
	
	public ArrayList<ConceptoFac> getConceptos() {
		return conceptos;
	}
	
	public void setObservaciones(ArrayList<Observacion> observaciones) {
		this.observaciones = observaciones;
	}
	
	public ArrayList<Observacion> getObservaciones() {
		return observaciones;
	}
	
	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCertSAT() {
		return certSAT;
	}

	public void setCertSAT(String certSAT) {
		this.certSAT = certSAT;
	}

	public String getSelloSAT() {
		return selloSAT;
	}

	public void setSelloSAT(String selloSAT) {
		this.selloSAT = selloSAT;
	}

	public Comprobante getCfdi() {
		return cfdi;
	}

	public void setCfdi(Comprobante cfdi) {
		this.cfdi = cfdi;
	}

	public Date getFechaTimbrado() {
		return fechaTimbrado;
	}

	public void setFechaTimbrado(Date fechaTimbrado) {
		this.fechaTimbrado = fechaTimbrado;
	}

	public UuidRelacionado getUuidRelacionado() {
		return uuidRelacionado;
	}

	public void setUuidRelacionado(UuidRelacionado uuidRelacionado) {
		this.uuidRelacionado = uuidRelacionado;
	}

	public void addConcepto(ConceptoFac concepto) {
		if (conceptos == null) {
			conceptos = new ArrayList<ConceptoFac>();
		}
		conceptos.add(concepto);
	}
	
	public void addObservacion(Observacion observacion) {
		if (observaciones == null) {
			observaciones = new ArrayList<Observacion>();
		}
		observaciones.add(observacion);
	}
	
	public void addDescuento(DescuentoRecargo descuento) {
		if (descuentos == null) {
			descuentos = new ArrayList<DescuentoRecargo>();
		}
		descuentos.add(descuento);
	}
	
	public void addPago(Pago pago) {
		if (pagos == null) {
			pagos = new ArrayList<Pago>();
		}
		pagos.add(pago);
	}
	
	public ArrayList<Pago> getPagos() {
		return pagos;
	}
	
	public void addDocumento(DocumentoRelacionado doc) {
		if (documentos == null) {
			documentos = new ArrayList<DocumentoRelacionado>();
		}
		documentos.add(doc);
	}
	
	public void addImpuestoPago(ImpuestoPago impuesto) {
		if (impuestosPago == null) {
			impuestosPago = new ArrayList<ImpuestoPago>();
		}
		impuestosPago.add(impuesto);
	}

	public void addImpuestoConcepto(ImpuestoConceptoFac impuesto) {
		if (impuestos == null) {
			impuestos = new ArrayList<ImpuestoConceptoFac>();
		}
		impuestos.add(impuesto);
	}
	
	public void addComentario(Comentario comentario) {
		if (comentarios == null) {
			comentarios = new ArrayList<Comentario>();
		}
		comentarios.add(comentario);
	}
	
	public void ajustaFactura() {
		if (conceptos != null) {
			if (impuestos != null) {
				for (ImpuestoConceptoFac ic : impuestos) {
					for (ConceptoFac c : conceptos) {
						if (c.getPartida() == ic.getPartida()) {
							c.addImpuesto(ic);
							break;
						}
					}
				}
			}
			if (comentarios != null) {
				for (Comentario com : comentarios) {
					for (ConceptoFac c : conceptos) {
						if (c.getPartida() == com.getPartida()) {
							c.addComentario(com);
							break;
						}
					}
				}
			}
			if (descuentos != null) {
				for (DescuentoRecargo dr : descuentos) {
					for (ConceptoFac c : conceptos) {
						if (c.getPartida() == dr.getPartida()) {
							c.addDescRec(dr);
							break;
						}
					}
				}
			}
			if ((pagos !=  null) & (documentos != null)) {
				for (DocumentoRelacionado doc : documentos) {
					for (Pago p : pagos) {
						if (p.getNumPago() == doc.getNumPago()) {
							p.addDocumento(doc);
							break;
						}
					}
				}
			}
			if ((pagos != null) & (impuestosPago != null)) {
				for (ImpuestoPago impuesto : impuestosPago) {
					for (Pago p : pagos) {
						if (p.getNumPago() == impuesto.getNumPago()) {
							p.setImpuestoPago(impuesto);
							break;
						}
					}
				}
			}
		}
	}
	
	public String getNombreArchivo() {
		String archivo = "";
		if (cfdi != null) {
			archivo = codigo + "F" + cfdi.getFolio();
		}
		return archivo; 
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Generales -> ").append(generales).append("\r\n")
		  .append("Receptor -> ").append(receptor).append("\r\n")
		  .append("Encabezado ->").append(encabezado).append("\r\n")
		  .append("Impuesto ->").append(impuesto).append("\r\n")
		  .append("Totales ->").append(totales).append("\r\n")
		  .append("Extras ->").append(extras).append("\r\n")
		  .append("Conceptos ->");
		for (ConceptoFac cf : conceptos) {
			sb.append(cf).append("\r\n");
			if (cf.getComentarios() != null) {
				for (Comentario c : cf.getComentarios()) {
					sb.append(" comentario -> ").append(c).append("\r\n");
				}
			}
		}
		sb.append("\r\n").append("Impuestos ->");
		for (ImpuestoConceptoFac icf : impuestos) {
			sb.append(icf);
		}
		sb.append("\r\n").append("Comentarios ->");
		for (Comentario c : comentarios) {
			sb.append(c);
		}
		sb.append("\r\n").append("Observaciones ->");
		for (Observacion o : observaciones) {
			sb.append(o);
		}
		sb.append("\r\n").append("Descuentos ->");
		for (DescuentoRecargo dr : descuentos) {
			sb.append(dr);
		}
		sb.append("\r\n").append("Pagos ->");
		for (Pago p : pagos) {
			sb.append(p);
		}
		sb.append("\r\n").append("Documentos ->");
		for (DocumentoRelacionado dr : documentos) {
			sb.append(dr);
		}
		sb.append("\r\n").append("ImpuestoPago ->");
		for (ImpuestoPago ip : impuestosPago) {
			sb.append(ip);
		}
		sb.append("\r\n").append("UUIDRelacionado -> ").append(uuidRelacionado);
		
		return sb.toString();
	}
}
