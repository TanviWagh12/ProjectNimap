package com.example.controller;
import com.example.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.entity.Category;
import com.example.service.CategoryService;

@RestController
public class CategoryController<Pageable> {
	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

	
	@GetMapping("/categories")
	public Page<Category> getCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
		
        return categoryService.getCategories(page, size);
    }
	
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
