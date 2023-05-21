package edu.hust.it4409.booking.hotel.amenity;

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
}
