package com.example.gift_vinh_gv.service.product;
import com.example.gift_vinh_gv.model.Product;
import com.example.gift_vinh_gv.repository.ProductRepository;
import com.example.gift_vinh_gv.service.product.request.ProductSaveRequest;
import com.example.gift_vinh_gv.service.product.response.ProductListResponse;
import com.example.gift_vinh_gv.utils.AppUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductListResponse> findAllWithSearchAndPaging(String search, String priceMin, String priceMax, Pageable pageable){
        List<Product> products = productRepository.findAll();
        search  = "%" + search + "%";
        return productRepository
                .searchEverything(search,
                        new BigDecimal(priceMin), new BigDecimal(priceMax),pageable)
                .map(product -> {
                    var response = AppUtils.mapper.map(product, ProductListResponse.class);
                    response.setCategoryName(product.getCategory().getName());
                    return response;
                });
    }

    public void create(ProductSaveRequest request){
        Product newProduct = AppUtils.mapper.map(request, Product.class);
        productRepository.save(newProduct);
    }
    public void update(ProductSaveRequest request, int id){
        Product newProduct = AppUtils.mapper.map(request, Product.class);
        newProduct.setId(id);
        productRepository.save(newProduct);
    }

    public void delete(int id){
        productRepository.deleteById(id);
    }
}
