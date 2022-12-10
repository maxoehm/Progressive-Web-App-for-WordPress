package de.heallife.app.data.generator;

import com.vaadin.flow.spring.annotation.SpringComponent;
import de.heallife.app.data.service.QehrgUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringComponent
public class DataGenerator {

  @Bean
  public CommandLineRunner loadData(
      PasswordEncoder passwordEncoder, QehrgUserRepository userRepository) {
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
