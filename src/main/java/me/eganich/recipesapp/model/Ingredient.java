package me.eganich.recipesapp.model;

import lombok.Data;

@Data
public class Ingredient {
    private final String ingredientName;
    private int number;
    private String measureUnit;
    private final int id;

}
