package io.egen.service;

import io.egen.entity.Vehicle;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 6/27/17.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Override
    @Transactional
    public List<Vehicle> create(List<Vehicle> vehicles) {

        List<Vehicle> perVehicles =new ArrayList<>();

        for (Vehicle vehicle : vehicles){

            if(!isVehiclePresent(vehicle.getVin())){
                perVehicles.add(repository.create(vehicle));
            }else{
                perVehicles.add(repository.update(vehicle));
            }
        }
        return perVehicles;
    }

    public boolean isVehiclePresent(String vin){return  repository.findByVin(vin) != null;}
}
