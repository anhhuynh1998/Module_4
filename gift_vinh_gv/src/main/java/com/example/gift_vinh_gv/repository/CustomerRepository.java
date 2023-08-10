package com.example.gift_vinh_gv.repository;

import com.example.gift_vinh_gv.model.Customer;
import com.example.gift_vinh_gv.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findCustomerByPhone(String phone);
}