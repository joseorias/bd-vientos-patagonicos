package com.unrn.bd.crud.entity;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

public class Sale {

    private int id;
    private LocalDate sale_date;
    private double total;
    private String state;
    private Set<Product> products = new HashSet<>();
    private Pay pay;
    private Client client;
    private Set<Promotion> promotions = new HashSet<>();

    public Sale(LocalDate sale_date, String state){
        this.sale_date = sale_date;
        this.state = state;
    }

    public Sale(int id, LocalDate sale_date, double total, String state, Set<Product> products, Pay pay, Client client,
                Set<Promotion> promotions){
        this.id = id;
        this.sale_date = sale_date;
        this.total = total;
        this.state = state;
        this.products = products;
        this.pay = pay;
        this.client = client;
        this.promotions = promotions;
    }

    private int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }
    private LocalDate getSale_date() {
        return sale_date;
    }
    private void setSale_date(LocalDate sale_date) {
        this.sale_date = sale_date;
    }
    private double getTotal() {
        return total;
    }
    private void setTotal(double total) {
        this.total = total;
    }
    private String getState() {
        return state;
    }
    private void setState(String state) {
        this.state = state;
    }
    private Set<Product> getProducts() {
        return products;
    }
    private void setProducts(Set<Product> products) {
        this.products = products;
    }
    private Pay getPay() {
        return pay;
    }
    private void setPay(Pay pay) {
        this.pay = pay;
    }
    private Client getClient() {
        return client;
    }
    private void setClient(Client client) {
        this.client = client;
    }
    private Set<Promotion> getPromotions() {
        return promotions;
    }
    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    
    public void addProduct(Product product){
        this.products.add(product);
    }

    public void addPromotion(Promotion promotion){
        this.promotions.add(promotion);
    }

    private static double discounted(double mount, int percentage){
        return mount - ((mount / percentage) * 100);
    }

    private Promotion promo_for_card(){
        for (Promotion promo : this.promotions){
            if (promo.getType() == "De tarjeta") {
                return promo;
            }
        }
        return null;
    }
    private double calcTotal(){
        double totalSale = 0;
        if (!this.promotions.isEmpty()){
            for (Promotion promo : this.promotions){
                if (promo.isCurrent()) {
                    if (promo.getType() == "De producto"){
                        for (Product prod : this.products){
                            if (promo.getBrand() == prod.getBrand()){
                                totalSale = totalSale + discounted(prod.getPrice(), promo.getDiscount());
                            } else {
                            totalSale = totalSale + prod.getPrice();
                            }
                        }
                    }
                }
            }
        } else {
            for (Product prod : this.products){
                totalSale = totalSale + prod.getPrice();
            }
        }
        return totalSale;
    }

    private boolean finaliceSale(CreditCard card){
        double total = this.calcTotal();
        Promotion promo = this.promo_for_card();
        if (promo != null){
            if (promo.getBrand() == card.getLine()){
                total = total - discounted(total, promo.getDiscount());
            }
        }
        this.setPay(new Pay(total, card));
        if (this.getPay().isApproved()){
            this.state = "Finalizada";
            return true;
        } else {
            this.state = "Pendiente de Pago";
            return false;
        }
    }
    

}

