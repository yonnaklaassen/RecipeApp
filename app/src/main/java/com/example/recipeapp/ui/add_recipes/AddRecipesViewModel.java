package com.example.recipeapp.ui.add_recipes;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.recipeapp.repository.RecipeRepository;
import com.example.recipeapp.roomDatabase.RecipeEntity;

public class AddRecipesViewModel extends AndroidViewModel {

    private RecipeRepository recipeRepository;

    public AddRecipesViewModel(Application application) {
        super(application);
        recipeRepository = RecipeRepository.getInstance(application);
    }

    public void insertRecipe(RecipeEntity recipeEntity)
    {
        recipeRepository.insertRecipeAsync(recipeEntity);
    }
}
