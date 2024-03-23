package com.dph.ms.proyectos.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {

	private int statusCode;
	/**
     * Marca de tiempo cuando se generó el error.
     */
	private LocalDateTime timestamp;
	private String message;
	private String description;
	/**
     * Constructor para crear un objeto ErrorMessage.
     *
     * @param statusCode  Código de estado HTTP asociado al error.
     * @param message     Mensaje descriptivo del error.
     * @param description Descripción detallada del error.
     */
	public ErrorMessage(HttpStatus statusCode, String message, String description) {
		this.statusCode = statusCode.value();
		this.timestamp = LocalDateTime.now();
		this.message = message;
		this.description = description;
	}
	
}
