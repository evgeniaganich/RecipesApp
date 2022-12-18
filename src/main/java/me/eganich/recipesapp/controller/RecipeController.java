package me.eganich.recipesapp.controller;

import me.eganich.recipesapp.model.Recipe;
import me.eganich.recipesapp.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final Service service;

    public RecipeController(Service service) {
        this.service = service;
    }
    @GetMapping("/getRecipe/{id}")
    public Recipe getRecipe(@PathVariable int id) {
        return this.service.getRecipe(id);
    }
    @PostMapping("/addRecipe")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return this.service.addRecipe(recipe);
    }
}
