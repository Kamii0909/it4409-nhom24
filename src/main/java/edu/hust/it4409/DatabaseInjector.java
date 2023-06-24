package edu.hust.it4409;

import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;

import com.google.common.collect.ImmutableList;

import edu.hust.it4409.booking.hotel.CommonHotelAmenity;
import edu.hust.it4409.booking.hotel.Hotel;
import edu.hust.it4409.booking.hotel.HotelAmenity;
import edu.hust.it4409.booking.hotel.HotelRepository;
import edu.hust.it4409.booking.hotel.amenity.additional.AdditionalAmenity;
import edu.hust.it4409.booking.hotel.amenity.breakfast.BreakfastAmenity;
import edu.hust.it4409.booking.hotel.amenity.internet.CommonInternetAmenity;
import edu.hust.it4409.booking.hotel.amenity.parking.CommonParkingAmenity;
import edu.hust.it4409.booking.hotel.amenity.pool.NearybyPool;
import edu.hust.it4409.booking.hotel.amenity.pool.PoolAmenity;
import edu.hust.it4409.booking.hotel.amenity.pool.PoolHour;
import edu.hust.it4409.booking.hotel.amenity.pool.UncommonPoolAmenity;
import edu.hust.it4409.booking.hotel.amenity.service.GuestService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DatabaseInjector implements CommandLineRunner {
    
    private final HotelRepository hotelRepository;
    
    @Override
    public void run(String... args) throws Exception {
        BreakfastAmenity breakfastAmenity = new BreakfastAmenity(ImmutableList.of());
        
        NearybyPool nearybyPool = new NearybyPool(false, false);
        UncommonPoolAmenity uncommonPoolAmenity =
            new UncommonPoolAmenity(false, false, false, false, false, false, false);
        PoolAmenity poolAmenity = new PoolAmenity(0, 0, ImmutableList.of(),
            new PoolHour(LocalTime.of(7, 0), LocalTime.of(19, 0)), nearybyPool, uncommonPoolAmenity);
        
        GuestService guestService = new GuestService();
        
        CommonHotelAmenity commonHotelAmenity = new CommonHotelAmenity(CommonInternetAmenity.FREE_ALL,
            CommonParkingAmenity.HAS_NO_PARKING, breakfastAmenity, poolAmenity, guestService);
        
        AdditionalAmenity additionalAmenity = new AdditionalAmenity(ImmutableList.of());
        HotelAmenity hotelAmenity = new HotelAmenity(commonHotelAmenity, additionalAmenity);
        
        Hotel hotel = new Hotel("test-hotel", "fun hotel from Hanoi", hotelAmenity);
        hotelRepository.persist(hotel);
    }
    
}
