# challenge
Challenge 

Desarrollo con Java 8, Spring Boot, Spring Security, REST, OAuth2 y bajo una arquitectura de microservicios compuesta de 4 microservicios: Microservicio Servidor de registro, Microservicio  Gateway, Microservicio servidor de Autenticación OAUTH2 y JWT, Microservicio Usuarios y ádemas una lib de usuarios con el modelo y la entidades , esta lib se inyecta en la api springboot-servicio-usuarios-server y se descarga como una dependencia a con maven.

Requisitos para Levantar los servicios:
Open JDK JAVA 11 u 8
Maven
Curl o Postman

Levantar de preferencia a traves de Eclipse o IntelliJ el proyecto en el siguiente Orden:
1. Generar JAR de libreria commons de Model de Usuarios:
Dirigirse al directorio del microservicio desde una consola y ejecutar las siguientes líneas de comandos:

cd ./springboot-servicio-usuarios-commons
mvn clean install

2. Iniciar microservicio register:
Dirigirse al directorio del microservicio servidor eureka desde una consola y ejecutar las siguientes líneas de comandos:

cd ./springboot-servicio-register-server
mvn clean install
mvn spring-boot:run
3. Iniciar microservicio OAuth:
Dirigirse al directorio del microservicio oauth desde una consola y ejecutar las siguientes líneas de comandos:

cd ./springboot-servicio-oauth-server
mvn clean install
mvn spring-boot:run
4. Iniciar microservicio Usuarios:
Dirigirse al directorio del microservicio usuarios desde una consola y ejecutar las siguientes líneas de comandos:

cd ./springboot-servicio-usuarios-server
mvn clean install
mvn spring-boot:run
5. Iniciar microservicio Gateway:
Dirigirse al directorio del gateway microservicio gateway desde una consola y ejecutar las siguientes líneas de comandos:

cd ./springboot-servicio-proxi-server
mvn clean install
mvn spring-boot:run

Para probar la api usar de prefenrencia postman donde se podrá encontrar en el mismo repositorio.

