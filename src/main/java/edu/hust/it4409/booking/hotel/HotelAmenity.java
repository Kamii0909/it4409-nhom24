package edu.hust.it4409.booking.hotel;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import edu.hust.it4409.booking.hotel.amenity.additional.AdditionalAmenity;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Embeddable
public class HotelAmenity {
    private CommonHotelAmenity commonHotelAmenity;
    @JdbcTypeCode(SqlTypes.JSON)
    private AdditionalAmenity additionalAmenity;
}
