# Digital Library Management System

This project is a **Digital Library Management System** built with Spring Boot and MySQL. It provides a streamlined solution for managing a digital library, allowing unique users to borrow books, search for books by various parameters, and enabling admins to manage library resources efficiently.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [Setup Instructions](#setup-instructions)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Future Enhancements](#future-enhancements)

---

## Features

- **User Management**:
  - Registration and authentication of users.
  - Differentiation between user roles (User and Faculty).
  - User borrowing quota to limit the maximum number of books a user can borrow.
  
- **Book Management**:
  - Book registration by admin.
  - Book search by author name, title, or ISBN number.
  - Borrow and return functionality with real-time updates.

- **Admin Dashboard**:
  - Track available and borrowed books.
  - Manage library resources automatically with a simple interface.
  
## Technologies Used

- **Backend**: Java, Spring Boot
- **Database**: MySQL
- **API Testing**: Postman
- **Dependencies**:
  - Spring Boot Starter Web
  - MySQL Driver
  - Spring Data JPA with Hibernate and Hibernate Envers for auditing

---

## Project Structure

This is a typical **Maven project** with the following main components:

- **Controller**: Handles API endpoints and user requests.
- **Entities**: Contains entity classes representing the database tables.
- **Repository**: Interfaces for database operations using JPA.
- **Service**: Business logic of the application.
- **Exception Handling**: Custom exception classes to manage application errors.

---

## Database Schema

The MySQL database contains the following main tables:

- **Users**: Stores user information, including role, borrow quota, etc.
- **Books**: Contains book details (author, title, ISBN number).
- **Borrowed Books**: Tracks which books are currently borrowed by each user.

---
## src/main/resources/application.properties

spring.application.name=your_project_name
spring.datasource.url=your_DB_url
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
authority.admin=admin
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
student.book.quota=3

---
mvn clean install
---
Contributions are welcome! Please fork the repository and create a pull request with your updates.
---
## License
This project is licensed under the MIT License. See the LICENSE file for details.
