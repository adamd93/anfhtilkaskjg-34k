package com.example.assesment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "WeatherSensorReading")
public class WeatherSensorReading {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn()
    private Sensor sensor;

    @Column()
    private double humidity;

    @Column()
    private double temperature;

    @Column()
    private double windspeed;

    @Column()
    private long timestamp;

    public WeatherSensorReading() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = this.id;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }


    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "WeatherSensorReading{" +
                "id=" + id +
                ", humidity=" + humidity +
                ", temperature=" + temperature +
                ", windspeed=" + windspeed +
                ", timestamp=" + timestamp +
                ", sensor=" + sensor +
                '}';
    }
}
