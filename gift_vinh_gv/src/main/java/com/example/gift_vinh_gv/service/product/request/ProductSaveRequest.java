package com.example.gift_vinh_gv.service.product.request;

public class ProductSaveRequest {
    private String nameProduct;
    private String price;
    private String quantity;
    private SelectOptionRequest category;

    public ProductSaveRequest() {
    }

    public ProductSaveRequest(String nameProduct, String price, String quantity, SelectOptionRequest category) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
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
