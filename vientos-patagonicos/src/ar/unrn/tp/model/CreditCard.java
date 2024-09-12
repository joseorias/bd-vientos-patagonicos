package tp.model;

import java.time.LocalDate;

public class CreditCard {

    private int id;
    private String number;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String line;
    private Client owner;

    public CreditCard(String number, LocalDate issuDate, LocalDate expiryDate, String line, Client owner) {
        this.number = number;
        this.issueDate = issuDate;
        this.expiryDate = expiryDate;
        this.line = line;
        this.owner = owner;
    }

    public CreditCard(int id, String number, LocalDate issuDate, LocalDate expiryDate, String line, Client owner) {
        this.id = id;
        this.number = number;
        this.issueDate = issuDate;
        this.expiryDate = expiryDate;
        this.line = line;
        this.owner = owner;
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
    private Client getOwner() {
        return owner;
    }

    @SuppressWarnings("unused")
    private void setOwner(Client owner) {
        this.owner = owner;
    }



}
