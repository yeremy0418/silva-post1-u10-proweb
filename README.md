# Gestion de Tareas

Proyecto de ejemplo con pruebas unitarias, de controlador y de repositorio para una API de tareas.

## Requisitos

- Java 17
- Maven 3.9+

## Configuracion de pruebas

Las pruebas usan H2 en memoria.

## Estructura del proyecto

Organizado por capas en `src/main` y `src/test`:

```
src/
  main/
    java/com/tareas/gestion_tareas/
      controller/
        TareaController.java
      exception/
        GlobalExceptionHandler.java
      model/
        Tarea.java
      repository/
        TareaRepository.java
      service/
        TareaService.java
      GestionTareasApplication.java
  test/
    java/com/tareas/gestion_tareas/
      controller/
        TareaControllerTest.java
      repository/
        TareaRepositoryTest.java
      service/
        TareaServiceTest.java
      GestionTareasApplicationTests.java
```

## Como ejecutar pruebas

```bash
mvn test
```

Para validar cobertura con JaCoCo:

```bash
mvn jacoco:check
```

## Clases de prueba

- `TareaServiceTest`: pruebas unitarias del servicio con Mockito (`@Mock`, `@InjectMocks`, stubbing y verify).
- `TareaControllerTest`: pruebas de controlador con `@WebMvcTest`, `MockMvc` y `@MockitoBean`.
- `TareaRepositoryTest`: pruebas de repositorio con `@DataJpaTest` y `TestEntityManager`.

## Reporte de cobertura

El reporte HTML se genera en `target/site/jacoco/index.html`.

### Captura de cobertura

Reemplaza el siguiente marcador con una imagen del reporte mostrando cobertura >= 70%.

![JaCoCo reporte](docs/jacoco-coverage.png)
