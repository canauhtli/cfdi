package com.canauhtli.cfdi.fel;

public enum FelMaxLengths {

	// Comprobante
	COMPROBANTE_CONDICIONES_PAGO(1000),
	COMPROBANTE_FOLIO(40),
	
	// Receptor
	RECEPTOR_NOMBRE(254),
	RECEPTOR_NUMREGIDTRIB(40),
	RECEPTOR_RESIDENCIAFISCAL(3),
	RECEPTOR_RFC(13),
	RECEPTOR_USOCFDI(3);
	
	private int lenght;
	
	private FelMaxLengths(int lenght) {
		this.lenght = lenght;
	}
	
	public int lenght() {
		return lenght;
	}
}
