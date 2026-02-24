🚨 Cyber Threat Alert Portal

A Secure & Geo-Aware Cyber Threat Monitoring Backend built with Spring Boot, Role-Based Access Control, and an Automated Alert Engine.

🌍 Overview

Cyber Threat Alert Portal is a secure backend application designed to:

🔐 Authenticate users using Spring Security

🛡️ Authorize admin operations using ROLE_ADMIN

📍 Generate geo-based alerts automatically

🚨 Filter alerts based on severity levels

🗄️ Persist data using MySQL & JPA

🧱 Follow clean layered architecture principles

This project demonstrates secure backend engineering with real-world business logic implementation.

🏗️ Architecture
Controller Layer
        ↓
Service Layer
        ↓
Repository Layer
        ↓
MySQL Database

Security operates independently through the Spring Security filter chain.

🛠️ Tech Stack
Layer	Technology
Backend	Spring Boot 4.x
Language	Java 21+
Security	Spring Security
ORM	Spring Data JPA (Hibernate)
Database	MySQL 8
Password Encoding	BCrypt
Build Tool	Maven
Authentication	HTTP Basic
🔐 Security Features (Step-5)

✔ Database-driven authentication
✔ ROLE_ADMIN based authorization
✔ BCrypt password hashing
✔ CustomUserDetailsService implementation
✔ Secured /api/admin/** endpoints
✔ CSRF disabled for API testing

Security Rules
/api/admin/** → ROLE_ADMIN
/api/threats/** → Public
All other endpoints → Authenticated
⚡ Automated Alert Engine (Step-6)

When an Admin creates a Threat:

Threat is saved in database

All UserPreferences are loaded

System filters users by:

Severity match

Geo-distance using Haversine formula

Matching Alerts are generated automatically

📍 Geo-Distance Calculation

Uses Haversine formula

Earth radius = 6371 km

Accurate spherical distance calculation

This upgrades the system from simple CRUD → Intelligent Alert Processing Engine.

📦 Project Structure
com.project.cyberalert
│
├── controller
│   ├── AdminController.java
│   ├── ThreatController.java
│   ├── UserAlertController.java
│
├── entity
│   ├── User.java
│   ├── Role.java
│   ├── Threat.java
│   ├── Alert.java
│   ├── UserPreference.java
│
├── repository
│   ├── UserRepository.java
│   ├── RoleRepository.java
│   ├── ThreatRepository.java
│   ├── AlertRepository.java
│   ├── UserPreferenceRepository.java
│
├── service
│   ├── CustomUserDetailsService.java
│   ├── ThreatService.java
│   ├── AlertService.java
│   ├── UserPreferenceService.java
│
├── security
│   ├── SecurityConfig.java
│
└── CyberThreatAlertPortalApplication.java
🗄️ Database Tables

users

roles

user_roles

threats

alerts

user_preferences

⚙️ Database Configuration

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/cyber_alert
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
🔑 Default Admin Credentials
Username: admin
Password: admin123

⚠ Password must be stored as BCrypt hash in database.

🧪 API Testing (Postman)
Admin Test Endpoint
GET http://localhost:8080/api/admin/test

Authorization:

Type → Basic Auth

Username → admin

Password → admin123

Expected Response:

ADMIN ACCESS GRANTED
🚀 Run the Application
Using Maven
mvn spring-boot:run
Using IDE

Run:

CyberThreatAlertPortalApplication.java

Application runs on:

http://localhost:8080
📊 Current Capabilities

✔ Secure Authentication
✔ Role-Based Authorization
✔ Admin-Only APIs
✔ Threat Management
✔ Automated Geo-Based Alert Generation
✔ Severity Filtering
✔ Clean Layered Architecture

🔮 Future Enhancements

JWT Authentication

WebSocket Real-Time Alerts

Alert Pagination & Sorting

Mark Alerts as Read

Email / SMS Notification Integration

Swagger API Documentation

Event-Driven Processing (Kafka/RabbitMQ)

📌 Development Milestones
Step	Description
Step-1	Project Setup
Step-2	Entity Modeling
Step-3	Repository Layer
Step-4	Service Layer
Step-5	Spring Security + RBAC
Step-6	Automated Geo-Based Alert Engine
⭐ Why This Project Stands Out

Implements enterprise-grade security

Demonstrates RBAC (Role-Based Access Control)

Uses secure password hashing (BCrypt)

Includes real-world geo-distance computation logic

Maintains scalable backend design principles

Clean separation of concerns

👨‍💻 Author

Pratik Kumar Nayak
Backend Developer | Spring Boot | Security | System Design
