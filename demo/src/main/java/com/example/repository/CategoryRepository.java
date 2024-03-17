package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Page<Category> findAll(Pageable pageable);
}
