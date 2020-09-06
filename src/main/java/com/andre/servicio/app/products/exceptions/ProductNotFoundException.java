package com.andre.servicio.app.products.exceptions;

public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(Long id) {
		super(String.format("Product with Id %d not found", id));
	}
	private static final long serialVersionUID = 1766494611340452956L;

}
