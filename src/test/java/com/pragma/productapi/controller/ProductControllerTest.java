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