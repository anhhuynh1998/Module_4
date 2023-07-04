package com.example.demo.validate;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
@Component
public class ContactNumberValidator implements ConstraintValidator<ValidateCatagoryId, Integer> {
  private final CategoryRepository categoryRepository;

    public ContactNumberValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initialize(ValidateCatagoryId constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer category, ConstraintValidatorContext constraintValidatorContext) {
        if (category== null){
            return false;
        }
       return categoryRepository.existsById(category);
    }


}
