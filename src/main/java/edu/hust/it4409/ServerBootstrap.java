package edu.hust.it4409;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import edu.hust.it4409.web.WebConfig;

@SpringBootConfiguration
@Import(BackEndConfig.class)
public class ServerBootstrap {
    
    public static void main(String[] args) {
        System.setProperty("spring.backgroundpreinitializer.ignore", "true");
        // @formatter:off
        new SpringApplicationBuilder(ServerBootstrap.class)
                .profiles("dev", "pg")
                .web(WebApplicationType.NONE)
                .registerShutdownHook(true)
            .child(WebConfig.class)
                .web(WebApplicationType.SERVLET)
            .run(args);
        // @formatter:on
    }
    

}
