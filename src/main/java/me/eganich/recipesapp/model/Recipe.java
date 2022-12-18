package me.eganich.recipesapp.model;

import java.util.List;

public class Recipe {
    private final String recipeName;
    private final int timeOfCooking;
    private final List<Ingredient> ingredientList;
    private final List<String> steps;

    private final int id;
    private static int counter = 1;

    public Recipe(String recipeName, int timeOfCooking, List<Ingredient> ingredientList, List<String> steps) {
        if (recipeName == null) {
            throw new RuntimeException("Необходимо указать название рецепта");
        } else {
            this.recipeName = recipeName;
        }
        if (timeOfCooking <= 0) {
            throw new RuntimeException("Время приготовления не может быть меньше или равно 0");
        } else {
            this.timeOfCooking = timeOfCooking;
        }
        this.ingredientList = ingredientList;
        this.steps = steps;
        this.id = counter++;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getTimeOfCooking() {
        return timeOfCooking;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public List<String> getSteps() {
        return steps;
    }

    public int getId() {
        return id;
    }
}
