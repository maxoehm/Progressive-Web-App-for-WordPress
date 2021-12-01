package de.heallife.app.data.service;

import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.QehrgUsermeta;
import de.heallife.app.data.entity.QehrgUsermetaService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class QehrgUserService {


    private QehrgUserRepository QEhRGUserRepository;
    private QehrgUsermetaService QEhRGUsermetaService;


    @Inject
    public QehrgUserService(QehrgUserRepository QEhRGUserRepository, QehrgUsermetaService QEhRGUsermetaService) {
        this.QEhRGUserRepository = QEhRGUserRepository;
        this.QEhRGUsermetaService = QEhRGUsermetaService;
    }

    public boolean validatePassword(String username, String password) {
        return new BCryptPasswordEncoder().matches(password, QEhRGUserRepository.findByCustomQuery(username).getUserPass());
    }

    public void updateEntity(QehrgUser user) {
        QEhRGUserRepository.save(user);
    }

    public QehrgUser find(String username) {

        try {
            return QEhRGUserRepository.findByCustomQuery(username);
        } catch (NullPointerException e) {

            return QEhRGUserRepository.findByCustomQueryEmail(username);
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
