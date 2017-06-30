package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.repository.AlertRepository;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Joel on 6/29/17.
 */
@Service
public class AlertServiceImpl implements AlertService{

    @Autowired
    AlertRepository alertRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public Vehicle create(Reading reading) {
        Vehicle existing = vehicleRepository.findByVin(reading.getVin());
        if (existing != null) {
            if(reading.getEngineRpm() > existing.getredlineRpm()){
                Alert alert = new Alert("HIGH", reading.getTimestamp() + " =engineRpm > readlineRpm", reading.getVin());
                alertRepository.create(alert);
            }
            if(reading.getFuelVolume() < (existing.getMaxFuelVolume()*0.01)){
                Alert alert = new Alert("MEDIUM", reading.getTimestamp() + " =fuelVolume < 10% of maxFuelVolume", reading.getVin());
                alertRepository.create(alert);
            }

            if(reading.getTires().getFrontLeft() < 32||
                    reading.getTires().getFrontRight() < 32||
                    reading.getTires().getRearLeft() < 32||
                    reading.getTires().getRearRight() < 32||

                    reading.getTires().getFrontLeft() > 36||
                    reading.getTires().getFrontRight() > 36||
                    reading.getTires().getRearLeft() > 36||
                    reading.getTires().getRearRight() > 36) {
                Alert alert = new Alert("LOW", reading.getTimestamp() + " =tire pressure of any tire < 32psi || > 36psi", reading.getVin());
                alertRepository.create(alert);
            }

            if(reading.getEngineCoolantLow() == "true" || reading.getCheckEngineLightOn() == "true"){
                Alert alert = new Alert("LOW", reading.getTimestamp() + " =engineCoolantLow = true || checkEngineLightOn = true", reading.getVin());
                alertRepository.create(alert);
            }
        }
        return existing;
    }
}