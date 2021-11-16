package de.heallife.app.data.service;

import de.heallife.app.QehrgUserRepository;
import de.heallife.app.data.QehrgUser;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class QehrgUserService {


    private QehrgUserRepository qehrgUserRepository;

    @Inject
    public QehrgUserService(QehrgUserRepository qehrgUserRepository) {
        this.qehrgUserRepository = qehrgUserRepository;
    }

    public QehrgUser getUserByNiceName(String niceName) {
        return qehrgUserRepository.findByCustomQuery(niceName);
    }

}
