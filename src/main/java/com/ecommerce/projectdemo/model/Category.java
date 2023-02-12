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

    @OneToMany
    @Column(name = "productId")
    private List<Product> product;

    @Column
    private String name;

    @Column
    private String desc;


}
