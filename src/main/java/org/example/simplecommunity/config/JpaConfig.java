package org.example.simplecommunity.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JpaConfig {
    @Autowired
    private Dotenv dotenv;

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.url", dotenv.get("DB_URL"));
        properties.put("jakarta.persistence.jdbc.user", dotenv.get("DB_USER"));
        properties.put("jakarta.persistence.jdbc.password", dotenv.get("DB_PASSWORD"));

        return Persistence.createEntityManagerFactory("PersistenceUnit", properties);
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }
}
