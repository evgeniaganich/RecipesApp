package me.eganich.recipesapp.service;

import org.springframework.stereotype.Service;

@Service
public interface RecipeFilesService {

    boolean saveRecipeToFile(String json);

    String readRecipeFromFile();


    boolean cleanDataFile();
}
