package me.eganich.recipesapp.service;

import me.eganich.recipesapp.model.Ingredient;

public interface IngredientService {
    Ingredient addIngredient(Ingredient ingredient);

    Ingredient getIngredient(int id);
}
