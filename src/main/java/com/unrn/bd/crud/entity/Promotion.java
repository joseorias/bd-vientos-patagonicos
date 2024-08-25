package com.unrn.bd.crud.entity;

import java.time.LocalDate;

public class Promotion {

    private int id;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private String brand;
    private int discount;

    public Promotion(String type, LocalDate starDate, LocalDate endDate, String brand, int discount) {
        this.type = type;
        this.startDate = starDate;
        this.endDate = endDate;
        this.brand = brand;
        this.discount = discount;
    }

    public Promotion(int id, String type, LocalDate starDate, LocalDate endDate, String brand, int discount) {
        this.id = id;
        this.type = type;
        this.startDate = starDate;
        this.endDate = endDate;
        this.brand = brand;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isCurrent(){
        LocalDate now = LocalDate.now();
        return (now.isEqual(this.startDate) || now.isAfter(this.startDate) &&
                now.isEqual(this.endDate) || now.isBefore(this.endDate)); 
    }


}
