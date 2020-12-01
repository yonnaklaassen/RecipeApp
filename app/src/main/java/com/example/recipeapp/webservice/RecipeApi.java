package com.example.recipeapp.webservice;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {

    @GET("1/search.php")
    Call<RecipeResponse> getRecipes(@Query("s") String name);
}
