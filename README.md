# Celebra - Backend API

Servicio backend para la plataforma de organización de eventos **Celebra**. Desarrollado con Java y Spring Boot, gestiona la autenticación JWT con soporte para múltiples roles (Anfitriones y Proveedores), gestión de eventos, contratos y pasarelas de pago.

## Tecnologías Utilizadas

* **Lenguaje:** Java 17+ (compatible con Java 21 / 24)
* **Framework:** Spring Boot 3
* **Gestor de Dependencias:** Apache Maven (incluye Maven Wrapper)
* **Base de Datos:** PostgreSQL
* **ORM:** Spring Data JPA / Hibernate
* **Seguridad:** Spring Security con JSON Web Tokens (JWT)
* **Comunicación en Tiempo Real:** Spring WebSocket / STOMP

## Requisitos Previos

* **JDK:** Java 17 o superior instalado y configurado en el PATH.
* **Motor de Base de Datos:** PostgreSQL 14+ ejecutándose localmente en el puerto 5432.
* **Herramienta opcional:** pgAdmin 4 o terminal psql.

## Guía de Instalación y Ejecución Local

### Paso 1. Crear la Base de Datos en PostgreSQL

Debes crear una base de datos vacía llamada exactamente `db_celebra`. Las tablas e índices se generarán de manera automática al arrancar la aplicación gracias a Hibernate.
Puedes crearla desde pgAdmin o desde tu consola interactiva de PostgreSQL:
```sql
CREATE DATABASE db_celebra;
```
Paso 2. Configurar Credenciales en application.properties
Abre el archivo de configuración ubicado en:
`src/main/resources/application.properties`
Verifica que el usuario y la contraseña coincidan con los de tu instalación local de PostgreSQL. Si difieren de los valores por defecto (`postgres` / `admin`), ajústalos:

```properties
spring.application.name=CelebraProyect
spring.datasource.url=jdbc:postgresql://localhost:5432/db_celebra
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
#No envia el trace al usuario cuando hay error.
server.error.include-stacktrace=never

ip.frontend=http://localhost:4200

jwt.secret=0C/ZZj9OCW7Q74lUM200BayaFq6u12EKyps4NLFQNufowubX5nE1DQT8XRdwv0zUBp7Tns1yhYlwzUCm3maQkg==
```

> **Nota:** Si `ddl-auto` está configurado en `create-drop`, las tablas se reconstruirán cada vez que reinicies el servidor. Para conservar los datos entre reinicios, asegúrate de mantenerlo en `update`.

---

### Paso 3. Compilar y Levantar el Servidor

**Opción A: Desde tu IDE (Recomendada y más rápida)**
1. Abre el proyecto en tu IDE preferido (**IntelliJ IDEA**, **VS Code** o **Eclipse**).
2. Localiza la clase principal en `src/main/java/.../AjedrezBackendApplication.java`.
3. Haz clic en el botón verde de **Run (Iniciar / ▶)**.

**Opción B: Desde la Terminal (Mediante Maven Wrapper)**
En la raíz del proyecto ejecuta:
* **Windows (PowerShell / CMD):**
  ```powershell
  .\mvnw.cmd spring-boot:run
  ```
* **Linux / macOS:**
  ```bash
  ./mvnw spring-boot:run
  ```
---

## Endpoints Principales

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| **POST** | `/api/authenticate` | Inicia sesión y genera token JWT para Anfitriones o Proveedores |
| **POST** | `/api/anfitrion` | Registra un nuevo perfil de Anfitrión |
| **POST** | `/api/jugadores` | Registra un nuevo perfil de Proveedor |
| **GET** | `/api/especializaciones` | Lista las especializaciones disponibles |
| **GET** | `/api/ciudades` | Lista las ciudades registradas |
| **GET** | `/api/distritos` | Lista los distritos registrados |
