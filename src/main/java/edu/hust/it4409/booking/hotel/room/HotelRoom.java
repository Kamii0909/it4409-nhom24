package edu.hust.it4409.booking.hotel.room;

import edu.hust.it4409.booking.hotel.Hotel;
import edu.hust.it4409.common.model.skeleton.AbstractLocalEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelRoom extends AbstractLocalEntity<Hotel> {
    
    private RoomType roomType;
    private RoomTier roomTier;
    private String description;
    private CommonRoomFeature commonRoomFeature;
    @ManyToOne(optional = false)
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
