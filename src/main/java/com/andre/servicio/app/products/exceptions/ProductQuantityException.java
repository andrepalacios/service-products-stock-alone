package com.andre.servicio.app.products.exceptions;

public class ProductQuantityException extends RuntimeException{
	
	private static final long serialVersionUID = 401491257141976194L;

	public ProductQuantityException() {
		super(String.format("Product units should be greater than zero."));
	}

}
