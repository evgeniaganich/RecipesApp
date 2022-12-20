package me.eganich.recipesapp.controller;

import me.eganich.recipesapp.model.Ingredient;
import me.eganich.recipesapp.service.IngredientService;
import me.eganich.recipesapp.service.IngredientServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable int id) {
        return this.service.getIngredient(id);
    }
    @PostMapping()
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return this.service.addIngredient(ingredient);
    }
}
