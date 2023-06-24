package edu.hust.it4409.booking;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.hust.it4409.booking.hotel.config.ConverterConfiguration;

@Configuration
@Import(ConverterConfiguration.class)
public class BookingConfig {
    
}
