package com.ecommerce.projectdemo.controller;

import com.ecommerce.projectdemo.model.Category;
import com.ecommerce.projectdemo.model.Product;
import com.ecommerce.projectdemo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getCategory(),OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        return new ResponseEntity<>(getCategoryById(id),OK);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category newCategory){
        return new ResponseEntity<>(categoryService.createCategory(newCategory),CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category categoryData , @PathVariable Long id){
        categoryService.updateCategory(id,categoryData);
        return new ResponseEntity<>(OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deletCategory(id);
        return new ResponseEntity<>(OK);
    }

    private Category getCategoryById(Long id){
        return categoryService.getCategoryById(id);
    }
}
