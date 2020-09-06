package com.andre.servicio.app.products.exceptions;

public class ProductSoldOutException extends RuntimeException{

	public ProductSoldOutException() {
		super(String.format("Product sold out!, no existence in stock."));
	}
	private static final long serialVersionUID = 9036685784086577776L;
	

}
