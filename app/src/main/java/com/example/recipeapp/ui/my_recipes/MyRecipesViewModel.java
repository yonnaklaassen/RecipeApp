package com.example.recipeapp.ui.my_recipes;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.recipeapp.repository.RecipeRepository;
import com.example.recipeapp.roomDatabase.RecipeEntity;

import java.util.List;

public class MyRecipesViewModel extends AndroidViewModel {

    private RecipeRepository repository;

    public MyRecipesViewModel(Application application) {
        super(application);
        repository = RecipeRepository.getInstance(application);

    }

    public LiveData<List<RecipeEntity>> getAllRecipes()
    {
        return repository.getRecipesFromDB();
    }


}