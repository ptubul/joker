package com.jokerapp.model;

import androidx.room.Embedded;
import androidx.room.Relation;

public class JokeWithOwner {
    @Embedded
    public Joke joke;

    @Relation(
            parentColumn = "ownerId",
            entityColumn = "userId"
    )
    public User owner;
}
