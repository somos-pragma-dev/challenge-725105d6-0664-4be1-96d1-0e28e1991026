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