import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.jpa.service.PromotionJPA;
import tp.model.Promotion;

public class TestPromotionJPA {
    private static EntityManagerFactory emf;
    private static PromotionJPA promoJPA;

	@BeforeEach
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("objectdb:testobjectdb.tmp;drop");
        promoJPA = new PromotionJPA();
	}

    @Test
    public void test_create_promotion() {
        promoJPA.init_context(emf);

        promoJPA.create_promotion(1, "De Producto", LocalDate.of(2024, 9, 30), 
                            LocalDate.of(2024, 10, 29), "Pulpito", 10);
        Promotion promo = promoJPA.find(1);

        promoJPA.close_context();

        assertEquals("De Producto", promo.getType());
        assertEquals("Pulpito", promo.getBrand());
        assertEquals(10, promo.getDiscount());
    }
}
