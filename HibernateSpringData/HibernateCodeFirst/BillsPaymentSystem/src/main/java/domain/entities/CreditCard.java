package domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {
    private String cardType;
    private Integer expirationMoth;
    private Integer expirationYear;

    public CreditCard() {
    }

    @Column(name = "card_type")
    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_month")
    public Integer getExpirationMoth() {
        return this.expirationMoth;
    }

    public void setExpirationMoth(Integer expirationMoth) {
        this.expirationMoth = expirationMoth;
    }

    @Column(name = "expiration_year")
    public Integer getExpirationYear() {
        return this.expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }
}
