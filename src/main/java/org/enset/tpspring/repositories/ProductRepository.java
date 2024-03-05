package org.enset.tpspring.repositories;

import org.enset.tpspring.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContains(String mc);
    List<Product> findByPriceGreaterThan(double price);

    @Query("select p from Product p WHERE p.name like %:x%")
    List<Product> search(@Param("x") String mc);

    @Query("select p from Product p WHERE p.price>:x")
    List<Product> searchByPrice(@Param("x") double price);
}
