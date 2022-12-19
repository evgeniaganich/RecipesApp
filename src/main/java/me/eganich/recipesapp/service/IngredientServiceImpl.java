package me.eganich.recipesapp.service;

import me.eganich.recipesapp.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class IngredientServiceImpl implements IngredientService {
    private final Map<Integer, Ingredient> ingredients = new HashMap<>();

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        if (ingredients.containsKey(ingredient.getId())) {
            throw new RuntimeException("Такой рецепт уже есть в списке");
        } else {
            ingredients.put(ingredient.getId(), ingredient);
        }
        return ingredient;
    }

    @Override
    public Ingredient getIngredient(int id) {
        if (ingredients.containsKey(id)) {
            return ingredients.get(id);
        } else {
            throw new RuntimeException("Такого ингредиента нет в базе данных");
        }
    }
}
