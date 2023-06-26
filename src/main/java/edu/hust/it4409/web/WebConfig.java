package edu.hust.it4409.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hust.it4409.booking.HotelMetadataService;
import edu.hust.it4409.booking.hotel.HotelRepository;
import edu.hust.it4409.web.booking.BookingController;

@ImportAutoConfiguration({
    ServletWebServerFactoryAutoConfiguration.class,
    DispatcherServletAutoConfiguration.class
})
@Import(DelegatingWebMvcConfiguration.class)
@Configuration
public class WebConfig {
    @Bean
    BookingController bookingController(HotelRepository hotelRepository, HotelMetadataService hotelMetadataService) {
        return new BookingController(hotelRepository, hotelMetadataService);
    }
    
    // TODO : Hax ALERT
    @Bean
    CommandLineRunner jsonHack(RequestMappingHandlerAdapter adapter, ObjectMapper mapper) {
        return args -> adapter.getMessageConverters().stream()
            .filter(messageConverter -> messageConverter instanceof MappingJackson2HttpMessageConverter mjhmc)
            .forEach(ms -> ((MappingJackson2HttpMessageConverter) ms).setObjectMapper(mapper));
        
    }
}
