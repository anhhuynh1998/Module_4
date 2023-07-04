package com.example.gift_vinh_gv.service.bill.request;
import com.example.gift_vinh_gv.service.product.request.SelectOptionRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

public class BillSaveRequest {
    private String dateBought;
    private @Valid CustomerSaveRequest customer;

    private  List<@Valid BillDetailSaveRequest> billDetails;

    public BillSaveRequest() {
        this.billDetails = new ArrayList<>();
        this.billDetails.add(new BillDetailSaveRequest());
    }

    public String getDateBought() {
        return dateBought;
    }

    public void setDateBought(String dateBought) {
        this.dateBought = dateBought;
    }

    public CustomerSaveRequest getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerSaveRequest customer) {
        this.customer = customer;
    }

    public List<BillDetailSaveRequest> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetailSaveRequest> billDetails) {
        this.billDetails = billDetails;
    }

    static class CustomerSaveRequest{
        @NotBlank
        private String name;

        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String address;

        @NotBlank
        @Pattern(regexp = "\\d{10}")
        private String phoneNumber;

        public CustomerSaveRequest() {
        }

        public CustomerSaveRequest(String name, String email, String address, String phoneNumber) {
            this.name = name;
            this.email = email;
            this.address = address;
            this.phoneNumber = phoneNumber;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

    static class BillDetailSaveRequest{
        private SelectOptionRequest product;

        private String price;
        private String quantity;

        public BillDetailSaveRequest() {
            product = new SelectOptionRequest();
        }

        public SelectOptionRequest getProduct() {
            return product;
        }

        public void setProduct(SelectOptionRequest product) {
            this.product = product;
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
    }
}
