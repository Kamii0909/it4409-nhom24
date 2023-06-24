package edu.hust.it4409.booking.hotel.room.amenity.refreshment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomRefreshmentAmenity {
    private boolean hasFreeWaterBottle;
    private boolean hasFreeCoffeeOrTea;
    private boolean hasElectricKettle;
    private boolean hasMinibar;
}
