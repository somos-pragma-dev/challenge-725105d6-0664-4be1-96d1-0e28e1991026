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