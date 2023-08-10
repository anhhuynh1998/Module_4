package com.example.gift_vinh_gv.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;
@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
  @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Bill> bills;

  public Customer(int id, String name, String email, String phone, Set<Bill> bills) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.bills = bills;
  }

  public Customer() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
  public Set<Bill> getBills() {
    return bills;
  }

  public void setBills(Set<Bill> bills) {
    this.bills = bills;
  }
}
