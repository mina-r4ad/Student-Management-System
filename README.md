# Student Management System

A console-based Java application built to practice software engineering principles, Object-Oriented Programming (OOP), and clean project architecture while implementing a complete Student Management System.

---

## Overview

This project is part of my long-term journey toward becoming a Backend Software Engineer.

Instead of building many unrelated projects, I continuously improve the same codebase while applying new concepts as I learn them.

Version **v1.2** introduces a cleaner architecture by separating responsibilities into layers (UI, Service, Repository, Model, Utility, and Exception packages), making the project easier to maintain, extend, and test.

---

## Features

- Add new students
- View all students
- Search by ID
- Search by partial name
- Update student name
- Update student GPA
- Delete student by ID
- Automatic student ID generation
- Input validation
- Case-insensitive search
- Custom exception handling
- Layered project architecture
- Console-based interactive menu

---

## Project Architecture

```
Main
 │
 ▼
ConsoleMenu (UI)
 │
 ▼
StudentService (Interface)
 │
 ▼
StudentManager (Business Logic)
 │
 ▼
StudentRepository (Data Access)
 │
 ▼
ArrayList<Student>
```

---

## Project Structure

```
src
├── exception
├── model
├── repository
├── service
├── ui
├── util
└── Main.java
```

---

## Technologies

- Java 21
- Object-Oriented Programming (OOP)
- Java Collections Framework
- ArrayList
- Interfaces
- Exception Handling
- Regular Expressions
- IntelliJ IDEA
- Git
- GitHub

---

## Concepts Practiced

- Classes & Objects
- Constructors
- Encapsulation
- Interfaces
- Layered Architecture
- Separation of Concerns
- Repository Pattern (Basic)
- CRUD Operations
- Input Validation
- Custom Exceptions
- Business Logic
- Collections
- Method Reusability
- Code Refactoring
- Git Version Control

---

## Current Limitations

- Console application only
- Data is stored in memory
- No file persistence
- No database integration
- No unit testing
- No dependency injection framework

---

## Roadmap

### Version 1.3

- Statistics
- Student sorting
- Better search options
- Improved validation
- Override `toString()`
- Override `equals()` and `hashCode()`

### Version 1.4

- File storage
- Load data at startup
- Save data before exit

### Version 2.0

- Generic Repository
- Generic Service
- Unit Testing (JUnit)
- Design Patterns

### Future Goals

- Spring Boot
- REST API
- MySQL
- Docker
- Authentication
- Cloud Deployment

---

## Learning Goal

The purpose of this repository is not simply to build a Student Management System.

It is to document my progress while learning software engineering fundamentals, improving code quality, applying better architectural practices, and gradually evolving the project toward a production-style backend application.
