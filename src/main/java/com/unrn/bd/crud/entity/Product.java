package com.unrn.bd.crud.entity;

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
        this.description = description;
        this.price = price;
        this.category = category;
    } 

    public Product(int id, String code, String brand, String description, double price, Category category) {
        this.id = id;
        this.code = code;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    



}
