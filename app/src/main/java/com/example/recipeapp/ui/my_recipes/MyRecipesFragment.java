package com.example.recipeapp.ui.my_recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.R;
import com.example.recipeapp.adapters.MyRecipesAdapter;
import com.example.recipeapp.adapters.OnListItemClickListener;
import com.example.recipeapp.roomDatabase.RecipeEntity;
import com.example.recipeapp.ui.SharedViewModel;
import com.example.recipeapp.ui.my_recipes.recipe_item.RecipeItemFragment_mr;

import java.util.List;

public class MyRecipesFragment extends Fragment implements OnListItemClickListener {

    private MyRecipesViewModel myRecipesViewModel;
    private RecyclerView recyclerView;
    private MyRecipesAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myRecipesViewModel =
                new ViewModelProvider(this).get(MyRecipesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my_recipes, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewMyRecipes);

        adapter = new MyRecipesAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        myRecipesViewModel.getAllRecipes().observe(getViewLifecycleOwner(), new Observer<List<RecipeEntity>>() {
            @Override
            public void onChanged(List<RecipeEntity> recipeEntities) {
                adapter.updateList(recipeEntities);
            }
        });

        return root;
    }

    @Override
    public void onClick(int position) {

      RecipeEntity recipe = adapter.findRecipeById(position);

        SharedViewModel sharedViewModel = SharedViewModel.getInstance();
        sharedViewModel.saveRecipe(recipe);

        RecipeItemFragment_mr fragment = new RecipeItemFragment_mr();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, fragment).addToBackStack(null).commit();

    }
}