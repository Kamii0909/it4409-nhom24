package edu.hust.it4409.booking;

import java.util.concurrent.ThreadLocalRandom;

import edu.hust.it4409.booking.hotel.Hotel;
import edu.hust.it4409.booking.hotel.room.HotelRoom;
import edu.hust.it4409.booking.spi.ReviewRankingProvider;

public class RandomReviewRankingProvider implements ReviewRankingProvider {
    
    @Override
    public double getReviewRanking(Hotel hotel) {
        return hotel.getReviewRanking() != 0 ? hotel.getReviewRanking() : ThreadLocalRandom.current().nextDouble(5, 10);
    }
    
    @Override
    public double getReviewRanking(HotelRoom hotelRoom) {
        return hotelRoom.getReviewRanking() != 0 ? hotelRoom.getReviewRanking() :
            ThreadLocalRandom.current().nextDouble(5, 10);
    }
    
}
