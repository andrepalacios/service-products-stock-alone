package com.andre.servicio.app.products.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.andre.servicio.app.products.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}
