package tp.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String line;
    private int id_owner;

    public CreditCard(String number, LocalDate issuDate, LocalDate expiryDate, String line, int id_owner) {
        this.number = number;
        this.issueDate = issuDate;
        this.expiryDate = expiryDate;
        this.line = line;
        this.id_owner = id_owner;
    }

    public CreditCard(int id, String number, LocalDate issuDate, LocalDate expiryDate, String line, int id_owner) {
        this.id = id;
        this.number = number;
        this.issueDate = issuDate;
        this.expiryDate = expiryDate;
        this.line = line;
        this.id_owner = id_owner;
    }


    @SuppressWarnings("unused")
    private int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(int id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    private String getNumber() {
        return number;
    }

    @SuppressWarnings("unused")
    private void setNumber(String number) {
        this.number = number;
    }

    @SuppressWarnings("unused")
    private LocalDate getIssueDate() {
        return issueDate;
    }

    @SuppressWarnings("unused")
    private void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @SuppressWarnings("unused")
    private LocalDate getExpiryDate() {
        return expiryDate;
    }

    @SuppressWarnings("unused")
    private void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLine() {
        return line;
    }

    @SuppressWarnings("unused")
    private void setLine(String line) {
        this.line = line;
    }

    @SuppressWarnings("unused")
    private int getIdOwner() {
        return id_owner;
    }

    @SuppressWarnings("unused")
    private void setIdOwner(int id_owner) {
        this.id_owner = id_owner;
    }



}
