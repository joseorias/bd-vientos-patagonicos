package tp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @SuppressWarnings("unused")
    private int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(int id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    private int getQuantity() {
        return quantity;
    }

    @SuppressWarnings("unused")
    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @SuppressWarnings("unused")
    private Product getProduct() {
        return product;
    }

    @SuppressWarnings("unused")
    private void setProduct(Product product) {
        this.product = product;
    }

    


}
