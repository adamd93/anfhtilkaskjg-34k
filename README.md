Setting up
------------
	- git clone this project 
	- cd in the project
    - from cmd run mvn clean install
    - to run project mvn spring-boot:run or run the program in IntelliJ/VSCode from the main class Application

## REST API Calls

### Available Queries and Samples -
Sample queries
- Create sensor
    - ```curl --location --request POST 'http://localhost:8080/sensor' \--header 'Content-Type: application/json' \--data-raw '{"sensorId": 1}"}'```
- Add Sensor Data
    - ```curl --location --request POST 'http://localhost:8080/addSensorReading/1?humidity=1.0&temperature=15.0&timestamp=1684797851643&windspeed=1.0' \--header 'Content-Type: application/json'```
- Give me the average temperature and humidity for sensor 1 in the last 7 days
    - ```curl --location --request GET 'http://localhost:8080/reading?sensors=1&days=7&metricValues=temperature, windspeed, humidity&statistic=avg' \--header 'Content-Type: application/json'```
