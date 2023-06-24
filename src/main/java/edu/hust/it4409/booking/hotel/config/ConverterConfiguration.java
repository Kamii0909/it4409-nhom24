package edu.hust.it4409.booking.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hust.it4409.booking.hotel.amenity.internet.InternetAmenity;
import edu.hust.it4409.booking.hotel.amenity.parking.ParkingAmenity;
import jakarta.persistence.AttributeConverter;

@Configuration
public class ConverterConfiguration {
    @Bean
    AttributeConverter<InternetAmenity, String> internetAmenityConverter(ObjectMapper mapper) {
        return new InternetAmenityConverter(mapper);
    }
    
    @Bean
    AttributeConverter<ParkingAmenity, String> parkingAmenityConverter(ObjectMapper mapper) {
        return new ParkingAmenityConverter(mapper);
    }
}
