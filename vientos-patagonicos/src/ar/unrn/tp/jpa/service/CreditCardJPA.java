package tp.jpa.service;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import tp.model.CreditCard;

public class CreditCardJPA {
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

    public void create_creditCard(int id, String number, LocalDate issuDate, LocalDate expiryDate, String line) {
        try {
            CreditCard card = new CreditCard(id, number, issuDate, expiryDate, line);
            em.persist(card);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
