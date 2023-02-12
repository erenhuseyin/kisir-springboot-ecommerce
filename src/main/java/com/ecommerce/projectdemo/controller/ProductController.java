package com.ecommerce.projectdemo.controller;

import com.ecommerce.projectdemo.model.Product;
import com.ecommerce.projectdemo.repository.ProductRepository;
import com.ecommerce.projectdemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getproduct(),OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        return new ResponseEntity<>(getProductById(id),OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product newProduct){
        return new ResponseEntity<>(productService.createProduct(newProduct),CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product productData , @PathVariable Long id){
        productService.updateProduct(id,productData);
        return new ResponseEntity<>(OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(OK);
    }

    private Product getProductById(Long id){
        return productService.getProductById(id);
    }

}