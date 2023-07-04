package com.example.gift_vinh_gv.service.bill;

import com.example.gift_vinh_gv.model.Bill;
import com.example.gift_vinh_gv.model.Customer;
import com.example.gift_vinh_gv.model.eNum.Status;
import com.example.gift_vinh_gv.repository.BillRepository;
import com.example.gift_vinh_gv.repository.CustomerRepository;
import com.example.gift_vinh_gv.repository.ProductRepository;
import com.example.gift_vinh_gv.service.bill.request.BillSaveRequest;
import com.example.gift_vinh_gv.utils.AppUtils;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    private final ProductRepository productRepository;

    private final BillRepository billRepository;
    private final CustomerRepository  customerRepository;

    public BillService(ProductRepository productRepository, BillRepository billRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.billRepository = billRepository;
        this.customerRepository = customerRepository;
    }


    public void create(BillSaveRequest request){
        //check phonenumber of customer
        // if exist update field
        // else create
        Bill bill = AppUtils.mapper.map(request, Bill.class);
        for (var item: bill.getBillDetails()) {
            var product = productRepository.findById(item.getProduct().getId()).orElseThrow();
            item.setPrice(product.getPrice());
            item.setNameProduct(product.getNameProduct());
        }
        bill.setStatus(Status.PAID) ;
       billRepository.save(bill);
    }
}
