package com.banco.model.dto;

import java.io.Serializable;


public class RespuestaDTO implements Serializable {
	
	private static final long serialVersionUID = 2812908376740565934L;
	
	private Integer codigoError;
	private String mensajeError;

	public RespuestaDTO() {
		super();
	}
	
	/*
	 * Getters and Setters
	 */

	public Integer getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(Integer codigoError) {
		this.codigoError = codigoError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
   
}
