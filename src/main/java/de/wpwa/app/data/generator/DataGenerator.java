package de.wpwa.app.data.generator;

import com.vaadin.flow.spring.annotation.SpringComponent;

import de.wpwa.app.data.service.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (userRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");
            logger.info("Generated demo data");
        };
    }

}