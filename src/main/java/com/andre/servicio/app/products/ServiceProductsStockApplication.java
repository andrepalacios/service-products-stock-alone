package com.andre.servicio.app.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceProductsStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProductsStockApplication.class, args);
	}

}
