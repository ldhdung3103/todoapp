# Todo App

## Overview

A simple and responsive Todo List web application built with **Spring Boot** and **Thymeleaf**. The application allows users to manage daily tasks by creating, updating, deleting, completing, and filtering tasks. This project demonstrates the use of the Spring MVC architecture, data validation, and a professional Git workflow.

---

## Features

### Core Features

- View all tasks
- Add a new task
- Edit an existing task
- Delete a task
- Mark task as completed or incomplete
- Filter tasks by:
    - All
    - Active
    - Completed

### Validation

- Prevent empty task title
- Validate task title length
- Validate description length
- Display validation errors without losing user input

### User Interface

- Responsive design
- Modern card-based layout
- Clean and simple interface
- Hover effects
- Confirmation dialog before deleting a task

---

## Tech Stack

### Backend

- Java 17
- Spring Boot 3.5.16
- Spring MVC
- Spring Data JPA
- Hibernate

### Frontend

- Thymeleaf
- HTML5
- CSS3

### Database

- MySQL 8

### Build Tool

- Maven

### Version Control

- Git
- GitHub

---

## Project Structure

```text
src
└── main
    ├── java
    │   └── com.example.todoapp
    │       ├── controller
    │       ├── entity
    │       ├── repository
    │       ├── service
    │       └── TodoappApplication.java
    │
    └── resources
        ├── static
        │   └── css
        │       └── style.css
        │
        ├── templates
        │   ├── index.html
        │   └── edit.html
        │
        └── application.properties
```

---

## Application Architecture

```text
Browser
    │
    ▼
Spring MVC Controller
    │
    ▼
Service Layer
    │
    ▼
Repository (JPA)
    │
    ▼
MySQL Database
```

The project follows the MVC (Model-View-Controller) architecture to keep the code clean, modular, and maintainable.

---

## Screenshots

### Home Page

> *![img.png](docs/images/img.png)*

### Edit Task

> *![img_1.png](docs/images/img_1.png)*

### Validation

> *![img_3.png](docs/images/img_3.png)*

---

## Installation

### 1. Clone the repository

```bash
git clone https://github.com/ldhdung3103/todo-app.git
```

### 2. Open the project

Open the project using **IntelliJ IDEA**.

### 3. Create MySQL database

```sql
CREATE DATABASE todo_db;
```

### 4. Configure database

Edit the following file:

```
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 5. Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Or simply run:

```
TodoappApplication.java
```

### 6. Open in browser

```
http://localhost:8080
```

---

## Git Workflow

This project was developed using a feature branch workflow.

```text
main
│
├── feature/task-crud
│
├── feature/task-edit-filter
│
├── feature/task-ui
│
└── feature/readme
```

Each feature follows the workflow below:

```text
Create Branch
      ↓
Implement Feature
      ↓
Commit
      ↓
Push
      ↓
Pull Request
      ↓
Code Review
      ↓
Merge
```

---

## Validation

This project uses Jakarta Bean Validation.

Implemented validations include:

- `@NotBlank`
- `@Size`
- `@Valid`
- `BindingResult`

Validation errors are displayed directly on the page without losing the current form data.

---

## Future Improvements

Although the required features have been completed, the following improvements can be added in the future:

- Search tasks by keyword
- Pagination
- Sorting
- Docker support
- Unit testing
- Spring Security authentication
- REST API
- Deploy to cloud platform

---

## Learning Outcomes

This project helped practice:

- Spring Boot fundamentals
- MVC Architecture
- Spring Data JPA
- Thymeleaf
- Form Validation
- CRUD operations
- Git & GitHub Workflow
- Feature Branch development
- Merge Conflict resolution
- Responsive Web Design

---

## Author

**Lê Dương Hoàng Dung**

GitHub:

https://github.com/ldhdung3103

---

## License

This project was created for learning purposes and internship assessment.