package com.ecommerce.projectdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    /*crud
    create
    read
    update
    delete
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "amount")
    private Integer stock;
    @Column(name = "brandName")
    private String brandName;

}
