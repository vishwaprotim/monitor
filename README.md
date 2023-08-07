# Monitoring Microservices

This is a small tutorial on monitoring spring boot microservices. It uses -
1. **Spring Data Rest** - To create REST APIs without controller and service. Click [here](https://docs.spring.io/spring-data/rest/docs/current/reference/html) for the documentation from Spring
2. **H2 in-memory database** - To store data without relying on installation of a separate RDBMS
3. **Swagger** - For Documentation.
4. **AOP** - To explain logging around Rest Repositories
5. **Spring Boot Actuator** - To monitor and generate metrics for the microservice
6. **Prometheus** - Scraping metrics from the actuator for user to search and explore
7. **Grafana** - Create dashboards, charts and make microservice monitoring more intuitive.

This project uses gradle as build tool and lombok to reduce boilerplate java code.

## Documentation
This project uses Swagger3 with Open API Specification. Check [this](https://springdoc.org/#migrating-from-springfox) to get more details on how to migrate from Swagger2 Spring Fox to Swagger 3.

## Testing this API

### Local Server
You can test this in your local server (localhost). Default port is 8080. Once the server is up, try the API from the swagger url [here](http://localhost:8080/swagger-ui/index.html).

This API also has an [API Collection in the resources folder](src/main/resources/Student%20API.postman_collection.json), which can be used to test using Postman.

### As Docker Container
This project comes with a [Dockerfile](Dockerfile) to help run it as a docker container. You can install Docker Destop in your machine if not already installed.

Navigate to the project directory and build the project in your IDE PowerShell -
```shell
./gradlew build
```

Run this command to create latest image -
```shell
docker build --tag=monitor:latest .
```

Run this command to create a container of the image and run it at 8080 port -
```shell
docker run --name monitor_app -p 8080:8080 monitor:latest
```

## Actuator
The Spring Boot Actuator provides endpoints to check various metrics for your microservice. Check [application.yml](src/main/resources/application.yml) on:
* how the endpoints can be exposed.
* how to enable more details for the health endpoint

One of the endpoint, [/actuator/prometheus](http://localhost:8080/actuator/prometheus) is interesting, as it provides various metrics with details. Here is a snippet from sample response:
```textmate
# HELP http_server_requests_seconds  
# TYPE http_server_requests_seconds summary
http_server_requests_seconds_count{error="none",exception="none",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",} 2.0
http_server_requests_seconds_sum{error="none",exception="none",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",} 1.4394774
http_server_requests_seconds_count{error="none",exception="none",method="POST",outcome="SUCCESS",status="201",uri="/student",} 3.0
http_server_requests_seconds_sum{error="none",exception="none",method="POST",outcome="SUCCESS",status="201",uri="/student",} 1.2027255
http_server_requests_seconds_count{error="none",exception="none",method="GET",outcome="SUCCESS",status="200",uri="/student",} 1.0
http_server_requests_seconds_sum{error="none",exception="none",method="GET",outcome="SUCCESS",status="200",uri="/student",} 0.3829308
```
As you can see, this data is difficult to read and can be made more intuitive through visualization.

Hence, we use prometheus to extract or "scrape" the metrics from this endpoint and provide it to end use in an intuitive way.

Although the prometheus screen allows you to query various metrics and create basic graphs. However, Grafana is a very powerful tool to visualize data and create beautiful graphs and charts to make monitoring easier.

Therefore, the overall workflow is:
* Spring Boot Actuator generating the metrics and making them available in required format through [/actuator/prometheus](http://localhost:8080/actuator/prometheus)
* Prometheus server scrapes data from this endpoint at regular intervals and presents it in intuitive way to the user. User can query and explore all metrics through the Prometheus UI screen.
* Grafana uses Prometheus server as datasource and creates intuitive graphs and charts for the end use to help monitor the microservice.

## Prometheus
For prometheus, we are using Docker.
1. Pull the Prometheus image from docker hub
2. Prometheus configurations are present in [prometheus.yml](src/main/resources/prometheus.yml). Configure it as needed.
3. Start the container. Notice the system path to yml and default prometheus port 9090
4. Once the container is running, open prometheus from from http://localhost:9090/
```shell
docker pull prom/prometheus
```
```shell
docker run -d -p 9090:9090 -v C:\Users\subir\git\monitor\src\main\resources\prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml
```
```java
// The syntax is
// docker run -p [outside port]:[inside (container) port] -v <host file path to yml>:<config path in container where it will be copied> <image name> --config.file=<to use config from file inside the container>
```

## Grafana
For Grafana, we are using Docker.
1. Pull the Grafana image from docker hub
2. Start Grafana container. Notice default port as 3000
3. Once the container is running, open grafana from http://localhost:3000/
4. Login with default credentials admin/admin. Skip change password process.
5. Add prometheus as datasource. Set Prometheus server URL as http://host.docker.internal:9090
    * The docker containers have their own ip and "local host".
    * To address the host machine, i.e., in this case Windows, use "host.docker.internal"
    * This will translate to the "localhost" (127.0.0.1) of the host machine
    * To check further on prometheus server url details, visit - https://github.com/grafana/grafana/issues/46434
```shell
docker pull grafana/grafana
```
```shell
docker run -d --name=grafana -p 3000:3000 grafana/grafana
```

Do not forget to check [this awesome video](https://www.youtube.com/watch?v=2wr9njNdywk&t=600s&ab_channel=JavaTechie) from Java Techie to learn more.