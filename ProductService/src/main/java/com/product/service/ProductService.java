package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.model.Product;

public interface ProductService {
	Product createProduct(Product product);

	void deleteProduct(Long id);

	List<Product> getAllProducts();

	Optional<Product> getProductById(Long id);

	public Boolean getProductStock(String productCode, int qty);

	Product updateProduct(Long id, Product product);
}