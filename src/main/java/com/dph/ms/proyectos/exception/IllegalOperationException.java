package com.dph.ms.proyectos.exception;
/*
 * Excepcion que laza cuando se realiza una operacion ilegal
 */
public class IllegalOperationException extends Exception{

	private static final long serialVersionUID = 1L;
	 
	public IllegalOperationException(String message) {
		super (message);
	}
}
