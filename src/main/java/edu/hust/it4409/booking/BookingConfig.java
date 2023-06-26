package edu.hust.it4409.booking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.hust.it4409.booking.hotel.HotelRepository;
import edu.hust.it4409.booking.hotel.config.ConverterConfiguration;
import edu.hust.it4409.booking.spi.ReviewRankingProvider;

@Configuration
@Import(ConverterConfiguration.class)
public class BookingConfig {
    @Bean
    HotelMetadataService hotelMetadataService(HotelRepository hotelRepository,
        ReviewRankingProvider reviewRankingProvider) {
        return new HotelMetadataServiceImpl(hotelRepository, reviewRankingProvider);
    }
    
    @Bean
    ReviewRankingProvider reviewRankingProvider() {
        return new RandomReviewRankingProvider();
    }
    
}
