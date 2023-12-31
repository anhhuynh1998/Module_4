package com.example.gift_vinh_gv.repository;

import com.example.gift_vinh_gv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameIgnoreCaseOrEmailIgnoreCaseOrPhoneNumber(String username, String email, String phoneNumber);
    boolean existsByUsernameIgnoreCase(String username);
    boolean existsByEmailIgnoreCase(String email);
    boolean existsByPhoneNumber(String phoneNumber);
}
