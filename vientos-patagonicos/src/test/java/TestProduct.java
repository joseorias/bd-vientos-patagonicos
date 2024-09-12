import tp.model.Category;
import tp.model.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestProduct {

    @Test
    public void test_create_product(){
        Category category = new Category(1, "Electro");
        Product product = new Product(null, null, "description", 1000, category);

        assertEquals("description", product.getDescription());
        assertEquals(1000, product.getPrice());
        assertEquals("Electro", product.getCategory().getName());
    }
}
