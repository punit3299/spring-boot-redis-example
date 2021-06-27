package com.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.entities.Product;

@Repository
public class ProductDao {

	private static final String HASH_KEY = "Product";

	@Autowired
	private RedisTemplate template;

	public Product save(Product product) {
		template.opsForHash().putIfAbsent(HASH_KEY, product.getId(), product);
		return product;
	}

	public Product findById(int id) {
		System.out.println("Fetching from Database, id = " + id);
		return (Product) template.opsForHash().get(HASH_KEY, id);
	}

	public List<Product> findAll() {
		return template.opsForHash().values(HASH_KEY);
	}

	public String delete(int id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "Product Deleted";
	}

}
