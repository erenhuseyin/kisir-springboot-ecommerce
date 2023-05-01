package com.ecommerce.projectdemo.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private String name;
    private String description;
    private List<ProductDto> productList;


}
