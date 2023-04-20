package edu.hust.it4409.booking.hotel.room;

import edu.hust.it4409.booking.hotel.room.bed.BedFeature;
import edu.hust.it4409.booking.hotel.room.food.FoodFeature;
import edu.hust.it4409.booking.hotel.room.view.ViewFeature;
import lombok.Data;

@Data
public class CommonRoomFeature implements RoomFeature {
    
    private final BedFeature bedFeature;
    private final ViewFeature viewFeature;
    private final FoodFeature foodFeature;
    private final boolean hasWifi;
    private final boolean hasAirConditioning;
    private final boolean hasTV;
    private final boolean hasHeating;
    
    @Override
    public String getDescription() {
        return "Common room amenities found around hotels";
    }
    
}
