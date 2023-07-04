package com.example.gift_vinh_gv.controller;

import com.example.gift_vinh_gv.repository.ProductRepository;
import com.example.gift_vinh_gv.service.bill.BillService;
import com.example.gift_vinh_gv.service.bill.request.BillSaveRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;

    private final ProductRepository productRepository;

    public BillController(BillService billService, ProductRepository productRepository) {
        this.billService = billService;
        this.productRepository = productRepository;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView view = new ModelAndView("create");
        view.addObject("bill", new BillSaveRequest());
        view.addObject("products", productRepository.findAll());
        return view;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("bill") @Valid BillSaveRequest bill, BindingResult result){
        ModelAndView view = new ModelAndView("create");
        view.addObject("products", productRepository.findAll());
        if(result.hasErrors()){
            return view;
        }
        billService.create(bill);
        view.addObject("bill", new BillSaveRequest());
        return view;
    }
}
