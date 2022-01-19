package com.bridgelabz.employeepayrollapp.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * @Data : Auto Generate Setters, Getters and ToString 
 */

public @Data class ResponseDTO {
	
	private String message;
	private Object data;
	public HttpStatus httpStatus;
	
	/**
	 * ResponseDTO : constructor
	 * @param message
	 * @param data
	 */
	public ResponseDTO(String message, Object data, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.data = data;
		this.httpStatus = httpStatus;
	}
	
	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
