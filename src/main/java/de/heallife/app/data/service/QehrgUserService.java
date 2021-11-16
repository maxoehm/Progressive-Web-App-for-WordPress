package de.heallife.app.data.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class QehrgUserService {


    private QehrgUserRepository qehrgUserRepository;

    @Inject
    public QehrgUserService(QehrgUserRepository qehrgUserRepository) {
        this.qehrgUserRepository = qehrgUserRepository;
    }

    public boolean validatePassword(String username, String password) {
        return new BCryptPasswordEncoder().matches(password, qehrgUserRepository.findByCustomQuery(username).getUserPass());
    }

}
