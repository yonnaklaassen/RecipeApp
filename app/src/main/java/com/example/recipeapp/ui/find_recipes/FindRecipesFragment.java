package com.example.recipeapp.ui.find_recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.R;
import com.example.recipeapp.adapters.FindRecipesAdapter;
import com.example.recipeapp.adapters.OnListItemClickListener;
import com.example.recipeapp.ui.SharedViewModel;
import com.example.recipeapp.ui.find_recipes.recipe_item.RecipeItemFragment_fr;
import com.example.recipeapp.ui.my_recipes.recipe_item.RecipeItemFragment_mr;
import com.example.recipeapp.webservice.RecipeResponse;

import java.util.List;

public class FindRecipesFragment extends Fragment implements View.OnClickListener, OnListItemClickListener {

    private FindRecipesViewModel findRecipesViewModel;
    private EditText editText;
    private Button button;

    private FindRecipesAdapter recipesAdapter;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        findRecipesViewModel =
                new ViewModelProvider(this).get(FindRecipesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_find_recipes, container, false);

        editText = root.findViewById(R.id.editText);
        button = root.findViewById(R.id.button);
        button.setOnClickListener(this);
        recyclerView = root.findViewById(R.id.recyclerViewFindRecipes);

        recipesAdapter = new FindRecipesAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recipesAdapter);

        findRecipesViewModel.getRecipeFromAPI().observe(getActivity(), new Observer<List<RecipeResponse.Meal>>() {
            @Override
            public void onChanged(List<RecipeResponse.Meal> meals) {
                recipesAdapter.updateList(meals);
            }
        });
        return root;
    }

    private void requestMeal()
    {
            findRecipesViewModel.requestRecipeFromAPI(editText.getText().toString());
            editText.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                requestMeal();
                break;
        }
    }

    @Override
    public void onClick(int position) {
        RecipeResponse.Meal meal = recipesAdapter.getRecipeByPosition(position);
        SharedViewModel sharedViewModel = SharedViewModel.getInstance();
        sharedViewModel.saveMeal(meal);

        RecipeItemFragment_fr fragment = new RecipeItemFragment_fr();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, fragment).addToBackStack(null).commit();
    }
}