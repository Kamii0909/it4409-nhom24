package edu.hust.it4409.booking.hotel.room;

import edu.hust.it4409.booking.hotel.Hotel;
import edu.hust.it4409.common.model.skeleton.AbstractLocalEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class HotelRoom extends AbstractLocalEntity<Hotel> {

    private String description;
    
    private CommonRoomFeature commonRoomFeature;

    @OneToMany(mappedBy = "rooms", fetch = FetchType.LAZY)
    private Hotel hotel;
    
    @Override
    protected void setRoot(Hotel hotel) {
        this.hotel = hotel;
    }
    
    @Override
    public Hotel getAggregateRoot() {
        return hotel;
    }
}
