package edu.hust.it4409.booking.hotel.room.bed;

import static com.google.common.collect.ImmutableList.of;
import static edu.hust.it4409.booking.hotel.room.bed.CommonBedUnit.*;

import com.google.common.collect.ImmutableList;

public enum CommonBedFeature implements BedFeature {
    TWIN_BEDDED(of(DOUBLE_TWIN), false, of()),
    TRIPLE_TWIN_BEDDED(of(TRIPLE_TWIN), false, of()),
    ONE_QUEEN_ONE_TWIN_BED(of(SINGLE_QUEEN, SINGLE_TWIN), false, of()),
    ONE_QUEEN_BED(of(SINGLE_QUEEN), false, of()),
    ONE_KING_BED(of(SINGLE_KING), false, of()),
    EXTRA_TWIN_BEDDED(of(DOUBLE_TWIN), true, of(SINGLE_CRIB, SINGLE_ROLLAWAY)),
    EXTRA_ONE_QUEEN_BED(of(SINGLE_QUEEN), true, of(SINGLE_CRIB, SINGLE_ROLLAWAY)),
    EXTRA_ONE_KING_BED(of(SINGLE_KING), true, of(SINGLE_CRIB, SINGLE_ROLLAWAY));
    
    private final ImmutableList<BedUnit> bedUnits;
    private final boolean allowExtraBeds;
    private final ImmutableList<BedUnit> allowedExtraBeds;
    
    private CommonBedFeature(
        ImmutableList<BedUnit> bedUnits,
        boolean allowExtraBeds,
        ImmutableList<BedUnit> allowedExtraBeds) {
        this.bedUnits = bedUnits;
        this.allowExtraBeds = allowExtraBeds;
        this.allowedExtraBeds = allowedExtraBeds;
    }
    
    @Override
    public ImmutableList<BedUnit> getAllBedTypes() {
        return bedUnits;
    }
    
    @Override
    public boolean allowExtraBeds() {
        return allowExtraBeds;
    }
    
    @Override
    public ImmutableList<BedUnit> allowedExtraBeds() {
        return allowedExtraBeds;
    }
    
}
