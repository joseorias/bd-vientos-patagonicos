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

    private int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }
    private int getQuantity() {
        return quantity;
    }
    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    private Product getProduct() {
        return product;
    }
    private void setProduct(Product product) {
        this.product = product;
    }

    


}
