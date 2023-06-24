package edu.hust.it4409.booking.hotel.amenity.internet;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommonInternetAmenity implements InternetAmenity {
    FREE_ALL(true, true, true, true);
    
    private final WifiConnection guestRoom;
    private final WifiConnection publicArea;
    
    private CommonInternetAmenity(
        boolean inGuestRoom,
        boolean isGuestFree,
        boolean inPublicArea,
        boolean isPublicAreaFree) {
        this.guestRoom = new WifiConnection(inGuestRoom, isGuestFree);
        this.publicArea = new WifiConnection(inPublicArea, isPublicAreaFree);
    }
    
    @Override
    public WifiConnection wifiInGuestRooms() {
        return guestRoom;
    }
    
    @Override
    public WifiConnection wifiInPublicAreas() {
        return publicArea;
    }
    
    private static final Map<String, CommonInternetAmenity> ENUM_MAP = Stream.of(CommonInternetAmenity.values())
        .collect(Collectors.toMap(CommonInternetAmenity::toJson, Function.identity()));
    
    public String toJson() {
        return "\"" + name() + "\"";
    }
    
    public static CommonInternetAmenity fromJson(String value) {
        return ENUM_MAP.get(value);
    }
}
