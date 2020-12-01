package com.example.recipeapp.roomDatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "recipe_table")
public class RecipeEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String mealName;
    private String category;
    private String ingredients;
    private String description;

    public RecipeEntity(String mealName, String category, String ingredients, String description) {
        this.mealName = mealName;
        this.category = category;
        this.ingredients = ingredients;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getMealName() {
        return mealName;
    }

    public String getCategory() {
        return category;
    }


    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setDescription(String description) {
        this.description = description;


    }
}
