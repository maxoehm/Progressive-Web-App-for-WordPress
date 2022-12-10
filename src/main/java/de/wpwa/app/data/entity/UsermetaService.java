package de.wpwa.app.data.entity;


import de.wpwa.app.data.service.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsermetaService {


    private UsermetaRepository UsermetaRepository;
    private de.wpwa.app.data.service.UserRepository UserRepository;

    @Inject
    public UsermetaService(UsermetaRepository UsermetaRepository, UserRepository UserRepository) {
        this.UsermetaRepository = UsermetaRepository;
        this.UserRepository = UserRepository;
    }

    public Usermeta findByUserId(Long userId) {
        return UsermetaRepository.findByUserId(userId);
    }

    public Usermeta save(Usermeta Usermeta) {
        return UsermetaRepository.save(Usermeta);
    }

    public List<Usermeta> findByUserIdAndGetProfileFields(Long userId) {

        String[] metaKeys = {"first_name", "last_name", "mepr-address-one", "mepr-address-city", "mepr-address-zip"};
        List<Usermeta> beans = new ArrayList<>();

        for (String key : metaKeys) {
            try {
                beans.add(UsermetaRepository.findByUserIdAndMetaKey(userId, key));
            } catch (NullPointerException e) {
                throw new NullPointerException("Usermeta with key " + key + " not found");
            }
        }

        return beans;
    }


}
