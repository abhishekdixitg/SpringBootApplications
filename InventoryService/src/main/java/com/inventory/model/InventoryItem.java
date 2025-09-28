package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class InventoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_code", unique = true, nullable = false)
	private String productCode;

	@Column(nullable = false)
	private Integer quantity;

	private String itemName;

	private Double price;

	public InventoryItem() {
	}

	public Long getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public Double getPrice() {
		return price;
	}

	public String getProductCode() {
		return productCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}