package com.canauhtli.cfdi.nomina;

public class ReciboCorreo {

	private String correo;
    private String pathPdf;
    private String xml;
    private String msg;
    private String nombre;
    private String error;
    private String numEmp;
    private boolean enviado;
	
    
    public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPathPdf() {
		return pathPdf;
	}
	public void setPathPdf(String pathPdf) {
		this.pathPdf = pathPdf;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public boolean isEnviado() {
		return enviado;
	}
	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}
	public String getNumEmp() {
		return numEmp;
	}
	public void setNumEmp(String numEmp) {
		this.numEmp = numEmp;
	}
}
