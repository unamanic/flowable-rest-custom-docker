# Flowable-Rest-Custom-Docker

## What is this
This is an **unmaintained** example project that is almost a clone of the current Flowable-Rest app.  There are several key differences:
- Flowable 5 Compatibility Enabled
- H2, MySQL, and Postres drivers are included
- Packaged as a JAR

## How To Use
Make any changes you would like "baked" into the app in `src/main/resources/flowable-default.properties`

Build the JAR using maven or the prebunded maven wrapper:
```
./mvnw clean package
```

Run the JAR with java:
```
java -jar target/flowable-rest-custom-docker-0.0.1-SNAPSHOT.jar
```

The app will then be available at http://localhost:8080/flowable-rest/ with Swagger docs at http://localhost:8080/flowable-rest/docs/

##Docker
This application also includes a Dockerfile for easy docker deployment.  After the Maven `package`, you can build the docker image as so: 
```
docker build . -t flowable-rest-custom
```
You can then run them like this:
```
docker run --name flowable-rest-custom -p 8080:8080 -d flowable-rest-custom
```

Some interesting environment variables to override, if you were to connect to a Postres instance on your host machine:
```
SPRING_DATASOURCE_DRIVER-CLASS-NAME=org.postgresql.Driver
SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/flowable
SPRING_DATASOURCE_USERNAME=flowable
SPRING_DATASOURCE_PASSWORD=flowable
```