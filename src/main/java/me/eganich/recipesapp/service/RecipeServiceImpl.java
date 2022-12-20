package me.eganich.recipesapp.service;

import me.eganich.recipesapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final Map<Integer, Recipe> recipes = new HashMap<>();

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipes.put(recipe.getId(), recipe);
        return recipe;
    }

    @Override
    public Recipe getRecipe(int id) {
        if (!recipes.containsKey(id)) {
            throw new RuntimeException("Такого рецепта нет в базе данных");
        }
        return recipes.get(id);
    }
}
