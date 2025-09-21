package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.Month;
import java.time.Year;

@Entity
@DiscriminatorValue(value = "CreditCard")
public class CreditCard extends BaseBillingDetail{

    @Column(name = "type")
    private String type;

    @Column(name = "expiry_month", nullable = false)
    private Month expiryMonth;

    @Column(name = "expiry_year", nullable = false)
    private Year expiryYear;


    public Month getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Month expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public Year getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Year expiryYear) {
        this.expiryYear = expiryYear;
    }
}
