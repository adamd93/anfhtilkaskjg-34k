package com.example.assesment.controller;

import com.example.assesment.managers.WeatherSensorManager;
import com.example.assesment.model.Sensor;
import com.example.assesment.model.WeatherSensorReading;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WeatherSensorControllerTests {

    private static final long WEATHER_SENSOR_ID = 1L;
    private static final long TIMESTAMP = 66304965345656l;
    private static final double HUMIDITY = 66.2;
    private static final double TEMP = 66.2;
    private static final double WINDSPEED = 66.2;

    private WeatherSensorController weatherSensorController;

    private WeatherSensorManager weatherSensorManager;

    private Sensor sensor;

    private WeatherSensorReading weatherSensorReading;

    @BeforeEach()
    public void setUp() {
        weatherSensorManager = Mockito.mock(WeatherSensorManager.class);
        weatherSensorController = new WeatherSensorController(weatherSensorManager);
        sensor = new Sensor();
        sensor.setSensorId(1L);
    }

    @Test
    public void itCreatesNewSensor() {
        when(weatherSensorManager.checkSensorExists(WEATHER_SENSOR_ID)).thenReturn(false);
        when(weatherSensorManager.createSensor(sensor)).thenReturn(sensor);

        ResponseEntity<Sensor> responseEntity = weatherSensorController.createSensor(sensor);

        verify(weatherSensorManager).createSensor(sensor);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void itWontCreatesNewSensorAlreadyExists() {
        when(weatherSensorManager.checkSensorExists(WEATHER_SENSOR_ID)).thenReturn(true);

        ResponseEntity<Sensor> responseEntity = weatherSensorController.createSensor(sensor);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void itAddsSensorData() {
        when(weatherSensorManager.checkSensorExists(WEATHER_SENSOR_ID)).thenReturn(true);
        when(weatherSensorManager.getSensor(WEATHER_SENSOR_ID)).thenReturn(sensor);
        weatherSensorReading = new WeatherSensorReading();

        weatherSensorReading.setSensor(sensor);
        weatherSensorReading.setHumidity(HUMIDITY);
        weatherSensorReading.setWindspeed(WINDSPEED);
        weatherSensorReading.setTemperature(TEMP);
        weatherSensorReading.setTimestamp(TIMESTAMP);
        weatherSensorReading.setId(0l);
        when(weatherSensorManager.saveSensorReading(weatherSensorReading)).thenReturn(weatherSensorReading);

        ResponseEntity responseEntity = weatherSensorController.insertSensorReading(WEATHER_SENSOR_ID,
        HUMIDITY, TEMP, TIMESTAMP, WINDSPEED);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void itFailsAddSensorData() {
        when(weatherSensorManager.checkSensorExists(WEATHER_SENSOR_ID)).thenReturn(false);

        ResponseEntity<WeatherSensorReading> responseEntity = weatherSensorController.insertSensorReading(WEATHER_SENSOR_ID,
                HUMIDITY, TEMP, TIMESTAMP, WINDSPEED);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void itFailsGetDataInvalidDays() {
        ResponseEntity<WeatherSensorReading> responseEntity = weatherSensorController.getSensorReadings(List.of(WEATHER_SENSOR_ID),
                45, List.of("temperature"), "average");

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());

        responseEntity = weatherSensorController.getSensorReadings(List.of(WEATHER_SENSOR_ID),
                -10, List.of("temperature"), "average");

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    public void itGetsSensorData() {
        ResponseEntity<WeatherSensorReading> responseEntity = weatherSensorController.getSensorReadings(List.of(WEATHER_SENSOR_ID),
                5, List.of("temperature"), "average");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
