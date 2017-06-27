package com.canauhtli.cfdi.reportes;

public class PercepcionDeduccion {

	private String perClave = "";
    private String perConcepto = "";
    private String perImporte = "";
    private String dedClave = "";
    private String dedConcepto = "";
    private String dedImporte = "";

    public String getPerClave() {
        return this.perClave;
    }

    public void setPerClave(String perClave) {
        this.perClave = perClave;
    }

    public String getPerConcepto() {
        return this.perConcepto;
    }

    public void setPerConcepto(String perConcepto) {
        this.perConcepto = perConcepto;
    }

    public String getPerImporte() {
        return this.perImporte;
    }

    public void setPerImporte(String perImporte) {
        this.perImporte = perImporte;
    }

    public String getDedClave() {
        return this.dedClave;
    }

    public void setDedClave(String dedClave) {
        this.dedClave = dedClave;
    }

    public String getDedConcepto() {
        return this.dedConcepto;
    }

    public void setDedConcepto(String dedConcepto) {
        this.dedConcepto = dedConcepto;
    }

    public String getDedImporte() {
        return this.dedImporte;
    }

    public void setDedImporte(String dedImporte) {
        this.dedImporte = dedImporte;
    }
}
