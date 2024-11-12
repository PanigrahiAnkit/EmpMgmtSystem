# Employee Management System 📊

A full-featured **Employee Management System** built using **Spring Boot**. This application provides a RESTful API to manage employees, allowing users to perform CRUD operations, view employee details, and explore various endpoints for better data management. It uses an in-memory **H2 database** for data storage and includes features like **Spring Data JPA**, **Hibernate**, and **Spring Actuator**.

## 🌟 Features

- **Add, View, Update, and Delete Employees**: Easily manage employee data.
- **RESTful API Endpoints**: Access employee data via secure and well-structured REST APIs.
- **In-Memory H2 Database**: Quick setup with an in-memory database, ideal for development and testing.
- **Spring Data JPA Integration**: Simplifies database access with powerful query capabilities.
- **H2 Console Access**: Explore the database using the integrated H2 console.
- **Spring Actuator**: Monitor application health and metrics.
- **Validation**: Ensures data integrity with input validation for employee details.

## 🛠️ Tech Stack

- **Backend**: Java 21, Spring Boot, Spring Data JPA, Hibernate
- **Database**: H2 Database (in-memory)
- **Build Tool**: Maven
- **API Testing**: Postman or any REST client
- **Version Control**: Git

## ⚙️ Installation & Setup

### Prerequisites
- Java 21+
- Maven 3.8+
- Git

### Clone the Repository

```bash
git clone https://github.com/your-username/employee-management-system.git
cd employee-management-system
```

### ⚒️ Build the Application

```bash
mvn clean install
```

### 🚀 Run the Application

```bash
mvn spring-boot:run
```

## 🌐 Access the Application

* **API Base URL**: [http://localhost:8080](http://localhost:8080)
* **H2 Console**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  * **JDBC URL**: `jdbc:h2:mem:employee_db`
  * **Username**: `sa`
  * **Password**: `password`
* **Actuator Health Endpoint**: [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)

## 🚀 API Endpoints

| HTTP Method | Endpoint               | Description                          |
|-------------|------------------------|--------------------------------------|
| GET         | `/api/employees`        | Get all employees                    |
| GET         | `/api/employees/{id}`   | Get employee by ID                   |
| POST        | `/api/employees`        | Add a new employee                   |
| PUT         | `/api/employees/{id}`   | Update an existing employee          |
| DELETE      | `/api/employees/{id}`   | Delete an employee by ID             |

### Example JSON Payload for Creating/Updating an Employee

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "position": "Software Engineer",
  "hireDate": "2024-01-01"
}
```

## 📊 Database Schema (H2)

* **Table**: `employees`
    * `id` (Primary Key)
    * `first_name`
    * `last_name`
    * `email` (Unique)
    * `position`
    * `hire_date`

## 💡 Future Enhancements

* Implement **Spring Security** for authentication and role-based authorization.
* Integrate with a **MySQL/PostgreSQL** database for persistent data storage.
* Add **Swagger** for API documentation.
* Implement **Docker** for containerized deployment.
* Create a **frontend** using React/Angular for a complete full-stack application.

## 🖥️ H2 Database Console

To access the H2 database console, navigate to: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

### H2 Console Configuration

* **JDBC URL**: `jdbc:h2:mem:employee_db`
* **Username**: `sa`
* **Password**: `password`

## 🩺 Actuator Endpoints

This project uses **Spring Boot Actuator** for monitoring and management.

* **Health Check**: [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)
* **Info**: [http://localhost:8080/actuator/info](http://localhost:8080/actuator/info)

## 🤝 Contributing

Contributions are welcome! If you find a bug or have a feature request, please open an issue. Feel free to fork this repository, make changes, and submit a pull request.

1. **Fork the repository**
2. **Create a new branch** (`git checkout -b feature-branch`)
3. **Commit your changes** (`git commit -m 'Add some feature'`)
4. **Push to the branch** (`git push origin feature-branch`)
5. **Open a Pull Request**

## 📄 License

This project is licensed under the MIT License. See the LICENSE file for more details.

## ✨ Acknowledgements

* Thanks to the **Spring Boot** team for their excellent documentation and support.
* Inspired by various open-source projects in the Spring ecosystem.

<p align="center">Made with ❤️ by <a href="https://github.com/your-username">Ankit Panigrahi</a></p>


