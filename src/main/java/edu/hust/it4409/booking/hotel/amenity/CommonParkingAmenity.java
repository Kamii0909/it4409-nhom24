package edu.hust.it4409.booking.hotel.amenity;

public enum CommonParkingAmenity implements ParkingAmenity {
    HAS_ALL(true, true, true, true),
    SELF_PARK_LONG_TERM(true, false, true, true),
    VALET_PARK_SHORT_TERM(false, true, false, false),
    HAS_NO_PARKING(false, false, false, false);
    
    private final boolean hasSelfParking;
    private final boolean hasValetParking;
    private final boolean hasLongTermParking;
    private final boolean hasOnSiteParking;
    
    private CommonParkingAmenity(boolean hasSelfParking,
        boolean hasValetParking,
        boolean hasLongTermParking,
        boolean hasOnSiteParking) {
        this.hasSelfParking = hasSelfParking;
        this.hasValetParking = hasValetParking;
        this.hasLongTermParking = hasLongTermParking;
        this.hasOnSiteParking = hasOnSiteParking;
    }
    
    @Override
    public boolean hasSelfParking() {
        return hasSelfParking;
    }
    
    @Override
    public boolean hasValetParking() {
        return hasValetParking;
    }
    
    @Override
    public boolean hasLongTermParking() {
        return hasLongTermParking;
    }
    
    @Override
    public boolean hasOnSiteParking() {
        return hasOnSiteParking;
    }
    
}
