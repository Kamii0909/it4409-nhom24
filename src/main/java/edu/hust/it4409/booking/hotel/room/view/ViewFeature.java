package edu.hust.it4409.booking.hotel.room.view;

import com.google.common.collect.ImmutableList;

import edu.hust.it4409.booking.hotel.room.RoomFeature;

public interface ViewFeature extends RoomFeature {
    String mainView();
    
    boolean hasBalcony();
    
    ImmutableList<String> extraViews();
    
    @Override
    default String getDescription() {
        return "What scenery can be viewed from the room";
    }
}
