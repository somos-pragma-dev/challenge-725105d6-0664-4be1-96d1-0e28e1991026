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