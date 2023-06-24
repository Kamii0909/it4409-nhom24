package edu.hust.it4409.booking.hotel.room.amenity;

import edu.hust.it4409.booking.hotel.room.amenity.bath.BathroomAmenity;
import edu.hust.it4409.booking.hotel.room.amenity.climate.RoomClimateControlAmenity;
import edu.hust.it4409.booking.hotel.room.amenity.entertainment.RoomEntertainmentAmenity;
import edu.hust.it4409.booking.hotel.room.amenity.layout.RoomLayoutAmenity;
import edu.hust.it4409.booking.hotel.room.amenity.refreshment.RoomRefreshmentAmenity;
import edu.hust.it4409.booking.hotel.room.amenity.view.RoomViewAmenity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonRoomAmenity {
    private BathroomAmenity bathroomAmenity;
    private RoomViewAmenity roomView;
    private RoomLayoutAmenity roomLayoutAmenity;
    private RoomRefreshmentAmenity roomRefreshmentAmenity;
    private RoomEntertainmentAmenity roomEntertainmentAmenity;
    private RoomClimateControlAmenity roomClimateControlAmenity;
}
