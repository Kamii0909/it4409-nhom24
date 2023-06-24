package edu.hust.it4409.booking.hotel.amenity.service;

import javax.money.MonetaryAmount;

import org.hibernate.annotations.CompositeType;

import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Smoking {
    /**
     * <p>
     * negative -> not provided
     * <p>
     * 0 -> free smoking area
     * <p>
     * positive -> fined smoking area
     */
    @CompositeType(MonetaryAmountType.class)
    private MonetaryAmount smokingFine;
    
    public boolean isProvided() {
        return smokingFine.isPositiveOrZero();
    }
    
    public boolean isFree() {
        return smokingFine.isNegative();
    }
}
