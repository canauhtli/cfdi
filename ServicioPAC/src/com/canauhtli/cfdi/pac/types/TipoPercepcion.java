package com.canauhtli.cfdi.pac.types;

public enum TipoPercepcion {

	_001("001",	"Sueldos, Salarios  Rayas y Jornales"),
	_002("002", "Gratificación Anual (Aguinaldo)"),
	_003("003", "Participación de los Trabajadores en las Utilidades PTU"),
	_004("004", "Reembolso de Gastos Médicos Dentales y Hospitalarios"),
	_005("005", "Fondo de Ahorro"),
	_006("006", "Caja de ahorro"),
	_009("009", "Contribuciones a Cargo del Trabajador Pagadas por el Patrón"),
	_010("010", "Premios por puntualidad"),
	_011("011", "Prima de Seguro de vida"),
	_012("012", "Seguro de Gastos Médicos Mayores"),
	_013("013", "Cuotas Sindicales Pagadas por el Patrón"),
	_014("014", "Subsidios por incapacidad"),
	_015("015", "Becas para trabajadores y/o hijos"),
	_019("019", "Horas extra"),
	_020("020", "Prima dominical"),
	_021("021", "Prima vacacional"),
	_022("022", "Prima por antigüedad"),
	_023("023", "Pagos por separación"),
	_024("024", "Seguro de retiro"),
	_025("025", "Indemnizaciones"),
	_026("026", "Reembolso por funeral"),
	_027("027", "Cuotas de seguridad social pagadas por el patrón"),
	_028("028", "Comisiones"),
	_029("029", "Vales de despensa"),
	_030("030", "Vales de restaurante"),
	_031("031", "Vales de gasolina"),
	_032("032", "Vales de ropa"),
	_033("033", "Ayuda para renta"),
	_034("034", "Ayuda para artículos escolares"),
	_035("035", "Ayuda para anteojos"),
	_036("036", "Ayuda para transporte"),
	_037("037", "Ayuda para gastos de funeral"),
	_038("038", "Otros ingresos por salarios"),
	_039("039", "Jubilaciones, pensiones o haberes de retiro"),
	_044("044", "Jubilaciones, pensiones o haberes de retiro en parcialidades"),
	_045("045", "Ingresos en acciones o títulos valor que representan bienes"),
	_046("046", "Ingresos asimilados a salarios"),
	_047("047", "Alimentación"),
	_048("048", "Habitación"),
	_049("049", "Premios por asistencia");
    
	 private String descripcion;
	 private String clave;

	 private TipoPercepcion(String clave, String descripcion) {
		 this.descripcion = descripcion;
	     this.clave = clave;
	 }

	 public String getDescripcion() {
	     return this.descripcion;
	 }

	 public String getClave() {
	     return this.clave;
	 }

	 public static TipoPercepcion fromClave(String clave) {
	     TipoPercepcion tipo = null;
	     
	     for (TipoPercepcion tp : TipoPercepcion.values()) {
	    	 if (tp.getClave().equals(clave)) {
	    		 tipo = tp;
	    		 break;
	    	 }
	     }
	     
	     return tipo;
	 }
}
