package me.eganich.recipesapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.eganich.recipesapp.model.Recipe;
import me.eganich.recipesapp.model.WrongRecipeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeFilesService recipeFilesService;
    private Map<Integer, Recipe> recipes = new HashMap<>();
    private int counter = 1;

    public RecipeServiceImpl(RecipeFilesService recipeFilesService) {
        this.recipeFilesService = recipeFilesService;
    }


    @PostConstruct
    private void init() {
        readRecipeFromFile();
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        if (StringUtils.isBlank(recipe.getRecipeName())) {
            throw new WrongRecipeException("Необходимо указать название рецепта!");
        }
        recipes.put(counter++, recipe);
        saveRecipeToFile();
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
        saveRecipeToFile();
        return updatedRecipe;
    }
    @Override
    public Recipe removeRecipe(int id) {
        return recipes.remove(id);
    }
    private void saveRecipeToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            RecipeFilesService.saveRecipeToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private void readRecipeFromFile(){
        String json = RecipeFilesService.readRecipeFromFile();
        try {
            recipes = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
