# 📚 Library API

A RESTful API for library management built with Spring Boot. This system allows managing books, people, and book loans with full authentication support.

---

## 🛠️ Technologies

- **Java 21**
- **Spring Boot 4.0.6**
- **Spring Security** — Authentication and authorization via JWT
- **Spring Data JPA** — Database communication
- **PostgreSQL** — Relational database
- **Flyway** — Database versioning and migrations
- **Swagger / SpringDoc OpenAPI** — API documentation
- **Lombok** — Boilerplate reduction
- **Docker & Docker Compose** — Containerization
- **ViaCep API** — Automatic address lookup by ZIP code

---

## ✅ Features

- [x] CRUD for Books
- [x] CRUD for Persons
- [x] Book loan management
- [x] Book return management
- [x] Many-to-many relationship between Person and Book
- [x] User authentication with JWT
- [x] Automatic address lookup via ViaCep
- [x] Exception handling
- [x] API documentation with Swagger
- [x] Docker support

---

## 📖 API Documentation

After running the application, access the full Swagger UI at:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🗄️ Database Structure

The system has three main tables:

| Table | Description |
|-------|-------------|
| `book` | Stores book data |
| `person` | Stores person/user data |
| `book_loan` | Manages the M:N relationship between books and persons |

---

## 🚀 How to Run

### Option 1 — Docker (Recommended)

#### Prerequisites
- Docker
- Docker Compose

#### Steps

**1. Clone the repository**
```bash
git clone https://github.com/hfurtini/lib-api.git
cd lib-api
```

**2. Start the containers**
```bash
docker compose up --build -d
```

**3. Access the API**
```
http://localhost:8080/swagger-ui/index.html
```

> The database is automatically created and configured by Docker. No manual setup needed!

---

### Option 2 — Running Locally

#### Prerequisites
- Java 21+
- PostgreSQL
- Maven

#### Steps

**1. Clone the repository**
```bash
git clone https://github.com/hfurtini/lib-api.git
cd lib-api
```

**2. Create the database**
```sql
CREATE DATABASE library_api;
```

**3. Configure `application.properties`**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library_api
spring.datasource.username=your_username
spring.datasource.password=your_password
api.security.token.secret=your_secret_key
```

**4. Run the application**
```bash
./mvnw spring-boot:run
```

**5. Access the API**
```
http://localhost:8080/swagger-ui/index.html
```

---

## 🔐 Authentication

This API uses JWT for authentication. Follow these steps:

**1. Register a person**
```
POST /person/create
```

**2. Login to get the token**
```
POST /auth/login
```
```json
{
  "email": "your@email.com",
  "password": "yourpassword"
}
```

**3. Use the token in Swagger**
- Click the 🔒 **Authorize** button at the top of the Swagger UI
- Enter: `Bearer your_token_here`
- Now all endpoints are accessible

---

## 📁 Project Structure

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
│   │   ├── infra/config/     # Security and API configurations
│   │   └── exception/        # Exception Handling
│   └── resources/
│       ├── application.properties
│       └── db/migration/     # Flyway Migrations
├── Dockerfile
└── docker-compose.yml
```

---

## 🔗 Main Endpoints

### Authentication
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/auth/login` | Authenticate and get JWT token | ✅ |

### Books
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/book/all` | Get all books | ✅ |
| GET | `/book/{id}` | Get book by ID | ✅ |
| POST | `/book/create` | Register a new book | ✅ |
| PUT | `/book/update/{id}` | Update a book | ✅ |
| DELETE | `/book/delete/{id}` | Delete a book | ✅ |

### Persons
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/person/create` | Register a new person | ✅ |
| GET | `/person/all` | Get all persons | ✅ |
| GET | `/person/{id}` | Get person by ID | ✅ |
| PUT | `/person/update/{id}` | Update a person | ✅ |
| DELETE | `/person/delete/{id}` | Delete a person | ✅ |

### Book Loans
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/bookloan/all` | Get all loans | ✅ |
| GET | `/bookloan/{id}` | Get loan by ID | ✅ |
| POST | `/bookloan/create` | Create a new loan | ✅ |
| PUT | `/bookloan/update/{id}` | Update a loan | ✅ |
| DELETE | `/bookloan/delete/{id}` | Delete a loan | ✅ |

---

## 👤 Author

**Henrique Araujo Furtini**
GitHub: [@hfurtini](https://github.com/hfurtini)

---

## 📄 License

This project was developed as part of a Back-End Development training program at Emakers.