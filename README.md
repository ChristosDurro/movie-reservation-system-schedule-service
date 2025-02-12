# Schedule Service

## Overview
The **Schedule Service** is a microservice within the Movie Reservation System responsible for managing movie schedules. It handles schedule creation, retrieval, and association with movies and reservations.

## Features
- Create and manage movie schedules.
- Retrieve schedule details by movie or date.
- Ensure schedules are linked to reservations and ticket bookings.

## Technologies Used
- **Spring Boot** – Core framework for building the microservice.
- **Spring Data JPA** – For interacting with the database.
- **MySQL** – Database for storing schedule-related information.
- **Feign Client** – For inter-service communication.
- **Spring Cloud Eureka** – Service discovery and registration.
- **JWT Authentication** – Securing API endpoints.

## API Endpoints

### Schedule Management
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/schedules` | Retrieve all schedules |
| `GET` | `/schedules/{id}` | Retrieve schedule details by ID |
| `GET` | `/schedules/movie/{movieId}` | Retrieve schedules for a specific movie |
| `POST` | `/schedules/multiple` | Retrieve multiple schedules by IDs |
| `POST` | `/schedules/create` | Create new schedule |
| `PUT` | `/schedules/update/{id}` | Update schedule |

## Service Communication
- Communicates with **Ticket Service** to ensure schedule validity in ticket bookings.
- Communicates with **Reservation Service** to link schedules with reservations.

## Installation & Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/ChristosDurro/movie-reservation-system-schedule-service.git
   ```
2. Navigate to the project folder:
   ```bash
   cd movie-reservation-system-schedule-service
   ```
3. Configure the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/schedule_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password

   # Eureka and other configurations you might want
   ```
4. Build and run the service:
   ```bash
   mvn spring-boot:run
   ```

---

This service is part of the **Movie Reservation System**, designed to showcase a microservices-based architecture with Spring Boot.

