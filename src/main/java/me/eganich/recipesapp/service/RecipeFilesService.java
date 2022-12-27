package me.eganich.recipesapp.service;

public interface RecipeFilesService {

    public boolean saveRecipeToFile(String json);

    public String readRecipeFromFile();


    public boolean cleanDataFile();
}
