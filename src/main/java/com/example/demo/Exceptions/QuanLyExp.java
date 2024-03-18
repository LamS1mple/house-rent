package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



public class QuanLyExp extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public QuanLyExp() {
	}
	public QuanLyExp(String message) {
		super(message);
		this.message = message;
	}
	
	
	
	
}
