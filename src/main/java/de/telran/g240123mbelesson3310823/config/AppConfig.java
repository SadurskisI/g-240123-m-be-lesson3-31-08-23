package de.telran.g240123mbelesson3310823.config;

import de.telran.g240123mbelesson3310823.domain.databasae.CommonDatabase;
import de.telran.g240123mbelesson3310823.domain.databasae.Database;
import de.telran.g240123mbelesson3310823.repository.ClientRepository;
import de.telran.g240123mbelesson3310823.repository.CommonClientRepository;
import de.telran.g240123mbelesson3310823.repository.CommonProductRepository;
import de.telran.g240123mbelesson3310823.repository.ProductRepository;
import de.telran.g240123mbelesson3310823.service.ClientService;
import de.telran.g240123mbelesson3310823.service.CommonClientService;
import de.telran.g240123mbelesson3310823.service.CommonProductService;
import de.telran.g240123mbelesson3310823.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Database database(){
        return new CommonDatabase();
    }
    @Bean
    public ClientService clientService(){
        return new CommonClientService();
    }

    @Bean
    public ProductService productService(){
        return new CommonProductService();
    }

    @Bean
    public ProductRepository productRepository(){
        return new CommonProductRepository();
    }

    @Bean
    public ClientRepository clientRepository(){
        return new CommonClientRepository();
    }
}
