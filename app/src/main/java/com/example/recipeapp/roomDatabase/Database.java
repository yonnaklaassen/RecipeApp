package com.example.recipeapp.roomDatabase;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = RecipeEntity.class, version = 1)
public abstract class Database extends RoomDatabase {

    private static Database instance;
    public abstract RecipeDAO recipeDAO();

    public static synchronized Database getInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class, "recipe_database").fallbackToDestructiveMigration().build();
        }

        return instance;
    }


}
