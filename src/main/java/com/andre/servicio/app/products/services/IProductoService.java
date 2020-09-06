package com.andre.servicio.app.products.services;

import java.util.List;

import com.andre.servicio.app.products.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
    public Producto findById(Long id);
    public Producto save(Producto producto);
    public void deleteById(Long id);
    public Producto addStock(Long id, Integer qty);
    public Producto removeStock(Long id, Integer qty);
    public Producto addSale(Long id, Integer qty);

}
