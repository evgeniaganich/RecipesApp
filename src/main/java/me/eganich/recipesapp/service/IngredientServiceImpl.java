package me.eganich.recipesapp.service;

import me.eganich.recipesapp.model.Ingredient;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class IngredientServiceImpl implements IngredientService {
    private final Map<Integer, Ingredient> ingredients = new HashMap<>();

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(ingredient.getId(), ingredient);
        return ingredient;
    }

    @Override
    public Ingredient getIngredient(int id) {
        if (!ingredients.containsKey(id)) {
            throw new RuntimeException("Такого рецепта нет в базе данных");
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
            throw new RuntimeException("Такого ингредиента нет в списке");
        }
        updatedIngredient.setMeasureUnit(ingredient.getMeasureUnit());
        updatedIngredient.setNumber(ingredient.getNumber());
        return updatedIngredient;
    }
    @Override
    public Ingredient removeIngredient(int id) {
        return ingredients.remove(id);

    }
}
