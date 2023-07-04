package com.example.gift_vinh_gv.repository;

import com.example.gift_vinh_gv.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
