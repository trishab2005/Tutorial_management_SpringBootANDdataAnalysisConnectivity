
# Tutorial Management System | Spring Boot & Data Analysis 📊

A Java Spring Boot application for managing tutorial data through RESTful APIs, with a focus on database connectivity, data analysis, and visualization. The project combines backend development with the ability to extract meaningful insights from structured data.

## 📌 About the Project

The Tutorial Management System is built using Spring Boot and Spring Data JPA to perform CRUD (Create, Read, Update, Delete) operations on tutorial records.

Beyond basic data management, the project explores how application data can be used for analysis and visualization. Tutorial records can serve as a dataset for understanding publication trends, identifying patterns, and presenting information through charts and graphical representations.

The project brings together backend development, database management, and data-oriented problem-solving in one application.

## ✨ Features

### 🔹 Tutorial Management
- Create and store tutorial records.
- Retrieve all tutorials or a specific tutorial by ID.
- Update existing tutorial information.
- Delete tutorial records.
- Search tutorials by title.
- Filter tutorials by publication status.

### 🔹 Database Connectivity
- Integration with a relational database through Spring Data JPA.
- Entity-based data persistence using Hibernate.
- Repository methods for database queries.
- Custom query methods for filtering tutorial records.
- DTO-based data transfer between application layers.

### 🔹 Data Analysis & Visualization
The tutorial dataset can be used to explore analytical features such as:

- Analysing the total number of tutorials.
- Comparing published and unpublished tutorials.
- Identifying publication-status distributions.
- Exploring tutorial title and record patterns.
- Summarising database records for reporting.
- Presenting analytical results through charts and visualizations.

These analytical features can be implemented using Python libraries such as Pandas, Matplotlib, and Seaborn, or another compatible visualization tool connected to the database or an exported dataset.

## 🛠️ Technologies Used

### Backend Development
- **Java** — Core programming language
- **Spring Boot** — Backend application framework
- **Spring Web** — REST API development
- **Spring Data JPA** — Database access and persistence
- **Hibernate** — Object-relational mapping
- **ModelMapper** — DTO and entity conversion
- **Lombok** — Boilerplate code reduction

### Database
- **MySQL** — Relational database, if configured
- **SQL** — Data retrieval and querying

### Data Analysis & Visualization
- **Python** — Data analysis programming language, if used
- **Pandas** — Data manipulation and analysis, if used
- **Matplotlib / Seaborn** — Data visualization, if used
- **Jupyter Notebook** — Exploratory analysis, if used

### Development Tools
- **Maven** — Dependency management
- **IntelliJ IDEA / VS Code** — Development environment
- **Postman** — REST API testing
- **Git & GitHub** — Version control

## 🏗️ Application Architecture

The project follows a layered architecture that separates API handling, business logic, data access, and data representation.

```text
Client / Postman
       |
       v
TutorialController
       |
       v
TutorialService
       |
       v
TutorialServiceImpl
       |
       v
TutorialRepository
       |
       v
Relational Database
       |
       v
Data Extraction
       |
       v
Data Analysis & Visualization
```

The analysis and visualization layer represents an extension of the database workflow. Its exact implementation depends on the analysis tools and connectivity configured in the project.

## 📂 Project Structure

```text
src/
└── main/
    ├── java/
    │   └── com/example/
    │       ├── controller/
    │       │   └── TutorialController.java
    │       ├── dto/
    │       │   └── TutorialDto.java
    │       ├── entity/
    │       │   └── Tutorial.java
    │       ├── repository/
    │       │   └── TutorialRepository.java
    │       ├── service/
    │       │   ├── TutorialService.java
    │       │   └── impl/
    │       │       └── TutorialServiceImpl.java
    │       └── TutorialApplication.java
    └── resources/
        └── application.properties
```

Additional Python scripts, notebooks, dashboards, or visualization files can be documented here if they are part of the repository.

## 🗃️ Tutorial Data Model

Each tutorial contains the following fields:

| Field | Data Type | Description |
|---|---|---|
| `id` | Long | Unique tutorial identifier |
| `title` | String | Title of the tutorial |
| `description` | String | Description of the tutorial |
| `published` | Boolean | Indicates whether the tutorial is published |

This structured dataset can be queried and transformed into summaries suitable for further analysis.

## 📊 Data Analysis Ideas

The tutorial dataset can be analysed to answer questions such as:

| Analysis | Purpose |
|---|---|
| Total tutorial count | Measure the number of stored records |
| Publication status distribution | Compare published and unpublished tutorials |
| Title-based search | Identify tutorials matching a particular title |
| Record summaries | Generate simple reports from stored data |
| Data visualization | Present counts and distributions graphically |

Possible visualizations include:
- Bar chart showing published versus unpublished tutorials.
- Pie chart representing publication-status distribution.
- Summary cards displaying total, published, and unpublished tutorials.

These charts should be included as completed project features only when the corresponding analysis and visualization code is available.

## ⚙️ Getting Started

### Prerequisites

Install the tools required for the components you use:

- Java JDK
- Maven
- MySQL, if using MySQL as the database
- Python, if using a Python-based analysis workflow
- Postman or another REST API client

### 1. Clone the Repository

```bash
git clone https://github.com/trishab2005/Tutorial_management_SpringBootANDdataAnalysisConnectivity.git
```

Navigate to the project directory:

```bash
cd Tutorial_management_SpringBootANDdataAnalysisConnectivity
```

### 2. Configure the Database

Create a database if your application uses MySQL:

```sql
CREATE DATABASE tutorial_db;
```

Update `src/main/resources/application.properties` with your database credentials.

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tutorial_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Replace the sample credentials with your own. Ensure the required Spring Data JPA and database-driver dependencies are configured in `pom.xml`.

### 3. Run the Spring Boot Application

Using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

Alternatively, if Maven is installed:

```bash
mvn spring-boot:run
```

The API will typically be available at:

```text
http://localhost:8080/api
```

Use the port configured in your application if it differs from `8080`.

## 🔗 REST API Endpoints

Base URL: `http://localhost:8080/api`

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/api` | Retrieve all tutorials |
| POST | `/api` | Create a tutorial |
| GET | `/api/{id}` | Retrieve a tutorial by ID |
| PUT | `/api/{id}` | Update a tutorial |
| DELETE | `/api/{id}` | Delete a tutorial |
| GET | `/api/search?title=Java` | Search by exact title |
| GET | `/api/published?published=true` | Retrieve tutorials by publication status |

The publication-status endpoint assumes that `getTutorialsByPublished(Boolean published)` has been implemented in the service interface and implementation.

## 🧪 API Examples

### Create a Tutorial

**Request**

```http
POST /api
Content-Type: application/json
```

**Request Body**

```json
{
  "title": "Java Spring Boot",
  "description": "Introduction to REST APIs with Spring Boot",
  "published": true
}
```

### Retrieve All Tutorials

```http
GET /api
```

### Retrieve a Tutorial by ID

```http
GET /api/1
```

### Update a Tutorial

```http
PUT /api/1
Content-Type: application/json
```

```json
{
  "title": "Advanced Spring Boot",
  "description": "Learning Spring Boot and Spring Data JPA",
  "published": true
}
```

### Delete a Tutorial

```http
DELETE /api/1
```

### Search by Title

```http
GET /api/search?title=Java
```

The current `findByTitle` repository method performs an exact match. Partial, case-insensitive searches require a method such as `findByTitleContainingIgnoreCase`.

### Filter by Publication Status

Published tutorials:

```http
GET /api/published?published=true
```

Unpublished tutorials:

```http
GET /api/published?published=false
```

## 🔄 Data Analysis Workflow

A possible workflow for extending the application with data analysis is:

1. **Collect:** Retrieve tutorial records from the database or REST API.
2. **Prepare:** Clean and transform the extracted records.
3. **Analyse:** Calculate record counts and publication-status summaries.
4. **Visualize:** Display the results through suitable charts.
5. **Interpret:** Use the results to understand the dataset and communicate findings.

The analysis may be performed using Python, SQL, or another suitable tool, depending on the project's implementation.

## 🎯 Learning Outcomes

This project provides practical experience with:

- Building RESTful APIs using Spring Boot.
- Implementing CRUD operations.
- Using DTOs and ModelMapper.
- Connecting an application to a relational database.
- Working with Spring Data JPA and Hibernate.
- Writing derived query methods.
- Retrieving structured data for analysis.
- Understanding exploratory data analysis and visualization workflows.
- Combining backend development with data-oriented problem-solving.

## 🚀 Future Enhancements

Potential improvements include:

- Adding a dedicated analytics dashboard.
- Connecting a Python analysis module to the database or REST API.
- Displaying interactive charts for tutorial statistics.
- Adding pagination and sorting.
- Implementing request validation and global exception handling.
- Exporting records to CSV for external analysis.
- Adding automated tests for API endpoints.

## 📸 Screenshots
<img width="1440" height="900" alt="Screenshot 2026-10-11 at 8 04 53 PM" src="https://github.com/user-attachments/assets/8f556fe9-08b4-42fd-80cb-5f79df8c580d" />
<img width="1440" height="900" alt="Screenshot 2026-10-11 at 8 04 58 PM" src="https://github.com/user-attachments/assets/06823abe-1252-4538-86d5-0c946c383a52" />
<img width="1440" height="900" alt="Screenshot 2026-10-11 at 8 06 49 PM" src="https://github.com/user-attachments/assets/a889e647-63da-4081-9a20-1df79a348ac0" />
<img width="1440" height="900" alt="Screenshot 2026-10-11 at 8 07 00 PM" src="https://github.com/user-attachments/assets/e6af24ff-7f70-45ed-80ff-f48e2d73d456" />
<img width="1440" height="900" alt="Screenshot 2026-10-11 at 8 09 50 PM" src="https://github.com/user-attachments/assets/6f726915-9808-4a04-a63a-d7d3dbb57594" />
<img width="1440" height="900" alt="Screenshot 2026-10-11 at 8 09 57 PM" src="https://github.com/user-attachments/assets/844335e1-62af-48fc-8062-faa120b9a998" />


## 🎯 Learning Outcomes

Through this project, you can practise:

- Building RESTful APIs with Spring Boot
- Implementing CRUD operations
- Understanding dependency injection
- Working with Spring Data JPA repositories
- Writing derived query methods
- Using DTOs and ModelMapper
- Connecting a Java application to a relational database
- Testing REST endpoints with Postman

## 👩‍💻 Author

**Trisha Basak**

GitHub: [@trishab2005](https://github.com/trishab2005)


