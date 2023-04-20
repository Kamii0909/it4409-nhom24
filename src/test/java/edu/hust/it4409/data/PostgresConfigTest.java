package edu.hust.it4409.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zaxxer.hikari.HikariConfig;

@ExtendWith(SpringExtension.class)
public class PostgresConfigTest {
    
    @TestConfiguration
    @Import(PostgresConfig.class)
    static class PGTestConfig {
        
    }
    
    @Autowired
    ApplicationContext ctx;
    
    @Test()
    void loadContext() {
        HikariConfig cf = ctx.getBean("hikariConfig", HikariConfig.class);
        HikariConfig ds = ctx.getBean("pgds", HikariConfig.class);
        assertEquals("test", ds.getSchema());
        assertEquals("test", cf.getSchema());
    }
}
