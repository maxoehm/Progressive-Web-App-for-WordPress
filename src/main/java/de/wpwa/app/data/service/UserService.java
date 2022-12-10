package de.wpwa.app.data.service;

import de.wpwa.app.data.User;
import de.wpwa.app.data.entity.Usermeta;
import de.wpwa.app.data.entity.UsermetaService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserService {


    private UserRepository UserRepository;
    private de.wpwa.app.data.entity.UsermetaService UsermetaService;


    @Inject
    public UserService(UserRepository UserRepository, UsermetaService UsermetaService) {
        this.UserRepository = UserRepository;
        this.UsermetaService = UsermetaService;
    }

    public boolean validatePassword(String username, String password) {
        return new BCryptPasswordEncoder().matches(password, UserRepository.findByCustomQuery(username).getUserPass());
    }

    public void updateEntity(User user) {
        UserRepository.save(user);
    }

    public User find(String username) {

        try {
            return UserRepository.findUserByUserEmail(username);
        } catch (NullPointerException e) {
            return UserRepository.findUserByUserNicename(username);

        }
    }

    public User findAuth(String authentication) {

        var a = authentication.split("=");
        var b = a[1].split(",");

        return this.find(b[0]);
    }

    public List<Usermeta> getProfileValues(Long userId) {
        return UsermetaService.findByUserIdAndGetProfileFields(userId);
    }

    public void saveMeta(Usermeta bean) {
        UsermetaService.save(bean);
    }

}
