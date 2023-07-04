package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT p FROM Product p WHERE " +
            "p.name like :search or " +
            "p.category.name like :search")
    List<Product> searchEverything(String search);
List<Product> searchAllByNameContainingOrCategory_NameContaining(@NotBlank(message = "trống rồi bạn ơi !!") String name, String category_name);
    Page<Product> findAll(Pageable pageable);
}
