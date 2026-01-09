# Task 2 – REST API with Spring Boot (Product Service)

## 📌 Project Overview

This project is a fully functional **REST API** built with **Spring Boot**. It demonstrates backend development concepts including:

* RESTful architecture
* Layered application structure
* HTTP methods (POST, GET, PUT, DELETE)
* Exception handling
* Swagger (OpenAPI) documentation
* In-memory and database persistence (H2 + JPA)

The API manages **Product** resources and exposes endpoints for full CRUD operations.

---

##  Technologies Used

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database
* Swagger / OpenAPI
* Maven

---

##  Project Structure

```
com.example.product
 ├── api
 │   ├── ProductController.java
 │   ├── request
 │   │   ├── ProductRequest.java
 │   │   └── UpdateProductRequest.java
 │   └── response
 │       └── ProductResponse.java
 ├── domain
 │   └── Product.java
 ├── repository
 │   └── ProductRepository.java
 ├── service
 │   └── ProductService.java
 └── support
     ├── ProductMapper.java
     ├── exception
     │   ├── ProductNotFoundException.java
     │   └── ProductExceptionSupplier.java
     └── handler
         └── GlobalExceptionHandler.java

shared.api.response
 └── ErrorMessageResponse.java
```

---

##  Application Startup

The project was created using **Spring Initializr in IntelliJ** with the following dependencies:

* Spring Web
* Spring Data JPA
* H2 Database
* Spring Boot DevTools

After building the project, the application runs on:

```
http://localhost:8080
```

---

##  Layered Architecture Explained

### Controller Layer (`api`)

* Accepts HTTP requests
* Maps requests to Java objects using `@RequestBody`
* Delegates logic to the service layer
* Returns responses wrapped in `ResponseEntity`

### Service Layer (`service`)

* Contains business logic
* Coordinates mapping, validation, and persistence
* Throws domain-specific exceptions

### Repository Layer (`repository`)

* Responsible for database operations
* Implemented using `JpaRepository`
* No method implementations required (Spring Data JPA generates them automatically)

### Domain Layer (`domain`)

* Contains JPA entities
* Represents database tables

### Support Layer (`support`)

* Object mapping
* Exception suppliers
* Global exception handling

---

##  Object Mapping

`ProductMapper` is responsible for:

* Converting `ProductRequest` → `Product`
* Converting `Product` → `ProductResponse`
* Handling update logic while preserving previous state

This separation ensures clean code and avoids exposing internal entities to clients.

---

##  REST Endpoints

###  Create Product

```
POST /api/v1/products
```

**Request Body (JSON):**

```json
{
  "name": "Laptop"
}
```

**Response:**

* Status: `201 Created`
* Body: ProductResponse

---

###  Get Product by ID

```
GET /api/v1/products/{id}
```

**Responses:**

* `200 OK` – Product found
* `404 Not Found` – Product does not exist

---

###  Update Product

```
PUT /api/v1/products/{id}
```

**Request Body:**

```json
{
  "name": "Updated Laptop"
}
```

* Returns previous state of the resource
* Uses exception handling if resource does not exist

---

###  Get All Products

```
GET /api/v1/products
```

* Returns a list of all products
* Returns empty list if no data exists

---

###  Delete Product

```
DELETE /api/v1/products/{id}
```

* Status: `204 No Content`
* Deletes resource if it exists
* Throws `404 Not Found` if not

---

##  Exception Handling

### Custom Exceptions

* `ProductNotFoundException`

### Global Exception Handler

* Implemented using `@ControllerAdvice`
* Converts exceptions into structured JSON responses
* Returns correct HTTP status codes

Example error response:

```json
{
  "message": "Product with given id not found"
}
```

---

##  Swagger (OpenAPI)

Swagger UI is enabled to:

* Document the API
* Test endpoints interactively

### Access URLs:

* Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

* OpenAPI JSON:

```
http://localhost:8080/v3/api-docs
```

---

##  Database Configuration (H2)

### application.properties

Key settings:

* Enable H2 console
* In-memory database
* SQL logging enabled

### H2 Console Access

```
http://localhost:8080/console
```

JDBC URL:

```
jdbc:h2:mem:testdb
```

---

##  Why JpaRepository Works Without Implementation

Spring Data JPA automatically provides implementations for common database operations based on:

* Interface inheritance
* Method naming conventions
* Runtime proxy generation

This eliminates boilerplate code and speeds up development.

---

##  Testing

The application can be tested using:

* Swagger UI
* Postman
* Browser (GET requests)

All CRUD operations should be verified, including error scenarios.

---

##  Key Learning Outcomes

* REST API design principles
* Spring stereotypes and annotations
* Exception handling best practices
* API documentation with Swagger
* Database integration using JPA and H2

---

##  Summary

Task 2 demonstrates a complete backend REST API with proper architecture, documentation, exception handling, and persistence. It reflects real-world Spring Boot application design and prepares the project for future expansion.
