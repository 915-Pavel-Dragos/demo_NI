# demo_NI

# Game Store App

A simple CRUD-based web application where users can explore and play video games. Built with **Java Spring Boot**.

---

## Technologies

- **Backend:** Spring Boot `3.4.5`
- **Database:** PostgreSQL (H2 for testing)
- **Authentication:** JSON Web Tokens (JWT)
- **Java Version:** `24`

---

## Dependencies

### Spring Boot

- `spring-boot-starter-data-jpa`
- `spring-boot-starter-web`
- `spring-boot-starter-security`
- `spring-boot-devtools`
- `spring-boot-starter-test`

### JWT (JSON Web Token)

- `jjwt-api` `0.11.5`
- `jjwt-impl` `0.11.5`
- `jjwt-jackson` `0.11.5`

### Database

- `postgresql` (Runtime)
- `h2` (Test scope)

### Other

- `jakarta.persistence-api`

---

## Running the App

### On macOS/Linux

./mvnw spring-boot:run 

---

### On Windows

- mvnw.cmd spring-boot:run

---

## Running only the test

### On macOS/Linux

./mvnw test

---

### On Windows

- mvnw.cmd test