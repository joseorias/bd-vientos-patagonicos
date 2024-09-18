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
    private Category category;

    public Product(String code, String brand, String description, double price, Category category) {
        this.code = code;
        this.brand = brand;
        if (description == null) {
            throw new IllegalArgumentException("Error: Debe agregar una descripcion al Producto.");
        } else {
            this.description = description;
        }
        if (price == 0.0) {
            throw new IllegalArgumentException("Error: Debe asignar un precio al Producto.");
        } else {
            this.price = price;
        }
        if (category == null) {
            throw new IllegalArgumentException("Error: Debe asignar una categoria al Producto.");
        } else {
            this.category = category;
        }
    } 

    public Product(int id, String code, String brand, String description, double price, Category category) {
        this.id = id;
        this.code = code;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    @SuppressWarnings("unused")
    private int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(int id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    private String getCode() {
        return code;
    }

    @SuppressWarnings("unused")
    private void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    @SuppressWarnings("unused")
    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    @SuppressWarnings("unused")
    private void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    @SuppressWarnings("unused")
    private void setPrice(double price) {
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }

    @SuppressWarnings("unused")
    private void setCategory(Category category) {
        this.category = category;
    }



}
