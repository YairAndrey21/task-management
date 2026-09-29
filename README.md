# Sistema de Gestión de Tareas 📝

Una aplicación de escritorio ágil e intuitiva para el control y seguimiento de tareas. Desarrollada en **Java**, este proyecto integra un backend robusto utilizando **Spring Boot** y **MySQL** con una interfaz gráfica moderna diseñada en **JavaFX**.

## 🚀 Tecnologías Utilizadas

*   **Lenguaje:** Java 17
*   **Backend:** Spring Boot (Spring Data JPA)
*   **Interfaz Gráfica (GUI):** JavaFX (FXML)
*   **Base de Datos:** MySQL
*   **Gestor de Dependencias:** Maven
*   **Herramientas Extra:** Lombok

## ✨ Características Principales

*   **Listado en tiempo real:** Visualización de todas las tareas en una tabla (TableView) interactiva.
*   **Registro de Tareas:** Permite agregar nuevas actividades definiendo el nombre de la tarea, la persona a cargo y su estado.
*   **Actualización:** Selección y modificación rápida de tareas existentes.
*   **Validación de Datos:** Prevención de duplicados y campos vacíos al gestionar la información.

## 🛠️ Requisitos e Instalación

### Requisitos previos
1. **Java JDK 17** o superior instalado.
2. Un servidor de **MySQL** en ejecución.

### Configuración de la Base de Datos
1. Crea una base de datos en MySQL (por ejemplo, `tareas_db`).
2. Ve al archivo `src/main/resources/application.properties` y actualiza tus credenciales:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/TU_BASE_DE_DATOS
   spring.datasource.username=TU_USUARIO
   spring.datasource.password=TU_CONTRASEÑA
   ```
   *(Nota: Spring Data JPA creará la tabla automáticamente gracias a la entidad `Task` si tienes configurado el ddl-auto)*.

### Ejecución del Proyecto
Puedes ejecutar la aplicación directamente desde **IntelliJ IDEA** corriendo la clase principal `TareasApplication.java`, o desde la terminal usando Maven:

```bash
# En Windows:
mvnw.cmd spring-boot:run

# En Linux/Mac:
./mvnw spring-boot:run
```
