# Career Levels
Career Level is a program for tracking the employee progress at his career journey. Every user has to complete tasks to go to the next level. The program shows all tasks and benefits for each user. User with admin role can add, edit or remove tasks, benefits and user accounts. Regular user can edit only his finished tasks.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
This project was developed using: [Eclipse IDE](https://eclipse.org/) and [MySQL RDBMS](https://www.mysql.com/).

### Installing
1. Run [Eclipse IDE](https://eclipse.org/).
2. Install Spring Tool Suite (STS) plugin for eclipse:
   1. Help -> Eclipse Marketplace...
   2. Write in search bar: Spring Tool Suite
   3. Click install button.
3. Download this repository and extract it in your workspace.
4. Import this extracted maven project:
   1. File -> Import... -> Maven -> Existing Maven Projects
   2. Browse to the location of extracted project.
   3. Click Finish.
5. Install [MySQL server (Workbench)](https://dev.mysql.com/downloads/workbench/)
6. From MySQL Workbench run `create_tables_and_insert.sql` file located in sql-scripts folder (File -> Run SQL Script...).
7. Before running application configure your application.properties file to set up your database:
   check your database name (MySQL), replace the user name and password of your database.
   For example:
      * `# Connection url for the database "internship"`
      * `spring.datasource.url = jdbc:mysql://localhost:3306/internship?useSSL=false`
      * `spring.datasource.driver-class-name=com.mysql.jdbc.Driver`

      * `# Username and password`
      * `spring.datasource.username = admin`
      * `spring.datasource.password = 1234`
7. Right click on project name: Run As -> Maven install
8. When project is ready right click on project name: Run as -> Spring Boot App
9. Open your favorite web browser and type in address bar: http://localhost:8080/
10. To login there are two accounts for your convenience:
  #### Admin account:
  * Username: admin
  * Password: admin
  
  #### Regular user account:
  * Username: user
  * Password: user

## Deployment
You can package your Spring Boot web application to jar file that runs on its own web container.
[Deploying Spring Boot Applications](https://spring.io/blog/2014/03/07/deploying-spring-boot-applications)

## Built With
[Maven](https://maven.apache.org/) - Dependency Management

## Authors
* Alexandr Jlobici
* Alexandru Rotari

## License
This project is licensed under the MIT License - see the LICENSE.txt file for details.
