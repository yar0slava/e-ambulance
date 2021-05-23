# e-ambulance

The project consists of 2 modules declared in parent pom.xml, 'client' for Angular and 'server' for Spring Boot.

## Requirements

- Java 8
- Maven 3.1.0
- Node v14.15
- npm 6.14.13
- Angular-cli 12.0.1

## Run Frontend and Backend separately

The 2 modules can be started separately during the development. The Angular app will use the port 4200, the Java application will use the port 8080.

1. Run the backend API server via Spring Boot: `mvn spring-boot:run`
2. Run the dev server for frontend: `ng serve`

To allow the communication between the HttpClient of Angular and the RestController of Spring you have to enable a Cross Origin Resource Sharing in Spring Boot by annotation `@CrossOrigin(origins = "http://localhost:4200")` or requests will be refused.

## Build the project for deploy as a JAR

1. To build the JAR run `mvn clean package`
2. There will be **server-0.0.1-SNAPSHOT.jar** file in **server/target/** directory
3. Run the application: `java -jar server-0.0.1-SNAPSHOT.jar`

Now application is available at the port 8080
