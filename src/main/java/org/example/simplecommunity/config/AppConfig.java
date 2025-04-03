package org.example.simplecommunity.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.simplecommunity")
public class AppConfig {
    // AppConfig.java에 추가
    @Bean
    public static Dotenv dotenv() {
        return Dotenv.load();
    }
}
