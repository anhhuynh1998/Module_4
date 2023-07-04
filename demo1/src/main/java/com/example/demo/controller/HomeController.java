package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class HomeController {
    @Autowired
    private  ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public HomeController(ProductService productService, ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productService = productService;
        this.productRepository =productRepository;
        this.categoryRepository= categoryRepository;
    }
    @GetMapping("/search")
    public String searchAll(@RequestParam("search") String search,Model model){

         model.addAttribute("products",productRepository.searchAllByNameContainingOrCategory_NameContaining(search,search));
         model.addAttribute("search",search);
        return "index";
    }


    @GetMapping
    public String getIndex(Model model, Pageable pageable) {
        int sizePage= 2;
        pageable = PageRequest.of(pageable.getPageNumber(),sizePage);
        Page<Product> productPage = productService.getPageProduct(pageable);
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", productPage.getNumber());
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("products",productPage);
        model.addAttribute("pageable",pageable);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
       model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("product") Product product,BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("categories",categoryRepository.findAll());
            return "create";
        }
        Category category = categoryRepository.findById(product.getCategory().getId()).get();
        product.setCategory(category);
        productRepository.save(product);
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("product",product);
        model.addAttribute("message","ÂU Kê BRO");
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id,Model model) {
        Product product = productRepository.findById(id).get();
        List<Category> categories = categoryRepository.findAll();
        productRepository.save(product);
        model.addAttribute("product", product);
        model.addAttribute("categories",categories);
        return "edit";
    }
    @PostMapping("/edit")
    public String updateProduct(@Valid @ModelAttribute("product") Product product,BindingResult result,Model model){
        if (result.hasErrors()){
            model.addAttribute("categories",categoryRepository.findAll());
            return "edit";
        }
        Category category = categoryRepository.findById(product.getCategory().getId()).get();
        product.setCategory(category);
        model.addAttribute("product", product);
        model.addAttribute("message","Âu Kê");
        productRepository.save(product);
        return "edit";
}
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") int id,Model model) {
      productRepository.deleteById(id);
        return "redirect:/products";
    }
}
