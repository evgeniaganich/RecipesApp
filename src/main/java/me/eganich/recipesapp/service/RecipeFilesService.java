package me.eganich.recipesapp.service;

import org.springframework.stereotype.Service;

import java.io.File;


public interface RecipeFilesService {

    boolean saveRecipeToFile(String json);

    String readRecipeFromFile();


    boolean cleanDataFile();

    File getDataFile();
}
