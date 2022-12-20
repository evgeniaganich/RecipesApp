package me.eganich.recipesapp.controller;

import me.eganich.recipesapp.model.Recipe;
import me.eganich.recipesapp.service.RecipeService;
import me.eganich.recipesapp.service.RecipeServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }
    @GetMapping("{id}")
    public Recipe getRecipe(@PathVariable int id) {
        return this.service.getRecipe(id);
    }
    @PostMapping()
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return this.service.addRecipe(recipe);
    }
}
