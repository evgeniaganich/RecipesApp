package me.eganich.recipesapp.controller;

import me.eganich.recipesapp.model.Ingredient;
import me.eganich.recipesapp.model.Recipe;
import me.eganich.recipesapp.service.IngredientService;
import me.eganich.recipesapp.service.IngredientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int id) {
        return ResponseEntity.ok().body(service.getIngredient(id));
    }
    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok().body(service.addIngredient(ingredient));
    }
    @GetMapping
    public ResponseEntity<Collection<Ingredient>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredient> deleteIngredient(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(service.removeIngredient(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateRecipe(@PathVariable("id") int id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.ok().body(service.updateIngredient(id, ingredient));
    }
}
