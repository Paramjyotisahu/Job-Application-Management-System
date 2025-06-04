# 🧑‍💼 Job Application Management System

A Spring Boot-based backend application to manage job listings, companies, and user reviews. This project demonstrates a modular and scalable architecture using Spring Boot, RESTful APIs, Spring Data JPA, and MySQL.

---

## 🚀 Features

- ✅ **Job Management**: Add, view, update, and delete job listings
- ✅ **Company Management**: Manage company profiles associated with jobs
- ✅ **Review System**: Submit and retrieve user reviews for companies
- ✅ **RESTful APIs**: Structured controller-service-repository architecture
- ✅ **MySQL Integration**: Database-driven storage using Spring Data JPA
- ✅ **Error Handling**: Custom exception for enhanced error messages
- ✅ **Layered Structure**: Clean separation of concerns for maintainability

---

## 🛠️ Tech Stack

- **Java 17** (or your actual version)
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Lombok** (if used)
- **Postman** (for API testing)

---

## 📁 Project Structure
firstjobapp/
├── src/
│ ├── main/
│ │ ├── java/com/embarkx/firstjobapp/
│ │ │ ├── job/
│ │ │ ├── company/
│ │ │ └── review/
│ │ └── resources/
│ │ └── application.properties
├── test/
│ └── FirstjobappApplicationTests.java
├── pom.xml
└── README.md

## 🧪 API Endpoints (Sample)

### Company
GET /api/company
POST /api/company
PUT /api/company/{id}
DELETE /api/company/{id}

### Job
GET /api/job
POST /api/job
PUT /api/job/{id}
DELETE /api/job/{id}

### Review
GET /api/review
POST /api/review
