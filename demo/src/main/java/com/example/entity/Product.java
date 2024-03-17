package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	 
	
    public Product() {
    	
    }
	
	public Product(Integer id, String product, Category category) {
		super();
		this.id = id;
		this.product = product;
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String product;
	@ManyToOne
	Category category;
	
	
}
