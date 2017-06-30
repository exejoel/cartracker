package io.egen.service;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;

/**
 * Created by Joel on 6/29/17.
 */
public interface AlertService {
    Vehicle create(Reading reading);
}
