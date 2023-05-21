package edu.hust.it4409.booking.hotel.amenity;

import javax.money.MonetaryAmount;

import edu.hust.it4409.booking.hotel.Surcharged;

public interface BreakfastAmenity {

    public interface BreakfastCharge extends Surcharged {
        MonetaryAmount perAdult();
        MonetaryAmount perChild();
    }

    public interface BreakfastAvailability {
        boolean isFree();

    }
    boolean isFree();

    String breakfastType();


}
