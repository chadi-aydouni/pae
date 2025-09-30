# PAE - Java/Spring Boot

Application developed in Java/Spring Boot as part of the WEBG5 course at HE2B ESI (2020-2021).

## Overview

PAE is an application that primarily allows students to view courses and the ones they are registered in, while also enabling the administration office to create students and register them for courses.
It is based on an **H2 in-memory database** storing students, courses, and user authentication data.

The web interface, built with Spring Boot (Thymeleaf + optional Vue.js for dynamic views), provides the user with:

* The ability to view all courses and students.
* The ability to add new courses and students via web forms.
* The ability to register students for courses and visualize their details.
* Basic user authentication with roles (e.g., `PROF`).

## Prerequisites

* Java JDK 11 or later
* Maven 3.x
* Spring Boot 2.x
* Optional: Web browser to access the application (localhost:8080)

## Installation

### Compile and run the project

Ensure Maven is installed and available in your system PATH. Then, open a terminal in the project root directory and run:

```bash
mvn clean spring-boot:run
```

This command will clean the project, download dependencies, and launch the Spring Boot application.
Once running, the web application is accessible at: [http://localhost:8080](http://localhost:8080)

### Database

The application uses an **H2 in-memory database**.
Tables include:

* `User`: authentication table with `username`, `password` (BCrypt), and `enabled` status.
* `Authority`: user roles.
* `Student`: student details (`id`, `name`, `gender`, `section`).
* `Course`: courses (`id`, `title`, `credits`).
* `course_registered_students`: join table for many-to-many relationship between students and courses.

#### Test Users

The application comes with the following preconfigured test users:

| Username | Password | Role      |
| -------- | -------- | --------- |
| etu      | etu      | USER      |
| prof     | prof     | PROF      |
| sec      | sec      | SECRETARY |


## Usage

Once the application is launched, you can:

* **Manage courses**:

  * View all courses
  * Add new courses
  * View course details and registered students
  * Register students for courses

* **Manage students**:

  * View all students
  * Add new students
  * View student details and their registered courses
  * Register students for courses

* **Authentication**:

  * Login as a student, professor or secretary 

* **Optional Vue.js interface**:

  * Some course lists can be viewed in a dynamic frontend using Vue.js (`/courses_vuejs`).

## Disclaimer

This repository was created as part of coursework. Some files (starter code, assignments, resources) were provided by the instructor or belong to third parties. All rights to these materials remain with their original authors and/or copyright holders.

My own contributions in this repository are shared under the MIT License. Files provided by instructors, external authors, or third parties are **not** covered by this license.

### Instructor-provided materials

This repository specifically includes the following materials provided by the instructor:

* **BeanValidationUtil.java** : methods for testing validation annotations applied to entities
* **logo_esi.png** – Logo of ESI (École Supérieure d’Informatique, Brussels). All rights reserved