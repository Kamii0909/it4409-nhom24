package edu.hust.it4409.booking.hotel;

import com.google.common.collect.ImmutableList;

import edu.hust.it4409.common.model.interfaces.ValueObject;

public interface HotelAmenity extends ValueObject {

    default ImmutableList<String> extraInformation() {
        return ImmutableList.of();
    }

    default String getDescription() {
        return "Hotel Amenity";
    }
}
