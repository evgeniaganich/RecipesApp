package me.eganich.recipesapp.service;

import org.springframework.stereotype.Service;

@Service
public interface IngredientFilesService {

    boolean saveIngredientToFile(String json);

    String readIngredientFromFile();

    boolean cleanDataFile();
}
