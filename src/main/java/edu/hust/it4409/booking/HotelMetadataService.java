package edu.hust.it4409.booking;

import java.math.BigDecimal;
import java.util.List;

import edu.hust.it4409.booking.hotel.Hotel;

public interface HotelMetadataService {
    List<Hotel> getHotels(int page, int pageSize);
    
    List<Hotel> getHotelsWith(BigDecimal moneyFrom,
        BigDecimal moneyTo,
        List<Integer> starRatings,
        double rankingMin);
    
    List<Hotel> getHotelsWith(BigDecimal moneyFrom,
        BigDecimal moneyTo,
        List<Integer> starRatings,
        double rankingMin,
        int page,
        int pageSize);
}
