# Test Demo Project

## Descripción

Este proyecto es una aplicación Spring Boot que utiliza Feign Client para consumir una API externa y proporciona una API REST que puede responder en formatos JSON y XML. Además, incluye Swagger-UI para documentación y pruebas de la API.

## Requisitos

- JDK 21 o superior
- Maven 3.8.7 o superior
- Docker (opcional, para generar y ejecutar imágenes Docker)

## Configuración del Proyecto

### Dependencias

Asegúrese de tener las siguientes dependencias en tu `pom.xml` para que la aplicación funcione correctamente:

```xml
<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
    <scope>provided</scope>
</dependency>

<!-- ModelMapper -->
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>3.1.0</version>
</dependency>

<!-- OpenFeign -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

<!-- Swagger -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>2.2.0</version>
</dependency>


## Instalacion del proyecto

### Generar imagen de docker

docker build -t test-demo.

### ejecutar imagen de docker

docker run -p 8080:8080 test-demo

### Consumir endpoint

abre tu navegador y ejecuta este link:
http://localhost:8080/swagger-ui.html

