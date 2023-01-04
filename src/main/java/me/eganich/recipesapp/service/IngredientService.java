package me.eganich.recipesapp.service;

import me.eganich.recipesapp.model.Ingredient;

import java.util.Collection;

public interface IngredientService {
    Ingredient addIngredient(Ingredient ingredient);

    Ingredient getIngredient(int id);

    Collection<Ingredient> getAll();

    Ingredient updateIngredient(int id, Ingredient ingredient);

    Ingredient removeIngredient(int id);



}
