package me.eganich.recipesapp.controller;

import me.eganich.recipesapp.model.Ingredient;
import me.eganich.recipesapp.model.Recipe;
import me.eganich.recipesapp.service.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final Service service;

    public IngredientController(Service service) {
        this.service = service;
    }
    @GetMapping("/getIngredient/{id}")
    public Ingredient getIngredient(@PathVariable int id) {
        return this.service.getIngredient(id);
    }
    @PostMapping("/addIngredient")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return this.service.addIngredient(ingredient);
    }
}
