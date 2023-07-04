package com.example.gift_vinh_gv.service.product.request;

public class ProductSaveRequest {
    private String price;
    private String quantity;
    private SelectOptionRequest category;

    public ProductSaveRequest(String price, String quantity, SelectOptionRequest category) {
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public SelectOptionRequest getCategory() {
        return category;
    }

    public void setCategory(SelectOptionRequest category) {
        this.category = category;
    }
}
