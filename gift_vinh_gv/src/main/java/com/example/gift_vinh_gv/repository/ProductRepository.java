package com.example.gift_vinh_gv.repository;

import com.example.gift_vinh_gv.model.Product;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT p FROM Product p WHERE " +
            "(p.nameProduct like :search or " +
            "p.category.name like :search) and " +
            "p.price between :min and :max")
    Page<Product> searchEverything(String search, BigDecimal min, BigDecimal max, Pageable pageable);


    Page<Product>findAllByNameProductContainingOrCategory_NameContainingAndPriceBetween(String nameProduct, String category_name, BigDecimal price, BigDecimal price2, Pageable pageable);
    public Product findAllById(int id);
    public Product findAllByNameProduct(String nameProduct);
}