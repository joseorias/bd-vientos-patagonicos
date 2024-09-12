import tp.model.Promotion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class TestPromotion {

    @Test
    public void test_create_promotion(){
        
            LocalDate startDate = LocalDate.of(2024, 9, 10);
            LocalDate endDate = LocalDate.of(2024, 9, 15);
            Promotion promo = new Promotion("De producto", startDate, endDate,
                             "Adidas", 10);

            assertEquals("2024-09-10", promo.getStartDate().toString());
            assertEquals("2024-09-15", promo.getEndDate().toString());
       
    }
}
