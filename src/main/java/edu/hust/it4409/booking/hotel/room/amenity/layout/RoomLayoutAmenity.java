package edu.hust.it4409.booking.hotel.room.amenity.layout;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomLayoutAmenity {
    private boolean hasCloset;
    private boolean hasDesk;
    private boolean hasConnectingRoom;
    private boolean hasWindow;
}
