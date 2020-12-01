package com.example.recipeapp.model;


public class Recipe {

    private String mealName;
    private String category;
    private String ingredients;
    private String instructions;

    public Recipe(String mealName, String category, String ingredients, String instructions) {
        this.mealName = mealName;
        this.category = category;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getMealName() {
        return mealName;
    }

    public String getCategory() {
        return category;
    }


    public String getInstructions() {
        return instructions;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
