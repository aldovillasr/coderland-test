package com.coderland.assessment.models;

public class CarNotFoundException extends RuntimeException {
	public CarNotFoundException(String exception) {
		super(exception);
	}
}
