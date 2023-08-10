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

import java.math.BigDecimal;

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
        bill.setCustomerName(request.getCustomer().getName());
        bill.setStatus(Status.PAID);
        var totalAmount = BigDecimal.ZERO;
        for (var item: bill.getBillDetails()) {
            var product = productRepository.findById(item.getProduct().getId()).orElseThrow();
            item.setPrice(product.getPrice());
            item.setNameProduct(product.getNameProduct());
            item.setBill(bill);
            totalAmount = totalAmount
                    .add(product.getPrice()
                            .multiply(new BigDecimal(item.getQuantity())));
        }
        bill.setTotalAmount(totalAmount);
        Customer customer = customerRepository.findCustomerByPhone(request.getCustomer().getPhone()).orElse(null);
        if(customer != null){
            bill.getCustomer().setId(customer.getId());
            //
        }
        customer = bill.getCustomer();

        bill.setCustomer(customerRepository.save(customer));

        billRepository.save(bill);
    }

}
