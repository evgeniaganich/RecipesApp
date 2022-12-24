package me.eganich.recipesapp.model;

import lombok.Data;

import java.util.List;
@Data
public class Recipe {
    private String recipeName;
    private int timeOfCooking;
    private List<Ingredient> ingredientList;
    private List<String> steps;
    private int id;


}
