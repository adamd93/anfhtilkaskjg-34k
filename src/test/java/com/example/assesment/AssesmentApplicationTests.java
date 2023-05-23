package com.example.assesment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AssesmentApplicationTests {

//	@Test
//	public void testQueryCreationSimpleAvgAggregate(){
//		String expected = "select avg(temperature) from Reading WHERE reading_sensor_id IN (1, 2, 3) AND timestamp between ?1 and ?2";
//
//		List<Long> sensors = Arrays.asList(1L,2L,3L);
//		String metric = "temperature";
//		String aggregationtype = "avg";
//
//		String sql = ReadingController.generateSQLQuery(sensors, metric, aggregationtype);
//
//		assertEquals(expected, sql);
//	}
//
//	@Test
//	public void testQueryCreationMinAggregate(){
//		String expected = "select min(temperature) from Reading WHERE reading_sensor_id IN (1, 2, 3) AND timestamp between ?1 and ?2";
//
//		List<Long> sensors = Arrays.asList(1L,2L,3L);
//		String metric = "temperature";
//		String aggregationtype = "min";
//
//		String sql = ReadingController.generateSQLQuery(sensors, metric, aggregationtype);
//
//		assertEquals(expected, sql);
//	}
//
//	@Test
//	public void testQueryCreationMaxAggregate(){
//		String expected = "select max(temperature) from Reading WHERE reading_sensor_id IN (1, 2, 3) AND timestamp between ?1 and ?2";
//
//		List<Long> sensors = Arrays.asList(1L,2L,3L);
//		String metric = "temperature";
//		String aggregationtype = "max";
//
//		String sql = ReadingController.generateSQLQuery(sensors, metric, aggregationtype);
//
//		assertEquals(expected, sql);
//	}
//
//	@Test
//	public void testQueryCreationTemperatureMetric(){
//		String expected = "select max(temperature) from Reading WHERE reading_sensor_id IN (1, 2, 3) AND timestamp between ?1 and ?2";
//
//		List<Long> sensors = Arrays.asList(1L,2L,3L);
//		String metric = "temperature";
//		String aggregationtype = "max";
//
//		String sql = ReadingController.generateSQLQuery(sensors, metric, aggregationtype);
//
//		assertEquals(expected, sql);
//	}
//
//	@Test
//	public void testQueryCreationWindSpeedMetric(){
//		String expected = "select max(windspeed) from Reading WHERE reading_sensor_id IN (1, 2, 3) AND timestamp between ?1 and ?2";
//
//		List<Long> sensors = Arrays.asList(1L,2L,3L);
//		String metric = "windspeed";
//		String aggregationtype = "max";
//
//		String sql = ReadingController.generateSQLQuery(sensors, metric, aggregationtype);
//
//		assertEquals(expected, sql);
//	}
//
//	@Test
//	public void testQueryCreationHumidityMetric(){
//		String expected = "select max(humidity) from Reading WHERE reading_sensor_id IN (1, 2, 3) AND timestamp between ?1 and ?2";
//
//		List<Long> sensors = Arrays.asList(1L,2L,3L);
//		String metric = "humidity";
//		String aggregationtype = "max";
//
//		String sql = ReadingController.generateSQLQuery(sensors, metric, aggregationtype);
//
//		assertEquals(expected, sql);
//	}
//
//	@Test
//	public void testQueryCreationAllSensors(){
//		String expected = "select max(humidity) from Reading WHERE timestamp between ?1 and ?2";
//
//		List<Long> sensors = Collections.emptyList();
//		String metric = "humidity";
//		String aggregationtype = "max";
//
//		String sql = ReadingController.generateSQLQuery(sensors, metric, aggregationtype);
//
//		assertEquals(expected, sql);
//	}

}
