package de.heallife.app.data.entity;


import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class QehrgUsermetaService {


    private QehrgUsermetaRepository qehrgUsermetaRepository;

    @Inject
    public QehrgUsermetaService(QehrgUsermetaRepository qehrgUsermetaRepository) {
        this.qehrgUsermetaRepository = qehrgUsermetaRepository;
    }

    public QehrgUsermeta findByUserId(Long userId) {
        return qehrgUsermetaRepository.findByUserId(userId);
    }

    public QehrgUsermeta save(QehrgUsermeta qehrgUsermeta) {
        return qehrgUsermetaRepository.save(qehrgUsermeta);
    }

    public List<QehrgUsermeta> findByUserIdAndGetProfileFields(Long userId) {

        String[] metaKeys = {"first_name", "last_name", "mepr-address-one", "mepr-address-city", "mepr-address-zip"};
        List<QehrgUsermeta> beans = new ArrayList<>();

        for (String key : metaKeys) {
            try {
                beans.add(qehrgUsermetaRepository.findByUserIdAndMetaKey(userId, key));
            } catch (NullPointerException e) {
                throw new NullPointerException("Usermeta with key " + key + " not found");
            }
        }

        return beans;
    }

}
