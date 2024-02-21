package com.aspirecoders.instock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspirecoders.instock.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
  // You can add custom query methods here if needed
}