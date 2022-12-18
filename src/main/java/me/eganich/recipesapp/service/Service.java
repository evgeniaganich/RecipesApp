package me.eganich.recipesapp.service;

import me.eganich.recipesapp.model.Ingredient;
import me.eganich.recipesapp.model.Recipe;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service

public class Service {

private final Map<Integer, Recipe> recipes = new HashMap<>();
private final Map<Integer, Ingredient> ingredients = new HashMap<>();


    public Recipe addRecipe(Recipe recipe) {
        if (recipes.containsKey(recipe.getId())) {
            throw new RuntimeException("Такой рецепт уже есть в списке");
        } else {
            recipes.put(recipe.getId(), recipe);
        }
        return recipe;
    }


    public Ingredient addIngredient(Ingredient ingredient) {
        if (ingredients.containsKey(ingredient.getId())) {
            throw new RuntimeException("Такой рецепт уже есть в списке");
        } else {
            ingredients.put(ingredient.getId(), ingredient);
        }
        return ingredient;
    }


    public Recipe getRecipe(int id) {
        if (recipes.containsKey(id)) {
            return recipes.get(id);
        } else {
            throw new RuntimeException("Такого рецепта нет в базе данных");
        }
    }


    public Ingredient getIngredient(int id) {
        if (ingredients.containsKey(id)) {
            return ingredients.get(id);
        } else {
            throw new RuntimeException("Такого ингредиента нет в базе данных");
        }
    }
}
