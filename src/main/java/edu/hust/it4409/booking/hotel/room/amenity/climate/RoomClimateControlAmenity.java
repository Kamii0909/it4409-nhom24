package edu.hust.it4409.booking.hotel.room.amenity.climate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomClimateControlAmenity {
    private boolean hasAirConditioning;
    private boolean hasFan;
    private boolean hasHeating;
}
