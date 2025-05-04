package com.example.roomreservationapp.service;

import com.example.roomreservationapp.model.Category;
import com.example.roomreservationapp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void salvarCategoria(Category categoria) {
        categoryRepository.save(categoria);
    }
}
