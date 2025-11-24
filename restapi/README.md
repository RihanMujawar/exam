# REST API Project

This is a Spring Boot REST API application that manages user data with CRUD operations.

## Technologies Used

- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- MySQL Database
- Thymeleaf (for web templates)
- Maven for build management

## Project Structure

The application consists of the following main components:

1. **FristApplication.java** - Main application class that bootstraps the Spring Boot application
2. **User.java** - Entity class representing a user with fields for ID, first name, and last name
3. **UserRepository.java** - JPA repository interface for database operations on User entities
4. **UserController.java** - Controller class handling HTTP requests for user operations

## API Endpoints

### Web Pages
- `GET /` - Displays the index page for user registration
- `GET /user` - Retrieves a user by first name and displays welcome page

### User Operations
- `POST /register` - Creates a new user
- `GET /user/update` - Shows the update form for a user
- `POST /user/update` - Updates an existing user
- `POST /user/delete` - Deletes a user by ID

## Database Configuration

The application uses MySQL as its database with the following configuration:
- Database name: `frist`
- Username: `frist_user`
- Password: `frist_password`
- Table: `user3`

## Setup Instructions

1. Ensure you have Java 21 and Maven installed
2. Set up a MySQL database with the credentials specified in `application.properties`
3. Build the project:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```
5. Access the application at `http://localhost:8080`

## Dependencies

All dependencies are managed through Maven and defined in `pom.xml`:
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Thymeleaf
- MySQL Connector/J