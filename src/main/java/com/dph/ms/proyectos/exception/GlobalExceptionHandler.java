package com.dph.ms.proyectos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
     * Maneja excepciones de tipo EntityNotFoundException.
     *
     * @param ex      Excepción EntityNotFoundException.
     * @param request Solicitud web asociada.
     * @return Respuesta HTTP con detalles del error.
     */
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(EntityNotFoundException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(
				HttpStatus.NOT_FOUND,
				ex.getMessage(),
				request.getDescription(false));
 
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}
	/**
     * Maneja excepciones de tipo IllegalOperationException.
     *
     * @param ex      Excepción IllegalOperationException.
     * @param request Solicitud web asociada.
     * @return Respuesta HTTP con detalles del error.
     */
	@ExceptionHandler(IllegalOperationException.class)
    public ResponseEntity<ErrorMessage> illegalOperationException(IllegalOperationException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.BAD_REQUEST,
            ex.getMessage(),
            request.getDescription(false));
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
	/**
     * Maneja excepciones generales.
     *
     * @param ex      Excepción general.
     * @param request Solicitud web asociada.
     * @return Respuesta HTTP con detalles del error.
     */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(
				HttpStatus.INTERNAL_SERVER_ERROR,
				ex.getMessage(),
				request.getDescription(false));
 
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
	

