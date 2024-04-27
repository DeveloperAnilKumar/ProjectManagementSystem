

# Project Management System

Brief description of the project.

## Table of Contents

1. [Introduction](#introduction)
2. [Technologies Used](#technologies-used)
4. [Usage](#usage)
5. [Endpoints](#endpoints)
6. [Testing](#testing)



## Introduction

This project is a demonstration of CRUD (Create, Read, Update, Delete) operations implemented using Spring Boot, Spring Data JPA, and Spring Web. The purpose of this application is to showcase how to build a simple RESTful API for managing projects.

The CRUD operations allow users to:

- **Create**: Add new projects with details such as name, description, start date, and end date.
- **Read**: Retrieve information about existing projects by their unique identifiers.
- **Update**: Modify the details of existing projects, including their names, descriptions, and dates.
- **Delete**: Remove projects from the system based on their IDs.

Additionally, this project provides:

- **Swagger UI**: Accessible at [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html), the Swagger UI allows users to explore and interact with the API endpoints visually.
- **H2 Database Console**: Accessible at [http://localhost:8081/h2-console](http://localhost:8081/h2-console), the H2 Database Console provides a web-based interface to view and manage the in-memory H2 database used by the application.
- **Access URL**: The RESTful API can be accessed at [http://localhost:8081/project/api/](http://localhost:8081/project/api/), where users can perform CRUD operations on projects.

- **Git Clone URL**: The source code for this project can be cloned from [GitHub](https://github.com/DeveloperAnilKumar/crud-operation.git). To clone the repository, use the following command:

    ```bash
    git clone https://github.com/DeveloperAnilKumar/crud-operation.git
    ```


## Technologies Used

### Spring Framework
- **Description**: A powerful and comprehensive framework for building Java applications.
- **Artifact**: `org.springframework:spring-context`

### Spring Web Dependency
- **Description**: Provides support for building web applications using Spring MVC.
- **Artifact**: `org.springframework.boot:spring-boot-starter-web`

### Spring Data JPA
- **Description**: Simplifies the implementation of data access layers by providing support for JPA.
- **Artifact**: `org.springframework.boot:spring-boot-starter-data-jpa`

### H2 Database
- **Description**: In-memory database used for development and testing.
- **Artifact**: `com.h2database:h2`

### Springdoc OpenAPI
- **Description**: Provides support for generating OpenAPI documentation for Spring Boot applications.
- **Artifact**: `org.springdoc:springdoc-openapi-starter-webmvc-ui`

### Spring Boot Starter Validation
- **Description**: Integrates validation support into Spring Boot applications.
- **Artifact**: `org.springframework.boot:spring-boot-starter-validation`

### Spring Boot Starter Test
- **Description**: Provides support for writing unit and integration tests for Spring Boot applications.
- **Artifact**: `org.springframework.boot:spring-boot-starter-test`
- **Scope**: Test

- **Embedded Tomcat Server**: The application runs on an embedded Tomcat server, eliminating the need for external server configuration.

---

You can copy and paste this section into your README file, making sure to update the versions if necessary. This will provide a clear overview of the technologies and dependencies used in your project.



---

# Usage

To interact with the CRUD operations of the project, you can use HTTP requests to the respective endpoints. Below are examples of how to perform each operation:

## Create (POST)

To create a new project, send a POST request to the `/project/api/` endpoint with the following JSON payload:

```bash
  http://localhost:8081/project/api/ \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "New Project",
    "description": "Description of the new project",
    "startDate": "2023-05-27",
    "endDate": "2024-05-27"
  }'
```


## Read (GET)

To retrieve a project by its ID, send a GET request to the `/project/api/{id}` endpoint:

```bash
  http://localhost:8081/project/api/{id}
```


## Read (GET)

To retrieve all project data, send a GET request to the `/project/api/` endpoint:

```bash
  http://localhost:8081/project/api/
```


## Update (PUT)

To update an existing project, send a PUT request to the `/project/api/{id}` endpoint with the updated project details:

```bash
  http://localhost:8081/project/api/{id} \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Updated Project",
    "description": "Updated description of the project",
    "startDate": "2023-06-01",
    "endDate": "2024-06-01"
  }'
```


## Delete (DELETE)

To delete a project by its ID, send a DELETE request to the `/project/api/{id}` endpoint:

```bash
  http://localhost:8081/project/api/{id}
```


---

You can provide additional information or customization options as needed for your project.
## Endpoints

### Create (POST)

- **Endpoint:** `/project/api/`
- **Method:** POST
- **Description:** Create a new project.
- **Request Body:**
  ```json
  {
      "name": "Project Name",
      "description": "Project Description",
      "startDate": "YYYY-MM-DD",
      "endDate": "YYYY-MM-DD"
  }
  ```
- **Response:** The created project object with HTTP status code 201 Created.

### Read (GET)

- **Endpoint:** `/project/api/{id}`
- **Method:** GET
- **Description:** Retrieve a project by its ID.
- **Response:** The project object with HTTP status code 200 OK if found, or HTTP status code 404 Not Found if the project does not exist.


### Read (GET)

- **Endpoint:** `/project/api/`
- **Method:** GET
- **Description:** Retrieve all project .
- **Response:** The project object with HTTP status code 200 OK if found, or HTTP status code 404 Not Found if the project does not exist.

### Update (PUT)

- **Endpoint:** `/project/api/{id}`
- **Method:** PUT
- **Description:** Update an existing project by its ID.
- **Request Body:** The updated project object.
- **Response:** The updated project object with HTTP status code 200 OK if successful, or HTTP status code 404 Not Found if the project does not exist.

### Delete (DELETE)

- **Endpoint:** `/project/api/{id}`
- **Method:** DELETE
- **Description:** Delete a project by its ID.
- **Response:** HTTP status code 200 OK if successful, or HTTP status code 404 Not Found if the project does not exist.

## Testing

Testing using junit and mockito



