# Spring-boot CRUD - Jose Lascar 

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.x-brightgreen)
![Java 17](https://img.shields.io/badge/Java-17-blue)
![Maven](https://img.shields.io/badge/Build-Maven-orange)

* [Technologies Used](#technologies-used)
* [Getting Started](#getting-started)
    * [Prerequisites](#prerequisites)
    * [Installation](#installation)
  
## Project Description
Prueba técnica para Previred - Jose Lascar * peplascar@gmail.com

⚡SwaggerUI (Browser): ```http://localhost:8080/previred-backend/swagger-ui/index.html```

## Features
* User Registration and Authentication (JWT-based)
* User Management (CRUD operations)
* Pre-loaded data ready to use
* Global Exception Handling
* Spring Security access control
* Swagger
* Logback
* Include Postman Colletion

## Backlog de futuras mejoras
* Incorporar test unitarios y de integracion con Mockito y JUnit 5
* JaCoCo para futuras integraciones con SonarQ
* Documentar clases y metodos
* Registro en Eureka
* Mejoras en lógica del Crud: Agregar/Eliminar tareas de forma masiva y generar UUID para cada transaccion.

## Technologies Used
* **Spring Boot 3.5.3:** Java backend framework for the Rest Service.
* **Spring Security:** For authentication, authorization and in.
* **Spring Data JPA:** For database interaction (ORM).
* **Maven:** Build automation tool.
* **H2:** Relational database.
* **Lombok:** To reduce boilerplate code.
* **JWT (jjwt):** For token-based authentication.
* **Swagger UI / OpenAPI:** For API documentation.


## Getting Started

### Prerequisites
* **Java Development Kit (JDK) 17 or higher:**
    * Download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.java.net/install/index.html).
* **Maven 3.8.x or higher:**
    * Download from [Apache Maven](https://maven.apache.org/download.cgi).
* **IntelliJIdea:**
    * Download from [IntelliJ](https://intellij-support.jetbrains.com/hc/en-us#).


### Installation
1.  **Clone the repository:**
    ```
    git clone https://github.com/previred/desafio-spring-boot
    git checkout https://github.com/previred/desafio-spring-boot/{pullRequest-JoseL}
    ```

2.  **Build the project:**
    ```bash
    mvn clean install
    ```
    This will download all dependencies and build the JAR file.

### Lets try the API

#### NOTE: The service have pre-loaded data ready to use.

Once you have the service running, download the Postman Collection located in this path:```src\main\resources```.  💡Recommendation: Add the token to global variables to reuse it.
1.   Register a new User: Open Token Creation folder and create a token in this endpoint
```http://localhost:8080/previred-backend/auth/register```
```json
Request:
{
    "name": "Jose Lascar",
    "email": "peplascar@gmail.com",
    "password": "admin"
}

Response:
{
    "access_token": "eyJhbGciOiJIUzM4NCJ9.eyJuYW1lIjoiSm9zZSBMYXNjYXIiLCJzdWIiOiJwZXBsYXNjYXJAZ21haWwuY29tIiwiaWF0IjoxNzUxOTQ4MzE3LCJleHAiOjE3NTE5NTQzMTd9.N3qphwL9cWGmSThCwx6NOrBai6ogjQrwv4MWGwvUQFiJugvZxAUYG7t2pbJ-GTHI"
}
```

2. Generate Token: With the created token go to Token Creation folder and login with the EMAIL and PASSWORD of the recently account created.
 ```http://localhost:8080/previred-backend/auth/login```
```json
Request:
{
"email": "peplascar@gmail.com",
"password": "admin"
}

Response:
{
    "access_token": "eyJhbMYXNjYXIiLCJzdWIiOiJwZXBsYXNjYXJAZ21YW1lIjoiSm9zZSBMYXNjYXIiLCJzdWIiOiJwZXBsYXNjYXJAZ21haWwuY29tIiwiaWF0IjoxNzUxOTQ4MzE3LCJleHAiOjE3NTE5NTQzMTd9.N3qphwL9cWGmSThCwx6NOrBai6ogjQrwv4MWGwvUQFiJugvZxAUYG7t2pbJ-GTHI"
}
```
3. Great you have the BEARER token to authenticate and consume the Api, good luck! 🚀 🚀

📚Create User: ```http://localhost:8080/previred-backend/api/users```
```json
Request:
{
"username": "Jose Lascar",
"email": "peplascar@gmail.com"
}
```

📚Create task: ```http://localhost:8080/previred-backend/api/tasks?userId=1```
```json
Request:
{
"title": "Improve error handling",
"description": "Make custom exceptions",
"completed": false
}
```

⚡ Now with a USER and a TASK we can explore all the Crud or also check te informational endpoints:

Api-docs: ```http://localhost:8080/previred-backend/v3/api-docs```

SwaggerUI (Browser): ```http://localhost:8080/previred-backend/swagger-ui/index.html```

Actuator: ```http://localhost:8080/previred-backend/actuator```