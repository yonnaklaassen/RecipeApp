package com.example.recipeapp.ui.add_recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recipeapp.R;
import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.roomDatabase.RecipeEntity;

public class AddRecipesFragment extends Fragment implements View.OnClickListener {

    private AddRecipesViewModel addRecipesViewModel;
    private Button addRecipe;
    private EditText name;
    private EditText category;
    private EditText instructions;
    private EditText ingredients;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addRecipesViewModel =
                new ViewModelProvider(this).get(AddRecipesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add_recipes, container, false);

        addRecipe = root.findViewById(R.id.addRecipe);
        addRecipe.setOnClickListener(this);
        ingredients =  root.findViewById(R.id.editTextIngredients);
        name =  root.findViewById(R.id.editTextName);
        category =  root.findViewById(R.id.editTextCategory);
        instructions = root.findViewById(R.id.editTextInstructions);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.addRecipe:

                RecipeEntity recipe = new RecipeEntity(name.getText().toString(),
                        category.getText().toString(),
                        ingredients.getText().toString(),
                        instructions.getText().toString());
                addRecipesViewModel.insertRecipe(recipe);

                name.setText("");
                category.setText("");
                instructions.setText("");
                ingredients.setText("");
                break;
        }
    }
}
