package edu.hust.it4409.web;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

import edu.hust.it4409.web.booking.BookingController;

@ImportAutoConfiguration({
    ServletWebServerFactoryAutoConfiguration.class,
    DispatcherServletAutoConfiguration.class,
    JacksonAutoConfiguration.class
})
@Import(DelegatingWebMvcConfiguration.class)
@Configuration
public class WebConfig {
    @Bean
    BookingController bookingController() {
        return new BookingController();
    }
}
