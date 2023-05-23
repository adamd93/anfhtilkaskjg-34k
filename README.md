Setting up
------------
	- git clone this project 
	- cd into the project
    - from cmd line run 'mvn clean install'
    - to run project from cmd line run 'mvn spring-boot:run' or run the program in IntelliJ/VSCode from the main class Application

### Available Queries and Samples -
Sample queries
- Create sensor
    - ```curl --location --request POST 'http://localhost:8080/sensor' \--header 'Content-Type: application/json' \--data-raw '{"sensorId": 1}"}'```
- Add Sensor Data
    - ```curl --location --request POST 'http://localhost:8080/addSensorReading/1?humidity=1.0&temperature=15.0&timestamp=1684797851643&windspeed=1.0' \--header 'Content-Type: application/json'```
- Give me the average temperature and humidity for sensor 1 in the last 7 days
    - ```curl --location --request GET 'http://localhost:8080/reading?sensors=1&days=7&metricValues=temperature, windspeed, humidity&statistic=avg' \--header 'Content-Type: application/json'```
### Notes
All API endpoint testing done by myself was using postman, I would suggeest the same it just makes things easier. 
Not everything was covered in implemntation/testing as I tried to limit time. Others could be:
- Ensuring correct statistic type(avg,max,min,sum)
- No extra fields or injection in requests
- extra information on sensors (location by lat/long)
- indexing of columns or primary keys as its just using simple storage concepts for POC and local implementation
