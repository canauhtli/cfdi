package com.canauhtli.cfdi.nomina;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;

@Record(minOccurs=1)
@Fields({
    @Field(name="empleado", at=0, rid=true, literal="E")
})
public class EmpleadoNom {

	@Field(at=1, required=true, type=String.class, align=Align.RIGHT, trim=true)
	private String numEmp;
	
	@Field(at=2, required=true)
	private String curp;
	
	@Field(at=3, required=true, type=String.class)
	private String regimen;
	
	@Field(at=4, required=true, type=Date.class, format="yyyy-MM-dd")
	private Date fechaPago;
	
	@Field(at=5, required=true, type=Date.class, format="yyyy-MM-dd")
	private Date fechaIniPago;
	
	@Field(at=6, required=true, type=Date.class, format="yyyy-MM-dd")
	private Date fechaFinPago;
	
	@Field(at=7, required=true, type=Integer.class, align=Align.RIGHT, trim=true)
	private int numDiasPagados;
	
	@Field(at=8, required=true)
	private String periodicidad;
	
	@Field(at=9)
	private String nss;
	
	@Field(at=10)
	private String departamento;
	
	@Field(at=11)
	private String cuentaBancaria;
	
	@Field(at=12)
	private String banco;
	
	@Field(at=13, type=Date.class, format="yyyy-MM-dd")
	private Date fechaInicioRelLaboral;
	
	@Field(at=14)
	private String antiguedad;
	
	@Field(at=15)
	private String puesto;
	
	@Field(at=16)
	private String tipoContrato;
	
	@Field(at=17)
	private String tipoJornada;
	
	@Field(at=18, type=Double.class)
	private double salarioBase;
	
	@Field(at=19, type=String.class)
	private String riesgoPuesto;
	
	@Field(at=20, type=Double.class)
	private double salarioDiarioIntegrado;
	
	@Field(at=21)
	private String plaza;
	
	@Field(at=22)
	private String correo;
	
	@Field(at=23)
	private String sindicalizado;

//	private String nombre;
//	private String rfc;
//	private Direccion direccion;
	
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

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaIniPago() {
		return fechaIniPago;
	}

	public void setFechaIniPago(Date fechaIniPago) {
		this.fechaIniPago = fechaIniPago;
	}

	public Date getFechaFinPago() {
		return fechaFinPago;
	}

	public void setFechaFinPago(Date fechaFinPago) {
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

	public Date getFechaInicioRelLaboral() {
		return fechaInicioRelLaboral;
	}

	public void setFechaInicioRelLaboral(Date fechaInicioRelLaboral) {
		this.fechaInicioRelLaboral = fechaInicioRelLaboral;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
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

	public String toRecord() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sb = new StringBuilder("E|");
		sb.append(numEmp).append("|")
		  .append(curp).append("|")
		  .append(regimen).append("|")
		  .append(sdf.format(fechaPago)).append("|")
		  .append(sdf.format(fechaIniPago)).append("|")
		  .append(sdf.format(fechaFinPago)).append("|")
		  .append(numDiasPagados).append("|")
		  .append(periodicidad).append("|")
		  .append(nss).append("|")
		  .append(departamento).append("|")
		  .append(cuentaBancaria).append("|")
		  .append(banco).append("|")
		  .append(sdf.format(fechaInicioRelLaboral)).append("|")
		  .append(antiguedad).append("|")
		  .append(puesto).append("|")
		  .append(tipoContrato).append("|")
		  .append(tipoJornada).append("|")
		  .append(salarioBase).append("|")
		  .append(riesgoPuesto).append("|")
		  .append(salarioDiarioIntegrado).append("|")
		  .append(plaza).append("|")
		  .append(correo).append("|")
		  .append(sindicalizado);
		return sb.toString();
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sb = new StringBuilder("Empleado [");
		sb.append("numEmp=").append(numEmp).append(", ")
		  .append("curp=").append(curp).append(", ")
		  .append("regimen=").append(regimen).append(", ")
		  .append("fechaPago=").append(sdf.format(fechaPago)).append(", ")
		  .append("fechaIniPago=").append(sdf.format(fechaIniPago)).append(", ")
		  .append("fechaFinPago=").append(sdf.format(fechaFinPago)).append(", ")
		  .append("numDiasPagados=").append(numDiasPagados).append(", ")
		  .append("periodicidad=").append(periodicidad).append(", ")
		  .append("nss=").append(nss).append(", ")
		  .append("departamento=").append(departamento).append(", ")
		  .append("cuentaBancaria=").append(cuentaBancaria).append(", ")
		  .append("banco=").append(banco).append(", ")
		  .append("fechaInicioRelLaboral=").append(sdf.format(fechaInicioRelLaboral)).append(", ")
		  .append("antiguedad=").append(antiguedad).append(", ")
		  .append("puesto=").append(puesto).append(", ")
		  .append("tipoContrato=").append(tipoContrato).append(", ")
		  .append("tipoJornada=").append(tipoJornada).append(", ")
		  .append("salarioBase=").append(salarioBase).append(", ")
		  .append("riesgoPuesto=").append(riesgoPuesto).append(", ")
		  .append("salarioDiarioIntegrado=").append(salarioDiarioIntegrado).append(", ")
		  .append("plaza=").append(plaza).append(", ")
		  .append("correo=").append(correo).append(", ")
		  .append("sindicalizado=").append(sindicalizado).append("]");
		return sb.toString();
		
	}
	
}
