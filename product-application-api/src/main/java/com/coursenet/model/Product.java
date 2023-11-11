package com.coursenet.model;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "product_seq", sequenceName = "products_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private long productId;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private long price;
    @Column(name = "description")
    private String description;

    public Product(long productId, String name, long price, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product(String name, long price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
