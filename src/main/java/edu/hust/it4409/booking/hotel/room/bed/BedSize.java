package edu.hust.it4409.booking.hotel.room.bed;

import java.util.Optional;

public interface BedSize {
    
    /**
     * How many people/adults can sleep on that. Not the maximum, but the prefered
     * amount.
     * 
     * @return the preferred amount of people for a sleep.
     */
    int numberOfAdults();
    
    /**
     * @return A short description about the bed size.
     */
    String getDescription();
    
    /**
     * @return the width (in centimeters).
     */
    double getWidth();
    
    /**
     * @return the height (in centimeters).
     */
    double getHeight();
    
    /**
     * An optional path to an image of the bed size.
     * 
     * @apiNote by default, this implementation returns empty (no image).
     */
    default Optional<String> image() {
        return Optional.empty();
    }
}
