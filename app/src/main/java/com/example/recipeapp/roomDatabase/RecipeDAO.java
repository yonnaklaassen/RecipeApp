package com.example.recipeapp.roomDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RecipeDAO {

    @Insert
    void insert(RecipeEntity recipeEntity);

    @Update
    void update(RecipeEntity recipeEntity);

    @Delete
    void delete(RecipeEntity recipeEntity);

    @Query("SELECT * FROM recipe_table")
    LiveData<List<RecipeEntity>> getAllRecipes();
}
