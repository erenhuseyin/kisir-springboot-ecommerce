package com.ecommerce.projectdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "brandName")
    private String brandName;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    @JsonBackReference
    private Category category;

}
