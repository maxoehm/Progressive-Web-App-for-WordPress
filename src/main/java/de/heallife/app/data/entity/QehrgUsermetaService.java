package de.heallife.app.data.entity;


import org.springframework.stereotype.Service;

import javax.inject.Inject;

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



}
