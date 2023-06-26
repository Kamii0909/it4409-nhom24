package edu.hust.it4409.booking;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.data.domain.PageRequest;

import edu.hust.it4409.booking.hotel.Hotel;
import edu.hust.it4409.booking.hotel.HotelRepository;
import edu.hust.it4409.booking.hotel.room.HotelRoom;
import edu.hust.it4409.booking.spi.ReviewRankingProvider;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HotelMetadataServiceImpl implements HotelMetadataService {
    private static final BigDecimal MAX_BIG_DECIMAL = BigDecimal.valueOf(Long.MAX_VALUE);
    private static final List<Integer> ALL_STAR_RATINGS =
        IntStream.range(0, 15)
            .boxed()
            .toList();
    private static final Comparator<Hotel> MIN_ROOM_COST_COMPARATOR = (h1, h2) -> {
        HotelRoom minH1 = h1.getRooms().stream().min(HotelRoom.COMPARATOR).get();
        HotelRoom minH2 = h2.getRooms().stream().min(HotelRoom.COMPARATOR).get();
        return HotelRoom.COMPARATOR.compare(minH1, minH2);
    };
    private final HotelRepository hotelRepository;
    private final ReviewRankingProvider rankingProvider;
    
    @Override
    public List<Hotel> getHotels(int page, int pageSize) {
        return getHotelsWith(BigDecimal.ZERO, MAX_BIG_DECIMAL, ALL_STAR_RATINGS, 0, page, pageSize);
    }
    
    @Override
    public List<Hotel> getHotelsWith(BigDecimal moneyFrom,
        BigDecimal moneyTo,
        List<Integer> starRatings,
        double rankingMin) {
        return getHotelsWith(moneyFrom, moneyTo, starRatings, rankingMin, 0, 20);
    }
    
    @Override
    public List<Hotel> getHotelsWith(BigDecimal moneyFrom,
        BigDecimal moneyTo,
        List<Integer> starRatings,
        double rankingMin,
        int page,
        int pageSize) {
        if (moneyFrom == null) {
            moneyFrom = BigDecimal.ZERO;
        }
        if (moneyTo == null) {
            moneyTo = MAX_BIG_DECIMAL;
        }
        if (starRatings == null || starRatings.isEmpty()) {
            starRatings = ALL_STAR_RATINGS;
        }
        List<Hotel> filterByRoom =
            hotelRepository.filterByRoom(starRatings, moneyFrom, moneyTo, PageRequest.of(page, pageSize));
        filterByRoom.removeIf(hotel -> rankingProvider.getReviewRanking(hotel) < rankingMin);
        filterByRoom.sort(MIN_ROOM_COST_COMPARATOR);
        return filterByRoom;
    }
    
}
