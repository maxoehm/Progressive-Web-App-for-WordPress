package de.heallife.app.data.generator;

import com.vaadin.flow.spring.annotation.SpringComponent;

import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.LatestPosts;
import de.heallife.app.data.service.QehrgUserRepository;
import de.heallife.app.data.service.QehrgUserService;
import de.heallife.app.data.service.UserRepository;
import de.heallife.app.data.entity.User;
import java.util.Collections;
import org.springframework.security.crypto.password.PasswordEncoder;
import de.heallife.app.data.Role;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(PasswordEncoder passwordEncoder, QehrgUserRepository userRepository) {
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