package com.ecommerce.projectdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "category")
    @Column(name = "product")
    private List<Product> product;

    @Column
    private String name;


}
