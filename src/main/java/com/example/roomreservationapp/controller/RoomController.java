package com.example.roomreservationapp.controller;

import com.example.roomreservationapp.model.Category;
import com.example.roomreservationapp.model.Room;
import com.example.roomreservationapp.service.CategoryService;
import com.example.roomreservationapp.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/quartos")
public class RoomController {

    private final RoomService roomService;
    private final CategoryService categoryService;

    public RoomController(RoomService roomService, CategoryService categoryService) {
        this.roomService = roomService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms/index";
    }

    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model) {
        List<Category> categorias = categoryService.getAllCategories();
        model.addAttribute("categorias", categorias);
        return "rooms/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvarSala(@RequestParam String number, @RequestParam List<Long> categoryIds) {
        Set<Category> categoriasSelecionadas = new HashSet<>();
        for (Long categoryId : categoryIds) {
            categoriasSelecionadas.add(categoryService.buscarPorId(categoryId));
        }

        Room room = new Room();
        room.setNumber(number);
        room.setCategories(categoriasSelecionadas);
        roomService.salvarRoom(room);

        return "redirect:/quartos";
    }
}
