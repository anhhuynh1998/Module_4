package com.example.gift_vinh_gv.model;

import com.example.gift_vinh_gv.model.eNum.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerName;

    private LocalDate dateBought;

    private BigDecimal totalAmount;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "bill")
    private Set<BillDetail> billDetails;
    @Enumerated(EnumType.STRING)
    private Status status;



    public Bill() {
    }


    public Bill(int id, String customerName, LocalDate dateBought, BigDecimal totalAmount, Customer customer, Set<BillDetail> billDetails, Status status) {
        this.id = id;
        this.customerName = customerName;
        this.dateBought = dateBought;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.billDetails = billDetails;
        this.status = status;
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

    public LocalDate getDateBought() {
        return dateBought;
    }

    public void setDateBought(LocalDate dateBought) {
        this.dateBought = dateBought;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(Set<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
