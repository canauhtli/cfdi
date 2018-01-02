package com.canauhtli.cfdi.pac.bean;

import java.util.Calendar;

public class Empleado {

	private String numEmp;
    private String curp;
    private String regimen;
    private Calendar fechaPago;
    private Calendar fechaIniPago;
    private Calendar fechaFinPago;
    private int numDiasPagados;
    private String periodicidad;
    private String nss;
    private String departamento;
    private String cuentaBancaria;
    private String banco;
    private Calendar fechaInicioRelLaboral;
    private String antiguedad;
    private String codigoAntiguedad;
    private String puesto;
    private String tipoContrato;
    private String tipoJornada;
    private double salarioBase;
    private String riesgoPuesto;
    private double salarioDiarioIntegrado;
    private String nombre;
    private String rfc;
    private Direccion direccion;
    private String plaza;
    private String correo;
    private String sindicalizado;
    
	public String getNumEmp() {
		return numEmp;
	}
	public void setNumEmp(String numEmp) {
		this.numEmp = numEmp;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getRegimen() {
		return regimen;
	}
	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}
	public Calendar getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Calendar fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Calendar getFechaIniPago() {
		return fechaIniPago;
	}
	public void setFechaIniPago(Calendar fechaIniPago) {
		this.fechaIniPago = fechaIniPago;
	}
	public Calendar getFechaFinPago() {
		return fechaFinPago;
	}
	public void setFechaFinPago(Calendar fechaFinPago) {
		this.fechaFinPago = fechaFinPago;
	}
	public int getNumDiasPagados() {
		return numDiasPagados;
	}
	public void setNumDiasPagados(int numDiasPagados) {
		this.numDiasPagados = numDiasPagados;
	}
	public String getPeriodicidad() {
		return periodicidad;
	}
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}
	public String getNss() {
		return nss;
	}
	public void setNss(String nss) {
		this.nss = nss;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public Calendar getFechaInicioRelLaboral() {
		return fechaInicioRelLaboral;
	}
	public void setFechaInicioRelLaboral(Calendar fechaInicioRelLaboral) {
		this.fechaInicioRelLaboral = fechaInicioRelLaboral;
	}
	public String getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}
	public String getCodigoAntiguedad() {
		return codigoAntiguedad;
	}
	public void setCodigoAntiguedad(String codigoAntiguedad) {
		this.codigoAntiguedad = codigoAntiguedad;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getTipoJornada() {
		return tipoJornada;
	}
	public void setTipoJornada(String tipoJornada) {
		this.tipoJornada = tipoJornada;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public String getRiesgoPuesto() {
		return riesgoPuesto;
	}
	public void setRiesgoPuesto(String riesgoPuesto) {
		this.riesgoPuesto = riesgoPuesto;
	}
	public double getSalarioDiarioIntegrado() {
		return salarioDiarioIntegrado;
	}
	public void setSalarioDiarioIntegrado(double salarioDiarioIntegrado) {
		this.salarioDiarioIntegrado = salarioDiarioIntegrado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getPlaza() {
		return plaza;
	}
	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getSindicalizado() {
		return sindicalizado;
	}
	public void setSindicalizado(String sindicalizado) {
		this.sindicalizado = sindicalizado;
	}
    
	public String toString() {
		StringBuilder sb = new StringBuilder("Empleado [");
		sb.append("numEmp=").append(numEmp)
		  .append(", curp=").append(curp)
		  .append(", regimen=").append(regimen)
		  .append(",fechaPago=").append(fechaPago)
		  .append(", fechaIniPago=").append(fechaIniPago)
		  .append(", fechaFinPago=").append(fechaFinPago)
		  .append(", numDiasPagados=").append(numDiasPagados)
		  .append(", periodicidad=").append(periodicidad)
		  .append(", nss=").append(nss)
		  .append(", departamento=").append(departamento)
		  .append(", cuentaBancaria=").append(cuentaBancaria)
		  .append(", banco=").append(banco)
		  .append(", fechaInicioRelLaboral=").append(fechaInicioRelLaboral)
		  .append(", antiguedad=").append(antiguedad)
		  .append(", puesto=").append(puesto)
		  .append(", tipoContrato=").append(tipoContrato)
		  .append(", tipoJornada=").append(tipoJornada)
		  .append(", salarioBase=").append(salarioBase)
		  .append(", riesgoPuesto=").append(riesgoPuesto)
		  .append(", salarioDiarioIntegrado=").append(salarioDiarioIntegrado)
		  .append(", nombre=").append(nombre)
		  .append(", rfc=").append(rfc)
		  .append(", ").append(direccion)
		  .append(", plaza=").append(plaza)
		  .append(", correo=").append(correo)
		  .append(", sindicalizado=").append(sindicalizado).append("]");
		  
        return sb.toString();
    }
}
