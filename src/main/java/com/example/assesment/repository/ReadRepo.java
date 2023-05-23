package com.example.assesment.repository;

import com.example.assesment.model.WeatherSensorReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadRepo extends JpaRepository<WeatherSensorReading, Long> {

}
