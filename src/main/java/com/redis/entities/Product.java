package com.redis.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RedisHash("Product")
public class Product implements Serializable{
	
	@Id
	private int id;
	private String name;
	private int price;
	
	public Product() {
		
	}

	public Product(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
