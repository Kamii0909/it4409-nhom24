package edu.hust.it4409;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.hust.it4409.booking.BookingConfig;
import edu.hust.it4409.data.DataAccessConfig;
import edu.hust.it4409.recommend.RecommendConfig;

@Import({
    BookingConfig.class,
    RecommendConfig.class,
    DataAccessConfig.class
})
@Configuration
public class BackEndConfig {
    
}
