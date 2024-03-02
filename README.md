# FindestCRUDwebApp

### Technical Choices and Challenges

For this project, I am currently working on a Java Spring Boot application as part of an ongoing project. Therefore, I decided to use this technology not only to improve my skills but also to develop the assessment for Findest. The project is initiated with Spring Initializr (https://start.spring.io/) utilizing Maven as the build tool and Java as the programming language.

For the database, I opted for a PostgreSQL database, which is initialized through Docker Compose. Docker Compose is used to facilitate the local launch of the application and the management of the database, ensuring a smooth setup and execution environment.

### How to Run

To run the application, please follow these steps:

1. Download the `findest_env` file.
2. Open a terminal and navigate to the file directory: `cd ~/findest_env`.
3. Initialize Docker Compose with the command: `docker-compose up -d`.
4. Launch the Maven application: `mvn spring-boot:run`.
5. You can view the application at: http://127.0.0.1:8080/.
6. Additionally, you can manage the database at: http://127.0.0.1:5051/.

    - **Login:** pguser@admin.com
    - **Password:** pgpwd

This setup ensures that you can easily start the application and manage the database without the need for extensive configuration.
