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