package me.eganich.recipesapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.eganich.recipesapp.model.Ingredient;
import me.eganich.recipesapp.model.WrongIngredientException;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.PostConstruct;
import java.sql.Array;
import java.util.*;

@org.springframework.stereotype.Service
public class IngredientServiceImpl implements IngredientService {
    private Map<Integer, Ingredient> ingredients = new HashMap<>();
    private int counter = 1;

    private final IngredientFilesService ingredientFilesService;

    public IngredientServiceImpl(IngredientFilesService ingredientFilesService) {
        this.ingredientFilesService = ingredientFilesService;
    }
    @PostConstruct
    private void init() {
        readIngredientFromFile();
    }
    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        if (StringUtils.isBlank(ingredient.getIngredientName())) {
            throw new WrongIngredientException("Необходимо указать название ингредиента!");
        }
        ingredients.put(counter++, ingredient);

        return ingredient;
    }

    @Override
    public Ingredient getIngredient(int id) {
        if (!ingredients.containsKey(id)) {
            throw new WrongIngredientException("Такого ингредиента нет в базе данных");
        }
        return ingredients.get(id);
    }

    @Override
    public Collection<Ingredient> getAll() {
        return ingredients.values();
    }
    @Override
    public Ingredient updateIngredient(int id, Ingredient ingredient) {
        Ingredient updatedIngredient = ingredients.get(id);
        if (updatedIngredient == null) {
            throw new WrongIngredientException("Такого ингредиента нет в списке");
        }
        updatedIngredient.setMeasureUnit(ingredient.getMeasureUnit());
        updatedIngredient.setNumber(ingredient.getNumber());
        return updatedIngredient;
    }
    @Override
    public Ingredient removeIngredient(int id) {
        return ingredients.remove(id);

    }
    private void saveIngredientToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            ingredientFilesService.saveIngredientToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private void readIngredientFromFile(){
        String json = ingredientFilesService.readIngredientFromFile();
        try {
            ingredients = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
