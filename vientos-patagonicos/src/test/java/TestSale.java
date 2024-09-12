import tp.model.Category;
import tp.model.Client;
import tp.model.CreditCard;
import tp.model.Product;
import tp.model.Promotion;
import tp.model.Sale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class TestSale {

    @Test
    public void test_calc_total_1(){
            try {
            Promotion promo = new Promotion("De producto", LocalDate.of(2024,9,1), LocalDate.of(2024, 9, 10), "Acme", 10);
            Category category_1 = new Category(1, "Insecticida");
            Category category_2 = new Category(2, "Pegamento");
            Product prod_1 = new Product("code001", "Acme", "Aerosol Insecticida por 300ml", 2500, category_1);
            Product prod_2 = new Product("code002", "TG", "Pegamento para camaras por 250ml", 5000, category_2);
            Product prod_3 = new Product("code003", "Pulpito", "Pegamento uiversal por 200g", 2800, category_2);
             
            
            Client client = new Client("Jose", "Orias", "36704607", "joseorias@gmail.com");
            

            Sale sale = new Sale(LocalDate.now(), "Pendiente");
            sale.addProduct(prod_1);
            sale.addProduct(prod_2);
            sale.addProduct(prod_3);
            sale.addPromotion(promo);
            sale.setClient(client);

            sale.setTotal(sale.calcTotal());
            
            assertEquals(10050, sale.getTotal());

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
    }

    @Test
    public void test_calc_total_2(){
            try {
            Promotion promo = new Promotion("De compra", LocalDate.of(2024,9,1), LocalDate.of(2024, 9, 10), "Visa", 15);
            Category category_1 = new Category(1, "Insecticida");
            Category category_2 = new Category(2, "Pegamento");
            Product prod_1 = new Product("code001", "Acme", "Aerosol Insecticida por 300ml", 2500, category_1);
            Product prod_2 = new Product("code002", "TG", "Pegamento para camaras por 250ml", 5000, category_2);
            Product prod_3 = new Product("code003", "Pulpito", "Pegamento uiversal por 200g", 2800, category_2);
             
            Client client = new Client("Jose", "Orias", "36704607", "joseorias@gmail.com");

            Sale sale = new Sale(LocalDate.now(), "Pendiente");
            sale.addProduct(prod_1);
            sale.addProduct(prod_2);
            sale.addProduct(prod_3);
            sale.addPromotion(promo);
            sale.setClient(client);

            CreditCard card = new CreditCard("4576 4532", LocalDate.of(2022, 5, 1), LocalDate.of(2029, 11, 20), "Visa", client);
            
            sale.finaliceSale(card);

            assertEquals(8755, sale.getTotal());

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
    }


    @Test
    public void test_calc_total_3(){
            try {
            Promotion promo_1 = new Promotion("De producto", LocalDate.of(2024,9,1), LocalDate.of(2024, 9, 10), "Comarca", 10);
            Promotion promo_2 = new Promotion("De compra", LocalDate.of(2024,9,1), LocalDate.of(2024, 9, 10), "MemeCard", 15);
            Category category_1 = new Category(1, "Insecticida");
            Category category_2 = new Category(2, "Pegamento");
            Product prod_1 = new Product("code001", "Acme", "Aerosol Insecticida por 300ml", 2500, category_1);
            Product prod_2 = new Product("code002", "Comarca", "Pegamento para camaras por 250ml", 5000, category_2);
            Product prod_3 = new Product("code003", "Comarca", "Pegamento uiversal por 200g", 2800, category_2);
             
            Client client = new Client("Jose", "Orias", "36704607", "joseorias@gmail.com");

            Sale sale = new Sale(LocalDate.now(), "Pendiente");
            sale.addProduct(prod_1);
            sale.addProduct(prod_2);
            sale.addProduct(prod_3);
            sale.addPromotion(promo_1);
            sale.addPromotion(promo_2);
            sale.setClient(client);

            CreditCard card = new CreditCard("4576 4532", LocalDate.of(2022, 5, 1), LocalDate.of(2029, 11, 20), "MemeCard", client);
            
            sale.finaliceSale(card);
            //sale.setTotal(sale.calcTotal());
            assertEquals(8092, sale.getTotal());

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
    }
}
