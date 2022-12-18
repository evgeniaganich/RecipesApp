package me.eganich.recipesapp.model;

public class Ingredient {
    private final String ingredientName;
    private final int number;
    private final String measureUnit;

    private static int counter = 1;

    private final int id;

    public Ingredient(String ingredientName, int number, String measureUnit) {
        if (ingredientName == null) {
            throw new RuntimeException("Необходимо указать название ингредиента");
        } else {
            this.ingredientName = ingredientName;
        }
        if (number <= 0) {
            throw new RuntimeException("Количество ингредиентов не может быть меньше или равно 0");
        } else {
            this.number = number;
        }
        if (measureUnit == null) {
            throw new RuntimeException("Необходимо указать единицу измерения для ингредиента");
        } else {
            this.measureUnit = measureUnit;
        }
        this.id = counter++;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getNumber() {
        return number;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public int getId() {
        return id;
    }
}
