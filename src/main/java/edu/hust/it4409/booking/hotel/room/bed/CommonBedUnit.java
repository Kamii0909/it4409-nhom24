package edu.hust.it4409.booking.hotel.room.bed;

import static edu.hust.it4409.booking.hotel.room.bed.CommonBedSize.*;

public enum CommonBedUnit implements BedUnit {
    SINGLE_CRIB(CRIB, 1),
    SINGLE_ROLLAWAY(ROLLAWAY, 1),
    SINGLE_TWIN(TWIN_BED, 1),
    DOUBLE_TWIN(TWIN_BED, 2),
    TRIPLE_TWIN(TWIN_BED, 3),
    SINGLE_FULL(FULL, 1),
    DOUBLE_FULL(FULL, 2),
    SINGLE_QUEEN(QUEEN, 1),
    DOUBLE_QUEEN(QUEEN, 2),
    SINGLE_KING(KING, 1),
    DOUBLE_KING(KING, 2),
    SINGLE_CALIFORNIA_KING(CALIFORNIA_KING, 1),
    DOUBLE_CALIFORNIA_KING(CALIFORNIA_KING, 2);
    
    private final BedSize bedSize;
    private final int numberOfBeds;
    
    private CommonBedUnit(BedSize bedSize, int numberOfBeds) {
        this.bedSize = bedSize;
        this.numberOfBeds = numberOfBeds;
    }
    
    @Override
    public BedSize getBedSize() {
        return bedSize;
    }
    
    @Override
    public int numberOfBeds() {
        return numberOfBeds;
    }
}
