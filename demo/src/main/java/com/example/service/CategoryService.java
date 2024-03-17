package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired CategoryRepository categoryRepository;
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Boolean deleteCategory(Integer id) {
		Category category = categoryRepository.findById(id).orElseThrow();
		categoryRepository.delete(category);
		return true;
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(Integer id, Category category) {
		Category existingCategory = categoryRepository.findById(id).orElseThrow();
		existingCategory.setCategory(category.getCategory());
		existingCategory.setProductList(category.getProductList());
		categoryRepository.save(existingCategory);
		return existingCategory;
	}
		
	public Category getCategory(Integer Id) {
		return categoryRepository.findById(Id).get();
	}

	public Page<Category> getCategories(int page, int size) {
		 Pageable pageable = PageRequest.of(page, size);
	        return categoryRepository.findAll(pageable);
	}
	
}
