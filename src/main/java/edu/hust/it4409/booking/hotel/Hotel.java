package edu.hust.it4409.booking.hotel;

import java.util.Collections;
import java.util.List;

import javax.money.MonetaryAmount;

import org.hibernate.annotations.CompositeTypeRegistration;

import edu.hust.it4409.booking.hotel.room.HotelRoom;
import edu.hust.it4409.common.model.skeleton.AbstractAggregateRoot;
import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@CompositeTypeRegistration(userType = MonetaryAmountType.class, embeddableClass = MonetaryAmount.class)
@Table(name = "hotel")
public class Hotel extends AbstractAggregateRoot {
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private HotelAmenity hotelAmenity;
    @OneToMany(mappedBy = "hotel")
    private List<HotelRoom> rooms = Collections.emptyList();
}
