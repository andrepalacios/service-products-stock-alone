package com.andre.servicio.app.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.andre.servicio.app.products.models.entity.Producto;
import com.andre.servicio.app.products.services.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
    private IProductoService productoService;
    
    @GetMapping("/listar")
    public List<Producto> listar(){
        
        return productoService.findAll();
        
    }

    @GetMapping("/listar/{id}")
    public Producto detalle(@PathVariable Long id) {
        return productoService.findById(id);
    }
    
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
        Producto productodb = productoService.findById(id);
        productodb.setDescription(producto.getDescription());
        productodb.setName(producto.getName());
        productodb.setPrice(producto.getPrice());
        productodb.setMaxStockThreshold(producto.getMaxStockThreshold());
        productodb.setAvailableStock(producto.getAvailableStock());
        productodb.setReStockThreshold(producto.getReStockThreshold());
        return productoService.save(productodb);
    }
    
    @PutMapping("/addstock/{id}/cantidad/{qty}")
    @ResponseStatus(HttpStatus.OK)
    public Producto addStock(@PathVariable Long id, @PathVariable int qty){
        return productoService.addStock(id, qty);
    }
    
    @PutMapping("/removestock/{id}/cantidad/{qty}")
    @ResponseStatus(HttpStatus.OK)
    public Producto removeStock(@PathVariable Long id, @PathVariable int qty){
        return productoService.removeStock(id, qty);
    }
    
    @PutMapping("/addsale/{id}/cantidad/{qty}")
    @ResponseStatus(HttpStatus.OK)
    public Producto addSale(@PathVariable Long id, @PathVariable int qty){
        return productoService.addSale(id, qty);
    }
    
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        productoService.deleteById(id);
    }


}
