# Task Tracker API

This project is a simple RESTful API for managing tasks, built with Spring Boot.

## Endpoints

- **`POST /tasks`**: Adds a new task to the system. Expects a JSON payload with the task description and returns the created task object, including its generated ID and timestamps.

- **`GET /tasks/list`**: Returns a list of all tasks stored in the database.

## How to Run

### Prerequisites

- JDK 17 or higher
- Maven installed
- Docker installed

### 1. Start the database

The project uses Docker to run a PostgreSQL instance locally. Start the database container with:

```bash
docker compose up -d
```

### 2. Run the application

With the database running, start the Spring Boot application:

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

### Making Requests

**Adding a new task:**

```bash
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"description": "Learn Spring Boot"}'
```

**Listing all tasks:**

```bash
curl http://localhost:8080/tasks/list
```

## Future Improvements

- Implement task updating and deletion endpoints.
- Robust error handling for user input and API requests.
- Use Enums for task status.
- Separate business logic from the controller.