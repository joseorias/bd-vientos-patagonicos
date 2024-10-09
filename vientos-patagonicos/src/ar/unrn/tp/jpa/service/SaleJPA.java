package tp.jpa.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import tp.api.SaleService;
import tp.model.Client;
import tp.model.CreditCard;
import tp.model.Product;
import tp.model.Promotion;
import tp.model.Sale;

public class SaleJPA implements SaleService {
    private static EntityManager em;
    private static EntityTransaction transaction;

    public void init_context(EntityManagerFactory emf){
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }

    public void close_context(){
        em.close();
    }

    @Override
    public void create_sale(int id_client, List<Integer> products, int id_card) {
        Sale sale;
        transaction.begin();
        try{
            Client client = em.find(Client.class, id_client);
            CreditCard card = em.find(CreditCard.class, id_card);
            Set<Product> prodts = new HashSet<>();
            if (client != null) {
                if (card != null) {
                    if (!prodts.isEmpty()) {
                        for (Integer id_product : products) {
                            prodts.add(em.find(Product.class, id_product));
                        }
                        sale = new Sale(LocalDate.now(), "Iniciada", client);
                        sale.setProducts(products);
                        em.persist(sale);
                        transaction.commit();
                    } else {
                        transaction.rollback();
                        throw new Exception("Lista de productos vacia. ");
                    }
                } else {
                    transaction.rollback();
                    throw new NullPointerException("Tarjeta de credito no registrada.");
                }
                
            } else {
                transaction.rollback();
                throw new NullPointerException("Cliente invalido.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

    }

    public void create_sale(int id_sale, int id_client, List<Integer> products, int id_card) {
        Sale sale;
        transaction.begin();
        try{
            Client client = em.find(Client.class, id_client);
            CreditCard card = em.find(CreditCard.class, id_card);
            //List<Product> prodts = new ArrayList<>();
            //for (Integer id_product : products) {
            //    prodts.add(em.find(Product.class, id_product));
            //}
            if (client != null) {
                if (card != null) {
                    if (!products.isEmpty()) {
                        sale = new Sale(id_sale, LocalDate.now(), "Iniciada", client);
                        sale.setProducts(products);
                        em.persist(sale);
                        transaction.commit();
                    } else {
                        throw new Exception("Lista de productos vacia. ");
                    }
                } 
                
            } else {
                throw new NullPointerException("Cliente invalido.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public List<Sale> list_sales() {
        List<Sale> sales = null;
        transaction.begin();
        try {
            TypedQuery<Sale> query = em.createQuery("SELECT s FROM Sale s", Sale.class);
            sales = query.getResultList();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return sales;
    }

    @Override
    public double calc_total(List<Integer> products, int id_card) {
        double totalSale = 0;
        double subtotal = 0;
        List<Promotion> promotions;
        List<Product> prodts = new ArrayList<>();
        Product product;
        transaction.begin();
        try{
            CreditCard card = em.find(CreditCard.class, id_card);
            TypedQuery<Promotion> query = em.createQuery("SELECT p FROM Promotion p", Promotion.class);
            promotions = query.getResultList();
            for (Integer id_product : products) {
                product = em.find(Product.class, id_product);
                prodts.add(product);
            }
            if (!promotions.isEmpty()){
                for (Product prod : prodts){
                    for (Promotion promo : promotions){
                        if (promo.isCurrent()) {
                            if (promo.getBrand().equals(prod.getBrand())){
                                subtotal = discounted(prod.getPrice(), promo.getDiscount());
                            } else {
                                subtotal = prod.getPrice();
                            }
                            if (promo.getBrand().equals(card.getLine())) {
                                subtotal = discounted(subtotal, promo.getDiscount());
                            }
                        }
                    }
                totalSale = totalSale + subtotal;
                }
            } else {
                for (Product prod : prodts){
                    totalSale = totalSale + prod.getPrice();
                }
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return totalSale;
    }

    private static double discounted(double mount, int percentage){
        return mount - ((mount * percentage) / 100);
    }

    public Sale find(int id) {
        Sale sale = null;
        transaction.begin();
        try {
            sale = em.find(Sale.class, id);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return sale;
    }

}
