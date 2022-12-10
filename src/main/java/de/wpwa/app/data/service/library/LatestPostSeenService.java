package de.wpwa.app.data.service.library;

import de.wpwa.app.data.entity.LatestPosts;
import de.wpwa.app.data.repositories.LatestPostSeenRepository;
import java.util.Optional;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LatestPostSeenService {

  private LatestPostSeenRepository repository;

  @Inject
  public LatestPostSeenService(LatestPostSeenRepository repository) {
    this.repository = repository;
  }

  public void save(LatestPosts entity) {
    repository.save(entity);
  }

  Logger logger = LoggerFactory.getLogger(getClass());

  public LatestPosts get(String username) {
    logger.info(username);
    Optional<LatestPosts> latestPosts = repository.findByUsernameIgnoreCase(username);

    if (latestPosts.isEmpty()) {
      return new LatestPosts(username);
    }

    return latestPosts.get();
  }
}
