package com.jokerapp.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface JokeDAO {
    @Transaction
    @Query("SELECT * FROM jokes")
    LiveData<List<JokeItem>> getAllJokesWithOwners();

    @Transaction
    @Query("SELECT * FROM jokes WHERE ownerId = :userId")
    LiveData<List<JokeItem>> getJokesByOwner(int userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertJoke(JokeItem joke);

    @Query("DELETE FROM jokes WHERE Id = :jokeId")
    void deleteJokeById(String jokeId);
}
