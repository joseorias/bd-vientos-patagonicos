package tp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String brand;
    private String description;
    private double price;
    private int id_category;

    public Product(String code, String brand, String description, double price, int id_category) {
        this.code = code;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.id_category = id_category;
    } 

    public Product(int id, String code, String brand, String description, double price, int id_category) {
        this.id = id;
        this.code = code;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.id_category = id_category;
    }

    public int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(int id) {
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
    public int getIdCategory() {
        return id_category;
    }

    public void setIdCategory(int id_category) {
        this.id_category = id_category;
    }



}
