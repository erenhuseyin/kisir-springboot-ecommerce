package com.ecommerce.projectdemo.service;

import com.ecommerce.projectdemo.model.Product;
import com.ecommerce.projectdemo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public Product createProduct(Product newProduct){
        return productRepository.save(newProduct);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IL not found"));

    }


    public void updateProduct(Long id, Product productData) {
        Product oldProduct = getProductById(id);
        oldProduct.setName(productData.getName());
        oldProduct.setPrice(productData.getPrice());
        oldProduct.setStock(productData.getStock());
        oldProduct.setBrandName(productData.getBrandName());
        productRepository.save(oldProduct);
    }
}