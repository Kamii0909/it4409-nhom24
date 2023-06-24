package edu.hust.it4409;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import edu.hust.it4409.booking.hotel.HotelRepository;

@Profile("dev")
@Configuration
public class DatabaseDataFiller {
    
    @Bean
    DatabaseInjector databaseInjector(HotelRepository hotelRepository) {
        return new DatabaseInjector(hotelRepository);
    }
    
}
