# Student Data Management API

This is a Spring Boot REST API application that manages student data with CRUD operations using MongoDB as the database.

## Technologies Used

- Java 21
- Spring Boot 3.5.6
- Spring Data MongoDB
- MongoDB Database
- Lombok (for reducing boilerplate code)
- Maven for build management

## Project Structure

The application consists of the following main components:

1. **Application.java** - Main application class that bootstraps the Spring Boot application
2. **Student.java** - Entity class representing a student with fields for ID, name, and address
3. **StudentRepo.java** - MongoDB repository interface for database operations on Student entities
4. **StudentController.java** - Controller class handling HTTP requests for student operations

## API Endpoints

All endpoints are RESTful and return JSON data:

- `POST /createData` - Create a new student record
- `GET /fetchData` - Retrieve all student records
- `GET /fetchData/{id}` - Retrieve a specific student by ID
- `PUT /updateData/{id}` - Update an existing student record
- `DELETE /removeData/{id}` - Delete a student record by ID

## Database Configuration

The application connects to a MongoDB Atlas cluster with the following configuration:
- Database name: `studentdb`
- Collection name: `studentData`
- Connection URI: `mongodb+srv://hackthon:Hackthon123@hackthon.lgke1tg.mongodb.net/studentdb`

The application runs on port `8888`.

## Setup Instructions

1. Ensure you have Java 21 and Maven installed
2. No local database setup required - the application connects to a remote MongoDB Atlas cluster
3. Build the project:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```
5. Access the application at `http://localhost:8888`

## Testing APIs with Postman

To test the API endpoints using Postman, follow these steps:

### 1. Create a Student Record
- Method: POST
- URL: `http://localhost:8888/createData`
- Headers: 
  - Key: `Content-Type`, Value: `application/json`
- Body (raw JSON):
  ```json
  {
    "id": 1,
    "name": "John Doe",
    "address": "123 Main St"
  }
  ```
- Click "Send" and expect a response like: `"Data added successfully."`

### 2. Fetch All Students
- Method: GET
- URL: `http://localhost:8888/fetchData`
- Click "Send" to retrieve all student records in JSON format

### 3. Fetch a Specific Student
- Method: GET
- URL: `http://localhost:8888/fetchData/1` (replace 1 with the actual student ID)
- Click "Send" to retrieve the specific student record

### 4. Update a Student Record
- Method: PUT
- URL: `http://localhost:8888/updateData/1` (replace 1 with the actual student ID)
- Headers: 
  - Key: `Content-Type`, Value: `application/json`
- Body (raw JSON):
  ```json
  {
    "id": 1,
    "name": "Jane Smith",
    "address": "456 Oak Ave"
  }
  ```
- Click "Send" and expect a response like: `"Data updated successfully."`

### 5. Delete a Student Record
- Method: DELETE
- URL: `http://localhost:8888/removeData/1` (replace 1 with the actual student ID)
- Click "Send" and expect a response like: `"Document deleted successfully"`

## Dependencies

All dependencies are managed through Maven and defined in `pom.xml`:
- Spring Boot Starter Web
- Spring Boot Starter Data MongoDB
- Lombok
- Spring Boot DevTools