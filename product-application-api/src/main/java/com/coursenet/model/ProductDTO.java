package com.coursenet.model;

public class ProductDTO {
    private String name;
    private String description;
    private long price;

    public ProductDTO(String name, String description, long price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
