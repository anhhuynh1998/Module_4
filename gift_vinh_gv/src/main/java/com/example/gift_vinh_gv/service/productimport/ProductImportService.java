package com.example.gift_vinh_gv.service.productimport;

import com.example.gift_vinh_gv.model.ProductImport;
import com.example.gift_vinh_gv.repository.CustomerRepository;
import com.example.gift_vinh_gv.repository.ProductImportRepository;
import com.example.gift_vinh_gv.service.product.response.ProductListResponse;
import com.example.gift_vinh_gv.service.productimport.reponse.ProductImportListResponse;
import com.example.gift_vinh_gv.service.productimport.request.ProductImportSaveRequest;
import com.example.gift_vinh_gv.utils.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductImportService {
    private final CustomerRepository customerRepository;

    private final ProductImportRepository productImportRepository;
    public Page<ProductImportListResponse> findAllWithSearchAndPagingImport(String search, Pageable pageable){
        return productImportRepository
                .findAllByCustomerName_NameContainingOrCouponCodeContaining(search, search,pageable)
                .map(product -> {
                    var response = AppUtils.mapper.map(product, ProductImportListResponse.class);
                    response.setCustomerName(product.getCustomerName().getName());
                    return response;
                });
    }

    public void create(ProductImportSaveRequest request){
        ProductImport productImport = AppUtils.mapper.map(request, ProductImport.class);
//        for (var item : productImport.getProductImportDetails()) {
//            item.setProductImport(productImport);
//        }
        productImport.getProductImportDetails().forEach(e -> {
            e.setProductImport(productImport);
        });
        productImportRepository.save(productImport);
    }
   public void update(ProductImportSaveRequest request,int id){
       ProductImport newProductImport = AppUtils.mapper.map(request,ProductImport.class);
       newProductImport.setId(id);
       productImportRepository.save(newProductImport);
   }
    public void delete(int id){
        productImportRepository.deleteById(id);
    }
}
