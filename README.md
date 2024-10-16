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

# Postman

Para probar la api usar de prefenrencia postman , use postman collection podrá encontrarlo en el mismo repositorio. Aquí un ejemplo para probar con CURL.

1.Obtener todos los usuarios(No requiere tóken)
  curl --location 'localhost:8090/api/usuarios/usuarios/' \
--data ''

3. Crear nuevo usuario (Requiere Tóken)
  curl --location 'http://localhost:8090/api/usuarios/usuarios/' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhbmRyZXMiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiYXBlbGxpZG8iOiJBZWRvIiwiY29ycmVvIjoiY2FlZG9AbWFpbC5jb20iLCJleHAiOjE3MjkwOTM5MzcsIm5vbWJyZSI6IkNyaXN0b2JhbCIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiXSwianRpIjoiOGZhNTI1MjgtY2NiYy00NjIyLWIwZTUtZTVjYWM1YjI3OWFmIiwiY2xpZW50X2lkIjoiZnJvbnRlbmRhcHAifQ.Dq0SZ6jvUeW3YWlyb2G90OL3IZRIwYz0zXF7Kl3LHAA' \
--data-raw '{
    "fechaCreacion": null,
    "fechaActualizacion": null,
    "username": "valentina",
    "password": "valentina123",
    "enabled": true,
    "nombre": "Valentina Paz",
    "apellido": "vale",
    "email": "valepaz@mail.com",
    "phones": [
        { 
            "id": 1,
            "number": 56505213,
            "citycode": 9,
            "countryCode": 56
        },
        {
              "id": 2,
            "number": 56505213,
            "citycode": 9,
            "countryCode": 56
        }
    ],
    "roles": [
        {
            "id": 1,
            "nombre": "ROLE_USER"
        },
         {
            "id": 2,
            "nombre": "ROLE_ADMIN"
        }
    ]

}'

3. Actualizar un usuario (Requiere Tóken)
  curl --location --request PUT 'http://localhost:8090/api/usuarios/usuarios/1' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhbmRyZXMiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiYXBlbGxpZG8iOiJBZWRvIiwiY29ycmVvIjoiY2FlZG9AbWFpbC5jb20iLCJleHAiOjE3Mjg5NTM2MDgsIm5vbWJyZSI6IkNyaXN0b2JhbCIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiXSwianRpIjoiMDNhMmU5YmEtZThiZi00MDAxLWE5MzUtODM5MjY0OWMzZWE3IiwiY2xpZW50X2lkIjoiZnJvbnRlbmRhcHAifQ.FFhIyKhAlI-IicxG62QCa2cyzdcbHXi09R8NH94e4mQ' \
--data-raw '{
    "fechaCreacion": "2024-04-29T04:43:09.739+00:00",
    "fechaActualizacion": null,
    "username": "subAdmin",
    "password": "$2a$10$NZp9GgbTPYFft6oPjZyLXOeIoGb.0WJGdqOSwqNjLzI2pfLXMJYsm",
    "enabled": true,
    "nombre": "Gustavo",
    "apellido": "Aedo",
    "email": "subAdmin@admin.com",
    "phones": [
        { 
            "id": 1,
            "number": 56505213,
            "citycode": 9,
            "countryCode": 56
        },
        {
              "id": 2,
            "number": 56505213,
            "citycode": 9,
            "countryCode": 56
        }
    ],
    "roles": [
        {
            "id": 1,
            "nombre": "ROLE_USER"
        },
         {
            "id": 2,
            "nombre": "ROLE_ADMIN"
        }
    ]

}'

4. Buscar usuario por ID (Requiere Tóken)
  curl --location --request GET 'localhost:8090/api/usuarios/usuarios/1' \
--data-urlencode 'user=frontendapp' \
--data-urlencode 'password=12345' \
--data-urlencode 'grand_type=password'


5. Get Tóken (Autenticación Básica de usuario)
  curl --location 'localhost:8090/api/security/oauth/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Authorization: ••••••' \
--data-urlencode 'username=andres' \
--data-urlencode 'password=12345' \
--data-urlencode 'grant_type=password'




