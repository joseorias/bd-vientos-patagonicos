package tp.api;

import java.time.LocalDate;

public interface PromotionService {
    void create_promotion(String type, LocalDate starDate, LocalDate endDate, String brand, int discount);
}
