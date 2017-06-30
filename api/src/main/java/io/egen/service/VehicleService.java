package io.egen.service;

import io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by Joel on 6/27/17.
 */
public interface VehicleService {

    List<Vehicle> create(List<Vehicle> vehicles);
}
