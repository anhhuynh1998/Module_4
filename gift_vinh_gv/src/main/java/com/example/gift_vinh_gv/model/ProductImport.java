package com.example.gift_vinh_gv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerName;
    private LocalDate dateAdded;
    private String couponCode;
    @OneToMany(mappedBy = "productImport")
    @JsonIgnore
    private List<ProductImportDetail> productImportDetails;


}
