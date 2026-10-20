# Trabajo 3 - CES2

**Estudiante:** Melanny Moreno Tabares
**Docente:** Juan Carlos Gil Vera
**Tema asignado:** Hacer construcciones (Construccion / EnumConstruccion / Categoria / ProyectosUrbanisticos)

Proyecto Spring Boot con las dependencias **Spring Web**, **Thymeleaf** y **Spring Boot DevTools**.

## Estructura

```
src/main/java/com/melanny/trabajo3
├── Trabajo3Application.java      (solo el main, sin código adicional)
├── modelo
│   ├── EnumConstruccion.java     (CASA, EDIFICIO, PUENTE, CARRETERA, PARQUE)
│   ├── Categoria.java            (RESIDENCIAL, COMERCIAL, PUBLICA)
│   ├── Construccion.java         (Stack<Integer> conteo, verTotales)
│   └── ProyectosUrbanisticos.java (Deque<Construccion> construcciones)
├── controlador
│   └── ConstruccionController.java
└── repositories
    └── ConstruccionRepository.java

src/main/resources
├── templates                     (vistas html con Thymeleaf)
└── static/css/estilo.css
```

## Uso de las dependencias

- **Spring Web:** el controlador atiende las peticiones `@GetMapping`.
- **Thymeleaf:** las vistas de `templates` muestran los datos con `th:each`, `th:text` y fragmentos.
- **DevTools:** reinicio automático al guardar (configurado en `application.properties`).

## Puntos del trabajo

| Ruta | Punto |
|------|-------|
| `/punto1` | Enums, clases, 5 objetos en un Stack y el proyecto con su Deque |
| `/punto2` | `ListIterator` sobre el Stack e `Iterator` sobre el Deque |
| `/punto3` | Programación funcional (`stream`, `filter`, `forEach`) sobre el Deque |
| `/punto4` | `Function<Construccion, Integer>` que suma el Stack `conteo` |
| `/punto5` | Método `verTotales` que recibe la función del punto 4 |

## Cómo ejecutarlo

Requiere Java 17 o superior.

```
./mvnw spring-boot:run          (Linux / Mac)
mvnw.cmd spring-boot:run        (Windows)
```

También se puede ejecutar desde Visual Studio Code con el botón *Run* sobre `Trabajo3Application.java`.
Luego abrir http://localhost:8080
