package tp.api;

import java.time.LocalDate;
import java.util.List;

import tp.model.CreditCard;

public interface ClientService {
    void create_client(String name, String lastName, String dni, String email);

    void update_client(int id, String name, String lastName, String dni, String email);

    void add_card(int id, String number, LocalDate issuDate, LocalDate expiryDate, String line);

    List<CreditCard> list_card(int id_client);
}
