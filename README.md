Claro, aquí tienes una versión más ordenada y elegante para tu `README.md`:

```markdown
# Challenge

## Descripción
Este proyecto está desarrollado con Java 8, Spring Boot, Spring Security, REST y OAuth2, utilizando una arquitectura de microservicios que consta de los siguientes componentes:

- **Microservicio Servidor de Registro**
- **Microservicio Gateway**
- **Microservicio Servidor de Autenticación OAUTH2 y JWT**
- **Microservicio Usuarios**
- **Librería de Usuarios** (contiene el modelo y las entidades, inyectada en `springboot-servicio-usuarios-server` y descargada como dependencia a través de Maven)

## Requisitos
Para levantar los servicios, asegúrate de tener instalados los siguientes:

- Open JDK (Java 11 u 8)
- Maven
- Curl o Postman

## Instrucciones para Levantar los Servicios
Se recomienda levantar el proyecto a través de Eclipse o IntelliJ en el siguiente orden:

1. **Generar JAR de la librería commons de Model de Usuarios**
   ```bash
   cd ./springboot-servicio-usuarios-commons
   mvn clean install
   ```

2. **Iniciar Microservicio Register**
   ```bash
   cd ./springboot-servicio-register-server
   mvn clean install
   mvn spring-boot:run
   ```

3. **Iniciar Microservicio OAuth**
   ```bash
   cd ./springboot-servicio-oauth-server
   mvn clean install
   mvn spring-boot:run
   ```

4. **Iniciar Microservicio Usuarios**
   ```bash
   cd ./springboot-servicio-usuarios-server
   mvn clean install
   mvn spring-boot:run
   ```

5. **Iniciar Microservicio Gateway**
   ```bash
   cd ./springboot-servicio-proxi-server
   mvn clean install
   mvn spring-boot:run
   ```

## Uso de Postman
Para probar la API, se recomienda usar Postman. La colección de Postman está disponible en el mismo repositorio. A continuación, se presentan algunos ejemplos utilizando CURL.

### Ejemplos de CURL

1. **Obtener todos los usuarios** (No requiere token)
   ```bash
   curl --location 'localhost:8090/api/usuarios/usuarios/'
   ```

2. **Crear nuevo usuario** (Requiere token)
   ```bash
   curl --location 'http://localhost:8090/api/usuarios/usuarios/' \
   --header 'Content-Type: application/json' \
   --header 'Authorization: Bearer <TOKEN>' \
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
           { "id": 1, "number": 56505213, "citycode": 9, "countryCode": 56 },
           { "id": 2, "number": 56505213, "citycode": 9, "countryCode": 56 }
       ],
       "roles": [
           { "id": 1, "nombre": "ROLE_USER" },
           { "id": 2, "nombre": "ROLE_ADMIN" }
       ]
   }'
   ```

3. **Actualizar un usuario** (Requiere token)
   ```bash
   curl --location --request PUT 'http://localhost:8090/api/usuarios/usuarios/1' \
   --header 'Content-Type: application/json' \
   --header 'Authorization: Bearer <TOKEN>' \
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
           { "id": 1, "number": 56505213, "citycode": 9, "countryCode": 56 },
           { "id": 2, "number": 56505213, "citycode": 9, "countryCode": 56 }
       ],
       "roles": [
           { "id": 1, "nombre": "ROLE_USER" },
           { "id": 2, "nombre": "ROLE_ADMIN" }
       ]
   }'
   ```

4. **Buscar usuario por ID** (Requiere token)
   ```bash
   curl --location --request GET 'localhost:8090/api/usuarios/usuarios/1' \
   --data-urlencode 'user=frontendapp' \
   --data-urlencode 'password=12345' \
   --data-urlencode 'grand_type=password'
   ```

5. **Obtener token** (Autenticación básica de usuario)
   ```bash
   curl --location 'localhost:8090/api/security/oauth/token' \
   --header 'Content-Type: application/x-www-form-urlencoded' \
   --header 'Authorization: ••••••' \
   --data-urlencode 'username=andres' \
   --data-urlencode 'password=12345' \
   --data-urlencode 'grant_type=password'
   ```

---

Asegúrate de reemplazar `<TOKEN>` con el token adecuado para las solicitudes que lo requieran.
```

Este formato es más claro y organizado, facilitando la comprensión y el uso del README.
