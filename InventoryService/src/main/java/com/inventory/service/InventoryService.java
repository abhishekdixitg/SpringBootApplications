package com.inventory.service;

import java.util.List;
import java.util.Optional;

import com.inventory.model.InventoryItem;

public interface InventoryService {
	public List<InventoryItem> findAllItems();

	public Optional<InventoryItem> findItemById(Long id);

	public boolean isProductInStock(String productCode, int requiredQuantity);

	public InventoryItem saveItem(InventoryItem item);
}