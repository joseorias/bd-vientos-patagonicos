package tp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private boolean approved;
    private CreditCard creditCard;

    public Pay(double amount, CreditCard card) {
        if (card != null){
            this.amount = amount;
            this.creditCard = card;
            this.approved = true;
        } else{
            this.approved = false;
        }
        
    }

    public Pay(int id, double amount, boolean approved, CreditCard card) {
        this.id = id;
        this.amount = amount;
        this.approved = approved;
        this.creditCard = card;
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
    private double getAmount() {
        return amount;
    }

    @SuppressWarnings("unused")
    private void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isApproved() {
        return approved;
    }

    @SuppressWarnings("unused")
    private void setApproved(boolean approved) {
        this.approved = approved;
    }

    @SuppressWarnings("unused")
    private CreditCard getCreditCard() {
        return creditCard;
    }

    @SuppressWarnings("unused")
    private void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }


    


}
