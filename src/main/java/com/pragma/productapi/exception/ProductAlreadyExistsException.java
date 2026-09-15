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