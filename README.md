🚨 Cyber Threat Alert Portal

A Spring Boot–based backend application for managing cyber threat alerts with Role-Based Access Control (RBAC) and secure API endpoints.

Built using:

Spring Boot 4.x

Spring Security

Spring Data JPA

MySQL 8

Maven

Basic Authentication (for API testing)

📌 Features

✅ User Authentication (Spring Security)

✅ Role-Based Authorization (ADMIN role)

✅ BCrypt Password Encryption

✅ REST APIs

✅ MySQL Database Integration

✅ Secure Admin Endpoints

✅ Basic Auth (Postman Friendly)

🏗️ Project Architecture
com.project.cyberalert
│
├── entity
│   ├── User.java
│   ├── Role.java
│   ├── Alert.java
│   ├── Threat.java
│
├── repository
│   ├── UserRepository.java
│   ├── RoleRepository.java
│
├── service
│   ├── CustomUserDetailsService.java
│   ├── ThreatService.java
│
├── security
│   ├── SecurityConfig.java
│
├── controller
│   ├── AdminController.java

🛠️ Tech Stack
Layer	Technology
Backend	Spring Boot 4
Security	Spring Security
ORM	Hibernate (JPA)
Database	MySQL 8
Build Tool	Maven
Password Encoding	BCrypt
⚙️ Database Configuration

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/location_alert_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

🗄️ Database Schema
roles
id	name
1	ROLE_ADMIN
users
id	username	password (BCrypt)	email	enabled
1	admin	$2a$10$...	admin@cyberalert.local
	1
user_roles
user_id	role_id
1	1
🔐 Security Configuration
SecurityConfig.java

CSRF disabled

Basic Auth enabled

/api/admin/** → ADMIN only

All other endpoints → authenticated

🔑 Default Admin Credentials
Username: admin
Password: admin123


⚠ Password must be stored as BCrypt hash in DB.

🧪 API Testing (Postman)
Admin Test Endpoint
GET http://localhost:8080/api/admin/test


Authorization:

Type → Basic Auth

Username → admin

Password → admin123

Expected Response:

200 OK
ADMIN ACCESS GRANTED

🚀 Run the Application
Using IDE

Run:

CyberThreatAlertPortalApplication.java

Using Maven
mvn spring-boot:run


Application runs on:

http://localhost:8080

📂 Git Commands (Push to Repository)
git add .
git commit -m "Added secure ADMIN RBAC implementation"
git push origin main

🔒 Security Notes

Passwords stored using BCrypt

Role prefix must be ROLE_

Always use HTTPS in production

Never store plain text passwords

📌 Future Enhancements

JWT Authentication

User Registration API

Threat Management APIs

Email Notifications

Audit Logging

Swagger API Documentation

👨‍💻 Author

Pratik Kumar Nayak