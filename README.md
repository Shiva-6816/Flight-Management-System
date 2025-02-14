# Flight Management System

## 1. Introduction

The **Flight Management System** is a Java-based application developed using **Spring Boot**. It provides functionalities to manage flights, bookings, and users efficiently. The system allows users to search flights, book tickets, and manage their bookings.

## 2. Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Swagger
- Postman (for API testing)

## 3. Project Structure

```
Flight-Management-System/
│-- src/main/java/com/qsp/flight_management_system/
│   ├── controller/
│   │   ├── AddressController.java
│   │   ├── AirhostessController.java
│   │   ├── AirportController.java
│   │   ├── FlightController.java
│   │   ├── FoodController.java
│   │   ├── PasangerController.java
│   │   ├── PassportController.java
│   │   ├── PaymentController.java
│   │   ├── PilotController.java
│   │   ├── SeatController.java
│   │   ├── TicketController.java
│   │
│   ├── dto/
│   │   ├── Address.java
│   │   ├── Airhostess.java
│   │   ├── Airport.java
│   │   ├── Flight.java
│   │   ├── Food.java
│   │   ├── Pasanger.java
│   │   ├── Passport.java
│   │   ├── Payment.java
│   │   ├── Pilot.java
│   │   ├── Seat.java
│   │   ├── Ticket.java
│   │
│   ├── exception/
│   │   ├── AddressIdNotFound.java
│   │   ├── AirhostessIdNotFound.java
│   │   ├── AirportIdNotFound.java
│   │   ├── ApplicationExceptionHandler.java
│   │   ├── FlightIdNotFound.java
│   │   ├── FoodIdNotFound.java
│   │   ├── PasangerIdNotFound.java
│   │   ├── PassportIdNotFound.java
│   │   ├── PaymentIdNotFound.java
│   │   ├── PilotIdNotFound.java
│   │   ├── SeatIdNotFound.java
│   │   ├── TicketIdNotFound.java
│   │
│   ├── repo/
│   │   ├── AddressRepo.java
│   │   ├── AirhostessRepo.java
│   │   ├── AirportRepo.java
│   │   ├── FlightRepo.java
│   │   ├── FoodRepo.java
│   │   ├── PasangerRepo.java
│   │   ├── PassportRepo.java
│   │   ├── PaymentRepo.java
│   │   ├── PilotRepo.java
│   │   ├── SeatRepo.java
│   │   ├── TicketRepo.java
│   │
│   ├── dao/
│   │   ├── AddressDao.java
│   │   ├── AirhostessDao.java
│   │   ├── AirportDao.java
│   │   ├── FlightDao.java
│   │   ├── FoodDao.java
│   │   ├── PasangerDao.java
│   │   ├── PassportDao.java
│   │   ├── PaymentDao.java
│   │   ├── PilotDao.java
│   │   ├── SeatDao.java
│   │   ├── TicketDao.java
│   │
│   ├── service/
│   │   ├── AddressService.java
│   │   ├── AirhostessService.java
│   │   ├── AirportService.java
│   │   ├── FlightService.java
│   │   ├── FoodService.java
│   │   ├── PasangerService.java
│   │   ├── PassportService.java
│   │   ├── PaymentService.java
│   │   ├── PilotService.java
│   │   ├── SeatService.java
│   │   ├── TicketService.java
│   │
│   ├── util/
│   │   ├── ApplicationConfiguration.java
│   │   ├── ResponseStructure.java
│   │   ├── ResponseStructureList.java
│   │
│   ├── FlightManagementSystemApplication.java
│
│-- src/main/resources/
│   ├── static/
│   ├── templates/
│   ├── application.properties
│
│-- src/test/java/
│-- pom.xml
```

## 4. Setting Up the Project

### Prerequisites:

- Install **Java JDK 17** or later
- Install **MySQL Server**
- Install **Maven**
- Install **Postman** (for API testing)

### Steps to Run the Application:

1. Clone the repository:
   ```sh
   git clone https://github.com/Shiva-6816/Flight-Management-System.git
   ```
2. Navigate to the project directory:
   ```sh
   cd Flight-Management-System
   ```
3. Configure the **database** in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/flight_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Build the project using Maven:
   ```sh
   mvn clean install
   ```
5. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```
6. Access Swagger API documentation:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

## 5. API Endpoints

### Flight API

- `GET /flights` - Get all flights
- `GET /flights/{id}` - Get flight by ID
- `POST /flights` - Add new flight
- `PUT /flights/{id}` - Update flight
- `DELETE /flights/{id}` - Delete flight
- `GET /flights/search?source={source}&destination={destination}` - Search flights by source and destination

### Booking API

- `POST /bookings` - Create booking
- `GET /bookings/{id}` - Get booking by ID
- `GET /bookings/user/{userId}` - Get bookings by user ID
- `DELETE /bookings/{id}` - Cancel booking
- `PUT /bookings/{id}/update` - Update booking details

### User API

- `POST /users` - Register user
- `GET /users/{id}` - Get user details
- `PUT /users/{id}` - Update user
- `DELETE /users/{id}` - Delete user
- `POST /users/login` - User login
- `GET /users/all` - Get all registered users

## 6. Future Enhancements

- Implement authentication and authorization using **Spring Security**.
- Integrate **payment gateway** for flight bookings.
- Add **real-time notifications** for flight status updates.
- Implement **role-based access control (RBAC)**.
- Include **email confirmation** for bookings.

## 7. Conclusion

This **Flight Management System** is a fully functional **Spring Boot application** with a well-defined structure and modular design, making it easy to extend and integrate additional features.

