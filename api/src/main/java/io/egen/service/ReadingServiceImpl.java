package io.egen.service;

import io.egen.entity.Reading;
import io.egen.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Joel on 6/28/17.
 */
@Service
public class ReadingServiceImpl implements ReadingService  {

    @Autowired
    ReadingRepository readingRepository;
    @Autowired
    AlertService alertService;

    @Override
    @Transactional
    public Reading create(Reading reading) {
        alertService.create(reading);
        return readingRepository.create(reading);
    }
}
