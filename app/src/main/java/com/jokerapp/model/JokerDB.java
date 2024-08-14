//package com.jokerapp.model;
//
//import android.content.Context;
//import android.util.Log;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//
//@Database(entities = {Joke.class, User.class}, version = 1)
//public abstract class JokerDB extends RoomDatabase {
//
//    // Add your DAO(s) here
//    public abstract JokeDAO getJokeDAO();
//    public abstract UserDAO getUserDAO();  // Add UserDAO for user-related queries
//
//    private static volatile JokerDB dbInstance;
//
//    private static final int NUMBER_OF_THREADS = 4;
//    public static final ExecutorService databaseWriteExecutor =
//            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
//
//    public static synchronized JokerDB getInstance(Context context) {
//        if (dbInstance == null) {
//            dbInstance = Room.databaseBuilder(context.getApplicationContext(),
//                            JokerDB.class, "joker_db")
//                    .fallbackToDestructiveMigration()
//                    .build();
//        }
//        Log.d("DBTAG", "DB CREATED");
//        return dbInstance;
//    }
//}
//
