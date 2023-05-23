package com.example.assesment.managers;

import com.example.assesment.model.Sensor;
import com.example.assesment.model.WeatherSensorReading;
import com.example.assesment.repository.ReadRepo;
import com.example.assesment.repository.WeatherSensorRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WeatherSensorManagerTests {
    private ReadRepo readRepo;
    private WeatherSensorRepo weatherSensorRepo;

    @InjectMocks
    private WeatherSensorManager weatherSensorManager;
    private Sensor sensor;

    private WeatherSensorReading weatherSensorReading = new WeatherSensorReading();

    @BeforeEach()
    public void setUp() {
        weatherSensorRepo = Mockito.mock(WeatherSensorRepo.class);
        readRepo = Mockito.mock(ReadRepo.class);
        weatherSensorManager = new WeatherSensorManager(readRepo, weatherSensorRepo);
        sensor = new Sensor();
        sensor.setSensorId(1L);
    }

    @Test
    public void itCreatesWeatherSensor() {
        when(weatherSensorRepo.save(sensor)).thenReturn(sensor);

       weatherSensorManager.createSensor(sensor);

        verify(weatherSensorRepo).save(sensor);
    }

    @Test
    public void itCreatesWeatherSensorAndAddsReading() {
        weatherSensorReading.setSensor(sensor);
        weatherSensorReading.setHumidity(66.6);
        weatherSensorReading.setTemperature(22.0);
        weatherSensorReading.setWindspeed(8.2);
        weatherSensorReading.setTimestamp(1684797851643L);
        weatherSensorManager.createSensor(sensor);

        when(readRepo.save(weatherSensorReading)).thenReturn(weatherSensorReading);

        WeatherSensorReading weatherSensorReadingResult = weatherSensorManager.saveSensorReading(weatherSensorReading);

        verify(readRepo).save(weatherSensorReading);
        assertEquals(weatherSensorReadingResult.getSensor(),weatherSensorReading.getSensor());
        assertEquals(weatherSensorReadingResult.getHumidity(), weatherSensorReading.getHumidity());
        assertEquals(weatherSensorReadingResult.getTemperature(), weatherSensorReading.getTemperature());
        assertEquals(weatherSensorReadingResult.getWindspeed(), weatherSensorReading.getWindspeed());
        assertEquals(weatherSensorReadingResult.getTimestamp(), weatherSensorReading.getTimestamp());

    }
}
