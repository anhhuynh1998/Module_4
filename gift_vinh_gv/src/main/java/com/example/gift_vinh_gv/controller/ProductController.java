package com.example.gift_vinh_gv.controller;
import com.example.gift_vinh_gv.model.Category;
import com.example.gift_vinh_gv.model.Product;
import com.example.gift_vinh_gv.repository.CategoryRepository;
import com.example.gift_vinh_gv.repository.ProductRepository;
import com.example.gift_vinh_gv.service.product.ProductService;
import com.example.gift_vinh_gv.service.product.request.ProductSaveRequest;
import com.example.gift_vinh_gv.service.product.request.SelectOptionRequest;
import com.example.gift_vinh_gv.service.product.response.ProductListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductService productService;

    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView view = new ModelAndView("/products/create");
        view.addObject("categories", categoryRepository.findAll());
        view.addObject("product", new ProductSaveRequest("","", "", new SelectOptionRequest("")));
        return view;
    }

    @PostMapping("/create")
    public String showFormCreate(@ModelAttribute("product") ProductSaveRequest product, Model model){
        productService.create(product);

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("product", product);
        return "/products/create";
    }

    @GetMapping
    public String showProduct(@RequestParam(defaultValue = "") String search, @PageableDefault(size = 3) Pageable pageable, Model model){
//        model.addAttribute("products", productService.findAllWithSearchAndPaging(search, pageable));
        return "index";
    }
//    @GetMapping
//    public String showProducts(Model model) {
//        model.addAttribute("products", productRepository.findAll());
//        return "index";
//    }
}