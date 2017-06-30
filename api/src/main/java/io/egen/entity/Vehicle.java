package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by Joel on 6/26/17.
 */


@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll",
                query = "SELECT veh FROM Vehicle veh ORDER BY veh.vin DESC"),
        @NamedQuery(name = "Vehicle.findByVin",
                query = "SELECT veh FROM Vehicle veh WHERE veh.vin=:paramVin")

})

@Entity
public class Vehicle {

        @Id
        private String vin;
        private String make;
        private String model;
        private int year;
        private int redlineRpm;
        private double maxFuelVolume;
        private String lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public int getredlineRpm() {
        return redlineRpm;
    }

    public void setredlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}
