package com.example.gift_vinh_gv.controller;

import com.example.gift_vinh_gv.model.eNum.Color;
import com.example.gift_vinh_gv.model.eNum.Size;
import com.example.gift_vinh_gv.repository.CustomerRepository;
import com.example.gift_vinh_gv.repository.ProductImportRepository;
import com.example.gift_vinh_gv.repository.ProductRepository;
import com.example.gift_vinh_gv.service.productimport.ProductImportService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product-imports")
@AllArgsConstructor
public class ProductImportController {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final ProductImportService productImportService;

    @GetMapping
    public ModelAndView showCreateForm() {
        ModelAndView view = new ModelAndView("/product-import/list");
        view.addObject("customers", customerRepository.findAll());
        view.addObject("products", productRepository.findAll());
        view.addObject("sizes", Size.values());
        view.addObject("colors", Color.values());
        return view;
    }
    @GetMapping("/import")
    public ModelAndView showProductImport(@RequestParam(defaultValue = "") String search,
                                          @PageableDefault(size = 2) Pageable pageable, Model model) {
        ModelAndView modelAndView = new ModelAndView("/product-import/import");
        modelAndView.addObject("customers", customerRepository.findAll());
        modelAndView.addObject("products", productRepository.findAll());
        modelAndView.addObject("sizes", Size.values());
        modelAndView.addObject("colors", Color.values());
        return modelAndView;
    }
}
