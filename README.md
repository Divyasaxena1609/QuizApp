This project is a Quiz Generator application built using Spring Boot. It allows users to start a quiz session, receive random multiple-choice questions from a database, submit answers, and view statistics on the number of questions answered, including correct and incorrect answers.

Features
Start a Quiz Session: Users can start a new quiz session.
Get Random Multiple-Choice Questions: Random multiple-choice questions are fetched from a set of questions stored in the database.
Submit an Answer: Users can submit their answers to the questions.
View Quiz Stats: After completing the quiz, users can view statistics, including the total number of questions answered, correct answers, and incorrect answers.
Technologies Used
Backend: Spring Boot
Database: MySQL
Java: Java 11+
Build Tool: Maven
API Documentation: Swagger (for REST API testing)
Prerequisites
To run the project locally, make sure you have the following installed:

Java 11 or higher
MySQL: A MySQL server should be set up and running.
Maven: To manage dependencies and build the project.
Postman/Swagger: For testing the REST API.
Setup
1. Clone the repository
Clone the repository to your local machine using the following command:

git clone https://github.com/yourusername/quiz-generator.git
cd quiz-generator
2. Database Setup
Create a MySQL database:

CREATE DATABASE quiz_generator;
Set up the database credentials in the src/main/resources/application.properties file:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/quiz_generator
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

3. Build the project
Run the following Maven command to build the project:
mvn clean install

5. Run the Application
Start the Spring Boot application:

mvn spring-boot:run
The application will run on http://localhost:8080.

5. API Endpoints
You can use Swagger or Postman to test the REST API.

Base URL: http://localhost:8080/api
Endpoints:
Start a New Quiz Session
POST /api/quiz/start

Starts a new quiz session for the user. This will initialize a new session for the user, and they can begin answering questions.
Get Random Multiple-Choice Question
GET /api/quiz/question

Retrieves a random multiple-choice question from the database for the user to answer.
Submit an Answer
POST /api/quiz/answer

Submits the user's answer for the current question. The request body should include the answer selected by the user.
Get Quiz Stats
GET /api/quiz/stats

Fetches the quiz statistics, including the number of questions answered, the number of correct answers, and the number of incorrect answers.

File Structure
The project is structured as follows:
quiz-generator/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/quiz/generator/
│   │   │       ├── Controller/
│   │   │       ├── Service/
│   │   │       ├── Model/
│   │   │       └── Repository/
│   │   ├── resources/
│   │   │   └── application.properties
├── pom.xml
└── README.md
Controller: Contains the REST API endpoints.
Service: Contains the business logic of the application.
Model: Contains the entity classes for database interactions.
Repository: Contains the interfaces for data access.

Acknowledgements
Spring Boot for the framework.
MySQL for the database.


