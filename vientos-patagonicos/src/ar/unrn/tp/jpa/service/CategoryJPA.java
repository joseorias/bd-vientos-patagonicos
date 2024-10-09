package tp.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import tp.model.Category;

public class CategoryJPA {
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

    public void create_category(int id, String name) {
        Category category;
        try{
            category = new Category(id, name);
            em.persist(category);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } 
        
    }
}
