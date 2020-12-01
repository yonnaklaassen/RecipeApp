package com.example.recipeapp.ui.my_recipes.recipe_item;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recipeapp.R;
import com.example.recipeapp.roomDatabase.RecipeEntity;
import com.example.recipeapp.ui.SharedViewModel;
import com.example.recipeapp.ui.my_recipes.MyRecipesViewModel;

public class RecipeItemFragment_mr extends Fragment {

    private TextView name;
    private TextView category;
    private TextView ingredients;
    private TextView instructions;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_recipe_item_my_recipes, container, false);

        name = root.findViewById(R.id.name_my_recipes);
        category = root.findViewById(R.id.category_my_recipes);
        ingredients = root.findViewById(R.id.ingredients_my_recipes);
        instructions = root.findViewById(R.id.instructions_my_recipes);

        SharedViewModel sharedViewModel = SharedViewModel.getInstance();

            name.setText(sharedViewModel.getRecipeEntity().getMealName());
            category.setText(sharedViewModel.getRecipeEntity().getCategory());
            ingredients.setText(sharedViewModel.getRecipeEntity().getIngredients());
            instructions.setText(sharedViewModel.getRecipeEntity().getDescription());

        return root;
    }
    
}
