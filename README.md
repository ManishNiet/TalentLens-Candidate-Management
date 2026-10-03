
# TalentLens - Candidate Management System

TalentLens is a web-based Candidate Management System built using Spring Boot, MySQL, HTML, CSS, and JavaScript. It helps manage candidate records and provides search, filtering, pagination, and dashboard statistics.

## Features

- Add, view, update, and delete candidates
- Search candidates by name or skills
- Filter candidates by minimum experience
- Advanced search using skills and experience
- Pagination and sorting
- Dashboard with candidate statistics
- Input validation and global exception handling
- Responsive web interface

## Tech Stack

- **Backend:** Java 17, Spring Boot
- **Database:** MySQL
- **Data Access:** Spring Data JPA, Hibernate
- **Frontend:** HTML, CSS, JavaScript
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA

## Project Structure

```text
src/
 └── main/
     ├── java/com/talentlens/
     │   ├── Candidate.java
     │   ├── CandidateRepository.java
     │   ├── CandidateService.java
     │   ├── CandidateController.java
     │   └── GlobalExceptionHandler.java
     └── resources/
         ├── static/
         │   └── index.html
         └── application.properties
```

## Getting Started

### Prerequisites

- Java 17 or later
- Maven
- MySQL

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/ManishNiet/TalentLens-Candidate-Management.git
   ```

2. Open the project in IntelliJ IDEA.

3. Create the MySQL database:

   ```sql
   CREATE DATABASE talentlens_db;
   ```

4. Configure your database username and connection settings in `application.properties`.

5. Set your MySQL password as the `DB_PASSWORD` environment variable. Do not store your actual password in the repository.

6. Run the Spring Boot application from IntelliJ IDEA.

7. Open the application in your browser:

   http://localhost:8080

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/candidates` | Add a candidate |
| GET | `/api/candidates` | Get candidates with pagination |
| GET | `/api/candidates/{id}` | Get candidate by ID |
| PUT | `/api/candidates/{id}` | Update candidate |
| DELETE | `/api/candidates/{id}` | Delete candidate |
| GET | `/api/candidates/search?keyword=` | Search candidates |
| GET | `/api/candidates/filter?minExperience=` | Filter by experience |
| GET | `/api/candidates/search/advanced?skills=&minExperience=` | Advanced search |

## Dashboard

The dashboard provides candidate statistics, including:

- Total candidates
- Experienced candidates
- Unique skills

## Future Enhancements

- User authentication and role-based access
- Job and recruiter management
- Resume upload and parsing

## Author

**Manish Gaur**

GitHub: [ManishNiet](https://github.com/ManishNiet)
