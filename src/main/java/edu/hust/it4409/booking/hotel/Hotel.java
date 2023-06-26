package edu.hust.it4409.booking.hotel;

import java.util.List;

import javax.money.MonetaryAmount;

import org.hibernate.annotations.CompositeTypeRegistration;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import edu.hust.it4409.booking.hotel.room.HotelRoom;
import edu.hust.it4409.common.model.skeleton.AbstractAggregateRoot;
import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@CompositeTypeRegistration(userType = MonetaryAmountType.class, embeddableClass = MonetaryAmount.class)
@Table(name = "hotel")
@SuperBuilder
public class Hotel extends AbstractAggregateRoot {
    private String name;
    private String description;
    private int starRating;
    @Transient
    private double reviewRanking;
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> images;
    private String location;
    private HotelAmenity hotelAmenity;
    @OneToMany(
        mappedBy = "hotel",
        fetch = FetchType.EAGER,
        cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JsonManagedReference
    private List<HotelRoom> rooms;
    
    public Hotel(String name,
        String description,
        int starRating,
        List<String> images,
        String location,
        HotelAmenity hotelAmenity) {
        this.name = name;
        this.description = description;
        this.starRating = starRating;
        this.images = images;
        this.location = location;
        this.hotelAmenity = hotelAmenity;
    }
    
}
