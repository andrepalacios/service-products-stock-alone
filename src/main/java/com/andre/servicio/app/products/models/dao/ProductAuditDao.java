package com.andre.servicio.app.products.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.andre.servicio.app.products.models.entity.ProductAudit;

public interface ProductAuditDao extends CrudRepository<ProductAudit, Long> {

}
