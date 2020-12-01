package com.example.recipeapp.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recipeapp.roomDatabase.Database;
import com.example.recipeapp.roomDatabase.RecipeDAO;
import com.example.recipeapp.roomDatabase.RecipeEntity;
import com.example.recipeapp.webservice.RecipeApi;
import com.example.recipeapp.webservice.RecipeResponse;
import com.example.recipeapp.webservice.ServiceGenerator;

import java.util.List;


public class RecipeRepository {

    private RecipeDAO recipeDAO;
    private static RecipeRepository instance;
    private MutableLiveData<List<RecipeResponse.Meal>> recipesFromApi;
    private LiveData<List<RecipeEntity>> recipesFromDB;

    private RecipeRepository(Application application)
    {
        Database database = Database.getInstance(application);
        recipesFromApi = new MutableLiveData<>();

        recipeDAO = database.recipeDAO();
        recipesFromDB = recipeDAO.getAllRecipes();
    }

    public static RecipeRepository getInstance(Application application)
    {
        if(instance == null)
        {
            instance = new RecipeRepository(application);
        }
        return instance;
    }

    public LiveData<List<RecipeResponse.Meal>> getRecipeFromAPI()
    {
        return recipesFromApi;
    }

    public LiveData<List<RecipeEntity>> getRecipesFromDB()
    {
        return recipesFromDB;
    }

    public void insertRecipeAsync(RecipeEntity recipeEntity)
    {
        new InsertRecipeAsync(recipeDAO).execute(recipeEntity);
    }


    public void requestRecipeFromAPI(String mealName) {
        RecipeApi mealApi = ServiceGenerator.getMealApi();
        Call<RecipeResponse> call = mealApi.getRecipes(mealName);
        call.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {

                if(response.code() == 200)
                {
                    recipesFromApi.setValue(response.body().getMeals());
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                Log.e("Retrofit", "Error retrieving");
            }
        });
    }

    private static class InsertRecipeAsync extends AsyncTask<RecipeEntity,Void,Void>
    {
        private RecipeDAO recipeDAO;

        private InsertRecipeAsync(RecipeDAO recipeDAO)
        {
            this.recipeDAO = recipeDAO;
        }
        @Override
        protected Void doInBackground(RecipeEntity... recipeEntities) {
            recipeDAO.insert(recipeEntities[0]);
            return null;
        }
    }
}
