package com.inventory.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.InventoryItem;
import com.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	private final InventoryService service;

	public InventoryController(InventoryService service) {
		this.service = service;
	}

	@GetMapping("/stock")
	public boolean checkStock(@RequestParam String code, @RequestParam int qty) {
		return service.isProductInStock(code, qty);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public InventoryItem createItem(@RequestBody InventoryItem newItem) {
		return service.saveItem(newItem);
	}

	@GetMapping
	public List<InventoryItem> getAllInventory() {
		return service.findAllItems();
	}

	@GetMapping("/{id}")
	public InventoryItem getItemById(@PathVariable Long id) {
		return service.findItemById(id).orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
	}
}
