package de.heallife.app.data.service;

import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.QehrgUsermeta;
import de.heallife.app.data.entity.QehrgUsermetaService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class QehrgUserService {

  private QehrgUserRepository QEhRGUserRepository;
  private QehrgUsermetaService QEhRGUsermetaService;

  @Inject
  public QehrgUserService(
      QehrgUserRepository QEhRGUserRepository, QehrgUsermetaService QEhRGUsermetaService) {
    this.QEhRGUserRepository = QEhRGUserRepository;
    this.QEhRGUsermetaService = QEhRGUsermetaService;
  }

  public boolean validatePassword(String username, String password) {
    return new BCryptPasswordEncoder()
        .matches(password, QEhRGUserRepository.findByCustomQuery(username).getUserPass());
  }

  public void updateEntity(QehrgUser user) {
    QEhRGUserRepository.save(user);
  }

  public QehrgUser find(String username) {

    try {
      return QEhRGUserRepository.findQehrgUserByUserEmail(username);
    } catch (NullPointerException e) {
      return QEhRGUserRepository.findQehrgUserByUserNicename(username);
    }
  }

  public QehrgUser findAuth(String authentication) {

    var a = authentication.split("=");
    var b = a[1].split(",");

    return this.find(b[0]);
  }

  public List<QehrgUsermeta> getProfileValues(Long userId) {
    return QEhRGUsermetaService.findByUserIdAndGetProfileFields(userId);
  }

  public void saveMeta(QehrgUsermeta bean) {
    QEhRGUsermetaService.save(bean);
  }
}
