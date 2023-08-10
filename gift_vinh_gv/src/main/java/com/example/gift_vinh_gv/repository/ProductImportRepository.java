package com.example.gift_vinh_gv.repository;

import com.example.gift_vinh_gv.model.Customer;
import com.example.gift_vinh_gv.model.ProductImport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ProductImportRepository extends JpaRepository<ProductImport,Integer> {
    Page<ProductImport> findAllByCustomerName_NameContainingOrCouponCodeContaining(String customerName_name, String couponCode, Pageable pageable);
}
