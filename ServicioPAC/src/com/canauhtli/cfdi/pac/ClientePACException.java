package com.canauhtli.cfdi.pac;

public class ClientePACException extends Exception {

	private static final long serialVersionUID = 2695324718739861221L;

	public ClientePACException(String msg) {
		super(msg);
	}
	
	public ClientePACException(String msg, Exception e) {
		super(msg, e);
	}
}
