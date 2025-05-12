package com.example.roomreservationapp.controller;

import com.example.roomreservationapp.model.Category;
import com.example.roomreservationapp.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Category categoria = categoryService.buscarPorId(id);
        if (categoria == null) {
            return "redirect:/categorias";
        }
        model.addAttribute("categoria", categoria);
        return "categorias/editar";
    }

    @PostMapping("/editar")
    public String editarCategoria(@RequestParam Long id, @RequestParam String name) {
        Category categoria = categoryService.buscarPorId(id);
        if (categoria != null) {
            categoria.setName(name);
            categoryService.salvarCategoria(categoria);
        }
        return "redirect:/categorias";
    }

    @GetMapping("/excluir")
    public String excluirCategoria(@RequestParam Long id) {
        categoryService.excluirCategoria(id);
        return "redirect:/categorias";
    }

}
