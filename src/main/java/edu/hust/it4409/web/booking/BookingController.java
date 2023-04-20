package edu.hust.it4409.web.booking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    @GetMapping("/")
    String get() {
        return "Hello";
    }
}
