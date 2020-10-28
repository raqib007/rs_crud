package com.raqib.rs_crud.repository;

import com.raqib.rs_crud.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private final static Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository){
        return args -> {
            log.info("Preloading "+repository.save(new Employee("Bilbo Baggins","burglar")));
            log.info("Preloading "+repository.save(new Employee("Frodo Baggins","thief")));
        };
    }
}
