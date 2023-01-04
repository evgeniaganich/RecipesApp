package me.eganich.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String ingredientName;
    private int number;
    private String measureUnit;

    @Override
    public String toString() {
        return ingredientName + ": " + number + " " + measureUnit;
    }
}
