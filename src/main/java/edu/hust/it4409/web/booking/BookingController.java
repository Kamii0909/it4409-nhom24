package edu.hust.it4409.web.booking;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import edu.hust.it4409.booking.HotelMetadataService;
import edu.hust.it4409.booking.hotel.Hotel;
import edu.hust.it4409.booking.hotel.HotelRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BookingController {
    
    // TODO
    private final HotelRepository hotelRepository;
    private final HotelMetadataService hotelMetadataService;
    
    @GetMapping("/")
    String get() {
        return "Hello";
    }
    
    @GetMapping("/hotel")
    List<Hotel> getHotel() {
        return hotelRepository.findAll();
    }
    
    @ResponseBody
    @GetMapping(value = "/hotel/filter", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Hotel> filterHotels(@RequestBody FilterBody filter,
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "pageSize", defaultValue = "20") int pageSize
        ) {
        return hotelMetadataService.getHotelsWith(filter.moneyFrom, filter.moneyTo, filter.starRatings,
            filter.rankingMin, page, pageSize);
    }
    
    @GetMapping("/hotel/{id}")
    Optional<Hotel> getHotel(@PathVariable("id") Long id) {
        return hotelRepository.findById(id);
    }

    @PostMapping(value = "/hotel/new")
    Hotel addNewHotel(@RequestBody Hotel hotel) {
        return hotelRepository.persist(hotel);
    }
}
