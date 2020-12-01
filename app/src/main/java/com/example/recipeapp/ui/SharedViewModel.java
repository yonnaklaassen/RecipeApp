package com.example.recipeapp.ui;

import com.example.recipeapp.roomDatabase.RecipeEntity;
import com.example.recipeapp.webservice.RecipeResponse;

public class SharedViewModel {

    private RecipeEntity recipeEntity;
    private RecipeResponse.Meal meal;
    private static SharedViewModel instance;

    private SharedViewModel()
    {

    }

    public static SharedViewModel getInstance()
    {
        if(instance == null)
        {
            instance = new SharedViewModel();
        }
        return instance;
    }

    public void saveMeal(RecipeResponse.Meal meal)
    {
        this.meal = meal;
    }

    public void saveRecipe(RecipeEntity recipeEntity) {
        this.recipeEntity = recipeEntity;
    }

    public RecipeEntity getRecipeEntity() {
        return recipeEntity;
    }

    public RecipeResponse.Meal getMeal() {
        return meal;
    }
}
