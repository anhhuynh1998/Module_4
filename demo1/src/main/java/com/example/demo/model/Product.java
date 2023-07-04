package com.example.demo.model;

import com.example.demo.validate.ValidateCatagoryId;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "trống rồi bạn ơi !!")
    private String name;
    @Min(value = 0,message = "Không thể nhỏ hơn 0 !")
    @Max(value = 1000,message = "không được lớn hơn 100")
    private double price;
    @Min(value = 0,message = "Không thể nhỏ hơn 0 !")
    @Max(value = 1000,message = "không được lớn hơn 100")
    private int quantity;
    public Product() {
    }

    public Product(Integer id, String name, double price, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private @Valid Category category;

    public Product(String name, double price, int quantity, Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
