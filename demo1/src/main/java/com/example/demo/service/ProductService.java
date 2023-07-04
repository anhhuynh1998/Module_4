package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {
    private final ProductRepository productRepository;

    public static List<Product> products;
    static {
        products = new ArrayList<>();
    }

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
       return products;
    }
    public void add(Product product){
       int  id= products.get(products.size()-1).getId() +1;
        product.setId(id);
        products.add(product);
    }


    public void update(Product product){
        for(Product p:products){
            if (p.getId()==product.getId()){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setQuantity(product.getQuantity());
                p.setCategory(product.getCategory());
                break;
            }
        }

    }

    public Product findById(int id) {
        for(Product p:products){
            if (p.getId()==id){
              return p;
            }
        }
        return null;
    }

    public void  delete(int id) {
        for (Product a : products) {
            if (a.getId() == id) {
                products.remove(a);
                break;
            }
        }
    }
    public Page<Product> getPageProduct(Pageable pageable){
        return productRepository.findAll(pageable);
    }
}
