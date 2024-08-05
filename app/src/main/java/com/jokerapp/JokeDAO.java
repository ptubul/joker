package com.jokerapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface JokeDAO {

    @Insert
    void insert(Joke newJoke);


    @Query("SELECT * FROM jokes")
    List<Joke> getAllJokes();

}
