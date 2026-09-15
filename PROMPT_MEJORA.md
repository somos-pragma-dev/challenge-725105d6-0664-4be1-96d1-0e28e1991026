# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Boilerplate del stack que falta

Sin esto no compila ni arranca. Es andamiaje, no toca nada de lo pedagogico:

- **Punto de entrada del stack elegido** — Sin un punto de entrada reconocible, el runtime no tiene por donde arrancar la aplicacion.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/productapi/ProductApiApplication.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.OpenAPIDefinition pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/productapi/model/Product.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/productapi/dto/ProductRequest.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/productapi/config/OpenApiConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.Components pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/productapi/controller/ProductController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/pragma/productapi/controller/ProductControllerTest.java` — `com.fasterxml.jackson`: El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java` — `ValidationErrorResponse.setTimestamp`: Se invoca `setTimestamp` sobre `ValidationErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java` — `ValidationErrorResponse.setStatus`: Se invoca `setStatus` sobre `ValidationErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java` — `ValidationErrorResponse.setError`: Se invoca `setError` sobre `ValidationErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java` — `ValidationErrorResponse.setMessage`: Se invoca `setMessage` sobre `ValidationErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java` — `ValidationErrorResponse.setPath`: Se invoca `setPath` sobre `ValidationErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.existsById`: Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.deleteById`: Se invoca `deleteById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `Product.isPresent`: Se invoca `isPresent` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.name`: Se invoca `name` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.price`: Se invoca `price` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.stock`: Se invoca `stock` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.size`: Se invoca `size` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.get`: Se invoca `get` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.isEmpty`: Se invoca `isEmpty` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductResponse.isPresent`: Se invoca `isPresent` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductRepository.existsById`: Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
el comando de build o arranque canonico del stack elegido
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Crear una API REST con persistencia en H2 y documentación con Swagger

### Reto
- Tema: api-rest
- Seniority: junior-l2
- Tipo: practical
- Título: Creación de una API REST con persistencia y documentación
- Tiempo estimado: 4 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición del modelo de producto — objetivo: Definir el modelo de datos para los productos y establecer las validaciones necesarias. — entregable (NO resolver): Modelo de datos de producto con validaciones implementadas.
- Fase 2: Implementación de la persistencia en H2 — objetivo: Implementar la persistencia de los productos en una base de datos H2. — entregable (NO resolver): Base de datos H2 configurada y operaciones CRUD implementadas.
- Fase 3: Documentación con Swagger — objetivo: Documentar la API REST con Swagger. — entregable (NO resolver): Documentación de la API REST con Swagger.
- Fase 4: Integración y prueba de la API — objetivo: Integrar y probar la API REST para asegurar que funcione correctamente. — entregable (NO resolver): API REST funcional y probada.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>
    
    <groupId>com.pragma</groupId>
    <artifactId>product-api</artifactId>
    <version>1.0.0</version>
    <name>product-api</name>
    <description>Product API REST</description>
    
    <properties>
        <java.version>21</java.version>
        <springdoc.version>2.6.0</springdoc.version>
        <lombok.version>1.18.34</lombok.version>
        <h2.version>2.3.230</h2.version>
    </properties>
    
    <dependencies>
        <!-- Spring Boot Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <!-- Spring Boot Data JPA -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <!-- H2 Database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>${h2.version}</version>
            <scope>runtime</scope>
        </dependency>
        
        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
            <scope>provided</scope>
        </dependency>
        
        <!-- SpringDoc OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${springdoc.version}</version>
        </dependency>
        
        <!-- Spring Boot Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>${lombok.version}</version>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>
        </plugins>
    </build>
    
</project>

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>
    
    <groupId>com.pragma</groupId>
    <artifactId>product-api</artifactId>
    <version>1.0.0</version>
    <name>product-api</name>
    <description>API REST para gestión de productos con persistencia H2</description>
    
    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <scope>compile</scope>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
            <scope>compile</scope>
        </dependency>
        
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.3.230</version>
            <scope>runtime</scope>
        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.34</version>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.6.0</version>
            <scope>compile</scope>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <version>3.4.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/productapi/ProductApiApplication.java ===
package com.pragma.productapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada de la aplicación Spring Boot.
 * Configura el contexto de Spring y habilita la documentación OpenAPI.
 */
@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Product API",
        version = "1.0.0",
        description = "API REST para gestión de productos en un catálogo",
        contact = @Contact(name = "Pragma Team", email = "dev@pragma.com")
    )
)
public class ProductApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }
}

// === ARCHIVO: src/main/resources/application.properties ===
# Configuración de la aplicación Spring Boot
spring.application.name=product-api

# Configuración del servidor embebido
server.port=8080

# Configuración de la base de datos H2 en memoria
spring.datasource.url=jdbc:h2:mem:productdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuración de JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Configuración de la consola H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.web-allow-others=true

# Configuración de Jackson para serialización JSON
spring.jackson.serialization.write-dates-as-timestamps=false
spring.jackson.default-property-inclusion=non_null

# Configuración de logging
logging.level.com.pragma.productapi=INFO
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

// === ARCHIVO: src/main/java/com/pragma/productapi/model/Product.java ===
package com.pragma.productapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad JPA que representa el modelo de datos de un producto.
 * Gestiona la validación de negocio a nivel de persistencia.
 */
@Entity
@Table(name = "products", uniqueConstraints = {
    @UniqueConstraint(name = "uk_product_name", columnNames = "name")
})
@Schema(description = "Entidad que representa un producto en el catálogo")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del producto", example = "1")
    private Long id;
    
    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, unique = true, length = 100)
    @Schema(description = "Nombre del producto", example = "Laptop Dell XPS 15", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    
    @Positive(message = "El precio debe ser mayor que cero")
    @Column(nullable = false, precision = 10, scale = 2)
    @Schema(description = "Precio del producto", example = "1299.99", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal price;
    
    @Positive(message = "El stock no puede ser negativo")
    @Column(nullable = false)
    @Schema(description = "Cantidad disponible en inventario", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer stock;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    @Schema(description = "Fecha de creación del registro")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    @Schema(description = "Fecha de última modificación")
    private LocalDateTime updatedAt;
    
    public Product() {
    }
    
    public Product(String name, BigDecimal price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Integer getStock() {
        return stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @jakarta.persistence.PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    @jakarta.persistence.PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id != null && id.equals(product.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/dto/ProductRequest.java ===
package com.pragma.productapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * DTO para la creación y actualización de productos.
 * Utiliza record de Java 21 para inmutabilidad y concisión.
 */
@Schema(description = "Solicitud para crear o actualizar un producto")
public record ProductRequest(
    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Schema(description = "Nombre del producto", example = "Laptop Dell XPS 15", 
            requiredMode = Schema.RequiredMode.REQUIRED, minLength = 3, maxLength = 100)
    String name,
    
    @Positive(message = "El precio debe ser mayor que cero")
    @Schema(description = "Precio del producto", example = "1299.99", requiredMode = Schema.RequiredMode.REQUIRED)
    BigDecimal price,
    
    @Positive(message = "El stock no puede ser negativo")
    @Schema(description = "Cantidad disponible en inventario", example = "50", 
            requiredMode = Schema.RequiredMode.REQUIRED, minimum = "0")
    Integer stock
) {
    
    /**
     * Constructor compacto con validación adicional de negocio.
     */
    public ProductRequest {
        if (price != null && price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        if (stock != null && stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/dto/ProductResponse.java ===
package com.pragma.productapi.dto;

import com.pragma.productapi.model.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO para la respuesta de productos.
 * Separa la entidad de persistencia de la representación externa.
 */
@Schema(description = "Respuesta con los datos de un producto")
public record ProductResponse(
    @Schema(description = "Identificador único del producto", example = "1")
    Long id,
    
    @Schema(description = "Nombre del producto", example = "Laptop Dell XPS 15")
    String name,
    
    @Schema(description = "Precio del producto", example = "1299.99")
    BigDecimal price,
    
    @Schema(description = "Cantidad disponible en inventario", example = "50")
    Integer stock,
    
    @Schema(description = "Fecha de creación del registro")
    LocalDateTime createdAt,
    
    @Schema(description = "Fecha de última modificación")
    LocalDateTime updatedAt
) {
    
    /**
     * Factory method para convertir una entidad Product a ProductResponse.
     */
    public static ProductResponse fromEntity(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getStock(),
            product.getCreatedAt(),
            product.getUpdatedAt()
        );
    }
    
    /**
     * Verifica si el producto tiene datos de auditoría.
     */
    public boolean hasAuditData() {
        return createdAt != null || updatedAt != null;
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/repository/ProductRepository.java ===
package com.pragma.productapi.repository;

import com.pragma.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    boolean existsByName(String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name AND p.id <> :id")
    Optional<Product> findByNameExcludingId(@Param("name") String name, @Param("id") Long id);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Product p WHERE p.name = :name")
    boolean hasProductWithName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.stock < :threshold")
    java.util.List<Product> findLowStockProducts(@Param("threshold") Integer threshold);

    @Query("SELECT p FROM Product p ORDER BY p.createdAt DESC")
    java.util.List<Product> findAllOrderByCreatedAtDesc();
}

// === ARCHIVO: src/main/java/com/pragma/productapi/config/OpenApiConfig.java ===
package com.pragma.productapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product API")
                        .version("1.0.0")
                        .description("API REST para la gestión de productos en un catálogo. " +
                                "Permite crear, leer, actualizar y eliminar productos. " +
                                "Los productos tienen nombre, precio y stock con validaciones de negocio.")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("desarrollo@pragma.com")
                                .url("https://www.pragma.com.co"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Token de autenticación JWT")));
    }

    @Bean
    public io.swagger.v3.oas.models.PathItems pathItems() {
        return new io.swagger.v3.oas.models.PathItems();
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/exception/ProductAlreadyExistsException.java ===
package com.pragma.productapi.exception;

public class ProductAlreadyExistsException extends RuntimeException {

    private final String productName;

    public ProductAlreadyExistsException(String productName) {
        super(String.format("Ya existe un producto con el nombre: %s", productName));
        this.productName = productName;
    }

    public ProductAlreadyExistsException(String productName, Throwable cause) {
        super(String.format("Ya existe un producto con el nombre: %s", productName), cause);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String getMessage() {
        return String.format("El producto con nombre '%s' ya existe en el catálogo. " +
                "Por favor utilize un nombre diferente o verifique el producto existente.", productName);
    }

    public String getSimpleMessage() {
        return super.getMessage();
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java ===
package com.pragma.productapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleProductAlreadyExistsException(
            ProductAlreadyExistsException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .error("Conflict")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        error -> error.getDefaultMessage() != null 
                                ? error.getDefaultMessage() 
                                : "Invalid value",
                        (existing, replacement) -> existing
                ));

        ValidationErrorResponse errorResponse = ValidationErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation Failed")
                .message("Los datos proporcionados no son válidos")
                .errors(errors)
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Internal Server Error")
                .message("Ha ocurrido un error inesperado")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static class ErrorResponse {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;

        private ErrorResponse() {}

        public static ErrorResponseBuilder builder() {
            return new ErrorResponseBuilder();
        }

        public LocalDateTime getTimestamp() { return timestamp; }
        public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
        public int getStatus() { return status; }
        public void setStatus(int status) { this.status = status; }
        public String getError() { return error; }
        public void setError(String error) { this.error = error; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public String getPath() { return path; }
        public void setPath(String path) { this.path = path; }

        public static class ErrorResponseBuilder {
            private LocalDateTime timestamp;
            private int status;
            private String error;
            private String message;
            private String path;

            public ErrorResponseBuilder timestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
                return this;
            }
            public ErrorResponseBuilder status(int status) {
                this.status = status;
                return this;
            }
            public ErrorResponseBuilder error(String error) {
                this.error = error;
                return this;
            }
            public ErrorResponseBuilder message(String message) {
                this.message = message;
                return this;
            }
            public ErrorResponseBuilder path(String path) {
                this.path = path;
                return this;
            }
            public ErrorResponse build() {
                ErrorResponse response = new ErrorResponse();
                response.timestamp = this.timestamp;
                response.status = this.status;
                response.error = this.error;
                response.message = this.message;
                response.path = this.path;
                return response;
            }
        }
    }

    public static class ValidationErrorResponse extends ErrorResponse {
        private Map<String, String> errors;

        private ValidationErrorResponse() {}

        public Map<String, String> getErrors() { return errors; }
        public void setErrors(Map<String, String> errors) { this.errors = errors; }

        public static ValidationErrorResponseBuilder builder() {
            return new ValidationErrorResponseBuilder();
        }

        public static class ValidationErrorResponseBuilder {
            private LocalDateTime timestamp;
            private int status;
            private String error;
            private String message;
            private String path;
            private Map<String, String> errors = new HashMap<>();

            public ValidationErrorResponseBuilder timestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
                return this;
            }
            public ValidationErrorResponseBuilder status(int status) {
                this.status = status;
                return this;
            }
            public ValidationErrorResponseBuilder error(String error) {
                this.error = error;
                return this;
            }
            public ValidationErrorResponseBuilder message(String message) {
                this.message = message;
                return this;
            }
            public ValidationErrorResponseBuilder path(String path) {
                this.path = path;
                return this;
            }
            public ValidationErrorResponseBuilder errors(Map<String, String> errors) {
                this.errors = errors;
                return this;
            }
            public ValidationErrorResponse build() {
                ValidationErrorResponse response = new ValidationErrorResponse();
                response.setTimestamp(this.timestamp);
                response.setStatus(this.status);
                response.setError(this.error);
                response.setMessage(this.message);
                response.setPath(this.path);
                response.errors = this.errors;
                return response;
            }
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/service/ProductService.java ===
package com.pragma.productapi.service;

import com.pragma.productapi.dto.ProductRequest;
import com.pragma.productapi.dto.ProductResponse;
import com.pragma.productapi.exception.ProductAlreadyExistsException;
import com.pragma.productapi.model.Product;
import com.pragma.productapi.repository.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest request) {
        validateProductRequest(request);
        checkProductNameUniqueness(request.name());

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.onCreate();

        Product savedProduct = productRepository.save(product);
        return ProductResponse.fromEntity(savedProduct);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<ProductResponse> getProductById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser mayor que cero");
        }
        return productRepository.findById(id)
                .map(ProductResponse::fromEntity);
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        validateProductRequest(request);

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Producto no encontrado con ID: " + id));

        Optional<Product> productWithSameName = productRepository.findByName(request.name());
        if (productWithSameName.isPresent() && 
            !productWithSameName.get().getId().equals(id)) {
            throw new ProductAlreadyExistsException(
                    "Ya existe un producto con el nombre: " + request.name());
        }

        existingProduct.setName(request.name());
        existingProduct.setPrice(request.price());
        existingProduct.setStock(request.stock());
        existingProduct.onUpdate();

        Product updatedProduct = productRepository.save(existingProduct);
        return ProductResponse.fromEntity(updatedProduct);
    }

    public void deleteProduct(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser mayor que cero");
        }

        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
        }

        productRepository.deleteById(id);
    }

    public List<ProductResponse> searchProductsByName(String namePattern) {
        if (namePattern == null || namePattern.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El patrón de búsqueda no puede estar vacío");
        }
        List<Product> products = productRepository.findByNameContaining(namePattern);
        return products.stream()
                .map(ProductResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> getProductsWithLowStock(Integer threshold) {
        if (threshold == null || threshold < 0) {
            throw new IllegalArgumentException(
                    "El umbral de stock debe ser un número no negativo");
        }
        List<Product> products = productRepository.findByStockLessThan(threshold);
        return products.stream()
                .map(ProductResponse::fromEntity)
                .collect(Collectors.toList());
    }

    private void validateProductRequest(ProductRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("La solicitud no puede ser nula");
        }
        if (request.name() == null || request.name().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del producto es obligatorio");
        }
        if (request.name().length() > 100) {
            throw new IllegalArgumentException(
                    "El nombre del producto no puede exceder 100 caracteres");
        }
        if (request.price() == null) {
            throw new IllegalArgumentException(
                    "El precio del producto es obligatorio");
        }
        if (request.price().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "El precio del producto no puede ser negativo");
        }
        if (request.stock() == null) {
            throw new IllegalArgumentException(
                    "El stock del producto es obligatorio");
        }
        if (request.stock() < 0) {
            throw new IllegalArgumentException(
                    "El stock del producto no puede ser negativo");
        }
    }

    private void checkProductNameUniqueness(String name) {
        Optional<Product> existingProduct = productRepository.findByName(name);
        if (existingProduct.isPresent()) {
            throw new ProductAlreadyExistsException(
                    "Ya existe un producto con el nombre: " + name);
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/controller/ProductController.java ===
package com.pragma.productapi.controller;

import com.pragma.productapi.dto.ProductRequest;
import com.pragma.productapi.dto.ProductResponse;
import com.pragma.productapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Gestión de Productos", description = "API para gestionar el catálogo de productos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo producto", 
               description = "Crea un nuevo producto en el catálogo con validación de nombre único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Producto creado exitosamente",
                     content = @Content(schema = @Schema(implementation = ProductResponse.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
        @ApiResponse(responseCode = "409", description = "El producto ya existe")
    })
    public ResponseEntity<ProductResponse> createProduct(
            @Parameter(description = "Datos del producto a crear", required = true)
            @RequestBody ProductRequest request) {
        ProductResponse createdProduct = productService.createProduct(request);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Obtener todos los productos", 
               description = "Retorna la lista completa de productos del catálogo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente")
    })
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto por ID", 
               description = "Retorna los detalles de un producto específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto encontrado",
                     content = @Content(schema = @Schema(implementation = ProductResponse.class))),
        @ApiResponse(responseCode = "400", description = "ID inválido"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<ProductResponse> getProductById(
            @Parameter(description = "ID del producto a buscar", required = true, example = "1")
            @PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto", 
               description = "Actualiza los datos de un producto existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente",
                     content = @Content(schema = @Schema(implementation = ProductResponse.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
        @ApiResponse(responseCode = "409", description = "Conflicto: nombre de producto duplicado")
    })
    public ResponseEntity<ProductResponse> updateProduct(
            @Parameter(description = "ID del producto a actualizar", required = true, example = "1")
            @PathVariable Long id,
            @Parameter(description = "Nuevos datos del producto", required = true)
            @RequestBody ProductRequest request) {
        ProductResponse updatedProduct = productService.updateProduct(id, request);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", 
               description = "Elimina un producto del catálogo por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "ID inválido"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "ID del producto a eliminar", required = true, example = "1")
            @PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar productos por nombre", 
               description = "Busca productos cuyo nombre contenga el patrón especificado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Patrón de búsqueda inválido")
    })
    public ResponseEntity<List<ProductResponse>> searchProducts(
            @Parameter(description = "Patrón de búsqueda", required = true, example = "lap")
            @RequestParam String name) {
        List<ProductResponse> products = productService.searchProductsByName(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/low-stock")
    @Operation(summary = "Obtener productos con stock bajo", 
               description = "Retorna productos cuyo stock está por debajo del umbral especificado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Consulta realizada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Umbral inválido")
    })
    public ResponseEntity<List<ProductResponse>> getLowStockProducts(
            @Parameter(description = "Umbral de stock", required = true, example = "10")
            @RequestParam(defaultValue = "10") Integer threshold) {
        List<ProductResponse> products = productService.getProductsWithLowStock(threshold);
        return ResponseEntity.ok(products);
    }
}

// === ARCHIVO: src/test/java/com/pragma/productapi/controller/ProductControllerTest.java ===
package com.pragma.productapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.productapi.dto.ProductRequest;
import com.pragma.productapi.dto.ProductResponse;
import com.pragma.productapi.exception.ProductAlreadyExistsException;
import com.pragma.productapi.model.Product;
import com.pragma.productapi.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    private Product product;
    private ProductRequest productRequest;
    private ProductResponse productResponse;

    @BeforeEach
    void setUp() {
        product = new Product("Laptop", new BigDecimal("1500.00"), 10);
        product.setId(1L);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        productRequest = new ProductRequest("Laptop", new BigDecimal("1500.00"), 10);
        productResponse = ProductResponse.fromEntity(product);
    }

    @Test
    @DisplayName("POST /api/products should create product and return 201")
    void createProduct_ShouldReturnCreated() throws Exception {
        when(productService.create(any(ProductRequest.class))).thenReturn(productResponse);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.price").value(1500.00))
                .andExpect(jsonPath("$.stock").value(10));
    }

    @Test
    @DisplayName("POST /api/products should return 400 when product already exists")
    void createProduct_WhenAlreadyExists_ShouldReturnBadRequest() throws Exception {
        when(productService.create(any(ProductRequest.class)))
                .thenThrow(new ProductAlreadyExistsException("Product with name Laptop already exists"));

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Product with name Laptop already exists"));
    }

    @Test
    @DisplayName("GET /api/products should return all products")
    void getAllProducts_ShouldReturnProductList() throws Exception {
        when(productService.findAll()).thenReturn(List.of(productResponse));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Laptop"));
    }

    @Test
    @DisplayName("GET /api/products/{id} should return product when exists")
    void getProductById_WhenExists_ShouldReturnProduct() throws Exception {
        when(productService.findById(1L)).thenReturn(productResponse);

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    @DisplayName("GET /api/products/{id} should return 404 when not exists")
    void getProductById_WhenNotExists_ShouldReturnNotFound() throws Exception {
        when(productService.findById(99L)).thenReturn(null);

        mockMvc.perform(get("/api/products/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("PUT /api/products/{id} should update product and return 200")
    void updateProduct_ShouldReturnUpdatedProduct() throws Exception {
        Product updatedProduct = new Product("Laptop Pro", new BigDecimal("2000.00"), 5);
        updatedProduct.setId(1L);
        updatedProduct.setCreatedAt(product.getCreatedAt());
        updatedProduct.setUpdatedAt(LocalDateTime.now());

        ProductResponse updatedResponse = ProductResponse.fromEntity(updatedProduct);

        when(productService.update(eq(1L), any(ProductRequest.class))).thenReturn(updatedResponse);

        mockMvc.perform(put("/api/products/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop Pro"))
                .andExpect(jsonPath("$.price").value(2000.00));
    }

    @Test
    @DisplayName("DELETE /api/products/{id} should return 204")
    void deleteProduct_ShouldReturnNoContent() throws Exception {
        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("POST /api/products should return 400 for invalid request")
    void createProduct_WithInvalidRequest_ShouldReturnBadRequest() throws Exception {
        ProductRequest invalidRequest = new ProductRequest("", new BigDecimal("-10"), -1);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());
    }
}

// === ARCHIVO: src/test/java/com/pragma/productapi/service/ProductServiceTest.java ===
package com.pragma.productapi.service;

import com.pragma.productapi.dto.ProductRequest;
import com.pragma.productapi.dto.ProductResponse;
import com.pragma.productapi.exception.ProductAlreadyExistsException;
import com.pragma.productapi.model.Product;
import com.pragma.productapi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;
    private ProductRequest productRequest;

    @BeforeEach
    void setUp() {
        product = new Product("Laptop", new BigDecimal("1500.00"), 10);
        product.setId(1L);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        productRequest = new ProductRequest("Laptop", new BigDecimal("1500.00"), 10);
    }

    @Test
    @DisplayName("create should save product when name is unique")
    void create_WhenNameIsUnique_ShouldSaveProduct() {
        when(productRepository.existsByName("Laptop")).thenReturn(false);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductResponse result = productService.create(productRequest);

        assertNotNull(result);
        assertEquals("Laptop", result.name());
        assertEquals(new BigDecimal("1500.00"), result.price());
        assertEquals(10, result.stock());
        verify(productRepository).save(any(Product.class));
    }

    @Test
    @DisplayName("create should throw exception when name already exists")
    void create_WhenNameExists_ShouldThrowException() {
        when(productRepository.existsByName("Laptop")).thenReturn(true);

        assertThrows(ProductAlreadyExistsException.class, () -> {
            productService.create(productRequest);
        });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("findAll should return all products")
    void findAll_ShouldReturnAllProducts() {
        when(productRepository.findAll()).thenReturn(List.of(product));

        List<ProductResponse> result = productService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).name());
    }

    @Test
    @DisplayName("findAll should return empty list when no products")
    void findAll_WhenNoProducts_ShouldReturnEmptyList() {
        when(productRepository.findAll()).thenReturn(List.of());

        List<ProductResponse> result = productService.findAll();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("findById should return product when exists")
    void findById_WhenExists_ShouldReturnProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        ProductResponse result = productService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals("Laptop", result.name());
    }

    @Test
    @DisplayName("findById should return null when not exists")
    void findById_WhenNotExists_ShouldReturnNull() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        ProductResponse result = productService.findById(99L);

        assertNull(result);
    }

    @Test
    @DisplayName("update should update product when exists")
    void update_WhenExists_ShouldUpdateProduct() {
        ProductRequest updateRequest = new ProductRequest("Laptop Pro", new BigDecimal("2000.00"), 5);
        Product updatedProduct = new Product("Laptop Pro", new BigDecimal("2000.00"), 5);
        updatedProduct.setId(1L);
        updatedProduct.setCreatedAt(product.getCreatedAt());
        updatedProduct.setUpdatedAt(LocalDateTime.now());

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(updatedProduct);

        ProductResponse result = productService.update(1L, updateRequest);

        assertNotNull(result);
        assertEquals("Laptop Pro", result.name());
        assertEquals(new BigDecimal("2000.00"), result.price());
        assertEquals(5, result.stock());
    }

    @Test
    @DisplayName("update should return null when product not exists")
    void update_WhenNotExists_ShouldReturnNull() {
        ProductRequest updateRequest = new ProductRequest("Laptop Pro", new BigDecimal("2000.00"), 5);

        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        ProductResponse result = productService.update(99L, updateRequest);

        assertNull(result);
        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("delete should delete product when exists")
    void delete_WhenExists_ShouldDeleteProduct() {
        when(productRepository.existsById(1L)).thenReturn(true);
        doNothing().when(productRepository).deleteById(1L);

        productService.delete(1L);

        verify(productRepository).deleteById(1L);
    }

    @Test
    @DisplayName("delete should throw exception when not exists")
    void delete_WhenNotExists_ShouldThrowException() {
        when(productRepository.existsById(99L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> {
            productService.delete(99L);
        });

        verify(productRepository, never()).deleteById(any());
    }

    @Test
    @DisplayName("create should handle null stock correctly")
    void create_WithNullStock_ShouldHandleCorrectly() {
        ProductRequest requestWithNullStock = new ProductRequest("Test", new BigDecimal("100.00"), null);
        Product productWithNullStock = new Product("Test", new BigDecimal("100.00"), null);
        productWithNullStock.setId(1L);

        when(productRepository.existsByName("Test")).thenReturn(false);
        when(productRepository.save(any(Product.class))).thenReturn(productWithNullStock);

        ProductResponse result = productService.create(requestWithNullStock);

        assertNotNull(result);
        assertNull(result.stock());
    }

    @Test
    @DisplayName("findById should handle very large id")
    void findById_WithVeryLargeId_ShouldReturnNull() {
        when(productRepository.findById(Long.MAX_VALUE)).thenReturn(Optional.empty());

        ProductResponse result = productService.findById(Long.MAX_VALUE);

        assertNull(result);
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/ProductApiApplication.java ===
package com.pragma.productapi;

import com.pragma.productapi.model.Product;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada de la aplicación Spring Boot.
 * Configura el contexto de Spring y habilita la documentación OpenAPI.
 */
@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Product API",
        version = "1.0.0",
        description = "API REST para gestión de productos en un catálogo",
        contact = @Contact(name = "Pragma Team", email = "dev@pragma.com")
    )
)
public class ProductApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/config/OpenApiConfig.java ===
package com.pragma.productapi.config;

import com.pragma.productapi.model.Product;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product API")
                        .version("1.0.0")
                        .description("API REST para la gestión de productos en un catálogo. " +
                                "Permite crear, leer, actualizar y eliminar productos. " +
                                "Los productos tienen nombre, precio y stock con validaciones de negocio.")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("desarrollo@pragma.com")
                                .url("https://www.pragma.com.co"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Token de autenticación JWT")));
    }

    @Bean
    public io.swagger.v3.oas.models.PathItems pathItems() {
        return new io.swagger.v3.oas.models.PathItems();
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java ===
package com.pragma.productapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleProductAlreadyExistsException(
            ProductAlreadyExistsException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .error("Conflict")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        error -> error.getDefaultMessage() != null 
                                ? error.getDefaultMessage() 
                                : "Invalid value",
                        (existing, replacement) -> existing
                ));

        ValidationErrorResponse errorResponse = ValidationErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation Failed")
                .message("Los datos proporcionados no son válidos")
                .errors(errors)
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Internal Server Error")
                .message("Ha ocurrido un error inesperado")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static class ErrorResponse {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;

        private ErrorResponse() {}

        public static ErrorResponseBuilder builder() {
            return new ErrorResponseBuilder();
        }

        public LocalDateTime getTimestamp() { return timestamp; }
        public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
        public int getStatus() { return status; }
        public void setStatus(int status) { this.status = status; }
        public String getError() { return error; }
        public void setError(String error) { this.error = error; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public String getPath() { return path; }
        public void setPath(String path) { this.path = path; }

        public static class ErrorResponseBuilder {
            private LocalDateTime timestamp;
            private int status;
            private String error;
            private String message;
            private String path;

            public ErrorResponseBuilder timestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
                return this;
            }
            public ErrorResponseBuilder status(int status) {
                this.status = status;
                return this;
            }
            public ErrorResponseBuilder error(String error) {
                this.error = error;
                return this;
            }
            public ErrorResponseBuilder message(String message) {
                this.message = message;
                return this;
            }
            public ErrorResponseBuilder path(String path) {
                this.path = path;
                return this;
            }
            public ErrorResponse build() {
                ErrorResponse response = new ErrorResponse();
                response.timestamp = this.timestamp;
                response.status = this.status;
                response.error = this.error;
                response.message = this.message;
                response.path = this.path;
                return response;
            }
        }
    }

    public static class ValidationErrorResponse extends ErrorResponse {
        private Map<String, String> errors;

        private ValidationErrorResponse() {}

        @Override
        public void setTimestamp(LocalDateTime timestamp) { super.setTimestamp(timestamp); }
        @Override
        public void setStatus(int status) { super.setStatus(status); }
        @Override
        public void setError(String error) { super.setError(error); }
        @Override
        public void setMessage(String message) { super.setMessage(message); }
        @Override
        public void setPath(String path) { super.setPath(path); }

        public Map<String, String> getErrors() { return errors; }
        public void setErrors(Map<String, String> errors) { this.errors = errors; }

        public static ValidationErrorResponseBuilder builder() {
            return new ValidationErrorResponseBuilder();
        }

        public static class ValidationErrorResponseBuilder {
            private LocalDateTime timestamp;
            private int status;
            private String error;
            private String message;
            private String path;
            private Map<String, String> errors = new HashMap<>();

            public ValidationErrorResponseBuilder timestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
                return this;
            }
            public ValidationErrorResponseBuilder status(int status) {
                this.status = status;
                return this;
            }
            public ValidationErrorResponseBuilder error(String error) {
                this.error = error;
                return this;
            }
            public ValidationErrorResponseBuilder message(String message) {
                this.message = message;
                return this;
            }
            public ValidationErrorResponseBuilder path(String path) {
                this.path = path;
                return this;
            }
            public ValidationErrorResponseBuilder errors(Map<String, String> errors) {
                this.errors = errors;
                return this;
            }
            public ValidationErrorResponse build() {
                ValidationErrorResponse response = new ValidationErrorResponse();
                response.setTimestamp(this.timestamp);
                response.setStatus(this.status);
                response.setError(this.error);
                response.setMessage(this.message);
                response.setPath(this.path);
                response.errors = this.errors;
                return response;
            }
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/repository/ProductRepository.java ===
package com.pragma.productapi.repository;

import com.pragma.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    boolean existsByName(String name);
    Optional<Product> findByNameExcludingId(@Param("name") String name, @Param("id") Long id);
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Product p WHERE p.name = :name")
    boolean hasProductWithName(@Param("name") String name);
    List<Product> findLowStockProducts(@Param("threshold") Integer threshold);
    List<Product> findAllOrderByCreatedAtDesc();
    List<Product> findByNameContaining(String name);
    List<Product> findByStockLessThan(Integer stock);
}

// === ARCHIVO: src/main/java/com/pragma/productapi/service/ProductService.java ===
package com.pragma.productapi.service;

import com.pragma.productapi.dto.ProductRequest;
import com.pragma.productapi.dto.ProductResponse;
import com.pragma.productapi.exception.ProductAlreadyExistsException;
import com.pragma.productapi.model.Product;
import com.pragma.productapi.repository.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest request) {
        validateProductRequest(request);
        checkProductNameUniqueness(request.name());

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.onCreate();

        Product savedProduct = productRepository.save(product);
        return ProductResponse.fromEntity(savedProduct);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<ProductResponse> getProductById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser mayor que cero");
        }
        return productRepository.findById(id)
                .map(ProductResponse::fromEntity);
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        validateProductRequest(request);

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Producto no encontrado con ID: " + id));

        Optional<Product> productWithSameName = productRepository.findByName(request.name());
        if (productWithSameName.isPresent() && 
            !productWithSameName.get().getId().equals(id)) {
            throw new ProductAlreadyExistsException(
                    "Ya existe un producto con el nombre: " + request.name());
        }

        existingProduct.setName(request.name());
        existingProduct.setPrice(request.price());
        existingProduct.setStock(request.stock());
        existingProduct.onUpdate();

        Product updatedProduct = productRepository.save(existingProduct);
        return ProductResponse.fromEntity(updatedProduct);
    }

    public void deleteProduct(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser mayor que cero");
        }

        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
        }

        productRepository.deleteById(id);
    }

    public List<ProductResponse> searchProductsByName(String namePattern) {
        if (namePattern == null || namePattern.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El patrón de búsqueda no puede estar vacío");
        }
        List<Product> products = productRepository.findByNameContaining(namePattern);
        return products.stream()
                .map(ProductResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> getProductsWithLowStock(Integer threshold) {
        if (threshold == null || threshold < 0) {
            throw new IllegalArgumentException(
                    "El umbral de stock debe ser un número no negativo");
        }
        List<Product> products = productRepository.findByStockLessThan(threshold);
        return products.stream()
                .map(ProductResponse::fromEntity)
                .collect(Collectors.toList());
    }

    private void validateProductRequest(ProductRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("La solicitud no puede ser nula");
        }
        if (request.name() == null || request.name().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del producto es obligatorio");
        }
        if (request.name().length() > 100) {
            throw new IllegalArgumentException(
                    "El nombre del producto no puede exceder 100 caracteres");
        }
        if (request.price() == null) {
            throw new IllegalArgumentException(
                    "El precio del producto es obligatorio");
        }
        if (request.price().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "El precio del producto no puede ser negativo");
        }
        if (request.stock() == null) {
            throw new IllegalArgumentException(
                    "El stock del producto es obligatorio");
        }
        if (request.stock() < 0) {
            throw new IllegalArgumentException(
                    "El stock del producto no puede ser negativo");
        }
    }

    private void checkProductNameUniqueness(String name) {
        Optional<Product> existingProduct = productRepository.findByName(name);
        if (existingProduct.isPresent()) {
            throw new ProductAlreadyExistsException(
                    "Ya existe un producto con el nombre: " + name);
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/dto/ProductResponse.java ===
package com.pragma.productapi.dto;

import com.pragma.productapi.model.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponse(
    Long id,
    String name,
    BigDecimal price,
    Integer stock,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public static ProductResponse fromEntity(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getStock(),
            product.getCreatedAt(),
            product.getUpdatedAt()
        );
    }

    public boolean hasAuditData() {
        return createdAt() != null || updatedAt() != null;
    }
}

// === ARCHIVO: src/test/java/com/pragma/productapi/controller/ProductControllerTest.java ===
package com.pragma.productapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.productapi.dto.ProductRequest;
import com.pragma.productapi.dto.ProductResponse;
import com.pragma.productapi.exception.ProductAlreadyExistsException;
import com.pragma.productapi.model.Product;
import com.pragma.productapi.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    private Product product;
    private ProductRequest productRequest;
    private ProductResponse productResponse;

    @BeforeEach
    void setUp() {
        product = new Product("Laptop", new BigDecimal("1500.00"), 10);
        product.setId(1L);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        productRequest = new ProductRequest("Laptop", new BigDecimal("1500.00"), 10);
        productResponse = ProductResponse.fromEntity(product);
    }

    @Test
    @DisplayName("POST /api/products should create product and return 201")
    void createProduct_ShouldReturnCreated() throws Exception {
        when(productService.createProduct(any(ProductRequest.class))).thenReturn(productResponse);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.price").value(1500.00))
                .andExpect(jsonPath("$.stock").value(10));
    }

    @Test
    @DisplayName("POST /api/products should return 400 when product already exists")
    void createProduct_WhenAlreadyExists_ShouldReturnBadRequest() throws Exception {
        when(productService.createProduct(any(ProductRequest.class)))
                .thenThrow(new ProductAlreadyExistsException("Product with name Laptop already exists"));

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Product with name Laptop already exists"));
    }

    @Test
    @DisplayName("GET /api/products should return all products")
    void getAllProducts_ShouldReturnProductList() throws Exception {
        when(productService.getAllProducts()).thenReturn(List.of(productResponse));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Laptop"));
    }

    @Test
    @DisplayName("GET /api/products/{id} should return product when exists")
    void getProductById_WhenExists_ShouldReturnProduct() throws Exception {
        when(productService.getProductById(1L)).thenReturn(Optional.of(productResponse));

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    @DisplayName("GET /api/products/{id} should return 404 when not exists")
    void getProductById_WhenNotExists_ShouldReturnNotFound() throws Exception {
        when(productService.getProductById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/products/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("PUT /api/products/{id} should update product and return 200")
    void updateProduct_ShouldReturnUpdatedProduct() throws Exception {
        Product updatedProduct = new Product("Laptop Pro", new BigDecimal("2000.00"), 5);
        updatedProduct.setId(1L);
        updatedProduct.setCreatedAt(product.getCreatedAt());
        updatedProduct.setUpdatedAt(LocalDateTime.now());

        ProductResponse updatedResponse = ProductResponse.fromEntity(updatedProduct);

        when(productService.updateProduct(eq(1L), any(ProductRequest.class))).thenReturn(updatedResponse);

        mockMvc.perform(put("/api/products/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop Pro"))
                .andExpect(jsonPath("$.price").value(2000.00));
    }

    @Test
    @DisplayName("DELETE /api/products/{id} should return 204")
    void deleteProduct_ShouldReturnNoContent() throws Exception {
        doNothing().when(productService).deleteProduct(1L);

        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("POST /api/products should return 400 for invalid request")
    void createProduct_WithInvalidRequest_ShouldReturnBadRequest() throws Exception {
        ProductRequest invalidRequest = new ProductRequest("", new BigDecimal("-10"), -1);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());
    }
}

// === ARCHIVO: src/test/java/com/pragma/productapi/service/ProductServiceTest.java ===
package com.pragma.productapi.service;

import com.pragma.productapi.dto.ProductRequest;
import com.pragma.productapi.dto.ProductResponse;
import com.pragma.productapi.exception.ProductAlreadyExistsException;
import com.pragma.productapi.model.Product;
import com.pragma.productapi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;
    private ProductRequest productRequest;

    @BeforeEach
    void setUp() {
        product = new Product("Laptop", new BigDecimal("1500.00"), 10);
        product.setId(1L);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        productRequest = new ProductRequest("Laptop", new BigDecimal("1500.00"), 10);
    }

    @Test
    @DisplayName("createProduct should save product when name is unique")
    void createProduct_WhenNameIsUnique_ShouldSaveProduct() {
        when(productRepository.existsByName("Laptop")).thenReturn(false);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductResponse result = productService.createProduct(productRequest);

        assertNotNull(result);
        assertEquals("Laptop", result.name());
        assertEquals(new BigDecimal("1500.00"), result.price());
        assertEquals(10, result.stock());
        verify(productRepository).save(any(Product.class));
    }

    @Test
    @DisplayName("createProduct should throw exception when name already exists")
    void createProduct_WhenNameExists_ShouldThrowException() {
        when(productRepository.existsByName("Laptop")).thenReturn(true);

        assertThrows(ProductAlreadyExistsException.class, () -> {
            productService.createProduct(productRequest);
        });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("getAllProducts should return all products")
    void getAllProducts_ShouldReturnAllProducts() {
        when(productRepository.findAll()).thenReturn(List.of(product));

        List<ProductResponse> result = productService.getAllProducts();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).name());
    }

    @Test
    @DisplayName("getAllProducts should return empty list when no products")
    void getAllProducts_WhenNoProducts_ShouldReturnEmptyList() {
        when(productRepository.findAll()).thenReturn(List.of());

        List<ProductResponse> result = productService.getAllProducts();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("getProductById should return product when exists")
    void getProductById_WhenExists_ShouldReturnProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<ProductResponse> result = productService.getProductById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().id());
        assertEquals("Laptop", result.get().name());
    }

    @Test
    @DisplayName("getProductById should return empty when not exists")
    void getProductById_WhenNotExists_ShouldReturnEmpty() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<ProductResponse> result = productService.getProductById(99L);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("updateProduct should update product when exists")
    void updateProduct_WhenExists_ShouldUpdateProduct() {
        ProductRequest updateRequest = new ProductRequest("Laptop Pro", new BigDecimal("2000.00"), 5);
        Product updatedProduct = new Product("Laptop Pro", new BigDecimal("2000.00"), 5);
        updatedProduct.setId(1L);
        updatedProduct.setCreatedAt(product.getCreatedAt());
        updatedProduct.setUpdatedAt(LocalDateTime.now());

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(updatedProduct);

        ProductResponse result = productService.updateProduct(1L, updateRequest);

        assertNotNull(result);
        assertEquals("Laptop Pro", result.name());
        assertEquals(new BigDecimal("2000.00"), result.price());
        assertEquals(5, result.stock());
    }

    @Test
    @DisplayName("updateProduct should throw exception when product not exists")
    void updateProduct_WhenNotExists_ShouldThrowException() {
        ProductRequest updateRequest = new ProductRequest("Laptop Pro", new BigDecimal("2000.00"), 5);

        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            productService.updateProduct(99L, updateRequest);
        });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("deleteProduct should delete product when exists")
    void deleteProduct_WhenExists_ShouldDeleteProduct() {
        when(productRepository.existsById(1L)).thenReturn(true);
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteProduct(1L);

        verify(productRepository).deleteById(1L);
    }

    @Test
    @DisplayName("deleteProduct should throw exception when not exists")
    void deleteProduct_WhenNotExists_ShouldThrowException() {
        when(productRepository.existsById(99L)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> {
            productService.deleteProduct(99L);
        });

        verify(productRepository, never()).deleteById(any());
    }

    @Test
    @DisplayName("createProduct should handle null stock correctly")
    void createProduct_WithNullStock_ShouldHandleCorrectly() {
        ProductRequest requestWithNullStock = new ProductRequest("Test", new BigDecimal("100.00"), null);
        Product productWithNullStock = new Product("Test", new BigDecimal("100.00"), null);
        productWithNullStock.setId(1L);

        when(productRepository.existsByName("Test")).thenReturn(false);
        when(productRepository.save(any(Product.class))).thenReturn(productWithNullStock);

        ProductResponse result = productService.createProduct(requestWithNullStock);

        assertNotNull(result);
        assertNull(result.stock());
    }

    @Test
    @DisplayName("getProductById should handle very large id")
    void getProductById_WithVeryLargeId_ShouldReturnEmpty() {
        when(productRepository.findById(Long.MAX_VALUE)).thenReturn(Optional.empty());

        Optional<ProductResponse> result = productService.getProductById(Long.MAX_VALUE);

        assertTrue(result.isEmpty());
    }
}

```
