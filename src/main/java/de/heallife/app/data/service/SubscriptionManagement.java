package de.heallife.app.data.service;

import de.heallife.app.data.QehrgUser;
import de.heallife.app.data.entity.QehrgMeprSubscription;
import de.heallife.app.data.entity.QehrgMeprSubscriptionRepository;
import de.heallife.app.data.entity.QehrgMeprTransaction;
import de.heallife.app.data.repositories.QehrgMeprTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
import java.time.Instant;
import java.util.List;

@Service
public class SubscriptionManagement {

    private QehrgMeprTransactionRepository meprTransactionRepository;
    private QehrgMeprSubscriptionRepository subscriptionRepository;

    @Inject
    public SubscriptionManagement(QehrgMeprTransactionRepository meprTransactionRepository, QehrgMeprSubscriptionRepository subscriptionRepository) {
        this.meprTransactionRepository = meprTransactionRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public boolean isSubscriptionActive(QehrgUser user) {

        List<QehrgMeprTransaction> transaction = meprTransactionRepository.findQehrgMeprTransactionByUserId(getUser(user).getUserId());

        if (!subscriptionRepository.findByUserId(Long.valueOf(user.getId())).get(0).getTrial()) {
            for (QehrgMeprTransaction t1 : transaction) {
                if (t1.getExpiresAt().isBefore(Instant.now())) {
                    return true;
                }
            }

        } else {

            return true;
        }
        return false;
    }


    private QehrgMeprSubscription getUser(QehrgUser user) {
        var b = subscriptionRepository.findByUserId(Long.valueOf(user.getId()));
        return b.get(0);
    }




}
