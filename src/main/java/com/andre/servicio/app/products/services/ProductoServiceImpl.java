package com.andre.servicio.app.products.services;

import java.util.Calendar;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andre.servicio.app.products.exceptions.ProductNotFoundException;
import com.andre.servicio.app.products.models.dao.ProductAuditDao;
import com.andre.servicio.app.products.models.dao.ProductoDao;
import com.andre.servicio.app.products.models.dao.WharehouseActivityDao;
import com.andre.servicio.app.products.models.entity.ActivityType;
import com.andre.servicio.app.products.models.entity.ProductAudit;
import com.andre.servicio.app.products.models.entity.Producto;
import com.andre.servicio.app.products.models.entity.WharehouseActivity;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	 @Autowired
	 private ProductoDao productoDao;
	 
	 @Autowired
	 private ProductAuditDao productAuditDao;
	 
	 @Autowired
	 private WharehouseActivityDao wharehouseActivityDao;

	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Long id) {
		 return productoDao.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		Producto productodb = productoDao.save(producto);
		ProductAudit productAudit = new ProductAudit();
		productAudit.setDescription(productodb.getDescription());
		productAudit.setUsername("username");
		productAudit.setProductId(productodb.getId());
		productAudit.setCreateAt(Calendar.getInstance().getTime());
		productAuditDao.save(productAudit);
		return productodb;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productoDao.deleteById(id);
	}

	@Override
	public Producto addStock(Long id, Integer qty) {
		Producto productodb = productoDao.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
		productodb.addStock(qty);
		productoDao.save(productodb);
		WharehouseActivity wharehouseActivity = new WharehouseActivity();
		wharehouseActivity.setActivityType(ActivityType.input);
		wharehouseActivity.setCreateAt(Calendar.getInstance().getTime());
		wharehouseActivity.setProductId(productodb.getId());
		wharehouseActivity.setQty(qty);
		wharehouseActivityDao.save(wharehouseActivity);
		return productodb;
	}

	@Override
	public Producto removeStock(Long id, Integer qty) {
		Producto productodb = productoDao.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
		productodb.removeStock(qty);
		productoDao.save(productodb);
		WharehouseActivity wharehouseActivity = new WharehouseActivity();
		wharehouseActivity.setActivityType(ActivityType.output);
		wharehouseActivity.setCreateAt(Calendar.getInstance().getTime());
		wharehouseActivity.setProductId(productodb.getId());
		wharehouseActivity.setQty(qty);
		wharehouseActivityDao.save(wharehouseActivity);
		return productodb;
	}

	@Override
	public Producto addSale(Long id, Integer qty) {
		Producto productodb = productoDao.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
		productodb.removeStock(qty);
		productoDao.save(productodb);
		WharehouseActivity wharehouseActivity = new WharehouseActivity();
		wharehouseActivity.setActivityType(ActivityType.sale);
		wharehouseActivity.setCreateAt(Calendar.getInstance().getTime());
		wharehouseActivity.setProductId(productodb.getId());
		wharehouseActivity.setQty(qty);
		wharehouseActivityDao.save(wharehouseActivity);
		return productodb;
	}

}
