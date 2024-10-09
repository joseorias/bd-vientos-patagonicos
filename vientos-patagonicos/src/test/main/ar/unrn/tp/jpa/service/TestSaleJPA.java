import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.jpa.service.CategoryJPA;
import tp.jpa.service.ClientJPA;
import tp.jpa.service.ProductJPA;
import tp.jpa.service.PromotionJPA;
import tp.jpa.service.SaleJPA;
import tp.model.Sale;

public class TestSaleJPA {
    private static EntityManagerFactory emf;
    private static SaleJPA saleJPA;
    private static ClientJPA cliJPA;
    private static PromotionJPA promoJPA;
    private static ProductJPA prodJPA;
    private static CategoryJPA cateJPA;

	@BeforeEach
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("objectdb:testobjectdb.tmp;drop");
        saleJPA = new SaleJPA();
        cliJPA = new ClientJPA();
        promoJPA = new PromotionJPA();
        prodJPA = new ProductJPA();
        cateJPA = new CategoryJPA();
        cateJPA.init_context(emf);
        cateJPA.create_category(1, "Adhesivos");
        cateJPA.close_context();
        
	}

    @Test
    public void test_create_sale() {
        cliJPA.init_context(emf);
        cliJPA.create_client_id(1, "Jose", "Orias", "36704607", "joseorias@gmail.com");
        cliJPA.close_context();
        cliJPA.init_context(emf);
        cliJPA.add_card(1, "1234456754895670", LocalDate.of(2023,8,15), LocalDate.of(2027,5,24), "Visa");
        cliJPA.close_context();

        promoJPA.init_context(emf);
        promoJPA.create_promotion(1, "De Producto", LocalDate.of(2024, 9, 30), 
                            LocalDate.of(2024, 10, 29), "Pulpito", 10);
        promoJPA.close_context();
        promoJPA.init_context(emf);
        promoJPA.create_promotion(2, "De Compra", LocalDate.of(2024, 9, 30), 
                            LocalDate.of(2024, 10, 29), "Visa", 15);
        promoJPA.close_context();
        
        prodJPA.init_context(emf);
        prodJPA.create_product(1, "AD1234", "Pulpito", "Pegamento Universal", 1400, 1);
        prodJPA.close_context();

        prodJPA.init_context(emf);
        prodJPA.create_product(2, "AD1252", "Poxipol", "Pegamento Universal", 1600, 1);
        prodJPA.close_context();

        prodJPA.init_context(emf);
        prodJPA.create_product(3, "AD1434", "Pegamax", "Pegamento Universal", 1100, 1);
        prodJPA.close_context();

        List<Integer> products = new ArrayList<>();
        products.add(1);
        products.add(2);
        products.add(3);

        saleJPA.init_context(emf);
        saleJPA.create_sale(1, 1, products, 1);
        saleJPA.close_context();

        saleJPA.init_context(emf);
        Sale sale = saleJPA.find(1);
        saleJPA.close_context();

        assertEquals(3, sale.getProducts().size());
        assertEquals("Jose", sale.getClient().getName());
        assertEquals("Orias", sale.getClient().getLastname());
        assertEquals("36704607", sale.getClient().getDni());
    }

    @Test
    public void test_list_sales() {
        cliJPA.init_context(emf);
        cliJPA.create_client_id(1, "Jose", "Orias", "36704607", "joseorias@gmail.com");
        cliJPA.close_context();
        cliJPA.init_context(emf);
        cliJPA.create_client_id(2, "Luis", "Lopez", "38404907", "lopez@gmail.com");
        cliJPA.close_context();
        cliJPA.init_context(emf);
        cliJPA.add_card(1, "12341234", LocalDate.of(2023, 8, 21), LocalDate.of(2027, 8, 9), "Visa");
        cliJPA.close_context();
        cliJPA.init_context(emf);
        cliJPA.add_card(2, "33341234", LocalDate.of(2023, 8, 21), LocalDate.of(2027, 8, 9), "Visa");
        cliJPA.close_context();

        prodJPA.init_context(emf);
        prodJPA.create_product(1, "AD1234", "Pulpito", "Pegamento Universal", 1400, 1);
        prodJPA.close_context();
        prodJPA.init_context(emf);
        prodJPA.create_product(2, "AD1252", "Poxipol", "Pegamento Universal", 1600, 2);
        prodJPA.close_context();

        List<Integer> products_1 = new ArrayList<>();
        products_1.add(1);
        List<Integer> products_2 = new ArrayList<>();
        products_2.add(2);

        saleJPA.init_context(emf);
        saleJPA.create_sale(1, 1, products_1, 1);
        saleJPA.close_context();
        saleJPA.init_context(emf);
        saleJPA.create_sale(2, 2, products_2, 2);
        saleJPA.close_context();

        saleJPA.init_context(emf);
        List<Sale> sales = saleJPA.list_sales();
        saleJPA.close_context();

        assertNotNull(sales);
        assertEquals(2, sales.size());
        assertEquals("Jose", sales.get(0).getClient().getName());
        assertEquals(1, sales.get(0).getProducts().size());
        assertEquals("Luis", sales.get(1).getClient().getName());
    }

    @Test
    public void test_calc_total() {
        promoJPA.init_context(emf);
        promoJPA.create_promotion(1, "De Producto", LocalDate.of(2024, 9, 30), 
                            LocalDate.of(2024, 10, 29), "Pulpito", 10);
        promoJPA.close_context();

        cliJPA.init_context(emf);
        cliJPA.create_client_id(1, "Jose", "Orias", "36704607", "joseorias@gmail.com");
        cliJPA.close_context();
        
        cliJPA.init_context(emf);
        cliJPA.add_card(1, "12341234", LocalDate.of(2023, 8, 21), LocalDate.of(2027, 8, 9), "Visa");
        cliJPA.close_context();

        prodJPA.init_context(emf);
        prodJPA.create_product(1, "AD1234", "Pulpito", "Pegamento Universal", 1400, 1);
        prodJPA.close_context();

        List<Integer> products = new ArrayList<>();
        products.add(1);

        saleJPA.init_context(emf);
        double total = saleJPA.calc_total(products, 1); 
        saleJPA.close_context();

        assertEquals(1260, total);

    }
}
