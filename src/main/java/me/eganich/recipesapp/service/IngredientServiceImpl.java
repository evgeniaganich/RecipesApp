package me.eganich.recipesapp.service;

import me.eganich.recipesapp.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class IngredientServiceImpl implements IngredientService {
    private final Map<Integer, Ingredient> ingredients = new HashMap<>();

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(ingredient.getId(), ingredient);
        return ingredient;
    }

    @Override
    public Ingredient getIngredient(int id) {
        if (!ingredients.containsKey(id)) {
            throw new RuntimeException("Такого рецепта нет в базе данных");
        }
        return ingredients.get(id);
    }
}
