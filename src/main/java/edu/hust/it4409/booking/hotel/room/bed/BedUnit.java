package edu.hust.it4409.booking.hotel.room.bed;

import edu.hust.it4409.common.model.interfaces.ValueObject;

/**
 * A single instance of this class tell the amount of X type bed in a room. 
 */
public interface BedUnit extends ValueObject {
    BedSize getBedSize();
    
    int numberOfBeds();
    
    default int numberOfAdults() {
        return numberOfAdults() * getBedSize().numberOfAdults();
    }
}
