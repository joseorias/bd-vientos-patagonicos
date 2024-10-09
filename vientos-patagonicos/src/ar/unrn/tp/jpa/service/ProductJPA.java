package tp.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import tp.api.ProductService;
import tp.model.Category;
import tp.model.Product;

public class ProductJPA implements ProductService {
    private static EntityManager em;
    private static EntityTransaction transaction;

    public void init_context(EntityManagerFactory emf){
        em = emf.createEntityManager();
        transaction = em.getTransaction();
        transaction.begin();
    }

    public void close_context(){
        em.close();
    }

    @Override
    public void create_product(String code, String brand, String description, double price, int id_category) {
        Product product;
        Category category;
        try{
            category = em.find(Category.class, id_category);
            if (!(category == null)){
                if (price != 0.0) {
                    product = new Product(code, brand, description, price, category.getId());
                    em.persist(product);
                    transaction.commit();
                } else {
                    throw new IllegalArgumentException("Debe ingresar un precio valido mayor a 0.");
                }
            } else {
                throw new NullPointerException("Debe asignar una categoria al producto.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }     
    }

    public void create_product(int id, String code, String brand, String description, double price, int id_category) {
        Product product;
        Category category;
        try{
            category = em.find(Category.class, id_category);
            if (!(category == null)){
                if (price != 0.0) {
                    product = new Product(id, code, brand, description, price, category.getId());
                    em.persist(product);
                    transaction.commit();
                } else {
                    throw new IllegalArgumentException("Debe ingresar un precio valido mayor a 0.");
                }
            } 
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }     
    }

    @Override
    public void update_product(int id, String code, String brand, String description, double price, int id_category) {
        
        try{
            Product product = em.find(Product.class, id);
            Category category = em.find(Category.class, id_category);
            if (product != null) {
                if (category != null) {
                    if (price != 0.0){
                        product.setCode(code);
                        product.setBrand(brand);
                        product.setDescription(description);
                        product.setPrice(price);
                        product.setIdCategory(category.getId());
                        transaction.commit();
                    } else {
                        throw new IllegalArgumentException("Debe ingresar un precio valido mayor a 0.");
                    }
                } 
            } 
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } 
    }

    @Override
    public List<Product> list_products() {
        List<Product> products = null;
        try {
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
            products = query.getResultList();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return products;
    }

    public Product find(int id_product) {
        Product product = null;
        try{
            product = em.find(Product.class, id_product);
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return product;
    }

}
