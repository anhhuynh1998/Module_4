package com.example.gift_vinh_gv.controller.rest;
import com.example.gift_vinh_gv.service.product.ProductService;
import com.example.gift_vinh_gv.service.product.request.ProductSaveRequest;
import com.example.gift_vinh_gv.service.product.response.ProductListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductListResponse> findAll(@RequestParam(defaultValue = "") String search,
                                             @RequestParam(defaultValue = "0", required = false) String priceMin,
                                             @RequestParam(defaultValue = "10000") String priceMax,

                                             Pageable pageable){

        return productService.findAllWithSearchAndPaging(search, priceMin, priceMax, pageable);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProductSaveRequest request){
        productService.create(request);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid ProductSaveRequest request, @PathVariable Integer id){
        productService.update(request, id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
