package com.example.recipeapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.recipeapp.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.roomDatabase.RecipeEntity;
import com.example.recipeapp.webservice.RecipeResponse;

import java.util.ArrayList;
import java.util.List;

public class FindRecipesAdapter extends RecyclerView.Adapter<FindRecipesAdapter.ViewHolder> {

    private List<RecipeResponse.Meal> meals;
    private final OnListItemClickListener onClickListener;

    public FindRecipesAdapter(OnListItemClickListener onClickListener)
    {
        meals = new ArrayList<>();
        this.onClickListener = onClickListener;
    }


    @NonNull
    @Override
    public FindRecipesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipe_item, parent, false);
        return new FindRecipesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FindRecipesAdapter.ViewHolder holder, int position) {
        holder.name.setText(meals.get(position).getStrMeal());
        holder.category.setText(meals.get(position).getStrCategory());
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public void updateList(List<RecipeResponse.Meal> meals)
    {
        this.meals = meals;
        notifyDataSetChanged();
    }

    public RecipeResponse.Meal getRecipeByPosition(int position)
    {
        return meals.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView category;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTextView);
            category = itemView.findViewById(R.id.categoryTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(getAdapterPosition());
        }
    }
}