package io.egen.repository;

import io.egen.entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Joel on 6/28/17.
 */
@Repository
public class ReadingRepositoryImpl implements ReadingRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Reading create(Reading reading) {
        entityManager.persist(reading.getTires());
        entityManager.persist(reading);
        return reading;
    }
}
