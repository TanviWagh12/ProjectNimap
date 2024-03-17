package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Category;
import com.example.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/category/{id}")
	Category getCategory(@PathVariable Integer id) {
		return categoryService.getCategory(id);
	}
	
	@DeleteMapping("/category/{id}")
	Boolean deleteCategory(@PathVariable Integer id) {
		return categoryService.deleteCategory(id);
	}
	
    @PutMapping("/category/{id}")
    Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {
    	return categoryService.updateCategory(id, category);
    }
    
    @PostMapping("/category")
    Category addCategory(@RequestBody Category category) {
    	return categoryService.addCategory(category);
    }
	
}
