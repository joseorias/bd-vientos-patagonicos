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

    private int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private int getNumber() {
        return number;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private LocalDate getIssueDate() {
        return issueDate;
    }

    private void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    private LocalDate getExpiryDate() {
        return expiryDate;
    }

    private void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLine() {
        return line;
    }

    private void setLine(String line) {
        this.line = line;
    }

    private Client getOwner() {
        return owner;
    }

    private void setOwner(Client owner) {
        this.owner = owner;
    }



}
