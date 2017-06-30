package io.egen.repository;

import io.egen.entity.Alert;
import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by Joel on 6/29/17.
 */

@Repository
public class AlertRepositoryImpl implements AlertRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Alert create(Alert alert) {
        entityManager.persist(alert);
        return alert;
    }
}
