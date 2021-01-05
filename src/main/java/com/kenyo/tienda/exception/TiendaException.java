package com.kenyo.tienda.exception;

public class TiendaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1721135239724681985L;

	public TiendaException() {
		super();
	}
	
	public TiendaException(String mensaje) {
		super(mensaje);
	}

}
