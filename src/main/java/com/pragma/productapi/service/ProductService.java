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