# Spring Boot RESTful API Demo Applications

This repository contains **demo applications** built with **Spring Boot** to demonstrate key concepts in modern microservices architecture, including REST APIs, database integration, monitoring, service discovery, API gateways, and resilience patterns.

## Features

The demos cover the following topics:

1. **Building RESTful APIs with `@RestController`**
   - Demonstrates how to create REST endpoints using Spring Boot.
   - CRUD operations on sample entities.

2. **Spring Data JPA**
   - Using `CrudRepository` for basic CRUD operations.
   - Using `@Query` annotations for custom queries.

3. **Actuators**
   - Monitoring Spring Boot applications using built-in endpoints.
   - Health checks, metrics, and environment info.

4. **Microservices Architecture**
   - Service discovery using **Eureka Server**.
   - Routing and API management using **Spring Cloud Gateway**.

5. **Resilience Patterns**
   - Implementing **Circuit Breaker** using **Resilience4j**.
   - Ensuring fault tolerance and handling service failures gracefully.

## Repository Structure

spring-boot-demo/
│
├── SpringBootDemo/ # REST API with @RestController and Spring Data JPA
├── actuator-demo/ # Monitoring using Spring Boot Actuators
├── SpringServiceDiscovery/ # Service registry for microservices
├── SpringCloudGateway/ # Spring Cloud Gateway routing demo
├── InventoryService/ # Circuit breaker implementation with Resilience4j
├── ProductService/ # Circuit breaker implementation with Resilience4j
└── README.md # This file

## Prerequisites

- Java 1.8 or above
- Maven 3.x
- IDE (IntelliJ, Eclipse, VSCode) recommended

## Getting Started

1. **Clone the repository**
```bash
git clone https://github.com/<your-username>/spring-boot-demo.git
cd spring-boot-demo
mvn clean install
cd rest-api-demo
mvn spring-boot:run
cd eureka-server
mvn spring-boot:run
cd api-gateway
mvn spring-boot:run
