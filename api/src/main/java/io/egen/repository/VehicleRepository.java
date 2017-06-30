package io.egen.repository;

import io.egen.entity.Vehicle;

/**
 * Created by Joel on 6/28/17.
 */
public interface VehicleRepository {

    Vehicle findByVin(String vin);
    Vehicle create(Vehicle veh);
    Vehicle update(Vehicle veh);
}
