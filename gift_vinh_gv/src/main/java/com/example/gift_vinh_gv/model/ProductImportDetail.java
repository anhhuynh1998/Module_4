package com.example.gift_vinh_gv.model;

import com.example.gift_vinh_gv.model.eNum.Color;
import com.example.gift_vinh_gv.model.eNum.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImportDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Enumerated(EnumType.STRING)
    private Size size;
    private int quantity;
    private int totalQuantity;
   @ManyToOne
   @JoinColumn(name = "product_id")
    private Product product;
   @ManyToOne
   @JoinColumn(name = "productImport_id")
   private ProductImport productImport;


}
