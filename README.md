# Event Ledger API

## Overview
This project is developed as part of the Charles Schwab assessment.  
It demonstrates a scalable and maintainable backend system using Spring Boot.

## AI Considerations
- Designed API structure for future AI integration
- Supports extensibility for AI-driven analytics
- Can be extended with recommendation engines or NLP services

## Features
- Idempotent event handling
- Out-of-order event support
- Balance computation
- Input validation
- Swagger API documentation

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Maven
- REST APIs

## Project Structure
src/main/java/com/example/ledger
- controller
- service
- repository
- entity
- dto
- exception

## Sample APIs
- POST /ledger/events
- GET /ledger/{id}
- GET /ledger/all

## How to Run

mvn spring-boot:run

## Notes
- Designed with clean architecture principles
- Follows microservices-ready structure

