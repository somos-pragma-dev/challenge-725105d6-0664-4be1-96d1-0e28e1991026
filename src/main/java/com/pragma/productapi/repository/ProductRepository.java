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