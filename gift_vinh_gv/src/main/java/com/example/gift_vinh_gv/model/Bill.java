package com.example.gift_vinh_gv.model;

import com.example.gift_vinh_gv.model.eNum.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dayBuy;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "bill")
    private Set<BillDetail> billDetails;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Bill() {
    }

    public Bill(int id, LocalDate dayBuy, Customer customer, Set<BillDetail> billDetails, Status status) {
        this.id = id;
        this.dayBuy = dayBuy;
        this.customer = customer;
        this.billDetails = billDetails;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDayBuy() {
        return dayBuy;
    }

    public void setDayBuy(LocalDate dayBuy) {
        this.dayBuy = dayBuy;
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
