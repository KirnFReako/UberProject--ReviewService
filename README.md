# Uber Review Service

A Spring Boot-based microservice designed to handle and manage reviews for an Uber-like application. This project demonstrates the usage of **Spring Data JPA**, **MySQL integration**, and **JPA Auditing**.

---

## 🚀 Project Overview

The **Uber Review Service** is responsible for storing and retrieving customer reviews. It currently features:
- A `Review` entity with fields for content, rating, and timestamps.
- Automatic timestamp generation using **JPA Auditing**.
- A repository layer for database operations.
- A service layer that seeds initial data on startup using `CommandLineRunner`.

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA** (Java Persistence API)
- **MySQL** (Database)
- **Lombok** (Boilerplate reduction)

---

## 📖 Deep Dive: Java Persistence API (JPA)

### What is JPA?
JPA is a **specification** in Java that provides a standard way to manage relational data in Java applications. It allows developers to map Java objects (POJOs) to database tables—a process known as **Object-Relational Mapping (ORM)**.

Instead of writing complex SQL queries for every operation, you interact with your Java objects, and JPA (via its provider) handles the SQL behind the scenes.

### JPA vs. Hibernate
- **JPA** is the **interface/specification**. It defines the rules and annotations.
- **Hibernate** is the **implementation**. It is the actual engine that performs the database work. 
*Think of JPA as a set of blueprints and Hibernate as the actual construction crew.*

---

## 📝 Key JPA Annotations Used

### 1. Entity Mapping
- **`@Entity`**: Marks the class as a JPA entity, meaning it will be mapped to a database table.
- **`@Table(name = "bookingreview")`**: Specifies the name of the database table for this entity.
- **`@Id`**: Marks the primary key of the table.
- **`@GeneratedValue(strategy = GenerationType.IDENTITY)`**: Configures the way the ID is generated. `IDENTITY` uses the database's auto-increment feature.

### 2. Column Mapping
- **`@Column`**: Used to customize the column mapping (e.g., `nullable`, `unique`, `length`).
- **`@Temporal(TemporalType.TIMESTAMP)`**: Specifies how `java.util.Date` or `java.util.Calendar` fields should be persisted in the database.

---

## ⏱️ JPA Auditing

This project uses **JPA Auditing** to automatically track when records are created and modified.

### Annotations:
- **`@CreatedDate`**: Automatically captures the timestamp when the entity is first saved.
- **`@LastModifiedDate`**: Automatically updates the timestamp every time the entity is updated.
- **`@EntityListeners(AuditingEntityListener.class)`**: Activates the auditing listener on the entity class.
- **`@EnableJpaAuditing`**: (In the Main class) Enables the auditing feature project-wide.

---

## 📦 Project Structure

### 1. Models (`com.example.UberReviewService.models`)
- **`Review.java`**: The core entity representing a review. It uses Lombok annotations like `@Getter`, `@Setter`, and `@Builder` to keep the code clean.

### 2. Repositories (`com.example.UberReviewService.repositories`)
- **`ReviewRepository.java`**: Extends `JpaRepository`. This gives us built-in methods like `save()`, `findAll()`, `findById()`, and `delete()` without writing any code.

### 3. Service (`com.example.UberReviewService.service`)
- **`ReviewService.java`**: Implements `CommandLineRunner`. This runs code automatically when the application starts, which we use here to save a sample review to the database.

---

## ⚙️ Configuration

The database connection is configured in `src/main/resources/application.properties`:

```properties
spring.datasource.url = jdbc:mysql://localhost:3306/Uber_Db_Local
spring.datasource.username = root
spring.datasource.password = W7301@jqir#
spring.jpa.hibernate.ddl-auto = update
```

- **`hibernate.ddl-auto=update`**: This tells Hibernate to automatically compare the entity classes with the database schema and update the tables if there are any changes.

---

## 🏃 How to Run

1. Ensure you have **MySQL** running and a database named `Uber_Db_Local` created.
2. Update the credentials in `application.properties` if necessary.
3. Run the application using your IDE or terminal:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Check the console output! You should see the "Saved Review" printout with automatic timestamps.
