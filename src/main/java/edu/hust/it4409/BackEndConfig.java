package edu.hust.it4409;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.hust.it4409.booking.BookingConfig;
import edu.hust.it4409.data.DataAccessConfig;
import edu.hust.it4409.recommend.RecommendConfig;

@Import({
    BookingConfig.class,
    RecommendConfig.class,
    DataAccessConfig.class,
    DatabaseDataFiller.class
})
@Configuration
@ImportAutoConfiguration(classes = {
    LiquibaseAutoConfiguration.class,
    JacksonAutoConfiguration.class
})
public class BackEndConfig {
    
}
