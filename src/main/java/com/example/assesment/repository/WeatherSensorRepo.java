package com.example.assesment.repository;

import com.example.assesment.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherSensorRepo extends JpaRepository<Sensor, Long> {

}
