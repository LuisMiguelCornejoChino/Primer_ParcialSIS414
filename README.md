# API REST CRUD de Entrenadores

Proyecto de ejemplo para administrar entrenadores usando Spring Boot, Spring Data JPA y H2.

## Requisitos
- Java 17 o superior
- Maven 3.6+ (o usar Maven Wrapper si lo agregas desde tu IDE)
- IntelliJ IDEA, Eclipse o VS Code con extensiones Java

## Cómo ejecutar
1. Descomprime el ZIP.
2. Abre la carpeta `entrenadores-api` en tu IDE.
3. Espera a que Maven descargue las dependencias.
4. Ejecuta `EntrenadoresApplication.java`, o desde una terminal en la carpeta del proyecto ejecuta:
   `mvn spring-boot:run`

La API estará disponible en `http://localhost:8080`.

## Endpoints
- `GET    /api/entrenadores` — listar todos
- `GET    /api/entrenadores/{id}` — buscar por ID
- `POST   /api/entrenadores` — crear
- `PUT    /api/entrenadores/{id}` — actualizar
- `DELETE /api/entrenadores/{id}` — eliminar

## Ejemplo de POST
En Postman selecciona `POST`, URL `http://localhost:8080/api/entrenadores`, Body > raw > JSON:

```json
{
  "nombre": "Carlos Mendoza",
  "especialidad": "Futbol",
  "experiencia": 5,
  "telefono": "76543210"
}
```

## Base de datos H2
La base está configurada en memoria. Mientras la aplicación esté ejecutándose, puedes abrir:
`http://localhost:8080/h2-console`

Usa:
- JDBC URL: `jdbc:h2:mem:entrenadoresdb`
- User Name: `sa`
- Password: (vacío)

Los datos se borran al detener la aplicación.
