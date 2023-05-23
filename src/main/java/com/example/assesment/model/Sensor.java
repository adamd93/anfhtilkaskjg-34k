package com.example.assesment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sensor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sensor {
    @Id
    private long sensorId;

    public Sensor() {
        super();
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public String toString() {
        return "Sensor{" + "sensorId=" + sensorId + '}';
    }
}
