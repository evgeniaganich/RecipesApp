package me.eganich.recipesapp.controller;

import me.eganich.recipesapp.model.Ingredient;
import me.eganich.recipesapp.model.Recipe;
import me.eganich.recipesapp.service.RecipeService;
import me.eganich.recipesapp.service.RecipeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        return ResponseEntity.ok().body(service.getRecipe(id));
    }
    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok().body(service.addRecipe(recipe));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(service.removeRecipe(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") int id, @RequestBody Recipe recipe) {
        return ResponseEntity.ok().body(service.updateRecipe(id, recipe));
    }
    @GetMapping
    public ResponseEntity<Collection<Recipe>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}
