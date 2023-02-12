package com.ecommerce.projectdemo.repository;

import com.ecommerce.projectdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
