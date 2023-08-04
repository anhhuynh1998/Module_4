package com.example.gift_vinh_gv.service.productimport.reponse;

import com.example.gift_vinh_gv.model.ProductImportDetail;

import java.time.LocalDate;
import java.util.List;

public class ProductImportListReponse {
    int id;
    String customerName;
    LocalDate dateAdded;
    String couponCode;
    List<ProductImportDetail> productImportDetails;

    public ProductImportListReponse() {
    }

    public ProductImportListReponse(int id, String customerName, LocalDate dateAdded, String couponCode, List<ProductImportDetail> productImportDetails) {
        this.id = id;
        this.customerName = customerName;
        this.dateAdded = dateAdded;
        this.couponCode = couponCode;
        this.productImportDetails = productImportDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public List<ProductImportDetail> getProductImportDetails() {
        return productImportDetails;
    }

    public void setProductImportDetails(List<ProductImportDetail> productImportDetails) {
        this.productImportDetails = productImportDetails;
    }
}
