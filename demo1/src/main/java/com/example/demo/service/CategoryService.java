package com.example.demo.service;

import com.example.demo.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CategoryService {
    public static List<Category> categories;
    public CategoryService(){
        categories.add(new Category(1,"sách"));
        categories.add(new Category(2,"vở"));
        categories.add(new Category(3,"quần"));
    }
    static {
        categories = new ArrayList<>();
    }

    public  List<Category> getCategories() {
        return categories;
    }
    public Category findById(int id){
        for (Category c: categories) {
            if (c.getId()==id){
                return c;
            }
        }
        return null;
    }
}
