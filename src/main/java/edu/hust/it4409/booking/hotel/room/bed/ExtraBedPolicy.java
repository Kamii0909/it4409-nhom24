package edu.hust.it4409.booking.hotel.room.bed;

import java.util.Collection;

/**
 * WIP
 */
public interface ExtraBedPolicy {
    boolean allowed();
    boolean allowed(Collection<BedUnit> required);
}
