package com.example.gift_vinh_gv.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nameProduct;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<BillDetail> billDetails;

    public Product() {
    }

    public Product(int id, String nameProduct, int quantity, BigDecimal price, Category category, Set<BillDetail> billDetails) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.billDetails = billDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(Set<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }
}
