package me.eganich.recipesapp.service;

import me.eganich.recipesapp.model.Recipe;

public interface RecipeService {

    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(int id);
}
