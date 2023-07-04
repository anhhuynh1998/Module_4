package com.example.gift_vinh_gv.model.eNum;

public enum Status {
    PAID(1),
    UNPAID(2);
    private int index;
    Status(int index){
        this.index = index;
    }

}
