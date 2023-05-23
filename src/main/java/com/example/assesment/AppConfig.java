package com.example.assesment;

import com.example.assesment.managers.WeatherSensorManager;
import com.example.assesment.repository.ReadRepo;
import com.example.assesment.repository.WeatherSensorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Autowired
    private ReadRepo readRepo;
    @Autowired
    private WeatherSensorRepo weatherSensorRepo;

    @Bean
    public WeatherSensorManager sensorReadingManager() {
        return new WeatherSensorManager(readRepo, weatherSensorRepo);
    }

}
