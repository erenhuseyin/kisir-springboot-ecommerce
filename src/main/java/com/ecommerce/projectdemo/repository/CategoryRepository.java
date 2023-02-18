package com.ecommerce.projectdemo.repository;

import com.ecommerce.projectdemo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
