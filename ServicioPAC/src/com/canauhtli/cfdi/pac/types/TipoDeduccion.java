package com.canauhtli.cfdi.pac.types;

public enum TipoDeduccion {

    _001("001", "Seguridad social"),
    _002("002", "ISR"),
    _003("003", "Aportaciones a retiro, cesant\u00eda en edad avanzada y vejez."),
    _004("004", "Otros"),
    _005("005", "Aportaciones a Fondo de vivienda"),
    _006("006", "Descuento por incapacidad"),
    _007("007", "Pensi\u00f3n alimenticia"),
    _008("008", "Renta"),
    _009("009", "Pr\u00e9stamos provenientes del Fondo Nacional de la Vivienda para los Trabajadores"),
    _010("010", "Pago por cr\u00e9dito de vivienda"),
    _011("011", "Pago de abonos INFONACOT"),
    _012("012", "Anticipo de salarios"),
    _013("013", "Pagos hechos con exceso al trabajador"),
    _014("014", "Errores"),
    _015("015", "P\u00e9rdidas"),
    _016("016", "Aver\u00edas"),
    _017("017", "Adquisici\u00f3n de art\u00edculos producidos por la empresa o establecimiento"),
    _018("018", "Cuotas para la constituci\u00f3n y fomento de sociedades cooperativas y de cajas de ahorro"),
    _019("019", "Cuotas sindicales"),
    _020("020", "Ausencia (Ausentismo)"),
    _021("021", "Cuotas obrero patronales");
    
    private String descripcion;
    private String clave;

    private TipoDeduccion(String clave, String descripcion) {
        this.descripcion = (String)descripcion;
        this.clave = clave;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getClave() {
        return this.clave;
    }

    public static TipoDeduccion fromClave(String clave) {
        TipoDeduccion tipo = null;
        
        for (TipoDeduccion td : TipoDeduccion.values()) {
        	if (td.getClave().equals(clave)) {
        		tipo = td;
        		break;
        	}
        }
        
        return tipo;
    }
}
