package com.jokerapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "jokes",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "userId",
                childColumns = "ownerId",
                onDelete = ForeignKey.CASCADE)
)
public class Joke {
    @PrimaryKey
    @NonNull
    public String Id;

    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name= "ownerName")
    public String ownerName;

    @ColumnInfo(name = "ownerId")
    public int ownerId;



    // Other fields like timestamp, imageUrl, etc.
}
