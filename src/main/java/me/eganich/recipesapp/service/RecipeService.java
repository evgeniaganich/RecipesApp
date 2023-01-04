package me.eganich.recipesapp.service;

import me.eganich.recipesapp.model.Recipe;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

public interface RecipeService {

    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(int id);

    Collection<Recipe> getAll();

    Recipe updateRecipe(int id, Recipe recipe);

    Recipe removeRecipe(int id);

    Path createRecipesFile() throws IOException;
}
