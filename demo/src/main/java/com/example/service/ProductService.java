package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired ProductRepository productRepository;
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProduct(Integer Id) {
		return productRepository.findById(Id).get();
	}
	
	public Product updateProduct(Integer id, Product product) {
		Product existingProduct = productRepository.findById(id).orElseThrow();
		existingProduct.setCategory(product.getCategory());
		existingProduct.setProduct(product.getProduct());
		productRepository.save(existingProduct);
		return existingProduct;
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Boolean deleteProduct(Integer id) {
		Product existingProduct = productRepository.findById(id).orElseThrow();
		 productRepository.delete(existingProduct);
		 return true;
	}

	public Page<Product> getProducts(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
	}
	
}
