package com.example.gift_vinh_gv.service.productimport.request;

import com.example.gift_vinh_gv.service.bill.request.BillSaveRequest;
import com.example.gift_vinh_gv.service.product.request.SelectOptionRequest;
import com.example.gift_vinh_gv.service.product.request.SelectOptionRequest;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;
@NoArgsConstructor
@Data
public class ProductImportSaveRequest {
    private String importDate;

    private @Valid SelectOptionRequest customer;

    private String couponCode;

    private List<@Valid ProductImportDetailSaveRequest> productImportDetails;

    @NoArgsConstructor
    @Data
    public static class ProductImportDetailSaveRequest{
        private SelectOptionRequest product;

        private String price;
        private String quantity;

        private String color;

        private String size;


    }
}
