package com.canauhtli.cfdi.pac.bean;

import java.util.ArrayList;

public class Nomina {

	private String tipoNomina;
	private Empleado empleado;
	private String numRecibo;
	private double totalPercepciones;
	private double totalDeducciones;
	private double totalOtrasDeducciones;
	private double totalImpuestosRetenidos;
	private double totalOtrosPagos;
	private double totalSueldos;
	private double totalSeparacionIndemnizacion;
	private double totalJubilacionPensionRetiro;
	private Percepcion percepcionHoraExtra;
	private JubilacionPensionRetiro percepcionJubilacionPensionRetiro;
	private SeparacionIndemnizacion percepcionSeparacionIndeminizacion;
	private ArrayList<Percepcion> percepciones;
	private ArrayList<Percepcion> deducciones;
	private ArrayList<Incapacidad> incapacidades;
	private ArrayList<HoraExtra> horasExtra;
	private ArrayList<OtroPago> otrosPagos;
	
	public double getTotalPercepciones() {
		return totalPercepciones;
	}
	public void setTotalPercepciones(double totalPercepciones) {
		this.totalPercepciones = totalPercepciones;
	}
	public double getTotalDeducciones() {
		return totalDeducciones;
	}
	public void setTotalDeducciones(double totalDeducciones) {
		this.totalDeducciones = totalDeducciones;
	}
	public double getTotalOtrasDeducciones() {
		return totalOtrasDeducciones;
	}
	public void setTotalOtrasDeducciones(double totalOtrasDeducciones) {
		this.totalOtrasDeducciones = totalOtrasDeducciones;
	}
	public double getTotalImpuestosRetenidos() {
		return totalImpuestosRetenidos;
	}
	public void setTotalImpuestosRetenidos(double totalImpuestosRetenidos) {
		this.totalImpuestosRetenidos = totalImpuestosRetenidos;
	}
	public double getTotalOtrosPagos() {
		return totalOtrosPagos;
	}
	public void setTotalOtrosPagos(double totalOtrosPagos) {
		this.totalOtrosPagos = totalOtrosPagos;
	}
	public double getTotalSueldos() {
		return totalSueldos;
	}
	public void setTotalSueldos(double totalSueldos) {
		this.totalSueldos = totalSueldos;
	}
	public double getTotalSeparacionIndemnizacion() {
		return totalSeparacionIndemnizacion;
	}
	public void setTotalSeparacionIndemnizacion(double totalSeparacionIndemnizacion) {
		this.totalSeparacionIndemnizacion = totalSeparacionIndemnizacion;
	}
	public double getTotalJubilacionPensionRetiro() {
		return totalJubilacionPensionRetiro;
	}
	public void setTotalJubilacionPensionRetiro(double totalJubilacionPensionRetiro) {
		this.totalJubilacionPensionRetiro = totalJubilacionPensionRetiro;
	}
	public String getTipoNomina() {
		return tipoNomina;
	}
	public void setTipoNomina(String tipoNomina) {
		this.tipoNomina = tipoNomina;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public String getNumRecibo() {
		return numRecibo;
	}
	public void setNumRecibo(String numRecibo) {
		this.numRecibo = numRecibo;
	}
	public ArrayList<Percepcion> getPercepciones() {
		return percepciones;
	}
	public void setPercepciones(ArrayList<Percepcion> percepciones) {
		this.percepciones = percepciones;
	}
	public ArrayList<Percepcion> getDeducciones() {
		return deducciones;
	}
	public void setDeducciones(ArrayList<Percepcion> deducciones) {
		this.deducciones = deducciones;
	}
	public ArrayList<Incapacidad> getIncapacidades() {
		return incapacidades;
	}
	public void setIncapacidades(ArrayList<Incapacidad> incapacidades) {
		this.incapacidades = incapacidades;
	}
	public Percepcion getPercepcionHoraExtra() {
		return percepcionHoraExtra;
	}
	public void setPercepcionHoraExtra(Percepcion percepcionHoraExtra) {
		this.percepcionHoraExtra = percepcionHoraExtra;
	}
	public ArrayList<HoraExtra> getHorasExtra() {
		return horasExtra;
	}
	public void setHorasExtra(ArrayList<HoraExtra> horasExtra) {
		this.horasExtra = horasExtra;
	}
	public ArrayList<OtroPago> getOtrosPagos() {
		return otrosPagos;
	}
	public void setOtrosPagos(ArrayList<OtroPago> otrosPagos) {
		this.otrosPagos = otrosPagos;
	}
	public JubilacionPensionRetiro getPercepcionJubilacionPensionRetiro() {
		return percepcionJubilacionPensionRetiro;
	}
	public void setPercepcionJubilacionPensionRetiro(JubilacionPensionRetiro percepcionJubilacionPensionRetiro) {
		this.percepcionJubilacionPensionRetiro = percepcionJubilacionPensionRetiro;
	}
	public SeparacionIndemnizacion getPercepcionSeparacionIndemnizacion() {
		return percepcionSeparacionIndeminizacion;
	}
	public void setPercepcionSeparacionIndemnizacion(SeparacionIndemnizacion percepcionSeparacionIndemnizacion) {
		this.percepcionSeparacionIndeminizacion = percepcionSeparacionIndemnizacion;
	}
	 
	public void addPercepcion(Percepcion percepcion) {
        if (this.percepciones == null) {
            this.percepciones = new ArrayList<Percepcion>();
        }
        this.percepciones.add(percepcion);
    }
	
	public void addDeduccion(Percepcion deduccion) {
        if (this.deducciones == null) {
            this.deducciones = new ArrayList<Percepcion>();
        }
        this.deducciones.add(deduccion);
    }
	
	public void addIncapacidad(Incapacidad incapacidad) {
        if (this.incapacidades == null) {
            this.incapacidades = new ArrayList<Incapacidad>();
        }
        this.incapacidades.add(incapacidad);
    }
	
	public void addHoraExtra(HoraExtra horaExtra) {
        if (this.horasExtra == null) {
            this.horasExtra = new ArrayList<HoraExtra>();
        }
        this.horasExtra.add(horaExtra);
    }
	
	public void addOtroPago(OtroPago otroPago) {
		if (this.otrosPagos == null) {
			this.otrosPagos = new ArrayList<OtroPago>();
		}
		this.otrosPagos.add(otroPago);
	}
	
	public double getTotalGravadoPercepcion() {
        double tgp = 0.0;
        for (Percepcion p : this.percepciones) {
            tgp += p.getImporteGravado();
        }
        return tgp;
    }

    public double getTotalExcentoPercepcion() {
        double tep = 0.0;
        for (Percepcion p : this.percepciones) {
            tep += p.getImporteExento();
        }
        return tep;
    }

    public double getTotalGravadoDeduccion() {
        double tgd = 0.0;
        for (Percepcion d : this.deducciones) {
            tgd += d.getImporteGravado();
        }
        return tgd;
    }

    public double getTotalExcentoDeduccion() {
        double ted = 0.0;
        for (Percepcion d : this.deducciones) {
            ted += d.getImporteExento();
        }
        return ted;
    }
    
    public String toString() {
    	StringBuilder sb = new StringBuilder("Nomina [");
    	sb.append("tipoNomina=").append(tipoNomina)
    	  .append(empleado)
    	  .append(", numRecibo=").append(numRecibo)
    	  .append(", totalPercepciones=").append(totalPercepciones)
    	  .append(", totalDeducciones=").append(totalDeducciones)
    	  .append(", totalOtrosPagos=").append(totalOtrosPagos)
    	  .append(", totalSueldos=").append(totalSueldos)
    	  .append(", totalSeparacionIndeminizacion=").append(totalSeparacionIndemnizacion)
    	  .append(", totalJubilacionPensionRetiro=").append(totalJubilacionPensionRetiro)
    	  .append(", percepciones=").append(percepciones)
    	  .append(", deducciones=").append(deducciones)
    	  .append(", incapacidades=").append(incapacidades)
    	  .append(", horasExtra=").append(horasExtra)
    	  .append(", otrosPagos=").append(otrosPagos)
    	  .append("]");
        return sb.toString();
    }
}
