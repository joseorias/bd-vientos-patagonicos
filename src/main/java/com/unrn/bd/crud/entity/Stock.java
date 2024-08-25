package com.unrn.bd.crud.entity;

public class Stock {

    private int id;
    private int quantity;
    private Product product;

    public Stock(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Stock(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    


}
