package com.canauhtli.cfdi.pac.types;

public enum Estado {

	AS("AGUASCALIENTES", "Ags", "AGU"),
    BC("BAJA CALIFORNIA", "BC", "BCN"),
    BS("BAJA CALIFORNIA SUR", "BCS", "BCS"),
    CC("CAMPECHE", "Cam", "CAM"),
    CS("CHIAPAS", "Chis", "CHP"),
    CH("CHIHUAHUA", "Chih", "CHH"),
    CL("COAHUILA", "Coah", "COA"),
    CM("COLIMA", "Col", "COL"),
    DF("DISTRITO FEDERAL", "DF", "DIF"),
    DG("DURANGO", "Dgo", "DUR"),
    MC("ESTADO DE M\u00c9XICO", "Mex", "MEX"),
    GT("GUANAJUATO", "Gto", "GUA"),
    GR("GUERRERO", "Gro", "GRO"),
    HG("HIDALGO", "Hdo", "HID"),
    JC("JALISCO", "Jal", "JAL"),
    MN("MICHOACAN", "Mich", "MIC"),
    MS("MORELOS", "Mor", "MOR"),
    NT("NAYARIT", "Nay", "NAY"),
    NL("NUEVO LE\u00d3N", "NL", "NLE"),
    OC("OAXACA", "Oax", "OAX"),
    PL("PUEBLA", "Pue", "PUE"),
    QT("QUER\u00c9TARO", "Qro", "QUE"),
    QR("QUINTANA ROO", "QR", "ROO"),
    SP("SAN LUIS POTOS\u00cd", "SLP", "SLP"),
    SL("SINALOA", "Sin", "SIN"),
    SR("SONORA", "Son", "SON"),
    TC("TABASCO", "Tab", "TAB"),
    TS("TAMAULIPAS", "Tamps", "TAM"),
    TL("TLAXCALA", "Tlax", "TLA"),
    VZ("VERACRUZ", "Ver", "VER"),
    YN("YUCAT\u00c1N", "Yuc", "YUC"),
    ZS("ZACATECAS", "Zac", "ZAC"),
    EX("ESTADO EXTRANJERO", "Ex", "EXT");
	
    
    private String nombre;
    private String nombreCorto;
    private String clave;

    private Estado(String nombre, String nombreCorto, String clave) {
        this.nombre = nombre;
        this.nombreCorto = nombreCorto;
        this.clave = clave;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getNombreCorto() {
        return this.nombreCorto;
    }
    
    public String getClave() {
    	return this.clave;
    }

    public static Estado fromEstado(String edo) {
        Estado estado = null;
        
        for (Estado e : Estado.values()) {
        	if (Estado.quitaAcentos(e.getNombre()).equalsIgnoreCase(edo)) {
        		estado = e;
        		break;
        	}
        	if (e.getNombreCorto().equalsIgnoreCase(edo)) {
        		estado = e;
        		break;
        	}
        }
       
        return estado;
    }
    
    public static Estado fromClave(String cve) {
    	Estado estado = null;
    	for (Estado e : Estado.values()) {
    		if (e.getClave().equalsIgnoreCase(cve)) {
    			estado = e;
    			break;
    		}
    	}
    	return estado;
    }

    private static String quitaAcentos(String edo) {
        return edo.toUpperCase().replaceAll("\u00c1", "A").replaceAll("\u00c9", "E").replaceAll("\u00cd", "I").replaceAll("\u00d3", "O");
    }
}
