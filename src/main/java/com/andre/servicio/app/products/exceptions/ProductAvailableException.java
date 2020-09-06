package com.andre.servicio.app.products.exceptions;

public class ProductAvailableException extends RuntimeException{

	public ProductAvailableException() {
		super(String.format("Product units requested are not available."));
	}
	private static final long serialVersionUID = 377950017076907355L;

}
