package br.ekerdev.faladev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@EntityScan(basePackages = {"br.ekerdev.faladev.core.domain.entities"})
@EnableJpaRepositories(basePackages = {"br.ekerdev.faladev.core.repositories"})
public class FalaDevApplication {
    public static void main(String[] args) {
        SpringApplication.run(FalaDevApplication.class, args);
    }
}
