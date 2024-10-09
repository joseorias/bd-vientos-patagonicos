package tp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate sale_date;
    private double total;
    private String state;
    private List<Integer> products = new ArrayList<>();

    @Embedded
    private Pay pay;

    @Embedded
    private Client client;
    
    public Sale(LocalDate sale_date, String state){
        this.sale_date = sale_date;
        this.state = state;
    }

    public Sale(int id, LocalDate sale_date, String state, Client client){
        this.id = id;
        this.sale_date = sale_date;
        this.state = state;
        this.client = client;
    }

    public Sale(LocalDate sale_date, String state, Client client){
        this.sale_date = sale_date;
        this.state = state;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(int id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    private LocalDate getSale_date() {
        return sale_date;
    }

    @SuppressWarnings("unused")
    private void setSale_date(LocalDate sale_date) {
        this.sale_date = sale_date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @SuppressWarnings("unused")
    private String getState() {
        return state;
    }

    @SuppressWarnings("unused")
    private void setState(String state) {
        this.state = state;
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }

    @SuppressWarnings("unused")
    private Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }

    
    public void addProduct(int id_product){
        this.products.add(id_product);
    }

}
