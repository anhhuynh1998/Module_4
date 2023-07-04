package com.example.gift_vinh_gv.repository;

import com.example.gift_vinh_gv.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT p FROM Product p WHERE " +
            "p.nameProduct like :search or " +
            "p.category.name like :search")
    Page<Product> searchEverything(String search, Pageable pageable);


    Page<Product>findAllByNameProductContainingOrCategory_NameContaining(String nameProduct, String category_name, Pageable pageable);

}
