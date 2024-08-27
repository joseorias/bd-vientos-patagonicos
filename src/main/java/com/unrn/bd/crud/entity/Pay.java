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

    private int getId() {
        return id;
    }


    private void setId(int id) {
        this.id = id;
    }


    private double getAmount() {
        return amount;
    }


    private void setAmount(double amount) {
        this.amount = amount;
    }


    public boolean isApproved() {
        return approved;
    }


    private void setApproved(boolean approved) {
        this.approved = approved;
    }


    private CreditCard getCreditCard() {
        return creditCard;
    }


    private void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }


    


}
