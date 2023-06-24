package edu.hust.it4409.booking.hotel.amenity.parking;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    
    private static final Map<String, CommonParkingAmenity> ENUM_MAP;
    
    static {
        ENUM_MAP = Stream.of(CommonParkingAmenity.values())
            .collect(Collectors.toMap(CommonParkingAmenity::toJson, Function.identity()));
    }
    
    public String toJson() {
        return "\"" + name() + "\"";
    }
    
    public static CommonParkingAmenity fromJson(String value) {
        return ENUM_MAP.get(value);
    }
    
}
