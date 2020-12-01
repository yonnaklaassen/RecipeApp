package com.example.recipeapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.R;
import com.example.recipeapp.roomDatabase.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

public class MyRecipesAdapter extends RecyclerView.Adapter<MyRecipesAdapter.ViewHolder> {

    private List<RecipeEntity> recipes;
    private final OnListItemClickListener onListItemClickListener;

    public MyRecipesAdapter(OnListItemClickListener onListItemClickListener) {
         recipes = new ArrayList<>();
        this.onListItemClickListener = onListItemClickListener;
    }

    @NonNull
    @Override
    public MyRecipesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipe_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecipesAdapter.ViewHolder holder, int position) {
        holder.name.setText(recipes.get(position).getMealName());
        holder.category.setText(recipes.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void updateList(List<RecipeEntity> recipes)
    {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    public RecipeEntity findRecipeById(int position)
    {
       int id = recipes.get(position).getId();

       for(RecipeEntity entity : recipes)
       {
           if(entity.getId() == id)
           {
               return entity;
           }
       }

       return null;
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
            onListItemClickListener.onClick(getAdapterPosition());
        }
    }
}