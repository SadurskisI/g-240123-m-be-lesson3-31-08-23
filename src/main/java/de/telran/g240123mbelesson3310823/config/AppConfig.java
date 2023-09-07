package de.telran.g240123mbelesson3310823.config;

import de.telran.g240123mbelesson3310823.domain.databasae.CommonDatabase;
import de.telran.g240123mbelesson3310823.domain.databasae.Database;
import de.telran.g240123mbelesson3310823.repository.*;
import de.telran.g240123mbelesson3310823.repository.mysql.MySqlCustomerRepository;
import de.telran.g240123mbelesson3310823.repository.mysql.MySqlProductRepository;
import de.telran.g240123mbelesson3310823.service.CustomerService;
import de.telran.g240123mbelesson3310823.service.common.CommonCustomerService;
import de.telran.g240123mbelesson3310823.service.common.CommonProductService;
import de.telran.g240123mbelesson3310823.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Database database(){
        return new CommonDatabase();
    }

//    @Bean
//    public CustomerService customerService(){
//        return new CommonCustomerService();
//    }

    @Bean
    public ProductRepository productRepository(){
        return new MySqlProductRepository();
    }

    @Bean
    public CustomerRepository clientRepository(){
        return new MySqlCustomerRepository();
    }

    //    @Bean
//    public ProductService productService(){
//        return new CommonProductService();
//    }
}
