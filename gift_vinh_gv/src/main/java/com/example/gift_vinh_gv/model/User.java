package com.example.gift_vinh_gv.model;

import com.example.gift_vinh_gv.model.eNum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;

    private String password;
    @Column(unique = true)
    private String email;
    private String fullname;
    @Column(unique = true)
    private String phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
