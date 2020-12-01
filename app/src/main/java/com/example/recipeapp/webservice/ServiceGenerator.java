package com.example.recipeapp.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/").addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();
    private static RecipeApi mealApi = retrofit.create(RecipeApi.class);

    public static RecipeApi getMealApi()
    {
        return mealApi;
    }
}
