package com.andre.servicio.app.products.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.andre.servicio.app.products.exceptions.ProductAvailableException;
import com.andre.servicio.app.products.exceptions.ProductQuantityException;
import com.andre.servicio.app.products.exceptions.ProductSoldOutException;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private Long id;
	private String name;
	private String description;
	private Double price;
	
	// Available stock of this product.
	@Column(name = "available_stock")
	private Integer availableStock;

	// Available stock at which we should reorder
	@Column(name = "restock_threshold")
	private Integer reStockThreshold;

	// Maximum number of units that can be in-stock at any time (constraints in
	// warehouses)
	@Column(name = "maxstock_threshold")
	private Integer maxStockThreshold;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
	private List<ProductAudit> productAudit;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
	private List<WharehouseActivity> wharehouseAcitvity;
	
	public void removeStock(Integer qty) {
		if(this.availableStock == 0) {
			throw new ProductSoldOutException();
		}
		else if(qty <= 0) {
			throw new ProductQuantityException();
		}
		else if (qty > this.availableStock) {
			throw new ProductAvailableException();
		}
		this.availableStock -= qty;
	}
	
	public void addStock(Integer qty) {	
		// The quantity that the client is trying to add to stock is greater than what can be physically accommodated in the Warehouse
		if((this.availableStock + qty) > this.maxStockThreshold) {
			// For now, this method only adds new units up maximum stock threshold. In an expanded version of this application, we
            //could include tracking for the remaining units and store information about overstock somewhere else.
			this.availableStock += this.maxStockThreshold - this.availableStock;
		} else {
			this.availableStock += qty;
		}
	}
	
	public List<ProductAudit> getProductAudit() {
		return productAudit;
	}

	public void setProductAudit(List<ProductAudit> productAudit) {
		this.productAudit = productAudit;
	}

	public List<WharehouseActivity> getWharehouseAcitvity() {
		return wharehouseAcitvity;
	}

	public void setWharehouseAcitvity(List<WharehouseActivity> wharehouseAcitvity) {
		this.wharehouseAcitvity = wharehouseAcitvity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(Integer availableStock) {
		this.availableStock = availableStock;
	}

	public Integer getReStockThreshold() {
		return reStockThreshold;
	}

	public void setReStockThreshold(Integer reStockThreshold) {
		this.reStockThreshold = reStockThreshold;
	}

	public Integer getMaxStockThreshold() {
		return maxStockThreshold;
	}

	public void setMaxStockThreshold(Integer maxStockThreshold) {
		this.maxStockThreshold = maxStockThreshold;
	}

	private static final long serialVersionUID = 2349286714599349451L;

}
