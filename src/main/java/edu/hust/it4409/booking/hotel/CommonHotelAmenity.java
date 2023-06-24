package edu.hust.it4409.booking.hotel;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import edu.hust.it4409.booking.hotel.amenity.breakfast.BreakfastAmenity;
import edu.hust.it4409.booking.hotel.amenity.internet.InternetAmenity;
import edu.hust.it4409.booking.hotel.amenity.parking.ParkingAmenity;
import edu.hust.it4409.booking.hotel.amenity.pool.PoolAmenity;
import edu.hust.it4409.booking.hotel.amenity.service.GuestService;
import edu.hust.it4409.booking.hotel.config.InternetAmenityConverter;
import edu.hust.it4409.booking.hotel.config.ParkingAmenityConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class CommonHotelAmenity {
    @Convert(converter = InternetAmenityConverter.class)
    @JdbcTypeCode(SqlTypes.JSON)
    private InternetAmenity internetAmenity;
    @Convert(converter = ParkingAmenityConverter.class)
    @JdbcTypeCode(SqlTypes.JSON)
    private ParkingAmenity parkingAmenity;
    @JdbcTypeCode(SqlTypes.JSON)
    private BreakfastAmenity breakfastAmenity;
    @JdbcTypeCode(SqlTypes.JSON)
    private PoolAmenity poolAmenity;
    @JdbcTypeCode(SqlTypes.JSON)
    private GuestService guestService;
}
