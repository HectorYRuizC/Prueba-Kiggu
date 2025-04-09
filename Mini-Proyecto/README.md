Mini Proyecto Full Stack 

Este es un proyecto simple de aplicación web full stack para gestionar tareas de un equipo de trabajo. Está compuesto por un backend en Spring Boot y un frontend en HTML, CSS y JavaScript.

Tecnologias usadas

- **Backend:** Java + Spring Boot + Maven
- **Frontend:** HTML + CSS + JavaScript
- **Base de datos:** MySQL
- **Dependencias:** Spring Web, Spring Data JPA, MySQL Driver




Requisitos

- Java 21
- Maven
- MySQL



Back-end

Verifica que el archivo `application.properties` tenga la siguiente configuración:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username= tu usuario
spring.datasource.password= tu contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
