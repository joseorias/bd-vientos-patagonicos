package com.unrn.bd.crud.entity;

public class Pay {

    private int id;
    private double amount;
    private boolean approved;
    private CreditCard creditCard;

    public Pay(double amount, CreditCard card) {
        if (card != null){
            this.amount = amount;
            this.creditCard = card;
            this.approved = true;
        } else{
            this.approved = false;
        }
        
    }

    public Pay(int id, double amount, boolean approved, CreditCard card) {
        this.id = id;
        this.amount = amount;
        this.approved = approved;
        this.creditCard = card;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }


    public boolean isApproved() {
        return approved;
    }


    public void setApproved(boolean approved) {
        this.approved = approved;
    }


    public CreditCard getCreditCard() {
        return creditCard;
    }


    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }


    


}
