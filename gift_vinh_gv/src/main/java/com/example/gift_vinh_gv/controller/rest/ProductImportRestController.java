package com.example.gift_vinh_gv.controller.rest;

import com.example.gift_vinh_gv.repository.ProductImportRepository;
import com.example.gift_vinh_gv.service.productimport.ProductImportService;
import com.example.gift_vinh_gv.service.productimport.reponse.ProductImportListResponse;
import com.example.gift_vinh_gv.service.productimport.request.ProductImportSaveRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product-imports")
@AllArgsConstructor
public class ProductImportRestController {
    private final ProductImportService productImportService;
    private final ProductImportRepository productImportRepository;

//    @GetMapping
//    public Map<String, Object> findAll(@RequestParam(defaultValue = "") String search, Integer page, Integer size) {
//        List<ProductImport> list = productImportRepository.findAll();
//        Map<String, Object> resp = new HashMap<>();
//        resp.put("content",list);
//        resp.put("totalPage",2);
//        return resp;
//    }
@GetMapping
public Page<ProductImportListResponse> findAll(@RequestParam(defaultValue = "") String search, Pageable pageable){
    return productImportService.findAllWithSearchAndPagingImport(search, pageable);
}
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProductImportSaveRequest request) {
        productImportService.create(request);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody @Valid ProductImportSaveRequest request, @PathVariable Integer id){
        productImportService.update(request, id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        productImportService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
