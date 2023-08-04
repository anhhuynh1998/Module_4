package com.example.gift_vinh_gv.service.producimport.request;

import com.example.gift_vinh_gv.service.customer.request.CustomerSaveRequest;
import jakarta.validation.Valid;

public class ProductImportSaveRequest {
    private @Valid CustomerSaveRequest customerSaveRequest;
    private String dateAdded;
    private String couponCode;
    private
}
