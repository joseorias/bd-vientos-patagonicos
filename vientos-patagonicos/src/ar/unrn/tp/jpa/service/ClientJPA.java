package tp.jpa.service;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import tp.api.ClientService;
import tp.model.Client;
import tp.model.CreditCard;

public class ClientJPA implements ClientService {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction transaction;

    private static void init_context(){
        emf = Persistence.createEntityManagerFactory("objectdb:vientospatagonicos.odb");
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }

    private static void close_context(){
        emf.close(); 
        em.close();
    }

    @Override
    public void create_client(String name, String lastName, String dni, String email) {
        if (!exist_dni(dni)){
            if (validate_email(email)) {
                init_context();
                transaction.begin();
                try{
                    Client client = new Client(name, lastName, dni, email);
                    em.persist(client);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    e.printStackTrace();
                } finally {
                    close_context();
                }
            }
        }
    }

    @Override
    public void update_client(int id, String name, String lastName, String dni, String email) {
        init_context();
        transaction.begin();
        try{
            Client client = em.find(Client.class, id);
            if (client != null) {
                if (client.getDni() != dni) {
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
        } finally {
            close_context();
        }
    }

    @Override
    public void add_card(int id, String number, LocalDate issuDate, LocalDate expiryDate, String line) {
        init_context();
        transaction.begin();
        try {
            Client owner = em.find(Client.class, id);
            if (owner != null) {
                CreditCard card = new CreditCard(number, issuDate, expiryDate, line, id);
                em.persist(card);
                transaction.commit();
            } else {
                transaction.rollback();
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            close_context();
        }
    }

    @Override
    public List<CreditCard> list_card(int id_client) {
        List<CreditCard> cards = null;
        init_context();
        transaction.begin();
        try {
            TypedQuery<CreditCard> query = em.createQuery("SELECT c FROM CreditCard c WHERE c.id_owner = :id_owner", CreditCard.class);
            query.setParameter("id_owner", id_client);
            cards = query.getResultList();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            close_context();
        }
        return cards;
    }

    private static boolean exist_dni(String dni){
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Clients", Client.class);
        List<Client> clients = query.getResultList();
        for (Client c : clients) {
            if (c.getDni() == dni) {
                return true;
            } 
        }
        return false;
    }

    private static boolean validate_email(String email){
        String email_pattern = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
