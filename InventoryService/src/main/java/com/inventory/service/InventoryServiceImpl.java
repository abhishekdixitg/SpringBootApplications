package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.InventoryItem;
import com.inventory.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository repository;

	public InventoryServiceImpl(InventoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<InventoryItem> findAllItems() {
		return repository.findAll();
	}

	@Override
	public Optional<InventoryItem> findItemById(Long id) {
		return repository.findById(id);
	}

	@Override
	public boolean isProductInStock(String productCode, int requiredQuantity) {
		return repository.existsByProductCodeAndQuantityGreaterThan(productCode, requiredQuantity);
	}

	@Override
	public InventoryItem saveItem(InventoryItem item) {
		return repository.save(item);
	}
}
