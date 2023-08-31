package de.telran.g240123mbelesson3310823.config;

import de.telran.g240123mbelesson3310823.domain.databasae.CommonDatabase;
import de.telran.g240123mbelesson3310823.domain.databasae.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Database database(){
        return new CommonDatabase();
    }
}
