package edu.hust.it4409.booking.hotel.amenity.breakfast;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.FastMoney;

import edu.hust.it4409.booking.hotel.Surcharged;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class BreakfastCharge implements Surcharged {
    public static final CurrencyUnit DEFAULT_CURRENCY = Monetary.getCurrency("USD");
    private static final MonetaryAmount FREE_MONETARY_AMOUNT = FastMoney.zero(DEFAULT_CURRENCY);
    public static final BreakfastCharge FREE = new BreakfastCharge(FREE_MONETARY_AMOUNT, FREE_MONETARY_AMOUNT);
    @AttributeOverride(
        name = "amount",
        column = @Column(name = "per_adult_amount"))
    @AttributeOverride(
        name = "currency",
        column = @Column(name = "per_adult_currency"))
    private MonetaryAmount perAdult;
    @AttributeOverride(
        name = "amount",
        column = @Column(name = "per_child_amount"))
    @AttributeOverride(
        name = "currency",
        column = @Column(name = "per_child_currency"))
    private MonetaryAmount perChild;
    
    @Override
    public boolean isFree() {
        return perAdult.isZero() && perChild.isZero();
    }
}
