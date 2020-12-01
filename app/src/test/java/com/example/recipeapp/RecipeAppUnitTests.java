package com.example.recipeapp;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.ui.my_recipes.MyRecipesViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class RecipeAppUnitTests {

    @Test
    public void createRecipeTest() {
        Recipe recipe = new Recipe("Name", "Category", "Ingredients", "Instructions");
        assertEquals("Category", recipe.getCategory());
    }

}