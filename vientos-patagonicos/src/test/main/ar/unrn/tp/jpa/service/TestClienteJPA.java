import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp.jpa.service.ClientJPA;
import tp.model.Client;
import tp.model.CreditCard;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestClienteJPA {
    private static EntityManagerFactory emf;
    private static ClientJPA cliJPA;

	@BeforeEach
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("objectdb:testobjectdb.tmp;drop");
        cliJPA = new ClientJPA();
	}
    

    @Test 
    public void test_create_client(){
        cliJPA.init_context(emf);

        cliJPA.create_client_id(1, "Jose", "Orias", "36704607", "joseorias@gmail.com");
        Client client = cliJPA.find_client_by_id(1);
        
        cliJPA.close_context();

        assertEquals("Jose", client.getName());
        assertEquals("Orias", client.getLastname());
        assertEquals("36704607", client.getDni());
        assertEquals("joseorias@gmail.com", client.getEmail());
    }

    @Test 
    public void test_update_client(){
        cliJPA.init_context(emf);
        cliJPA.create_client_id(2, "Jose", "Orias", "36704607", "joseorias@gmail.com");
        cliJPA.close_context();

        cliJPA.init_context(emf);
        cliJPA.update_client(2, "Jose", "Arias", "36704607", "oriasjose@gmail.com");
       
        Client cli_uptate = cliJPA.find_client_by_id(2);
        cliJPA.close_context();

        assertEquals("Arias", cli_uptate.getLastname());
        assertEquals("oriasjose@gmail.com", cli_uptate.getEmail());
    }

    @Test 
    public void test_add_card(){
        cliJPA.init_context(emf);
        cliJPA.create_client_id(3, "Jose", "Orias", "36704607", "joseorias@gmail.com");
        cliJPA.close_context();

        cliJPA.init_context(emf);
        cliJPA.add_card(3, "1234456754895670", LocalDate.of(2023,8,15), LocalDate.of(2027,5,24), "Visa");
        cliJPA.close_context();
        cliJPA.init_context(emf);
        cliJPA.add_card(3, "1234456778258209", LocalDate.of(2024,8,15), LocalDate.of(2028,5,24), "Mastercard");
        
        Client client = cliJPA.find_client_by_id(3);
        cliJPA.close_context();

        assertNotNull(client.getCards());
        assertEquals(2, client.getCards().size());

    }

    @Test 
    public void test_list_card(){
        List<CreditCard> list_card;
        cliJPA.init_context(emf);
        cliJPA.create_client_id(3, "Jose", "Orias", "36704607", "joseorias@gmail.com");
        cliJPA.close_context();

        cliJPA.init_context(emf);
        cliJPA.add_card(3, "1234456754895670", LocalDate.of(2023,8,15), LocalDate.of(2027,5,24), "Visa");
        cliJPA.close_context();
        cliJPA.init_context(emf);
        cliJPA.add_card(3, "1234456778258209", LocalDate.of(2024,8,15), LocalDate.of(2028,5,24), "Mastercard");
        
        list_card = cliJPA.list_card(3);
        cliJPA.close_context();

        assertNotNull(list_card);
        assertEquals(2, list_card.size());
        assertEquals("Visa", list_card.get(0).getLine());
        assertEquals("Mastercard", list_card.get(1).getLine());
    }
}
