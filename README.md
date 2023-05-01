# ✨Outer Space API ✨

Let's have some fun by creating your own universee! With the **Outer Space API**, you can create your own Solar Systems and Planets! Sit back, and travel through your own universe from the comfort of your keyboard!

## Get Started
The environment is set up and ready to use! Simply create a database named **outerSpace** in the **pgAdmin** app, and run the <a href="#endpoints">endpoints</a> using **Postman**. 
The environment is set to the **dev** profile by default, which is set up in `applicatoin-dev.properties`, and runniing on port **9092**. 
Just watch out. Some of these endpoints require an authorized user! That's where the magic of JWT authentication comes into play.

## Technologies Used
- [Java](https://www.java.com/en/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Spring Boot](https://spring.io/)
- [Maven](https://mvnrepository.com/)
- [PostgreSQL](https://www.postgresql.org/)
- [pgAdmin](https://www.pgadmin.org/)
- [Postman](https://www.postman.com/)
- GitHub Branching
- [GitHub Stories](https://github.com/dayjyun/outer-space-api/wiki/User-Stories)
- [GitHub Project Board](https://github.com/users/dayjyun/projects/6)
- [dbdiagram.io](https://dbdiagram.io/home)

<details>
<summary>List of Dependencies Used</summary>

- [Spring Boot Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter)
- [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)
- [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
- [Spring Boot Starter Security](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security)
- [PostgreSQL Driver](https://mvnrepository.com/artifact/org.postgresql/postgresql)
- [Spring Boot Starter Data JPA ](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa/3.0.6 )
- [Spring Boot Starter Validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation)
- [JJWT :: API](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api)
- [JJWT :: Impl](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl)
- [JJWT :: Extensions :: Jackson](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson)
</details>

## Endpoints
### Solar Systems
| Request Type 	| URL                                    	      |           Functionality              |        Access        	|
| -------------	| ---------------------------------------------	| ------------------------------------ | ----------------------	|
| GET          	| /api/solar-systems          	                | Gets all Solar Systems               | Public               	|
| GET          	| /api/solar-systems/{solarSystemId}            | Gets a Solar System for Provided ID  | Public               	|
| POST         	| /api/solar-systems          	                | Creates a new Solar System           | Private              	|
| POST         	| /api/solar-systems/{solarSystemId}/planets    | Creates a planet for a Solar System  | Private              	|
| PUT          	| /api/solar-systems/{solarSystemId}            | Updates a Solar System               | Private              	|
| DELETE       	| /api/solar-systems/{solarSystemId}            | Deletes a Solar System               | Private              	|

### Planets
| Request Type 	| URL                                    	      |           Functionality              |        Access        	|
| -------------	| --------------------------------------------	| ------------------------------------ | ----------------------	|
| GET          	| /api/planets                	                | Gets all Planets                     | Public               	|
| GET          	| /api/planets/{planetId}                       | Gets a Planet for Provided ID        | Public                	|
| POST         	| /api/planets                	                | Creates a new Planet                 | Private              	|
| PUT          	| /api/planets/{planetId}                       | Updates a Planet                     | Private              	|
| DELETE       	| /api/planets/{planetId}                       | Deletes a Planet                     | Private              	|

### Astronomers
| Request Type 	| URL                                    	      |           Functionality              |        Access        	|
| -------------	| --------------------------------------------	| ------------------------------------ | ----------------------	|
| POST         	| /auth/astronomers/register   	                | Registers a new Astronomer           | Public               	|
| POST         	| /auth/astronomers/login                       | Logs in a registered Astronomer      | Public                	|

## Planning
When it comes to coding, I want to fast foward to the middle of the project where I have thousands of lines of code written out and I'm brainstorming ways to resolve a bug. But before that, it may be even more intuitive to start the planning process before diving right in. The **[User Stories](https://github.com/dayjyun/outer-space-api/wiki/User-Stories)** highlight an excellent representation of the thinking process and ideas of what the application should accomplish. The next stage in the planning process is coming up with the endpoints desired to create throughout the journey. Using the **[Project Board](https://github.com/users/dayjyun/projects/6)** provided a foundational vision of what each endpoint should accomplish as well as organization and a simple way to know my progress for each task.

Here is a [snapshot of the diagram](https://dbdiagram.io/d/644ad886dca9fb07c42b4c62) which illustrates the relationships for each mdoel.

<img width="" alt="outer space api database diagram" src="">

## Future
In a ever-expanding universe, there's also a never-ending expansion in code.
- [ ] Set custom errors to return more user-friendly errors
- [ ] Fix `@Email` issue creating a 400 error when logging in
- [ ] Include a links to gifs for corresping
- [ ] Generate a local time for Astronomer when creating a new **Planet** or **Solar System** instead of returning UTC time

## Acknowledgements
A special thanks to [Dominique Akers](https://github.com/Dommy99), [Jaime Padilla](https://github.com/Jaypad07), and [Velvet Pugh](https://github.com/vnpugh) for providing fun company sparking up a converstation every random often. And an extra special thanks to [Jeff Ou](https://github.com/pophero110) and [Maksym Zinchenko](https://github.com/maklaut007) for help with tackling issues throughout the code.
