package me.eganich.recipesapp.service;

import me.eganich.recipesapp.model.Recipe;
import me.eganich.recipesapp.model.WrongRecipeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final Map<Integer, Recipe> recipes = new HashMap<>();
    private int counter = 1;

    @Override
    public Recipe addRecipe(Recipe recipe) {
        if (StringUtils.isBlank(recipe.getRecipeName())) {
            throw new WrongRecipeException("Необходимо указать название рецепта!");
        }
        recipes.put(counter++, recipe);
        return recipe;
    }

    @Override
    public Recipe getRecipe(int id) {
        if (!recipes.containsKey(id)) {
            throw new WrongRecipeException("Такого рецепта нет в базе данных");
        }
        return recipes.get(id);
    }
    @Override
    public Collection<Recipe> getAll() {
        return recipes.values();
    }
    @Override
    public Recipe updateRecipe(int id, Recipe recipe) {
        Recipe updatedRecipe = recipes.get(id);
        if (updatedRecipe == null) {
            throw new WrongRecipeException("Такого рецепта нет в списке");
        }
        updatedRecipe.setSteps(recipe.getSteps());
        updatedRecipe.setIngredientList(recipe.getIngredientList());
        updatedRecipe.setTimeOfCooking(recipe.getTimeOfCooking());
        return updatedRecipe;
    }
    @Override
    public Recipe removeRecipe(int id) {
        return recipes.remove(id);
    }
}
