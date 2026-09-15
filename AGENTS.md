# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Creación de una API REST con persistencia y documentación**.

| | |
|---|---|
| Tema | api-rest |
| Nivel | junior-l2 |
| Chapter | Generico |
| Especialidad | Inferido del contexto |
| Stack | Java / Spring Boot 3.4 |
| Patron arquitectonico | capas estándar |
| Tiempo estimado | 4 horas |

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `el comando de build o arranque canonico del stack elegido` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `el comando de build o arranque canonico del stack elegido` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición del modelo de producto**: Modelo de datos de producto con validaciones implementadas.
- **Fase 2 — Implementación de la persistencia en H2**: Base de datos H2 configurada y operaciones CRUD implementadas.
- **Fase 3 — Documentación con Swagger**: Documentación de la API REST con Swagger.
- **Fase 4 — Integración y prueba de la API**: API REST funcional y probada.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Boilerplate del stack (1)

Sin esto el proyecto no compila ni arranca. **Es tu trabajo crearlo**, y no toca nada de lo pedagogico: es andamiaje del stack.

- [ ] **Punto de entrada del stack elegido** — Sin un punto de entrada reconocible, el runtime no tiene por donde arrancar la aplicacion.

### 2. Referencias colgando (28)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/pragma/productapi/ProductApiApplication.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.OpenAPIDefinition pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/productapi/model/Product.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/productapi/dto/ProductRequest.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/productapi/config/OpenApiConfig.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.models.Components pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/productapi/controller/ProductController.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/pragma/productapi/controller/ProductControllerTest.java` — `com.fasterxml.jackson`
      El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java` — `ValidationErrorResponse.setTimestamp`
      Se invoca `setTimestamp` sobre `ValidationErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java` — `ValidationErrorResponse.setStatus`
      Se invoca `setStatus` sobre `ValidationErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java` — `ValidationErrorResponse.setError`
      Se invoca `setError` sobre `ValidationErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java` — `ValidationErrorResponse.setMessage`
      Se invoca `setMessage` sobre `ValidationErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java` — `ValidationErrorResponse.setPath`
      Se invoca `setPath` sobre `ValidationErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.save`
      Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.findAll`
      Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.findById`
      Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.existsById`
      Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.deleteById`
      Se invoca `deleteById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productapi/service/ProductService.java` — `Product.isPresent`
      Se invoca `isPresent` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductRepository.save`
      Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.name`
      Se invoca `name` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.price`
      Se invoca `price` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.stock`
      Se invoca `stock` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductRepository.findAll`
      Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.size`
      Se invoca `size` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.get`
      Se invoca `get` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.isEmpty`
      Se invoca `isEmpty` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductRepository.findById`
      Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.isPresent`
      Se invoca `isPresent` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductRepository.existsById`
      Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (14)

- `pom.xml`
- `src/main/java/com/pragma/productapi/ProductApiApplication.java`
- `src/main/resources/application.properties`
- `src/main/java/com/pragma/productapi/model/Product.java`
- `src/main/java/com/pragma/productapi/dto/ProductRequest.java`
- `src/main/java/com/pragma/productapi/dto/ProductResponse.java`
- `src/main/java/com/pragma/productapi/repository/ProductRepository.java`
- `src/main/java/com/pragma/productapi/config/OpenApiConfig.java`
- `src/main/java/com/pragma/productapi/exception/ProductAlreadyExistsException.java`
- `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java`
- `src/main/java/com/pragma/productapi/service/ProductService.java`
- `src/main/java/com/pragma/productapi/controller/ProductController.java`
- `src/test/java/com/pragma/productapi/controller/ProductControllerTest.java`
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/productapi`
- `src/main/java/com/pragma/productapi/config`
- `src/main/java/com/pragma/productapi/controller`
- `src/main/java/com/pragma/productapi/dto`
- `src/main/java/com/pragma/productapi/exception`
- `src/main/java/com/pragma/productapi/model`
- `src/main/java/com/pragma/productapi/repository`
- `src/main/java/com/pragma/productapi/service`
- `src/main/resources`
- `src/test/java/com/pragma/productapi`

## Verificacion

```bash
el comando de build o arranque canonico del stack elegido
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Brecha que el reto ataca: Crear una API REST con persistencia en H2 y documentación con Swagger

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
