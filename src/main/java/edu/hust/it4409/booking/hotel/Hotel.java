package edu.hust.it4409.booking.hotel;

import java.util.List;

import com.google.common.collect.ImmutableList;

import edu.hust.it4409.booking.hotel.amenity.InternetAmenity;
import edu.hust.it4409.booking.hotel.room.HotelRoom;
import edu.hust.it4409.common.model.skeleton.AbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Hotel extends AbstractAggregateRoot {
    
    private String name;
    private String description;
    @OneToMany
    private List<HotelRoom> rooms;

    private ImmutableList<String> foodAndDrinks;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<HotelRoom> getRooms() {
        return rooms;
    }
    
    public void setRooms(List<HotelRoom> rooms) {
        this.rooms = rooms;
    }
}
