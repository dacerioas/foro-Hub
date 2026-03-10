<h1 align="center"> ForoHub</h1>

<p align="center">
  <strong>API REST de Foro Educativo con Gestión de Tópicos y Autenticación JWT</strong>
</p>

<p align="center">
  ForoHub permite a estudiantes, profesores y moderadores interactuar en un foro, crear, listar, actualizar y eliminar tópicos, todo con seguridad mediante JWT y persistencia en base de datos.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring_Boot-Framework-brightgreen?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/Spring_Data_JPA-Persistence-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge" />
  <img src="https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql" />
  <img src="https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven" />
</p>

---

# 📖 Descripción

**ForoHub** es una API REST desarrollada con **Spring Boot 3** que permite:

- Crear, consultar, actualizar y eliminar tópicos (CRUD completo).  
- Gestionar usuarios con seguridad basada en **JWT**.  
- Mantener relaciones entre entidades: `Topico`, `Autor` y `Curso`.  
- Validar datos mediante anotaciones de **Bean Validation**.  
- Manejar errores y respuestas HTTP de forma centralizada.

---

# 🎯 Objetivos del Proyecto

✔ Crear un foro educativo funcional  
✔ Implementar autenticación y autorización con JWT  
✔ Aplicar buenas prácticas REST  
✔ Persistir información con **Spring Data JPA**  
✔ Manejar errores y validaciones de negocio

---

# 🏗 Arquitectura del Proyecto

```text
forohub
│
├── controller
│   ├── AutenticacionController.java
│   └── TopicoController.java
├── domain
│   ├── usuario
│   │   ├── Usuario.java
│   │   ├── DatosAutenticacion.java
│   │   ├── AutenticacionService.java
│   │   └── UsuarioRepository.java
│   └── topico
│       ├── Topico.java
│       ├── DatosRegistroTopicos.java
│       ├── DatosListaTopicos.java
│       ├── DatosDetalleTopico.java
│       ├── TopicoRepository.java
│       └── Status.java
├── infra/security
│   ├── TokenService.java
│   ├── SecurityFilter.java
│   ├── SecurityConfigurations.java
│   └── DatosTokenJWT.java
├── repository
│   └── JpaRepositories...
└── ForoHubApplication.java

```
---

#  Base de Datos y Entidades


---

#  📘 Usuario

- Campos: id, login, contrasena
- Implementa UserDetails para integrarse con Spring Security
- Roles por defecto: ROLE_USER

  ---

#  📘 Topico

- Campos: id, activo, titulo, mensaje, fechaCreacion, status, autor, curso
- Soft delete: activo = false
- Métodos:
    - actualizarInformaciones(DatosActualizacionTopico)
    - eliminar()
- DTOs:
    - DatosRegistroTopicos → creación
    - DatosListaTopicos → listado
    - DatosDetalleTopico → detalle
 
        ---

#  👤 Autor y Curso

- Embeddables dentro de Topico para mantener datos estructurados
🔐 Autenticación con JWT
Login
- URL: /login
- Método: POST

- Headers para solicitudes protegidas:
Authorization: Bearer <token>
Seguridad implementada
- Filtro SecurityFilter valida el token antes de cada endpoint protegido
- Contraseñas cifradas con BCrypt
- Endpoints públicos: /login
- Política de sesión: STATELESS
