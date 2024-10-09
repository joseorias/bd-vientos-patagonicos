import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.jpa.service.CategoryJPA;
import tp.jpa.service.ProductJPA;
import tp.model.Product;

public class TestProductJPA {
private static EntityManagerFactory emf;
    private static ProductJPA productJPA;
    private static CategoryJPA cateJPA;

	@BeforeEach
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("objectdb:testobjectdb.tmp;drop");
        productJPA = new ProductJPA();
        cateJPA = new CategoryJPA();
        cateJPA.init_context(emf);
        cateJPA.create_category(1, "Adhesivos");
        cateJPA.close_context();
        cateJPA.init_context(emf);
        cateJPA.create_category(2, "Lufricante");
        cateJPA.close_context();
        cateJPA.init_context(emf);
        cateJPA.create_category(3, "Herraje");
        cateJPA.close_context();

	}

    @Test
    public void test_create_product() {
        productJPA.init_context(emf);

        productJPA.create_product(1, "AD1234", "Pulpito", "Pegamento Universal", 1200, 1);
        Product product = productJPA.find(1);
        
        productJPA.close_context();

        assertEquals("AD1234", product.getCode());
        assertEquals("Pulpito", product.getBrand());
        assertEquals("Pegamento Universal", product.getDescription());
        assertEquals(1200, product.getPrice());
        assertEquals(1, product.getIdCategory());
    }

    @Test
    public void test_update_product() {
        productJPA.init_context(emf);
        productJPA.create_product(2, "AD1234", "Pulpito", "Pegamento Universal", 1200, 1);
        productJPA.close_context();

        productJPA.init_context(emf);
        productJPA.update_product(2, "AD1234", "Pulpito", "Pegamento", 1350, 1);
        
        Product productUpdate = productJPA.find(2);
        productJPA.close_context();

        assertEquals(2, productUpdate.getId());
        assertEquals("Pegamento", productUpdate.getDescription());
        assertEquals(1350, productUpdate.getPrice());
    }

    @Test
    public void test_list_products() {
        List<Product> products;

        productJPA.init_context(emf);
        productJPA.create_product(1, "AD1234", "Pulpito", "Pegamento Universal", 1400, 1);
        productJPA.close_context();

        productJPA.init_context(emf);
        productJPA.create_product(2, "AD1252", "Poxipol", "Pegamento Universal", 1600, 1);
        productJPA.close_context();

        productJPA.init_context(emf);
        productJPA.create_product(3, "AD1434", "Pegamax", "Pegamento Universal", 1100, 1);
        
        products = productJPA.list_products();

        productJPA.close_context();

        assertNotNull(products);
        assertEquals(3, products.size());
    }
}
