# Task Tracker API

This project is a simple RESTful API for managing tasks, built with Spring Boot.

## Current Endpoint

*   **`POST /tasks`**: Adds a new task to the system. It expects a JSON payload representing the task (e.g., `{"description": "My new task"}`) and returns the created task object, including its generated ID and timestamps.

## How to Run

### Prerequisites

*   JDK (Java Development Kit) installed (version 17 or higher recommended)
*   Maven installed

### Compile and Run

1.  Clone the repository:
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO]
    cd task-tracker
    ```
2.  Compile the project using Maven:
    ```bash
    mvn clean install
    ```
3.  Run the Spring Boot application:
    ```bash
    java -jar target/task-tracker-1.0-SNAPSHOT.jar
    ```
    (Note: The JAR file name might vary slightly depending on your project version and packaging. Use `mvn package` to be sure, or check the `target/` directory after `mvn install`.)

### Making a Request

You can use `curl` or any other HTTP client to interact with the API.

**Example: Adding a new task**

```bash
curl -X POST http://localhost:8080/tasks \
-H "Content-Type: application/json" \
-d '{"description": "Learn Spring Boot"}'
```

This command will send a POST request to `http://localhost:8080/tasks` with a JSON body containing the task description. The API will respond with the created task object.

## Future Improvements

*   Implement task listing, updating, and deletion endpoints.
*   Robust error handling for user input and API requests.
*   Persist tasks to a database.
*   Use Enums for task status.
*   Separate business logic from the controller.