package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.product.model.Product;
import com.product.repository.ProductRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ProductServiceImpl implements ProductService {

	private static final String INVENTORY_CB = "inventoryLookup";

	private final ProductRepository productRepository;
	private final RestTemplate restTemplate;

	public ProductServiceImpl(RestTemplate restTemplate, ProductRepository productRepository) {
		this.restTemplate = restTemplate;
		this.productRepository = productRepository;

	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		if (!productRepository.existsById(id)) {
			throw new RuntimeException("Product not found with id " + id);
		}
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	/**
	 * Fallback method: Must have the same return type and a Throwable parameter.
	 */
	public Boolean getFallbackStockLevel(String productCode, int qty, Throwable t) {
		System.out.println("Circuit is OPEN or call failed. Returning fallback stock (0). Error: " + t.getMessage());
		return false;
	}

	@Override
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	@CircuitBreaker(name = INVENTORY_CB, fallbackMethod = "getFallbackStockLevel")
	public Boolean getProductStock(String productCode, int qty) {
		String baseUrl = "http://localhost:8097/inventory";
		String inventoryUrl = baseUrl + "/stock?code=" + productCode + "&qty=" + qty;
		System.out.println("Calling Inventory Service: " + inventoryUrl);

		Boolean inStock = restTemplate.getForObject(inventoryUrl, Boolean.class);

		return inStock;
	}

	@Override
	public Product updateProduct(Long id, Product updatedProduct) {
		return productRepository.findById(id).map(existing -> {
			existing.setName(updatedProduct.getName());
			existing.setDescription(updatedProduct.getDescription());
			existing.setPrice(updatedProduct.getPrice());
			existing.setQuantity(updatedProduct.getQuantity());
			return productRepository.save(existing);
		}).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
	}
}
