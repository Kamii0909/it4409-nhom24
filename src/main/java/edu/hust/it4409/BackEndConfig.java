package edu.hust.it4409;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.zalando.jackson.datatype.money.MoneyModule;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module.Feature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
@ImportAutoConfiguration({
    JacksonAutoConfiguration.class
})
public class BackEndConfig {
    @Bean
    Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        Hibernate6Module hibernate6Module = new Hibernate6Module();
        hibernate6Module.configure(Feature.FORCE_LAZY_LOADING, false);
        return builder -> builder.modules(l -> {
            List<Module> modules = new ArrayList<>(l);
            modules.add(hibernate6Module);
            modules.add(new JavaTimeModule());
            modules.add(new Jdk8Module());
            modules.add(new MoneyModule());
            builder.modules(modules);
        });
    }
}
