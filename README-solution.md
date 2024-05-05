# Repository README

## Project Title
Projeto-de-Tasks

## Project Description
Performing tasks with java and creating apis.

## Technologies Used
- Java JDK 17
- Spring Boot
- AWS
- MySQL

## Installation and Usage
1. Clone the repository to your local machine.
2. Ensure you have Java JDK 17 installed.
3. Open the project in your preferred IDE.
4. Configure the `application.properties` file with the necessary AWS S3 credentials and configure the Database.
5. Build the project using Maven.
6. Run the application.

## Informação adicionais

- **TASK4:** The endpoint available for fetching information and saving data in S3 is available at:
http://localhost:8081/process/saveToS3


- **TASK5:** The endpoint available for using CRUD is available at:
http://localhost:8081/all

### Requisições HTTP para o CRUD:

- Create Task
```
$ http POST :8081/all name="Learning Java" description=" " priority=1
```

- List Task
```
$ http GET :8081/all
```

- Update Task
```
$ http PUT :8081/all/1 nome="Learning Python" description=" " priority=2
```

- Delete Task
```
http DELETE :8081/all/1
```