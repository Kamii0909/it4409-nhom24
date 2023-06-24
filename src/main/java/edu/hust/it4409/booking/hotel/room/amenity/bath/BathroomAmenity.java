package edu.hust.it4409.booking.hotel.room.amenity.bath;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BathroomAmenity {
    private int numberOfBathrooms;
    private BathroomPosition type;
    private boolean hasTowels;
    private boolean hasBathrobes;
    private boolean hasToiletries;
    private boolean hasAirDryer;


}
