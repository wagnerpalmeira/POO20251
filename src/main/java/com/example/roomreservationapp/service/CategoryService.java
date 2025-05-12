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

    public Category buscarPorId(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void excluirCategoria(Long id) {
        categoryRepository.deleteById(id);
    }

}
