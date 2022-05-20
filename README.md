## Spring Boot for Employee Management System
Spring MVC application to manage employees in the database.

### Project Features
User can save, delete, update, read employees for the given database by following necessary validation rules.

### Technologies
Java 11, Maven, Spring Boot, JPA, H2 database, Hibernate Validator, Thymeleaf, Project Lombok

#### H2 database
Application is executing script on-startup to create the necessary table to use further.

#### Hibernate Validator
- Validator has been configured inside validation configuration file to provide DI (dependency injection).
- Custom validation and groups have been created to manage the object for two different scenarios (add and update case).
