# Creación de una API REST con persistencia y documentación

Necesitamos una API REST que gestione productos en un catálogo. Los productos tienen nombre, precio y stock. La API debe validar que los nombres de los productos sean únicos y que los precios no sean negativos. Los datos se almacenarán en una base de datos H2 y la API debe estar documentada con Swagger.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | api-rest |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 4 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición del modelo de producto

**Objetivo:** Definir el modelo de datos para los productos y establecer las validaciones necesarias.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Crear un modelo de datos para los productos con los atributos nombre, precio y stock.
- Asegurar que los nombres de los productos sean únicos y que los precios no sean negativos.

**Entregable:** Modelo de datos de producto con validaciones implementadas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo representar la unicidad de los nombres y la validación de los precios en el modelo de datos.

</details>

### Fase 2: Implementación de la persistencia en H2

**Objetivo:** Implementar la persistencia de los productos en una base de datos H2.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Configurar una base de datos H2 para almacenar los productos.
- Implementar las operaciones CRUD para los productos.

**Entregable:** Base de datos H2 configurada y operaciones CRUD implementadas.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo configurar la conexión a la base de datos H2 y cómo mapear el modelo de datos a la base de datos.

</details>

### Fase 3: Documentación con Swagger

**Objetivo:** Documentar la API REST con Swagger.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Configurar Swagger para documentar la API REST.
- Asegurar que la documentación incluya todos los endpoints y sus parámetros.

**Entregable:** Documentación de la API REST con Swagger.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo configurar Swagger para que documente adecuadamente la API REST.

</details>

### Fase 4: Integración y prueba de la API

**Objetivo:** Integrar y probar la API REST para asegurar que funcione correctamente.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Integrar todas las fases anteriores para crear una API REST funcional.
- Realizar pruebas para asegurar que la API cumple con los requisitos especificados.

**Entregable:** API REST funcional y probada.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo integrar todas las partes de la API y cómo realizar pruebas efectivas para asegurar su correcto funcionamiento.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un modelo de datos y por qué es importante en una API REST?
- **paraQueSirve**: ¿Para qué sirve la documentación con Swagger en una API REST?
- **comoSeUsa**: ¿Cómo se usa una base de datos H2 para la persistencia de datos en una API REST?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar validaciones en un modelo de datos?
- **queDecisionesImplica**: ¿Qué decisiones implica la integración y prueba de una API REST?

## Criterios de Evaluacion

- Modelo de datos con validaciones implementadas.
- Base de datos H2 configurada y operaciones CRUD implementadas.
- Documentación de la API REST con Swagger.
- API REST funcional y probada.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
el comando de build o arranque canonico del stack elegido
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
