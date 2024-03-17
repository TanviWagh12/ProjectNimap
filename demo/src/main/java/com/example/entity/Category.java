package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	public Category() {
		super();
	}
	public Category(Integer id, String category, List<Product> productList) {
		super();
		this.id = id;
		this.category = category;
		this.productList = productList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String category;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	List<Product> productList;
	
}
