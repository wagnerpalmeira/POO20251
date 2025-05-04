package com.example.roomreservationapp.controller;

import com.example.roomreservationapp.model.Category;
import com.example.roomreservationapp.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categorias")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categorias", categoryService.getAllCategories());
        return "categorias/index";
    }

    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro() {
        return "categorias/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvarCategoria(@RequestParam String name) {
        Category categoria = new Category();
        categoria.setName(name);
        categoryService.salvarCategoria(categoria);
        return "redirect:/categorias";
    }
}
