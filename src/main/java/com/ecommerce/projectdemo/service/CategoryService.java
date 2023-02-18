package com.ecommerce.projectdemo.service;

import com.ecommerce.projectdemo.model.Category;
import com.ecommerce.projectdemo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    //dependency injection
    //ioc container

    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }

    public Category createCategory(Category newCategory){

        return categoryRepository.save(newCategory);
    }

    public void deletCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IL not found"));

    }


    public void updateCategory(Long id, Category categoryData) {
        Category oldCategory = getCategoryById(id);
        oldCategory.setName(categoryData.getName());
        oldCategory.setProduct(categoryData.getProduct());
        categoryRepository.save(oldCategory);
    }


}
