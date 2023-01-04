package me.eganich.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String recipeName;
    private int timeOfCooking;
    private List<Ingredient> ingredientList;
    private List<String> steps;


    public StringBuilder stepsToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < steps.size(); i++)
        sb.append(steps.get(i) + '\n');
        return sb;
    }
    public StringBuilder ingredientsToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ingredientList.size(); i++)
            sb.append(ingredientList.get(i).toString() + '\n');
        return sb;
    }

}
