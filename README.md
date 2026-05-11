# Library API

A RESTful API for library management built with Spring Boot. This system allows managing books, people, and book loans with full authentication support.

---

## Technologies

- **Java 17**
- **Spring Boot**
- **Spring Security** — Authentication and authorization
- **Spring Data JPA** — Database communication
- **PostgreSQL** — Relational database
- **Flyway** — Database versioning and migrations
- **Swagger / SpringDoc OpenAPI** — API documentation
- **Lombok** — Boilerplate reduction
- **ViaCep API** — Automatic address lookup by ZIP code

---

## Features

- [x] CRUD for Books
- [x] CRUD for Persons
- [x] Book loan management
- [x] Book return management
- [x] Many-to-many relationship between Person and Book
- [x] User authentication
- [x] Automatic address lookup via ViaCep
- [x] Exception handling
- [x] API documentation with Swagger
- [ ] Docker support *(coming soon)*

---

## API Documentation

After running the application, access the full Swagger UI at:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Database Structure

The system has three main tables:

| Table | Description |
|-------|-------------|
| `book` | Stores book data |
| `person` | Stores person/user data |
| `book_loan` | Manages the M:N relationship between books and persons |

---

## How to Run

### Prerequisites

- Java 17+
- PostgreSQL running locally
- Maven

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/hfurtini/biblioteca-api.git
cd biblioteca-api
```

**2. Create the database**
```sql
CREATE DATABASE library;
```

**3. Configure `application.properties`**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library
spring.datasource.username=your_username
spring.datasource.password=your_password
```

**4. Run the application**
```bash
./mvnw spring-boot:run
```

**5. Access the API**
```
http://localhost:8080
```

---

## Project Structure

```
src/
├── main/
│   ├── java/com/br/emakers/lib_api/
│   │   ├── controller/       # REST Controllers
│   │   ├── data/
│   │   │   ├── dto/
│   │   │   │   ├── request/  # Request DTOs
│   │   │   │   └── response/ # Response DTOs
│   │   │   └── entity/       # JPA Entities
│   │   ├── repository/       # Spring Data Repositories
│   │   ├── service/          # Business Logic
│   │   └── exception/        # Exception Handling
│   └── resources/
│       ├── application.properties
│       └── db/migration/     # Flyway Migrations
```

---

## 🔗 Main Endpoints

### Books
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/book/all` | Get all books |
| GET | `/book/{id}` | Get book by ID |
| POST | `/book/create` | Register a new book |
| PUT | `/book/update/{id}` | Update a book |
| DELETE | `/book/delete/{id}` | Delete a book |

### Persons
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/person/all` | Get all persons |
| GET | `/person/{id}` | Get person by ID |
| POST | `/person/create` | Register a new person |
| PUT | `/person/update/{id}` | Update a person |
| DELETE | `/person/delete/{id}` | Delete a person |

### Book Loans
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/bookloan/all` | Get all loans |
| GET | `/bookloan/{id}` | Get loan by ID |
| POST | `/bookloan/create` | Create a new loan |
| PUT | `/bookloan/update/{id}` | Update a loan |
| DELETE | `/bookloan/delete/{id}` | Delete a loan |

---

## Author

**Henrique Araujo Furtini**  
GitHub: [@hfurtini](https://github.com/hfurtini)

---

## License

This project was developed as part of a Back-End Development training program.
