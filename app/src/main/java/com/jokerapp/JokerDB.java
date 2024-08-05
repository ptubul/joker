package com.jokerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Joke.class}, version = 1)
public abstract class JokerDB extends RoomDatabase {
    public  abstract  JokeDAO getJokeDAO();

    private static JokerDB dbInstance;

    public  static  synchronized JokerDB getInstance(Context context){
            if(dbInstance == null){
                dbInstance = Room.databaseBuilder( context.getApplicationContext(),
                                                   JokerDB.class, "joker_db")
                        .fallbackToDestructiveMigration().build();
            }
            return  dbInstance;
    }
}
