package tp.model;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

public class Sale {

    private int id;
    private LocalDate sale_date;
    private double total;
    private String state;
    private Set<Product> products = new HashSet<>();
    private Pay pay;
    private Client client;
    private Set<Promotion> promotions = new HashSet<>();

    public Sale(LocalDate sale_date, String state){
        this.sale_date = sale_date;
        this.state = state;
    }

    public Sale(int id, LocalDate sale_date, double total, String state, Set<Product> products, Pay pay, Client client,
                Set<Promotion> promotions){
        this.id = id;
        this.sale_date = sale_date;
        this.total = total;
        this.state = state;
        this.products = products;
        this.pay = pay;
        this.client = client;
        this.promotions = promotions;
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

    @SuppressWarnings("unused")
    private Set<Product> getProducts() {
        return products;
    }

    @SuppressWarnings("unused")
    private void setProducts(Set<Product> products) {
        this.products = products;
    }

    private Pay getPay() {
        return pay;
    }

    private void setPay(Pay pay) {
        this.pay = pay;
    }

    @SuppressWarnings("unused")
    private Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }

    @SuppressWarnings("unused")
    private Set<Promotion> getPromotions() {
        return promotions;
    }
    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    
    public void addProduct(Product product){
        this.products.add(product);
    }

    public void addPromotion(Promotion promotion){
        this.promotions.add(promotion);
    }

    private static double discounted(double mount, int percentage){
        return mount - ((mount * percentage) / 100);
    }

    private Promotion promo_for_card(){
        for (Promotion promo : this.promotions){
            if (promo.getType() == "De compra") {
                return promo;
            }
        }
        return null;
    }
    public double calcTotal(){
        double totalSale = 0;
        double subtotal = 0;
        if (!this.promotions.isEmpty()){
            for (Product prod : this.products){
                for (Promotion promo : this.promotions){
                    if (promo.isCurrent()) {
                            if (promo.getBrand() == prod.getBrand()){
                                subtotal = discounted(prod.getPrice(), promo.getDiscount());
                            } else {
                                subtotal = prod.getPrice();
                            }
                    }
                }
            totalSale = totalSale + subtotal;
            }
        } else {
            for (Product prod : this.products){
                totalSale = totalSale + prod.getPrice();
            }
        }
        return totalSale;
    }

    public boolean finaliceSale(CreditCard card){
        double total = this.calcTotal();
        Promotion promo = this.promo_for_card();
        if (promo != null){
            if (promo.getBrand() == card.getLine()){
                this.total = discounted(total, promo.getDiscount());
            }
        }
        this.setPay(new Pay(total, card));
        if (this.getPay().isApproved()){
            this.state = "Finalizada";
            return true;
        } else {
            this.state = "Pendiente de Pago";
            return false;
        }
    }
    

}

