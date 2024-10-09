package tp.jpa.service;

import java.time.DateTimeException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import tp.api.PromotionService;
import tp.model.Promotion;

public class PromotionJPA implements PromotionService {
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
    public void create_promotion(String type, LocalDate starDate, LocalDate endDate, String brand, int discount) {
        Promotion promotion;
        transaction.begin();
        try{
            if (validate_dates(starDate, endDate)){
                promotion = new Promotion(type, starDate, endDate, brand, discount);
                em.persist(promotion);
                transaction.commit();
            } else {
                transaction.rollback();
                throw new DateTimeException("Error: Fechas de la promocion invalidas.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }   
    }

    public void create_promotion(int id, String type, LocalDate starDate, LocalDate endDate, String brand, int discount) {
        Promotion promotion;
        try{
            if (validate_dates(starDate, endDate)){
                promotion = new Promotion(id, type, starDate, endDate, brand, discount);
                em.persist(promotion);
                transaction.commit();
            } else {
                transaction.rollback();
                throw new DateTimeException("Error: Fechas de la promocion invalidas.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }   
    }

    public Promotion find(int id) {
        Promotion promo = null;
        try {
            promo = em.find(Promotion.class, id);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return promo;
    }

    private boolean validate_dates(LocalDate start, LocalDate end){
        LocalDate now = LocalDate.now();
        return (start.isEqual(now) || start.isBefore(now) && 
                start.isBefore(end) || start.isEqual(end));
    }

    

}
