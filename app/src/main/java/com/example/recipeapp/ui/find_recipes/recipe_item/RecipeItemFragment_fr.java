package com.example.recipeapp.ui.find_recipes.recipe_item;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recipeapp.R;
import com.example.recipeapp.ui.SharedViewModel;

public class RecipeItemFragment_fr extends Fragment {

    private TextView name;
    private TextView category;
    private TextView ingredients;
    private TextView instructions;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recipe_item_find_recipes, container, false);

        name = root.findViewById(R.id.name_find_recipes);
        category = root.findViewById(R.id.category_find_recipes);
        ingredients = root.findViewById(R.id.ingredients_find_recipes);
        instructions = root.findViewById(R.id.instructions_find_recipes);

        SharedViewModel sharedViewModel = SharedViewModel.getInstance();

        name.setText(sharedViewModel.getMeal().getStrMeal());
        category.setText(sharedViewModel.getMeal().getStrCategory());

        ingredients.setText(sharedViewModel.getMeal().getStrMeasure1() + ": " + sharedViewModel.getMeal().getStrIngredient1() + "\n"
        + sharedViewModel.getMeal().getStrMeasure2() + sharedViewModel.getMeal().getStrIngredient2() + "\n"
                + sharedViewModel.getMeal().getStrMeasure3() + ": " + sharedViewModel.getMeal().getStrIngredient3() + "\n"
                + sharedViewModel.getMeal().getStrMeasure4() + ": " + sharedViewModel.getMeal().getStrIngredient4() + "\n"
                + sharedViewModel.getMeal().getStrMeasure5() + ": " + sharedViewModel.getMeal().getStrIngredient5() + "\n"
                + sharedViewModel.getMeal().getStrMeasure6() + ": " + sharedViewModel.getMeal().getStrIngredient6() + "\n"
                + sharedViewModel.getMeal().getStrMeasure7() + ": " + sharedViewModel.getMeal().getStrIngredient7() + "\n"
                + sharedViewModel.getMeal().getStrMeasure8() + ": " + sharedViewModel.getMeal().getStrIngredient8() + "\n"
                + sharedViewModel.getMeal().getStrMeasure9() + ": " + sharedViewModel.getMeal().getStrIngredient9() + "\n"
                + sharedViewModel.getMeal().getStrMeasure10() + ": " + sharedViewModel.getMeal().getStrIngredient10() + "\n"
                + sharedViewModel.getMeal().getStrMeasure11() + ": " + sharedViewModel.getMeal().getStrIngredient11() + "\n"
                + sharedViewModel.getMeal().getStrMeasure12() + ": " + sharedViewModel.getMeal().getStrIngredient12() + "\n"
                + sharedViewModel.getMeal().getStrMeasure13() + ": " + sharedViewModel.getMeal().getStrIngredient13() + "\n"
                + sharedViewModel.getMeal().getStrMeasure14() + ": " + sharedViewModel.getMeal().getStrIngredient14() + "\n"
                + sharedViewModel.getMeal().getStrMeasure15() + ": " + sharedViewModel.getMeal().getStrIngredient15() + "\n"
                + sharedViewModel.getMeal().getStrMeasure16() + ": " + sharedViewModel.getMeal().getStrIngredient16() + "\n"
                + sharedViewModel.getMeal().getStrMeasure17() + ": " + sharedViewModel.getMeal().getStrIngredient17() + "\n"
                + sharedViewModel.getMeal().getStrMeasure18() + ": " + sharedViewModel.getMeal().getStrIngredient18() + "\n"
                + sharedViewModel.getMeal().getStrMeasure19() + ": " + sharedViewModel.getMeal().getStrIngredient19() + "\n"
                + sharedViewModel.getMeal().getStrMeasure20() + ": " + sharedViewModel.getMeal().getStrIngredient20()
                );
        instructions.setText(sharedViewModel.getMeal().getStrInstructions());

        return root;
    }
}
