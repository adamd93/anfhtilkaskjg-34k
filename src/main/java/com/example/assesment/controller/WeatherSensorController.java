package com.example.assesment.controller;


import com.example.assesment.managers.WeatherSensorManager;
import com.example.assesment.model.Sensor;
import com.example.assesment.model.WeatherSensorReading;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class WeatherSensorController {
    private final WeatherSensorManager weatherSensorManager;


    public WeatherSensorController(WeatherSensorManager weatherSensorManager) {
        this.weatherSensorManager = weatherSensorManager;
    }

    @PostMapping(value = "/sensor", consumes = "application/json")
    public ResponseEntity createSensor(@RequestBody Sensor sensor) {
        if(weatherSensorManager.checkSensorExists(sensor.getSensorId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("WeatherSensorId:" + sensor.getSensorId() + " already exists, please try again");
        }
        return ResponseEntity.ok(weatherSensorManager.createSensor(sensor));
    }

    @PostMapping(value = "/addSensorReading/{weatherSensorId}")
    public ResponseEntity insertSensorReading(@PathVariable long weatherSensorId,
                                              @RequestParam(name="humidity") Double humidity,
                                              @RequestParam(name="temperature") Double temperature,
                                              @RequestParam(name="timestamp") Long timestamp,
                                              @RequestParam(name="windspeed") Double windspeed){

        if(weatherSensorManager.checkSensorExists(weatherSensorId)){
            WeatherSensorReading weatherSensorReading = new WeatherSensorReading();
            weatherSensorReading.setSensor(weatherSensorManager.getSensor(weatherSensorId));
            weatherSensorReading.setTemperature(temperature);
            weatherSensorReading.setHumidity(humidity);
            weatherSensorReading.setWindspeed(windspeed);
            weatherSensorReading.setTimestamp(timestamp);

            return ResponseEntity.ok(weatherSensorManager.saveSensorReading(weatherSensorReading));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("WeatherSensorId:" + weatherSensorId + " does not exist, please try again");


    }

    @GetMapping(value = "/reading")
    public ResponseEntity getSensorReadings(@RequestParam(required = false, defaultValue = "") List<Long> sensors,
                                            @RequestParam(required = false, defaultValue = "1") int days,
                                            @RequestParam List<String> metricValues,
                                            @RequestParam String statistic) {
        if(days < 0 || days > 30){
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Date range must be less than 30 and a positive value");
        }
        Map<String, Object> sensorReadings = weatherSensorManager.getSensorReading(sensors, days, metricValues, statistic);
        return ResponseEntity.ok(sensorReadings);

    }



}
