package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;


@RestController
public class ProductController {
	  private final ProductService productService;

	@Autowired
	 public ProductController(ProductService productService) {
        this.productService = productService;
    }
	
	 @GetMapping("/products")
	    public Page<Product> getProducts(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size
	    ) {
	        return productService.getProducts(page, size);
	    }
   
	
	@GetMapping("/products/{id}") 
	Product getAllProducts(@PathVariable("id") Integer id){
		return productService.getProduct(id);		
	}
		
    @PutMapping("/products/{id}")
    Product updateProduct(@PathVariable("id")Integer id, @RequestBody Product product) {
    	return productService.updateProduct(id, product);
    }
	
	@DeleteMapping("/products/{id}")
	Boolean deleteProduct(@PathVariable("id")Integer id) {
		return productService.deleteProduct(id);
	}
    
	@PostMapping("/products")
	Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	
}
