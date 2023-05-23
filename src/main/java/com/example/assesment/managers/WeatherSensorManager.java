package com.example.assesment.managers;

import com.example.assesment.model.Sensor;
import com.example.assesment.model.WeatherSensorReading;
import com.example.assesment.repository.ReadRepo;
import com.example.assesment.repository.WeatherSensorRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherSensorManager {

    private final ReadRepo readRepo;
    private final WeatherSensorRepo weatherSensorRepo;
    private static final long MILLISECONDS_IN_DAY = 86400000;

    @Autowired
    EntityManager entityManager;

    public WeatherSensorManager(ReadRepo readRepo, WeatherSensorRepo weatherSensorRepo) {
        this.readRepo = readRepo;
        this.weatherSensorRepo = weatherSensorRepo;
    }
    public boolean checkSensorExists(long weatherSensorId) {
        return weatherSensorRepo.existsById(weatherSensorId);
    }
    public Sensor createSensor(Sensor sensor) {
        return weatherSensorRepo.save(sensor);
    }
    public Sensor getSensor(long sensorId){
       return weatherSensorRepo.getReferenceById(sensorId);
    }
    public WeatherSensorReading saveSensorReading(WeatherSensorReading weatherSensorReading){
    return readRepo.save(weatherSensorReading);
    }

    public Map<String, Object> getSensorReading(List<Long> sensors, int days, List<String> metricValues, String statistic){
        long startDate = Instant.now().toEpochMilli();
        long endDate = startDate - (MILLISECONDS_IN_DAY * days);

        Map<String, Object> results = new HashMap<>();
        Query query;
        for(String metric: metricValues){
            query= entityManager.createQuery(createSQLQuery(sensors, metric, statistic));
            query.setParameter(1, endDate);
            query.setParameter(2, startDate);
            results.put(metric, query.getSingleResult());
        }
        return results;
    }

    private static String createSQLQuery(List<Long> sensors, String metricValue, String statistic){

        StringBuilder sb = new StringBuilder();
        sb.append("select ").append(statistic).append("(").append(metricValue).append(") from WeatherSensorReading WHERE ");

        if (sensors.size() > 0){
            sb.append("sensor.id IN (");
           for(int i = 0; i < sensors.size(); i++){
                sb.append(sensors.get(i));
                if ( i != sensors.size() - 1){
                    sb.append(", ");
                }
            }
            sb.append(") AND ");
        }

        sb.append("timestamp between ?1 and ?2");
        return sb.toString();
    }
}
