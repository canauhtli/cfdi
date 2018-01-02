package com.canauhtli.cfdi.pac.types;

public enum TipoCFD {

	FACTURA("factura"),
    NOTACREDITO("nota credito"),
    NOTADEBITO("nota debito"),
    RECIBO("recibo"),
    PAGO("pago"),
    NOMINA("nomina");
    
    private String tipo;

    private TipoCFD(String tipo) {
        this.tipo = tipo;
    }

    public static TipoCFD fromTipo(String t) {
        TipoCFD tipo = null;
        
        for (TipoCFD tp : TipoCFD.values()) {
        	if (tp.getTipo().equalsIgnoreCase(t)) {
        		tipo = tp;
        		break;
        	}
        }
        
        return tipo;
    }

    public String getTipo() {
        return this.tipo;
    }
}
