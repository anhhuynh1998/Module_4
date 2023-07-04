package com.example.gift_vinh_gv.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private BigDecimal price;
    private int quantity;
    private String nameProduct;
    @ManyToOne
    @JoinColumn( name = "bill_id")
    public Bill bill;

    public BillDetail() {
    }

    public BillDetail(int id, Product product, BigDecimal price, int quantity, String nameProduct, Bill bill) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.nameProduct = nameProduct;
        this.bill = bill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
