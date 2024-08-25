package com.unrn.bd.crud.entity;

import java.time.LocalDate;

public class CreditCard {

    private int id;
    private int number;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String line;
    private Client owner;

    public CreditCard(int number, LocalDate issuDate, LocalDate expiryDate, String line, Client owner) {
        this.number = number;
        this.issueDate = issuDate;
        this.expiryDate = expiryDate;
        this.line = line;
        this.owner = owner;
    }

    public CreditCard(int id, int number, LocalDate issuDate, LocalDate expiryDate, String line, Client owner) {
        this.id = id;
        this.number = number;
        this.issueDate = issuDate;
        this.expiryDate = expiryDate;
        this.line = line;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }



}
