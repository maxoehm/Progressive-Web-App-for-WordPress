package de.heallife.app.data.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class QehrgUserService {


    private QehrgUserRepository QEhRGUserRepository;

    @Inject
    public QehrgUserService(QehrgUserRepository QEhRGUserRepository) {
        this.QEhRGUserRepository = QEhRGUserRepository;
    }

    public boolean validatePassword(String username, String password) {
        return new BCryptPasswordEncoder().matches(password, QEhRGUserRepository.findByCustomQuery(username).getUserPass());
    }

}
