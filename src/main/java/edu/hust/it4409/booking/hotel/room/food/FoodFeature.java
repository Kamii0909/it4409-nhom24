package edu.hust.it4409.booking.hotel.room.food;

import com.google.common.collect.ImmutableList;

import edu.hust.it4409.booking.hotel.room.RoomFeature;

public interface FoodFeature extends RoomFeature {
    boolean hasFreeBreakfast();
    
    boolean hasFreeLunch();
    
    boolean hasFreeDinner();

    boolean hasRoomService();

    boolean hasLimitedRoomService();

    ImmutableList<String> others();
    
    @Override
    default String getDescription() {
        return "Food and drink service of the hotel";
    }
}
