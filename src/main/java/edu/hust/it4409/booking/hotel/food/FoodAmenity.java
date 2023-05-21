package edu.hust.it4409.booking.hotel.food;

import com.google.common.collect.ImmutableList;

import edu.hust.it4409.booking.hotel.HotelAmenity;

public interface FoodAmenity extends HotelAmenity {
    ImmutableList<String> breakfastPolicies();
    int restaurants();
    
}
