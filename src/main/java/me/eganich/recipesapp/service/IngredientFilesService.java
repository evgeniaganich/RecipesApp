package me.eganich.recipesapp.service;

import org.springframework.stereotype.Service;

import java.io.File;


public interface IngredientFilesService {

    boolean saveIngredientToFile(String json);

    String readIngredientFromFile();

    boolean cleanDataFile();

    File getDataFile();
}
