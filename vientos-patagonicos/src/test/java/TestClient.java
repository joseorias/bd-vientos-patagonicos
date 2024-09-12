

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import tp.model.Client;

public class TestClient {

    @Test
    public void test_create_client(){
        try {
            Client client = new Client("Jose", "Orias", "36704607", "joseorias@gmail.com");

            assertEquals("Jose", client.getName());
            assertEquals("Orias", client.getLastname());
            assertEquals(36704607, client.getDni());
            assertEquals("joseorias@gmail.com", client.getEmail());
        } catch (IllegalAccessException e){
            
        }
    }
}
