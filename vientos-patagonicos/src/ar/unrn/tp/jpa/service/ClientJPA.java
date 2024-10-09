package tp.jpa.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import tp.api.ClientService;
import tp.model.Client;
import tp.model.CreditCard;

public class ClientJPA implements ClientService {
    private static EntityManager em;
    private static EntityTransaction transaction;

    public void init_context(EntityManagerFactory emf){
        em = emf.createEntityManager();
        transaction = em.getTransaction();
        transaction.begin();
    }

    public void close_context(){
        em.close();
    }

    @Override
    public void create_client(String name, String lastName, String dni, String email) {
        Client client;
        if (!exist_dni(dni)){
            if (validate_email(email)) {
                try{
                    client = new Client(name, lastName, dni, email);
                    em.persist(client);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    e.printStackTrace();
                } 
            }
        } 
    }

    public void create_client_id(int id, String name, String lastName, String dni, String email) {
        Client client;
        if (!exist_dni(dni)){
            if (validate_email(email)) {
                try{
                    client = new Client(id, name, lastName, dni, email);
                    em.persist(client);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    e.printStackTrace();
                } 
            }
        } 
    }

    public Client find_client_by_id(int id){
        Client client = null;
        try{
            client = em.find(Client.class, id);
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } 
        return client;
    }

    @Override
    public void update_client(int id, String name, String lastName, String dni, String email) {
        try{
            Client client = em.find(Client.class, id);
            if (client != null) {
                if (!(client.getDni().equals(dni))) {
                    if (!exist_dni(dni)){
                        if (validate_email(email)) {
                            client.setName(name);
                            client.setLastname(lastName);
                            client.setDni(dni);
                            client.setEmail(email);
                            transaction.commit();
                        }
                    }
                } else if (validate_email(email)) {
                    client.setName(name);
                    client.setLastname(lastName);
                    client.setDni(dni);
                    client.setEmail(email);
                    transaction.commit();
                }
            } else {
                transaction.rollback();
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } 
    }

    @Override
    public void add_card(int id_owner, String number, LocalDate issuDate, LocalDate expiryDate, String line) {
        try {
            Client owner = em.find(Client.class, id_owner);
            if (owner != null) {
                CreditCard card = new CreditCard(number, issuDate, expiryDate, line);
                owner.add_card(card);
                transaction.commit();
            } else {
                transaction.rollback();
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } 
    }

    @Override
    public List<CreditCard> list_card(int id_client) {
        List<CreditCard> cards = new ArrayList<>();
        try {
            Client client = em.find(Client.class, id_client);
            for (CreditCard card : client.getCards()) {
                cards.add(card);
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return cards;
    }

    private static boolean exist_dni(String dni){
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.dni = :dni", Client.class);
        query.setParameter("dni", dni);
        List<Client> clients = query.getResultList();
        if (!clients.isEmpty()) {
           return true;
        } else {
            return false;
        }        
    }

    private static boolean validate_email(String email){
        String email_pattern = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
