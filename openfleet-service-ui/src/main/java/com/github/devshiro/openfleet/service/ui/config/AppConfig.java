package com.github.devshiro.openfleet.service.ui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    EntityManager entityManager() {
        return Persistence.createEntityManagerFactory("openfleet_corda")
                .createEntityManager();
    }
}
