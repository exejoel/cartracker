package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by Joel on 6/29/17.
 */

@Entity
public class Alert {

    @Id
    private String id;
    private String priorityLevel;
    private String alertMessage;
    private String vin;

    public Alert(String priorityLevel, String alertMessage, String vin) {
        this.id = UUID.randomUUID()
                .toString();
        this.priorityLevel = priorityLevel;
        this.alertMessage = alertMessage;
        this.vin = vin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
