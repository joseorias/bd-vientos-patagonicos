package tp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @SuppressWarnings("unused")
    private int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }

    @SuppressWarnings("unused")
    private void setType(String type) {
        this.type = type;
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    @SuppressWarnings("unused")
    private void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }

    @SuppressWarnings("unused")
    private void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getBrand() {
        return brand;
    }

    @SuppressWarnings("unused")
    private void setBrand(String brand) {
        this.brand = brand;
    }
    public int getDiscount() {
        return discount;
    }

    @SuppressWarnings("unused")
    private void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isCurrent(){
        LocalDate now = LocalDate.now();
        return (now.isEqual(this.getStartDate()) || now.isAfter(this.getStartDate()) &&
                now.isEqual(this.getEndDate()) || now.isBefore(this.getEndDate())); 
    }
    

}
