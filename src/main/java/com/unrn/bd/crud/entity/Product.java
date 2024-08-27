package com.unrn.bd.crud.entity;

import java.util.Locale.Category;

public class Product {

    private int id;
    private String code;
    private String brand;
    private String description;
    private double price;
    private Category category;

    public Product(String code, String brand, String description, double price, Category category) {
        this.code = code;
        this.brand = brand;
        if (description == null) {
            throw new IllegalArgumentException("Error: Debe agregar una descripcion al Producto.");
        } else {
            this.description = description;
        }
        if (price == 0.0) {
            throw new IllegalArgumentException("Error: Debe asignar un precio al Producto.");
        } else {
            this.price = price;
        }
        if (category == null) {
            throw new IllegalArgumentException("Error: Debe asignar una categoria al Producto.");
        } else {
            this.category = category;
        }
    } 

    public Product(int id, String code, String brand, String description, double price, Category category) {
        this.id = id;
        this.code = code;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    private int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }
    private String getCode() {
        return code;
    }
    private void setCode(String code) {
        this.code = code;
    }
    public String getBrand() {
        return brand;
    }
    private void setBrand(String brand) {
        this.brand = brand;
    }
    private String getDescription() {
        return description;
    }
    private void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    private void setPrice(double price) {
        this.price = price;
    }
    private Category getCategory() {
        return category;
    }
    private void setCategory(Category category) {
        this.category = category;
    }



}
