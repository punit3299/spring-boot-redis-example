package com.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entities.Product;
import com.redis.repository.ProductDao;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDao dao;

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return dao.save(product);
	}

	@GetMapping
	public List<Product> getAllProduct() {
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		return dao.findById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		return dao.delete(id);
	}
}
