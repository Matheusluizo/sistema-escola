package com.matheusluizo.sistemaescola.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Instant timestramp;	
	private Integer status;
	private String erro;
	private String message;
	private String path;
	
	public StandardError () {
	}

	public StandardError(Instant timestramp, Integer status, String erro, String message, String path) {
		super();
		this.timestramp = timestramp;
		this.status = status;
		this.erro = erro;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestramp() {
		return timestramp;
	}

	public void setTimestramp(Instant timestramp) {
		this.timestramp = timestramp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
