package edu.hust.it4409.booking.hotel.room;

import java.util.Optional;

import edu.hust.it4409.booking.hotel.room.amenity.CommonRoomAmenity;
import edu.hust.it4409.booking.hotel.room.bed.BedFeature;
import edu.hust.it4409.booking.hotel.room.food.FoodFeature;
import edu.hust.it4409.booking.hotel.room.view.ViewFeature;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonRoomFeature {
    
    private BedFeature bedFeature;
    private ViewFeature viewFeature;
    private FoodFeature foodFeature;
    private CommonRoomAmenity commonRoomAmenity;
    
    public String getDescription() {
        return "Common room amenities found around hotels";
    }
    
}
