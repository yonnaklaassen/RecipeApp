package com.example.recipeapp.ui.find_recipes;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.recipeapp.repository.RecipeRepository;
import com.example.recipeapp.webservice.RecipeResponse;

import java.util.List;

public class FindRecipesViewModel extends AndroidViewModel {

    private RecipeRepository recipeRepository;

    public FindRecipesViewModel(Application application) {
        super(application);
        recipeRepository = RecipeRepository.getInstance(application);
    }

    public LiveData<List<RecipeResponse.Meal>> getRecipeFromAPI()
    {
        return recipeRepository.getRecipeFromAPI();
    }

    public void requestRecipeFromAPI(String mealName)
    {
        recipeRepository.requestRecipeFromAPI(mealName);
    }

}