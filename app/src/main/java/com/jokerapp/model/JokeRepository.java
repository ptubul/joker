package com.jokerapp.model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class JokeRepository {
    private JokeDAO jokeDao;
    private MutableLiveData<List<JokeItem>> allJokes;
    private MutableLiveData<List<JokeItem>> myJokes;
private FirebaseFirestore remoteDb;
    public JokeRepository(Application application) {
//        JokerDB db = JokerDB.getInstance(application);
//        jokeDao = db.getJokeDAO();
//        allJokes = jokeDao.getAllJokesWithOwners();
        allJokes = new MutableLiveData<>();
        myJokes = new MutableLiveData<>();
        remoteDb  = FirebaseFirestore.getInstance();
    }

    public MutableLiveData<List<JokeItem>> getAllJokes() {
        Task<QuerySnapshot> queryTask = remoteDb.collection("jokes").get();
        allJokes = fetchJokes(queryTask);

        return allJokes;
    }

    public MutableLiveData<List<JokeItem>> getJokesByOwner(String ownerId) {
//        return jokeDao.getJokesByOwner(ownerId);
        Task<QuerySnapshot> queryTask = remoteDb.collection("jokes").whereEqualTo("ownerId", ownerId).get();
        myJokes = fetchJokes(queryTask);
        return  myJokes;
    }

    private MutableLiveData<List<JokeItem>> fetchJokes(Task<QuerySnapshot> query){

        MutableLiveData<List<JokeItem>> jokesResult;
        jokesResult = new MutableLiveData<>();
        query.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<JokeItem> jokeList = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        JokeItem joke = document.toObject(JokeItem.class);
                        jokeList.add(joke);
                    }
                    jokesResult.setValue(jokeList);
                } else {
                    Log.w("Firestore", "Error getting documents.", task.getException());
                }
            }
        });
        return  jokesResult;
    }
    public void insertJoke(JokeItem joke) {
        Log.d("MYTAG", "inserrrrrrrrrrrrrrrrrrrrrtttttttttt");
        remoteDb.collection("jokes").add(joke)
                .addOnSuccessListener(documentReference -> {

                    // The joke was successfully added, you can get the document ID if needed
                    String documentId = documentReference.getId();
                    Log.d("MYTAG", "AddRecord");

                    // Optionally, log or perform further actions
//                    System.out.println("Joke added with ID: " + documentId);
                })
                .addOnFailureListener(e -> {
                    // There was an error adding the joke, handle the failure
                    System.err.println("Error adding joke: " + e.getMessage());
                });
//        JokerDB.databaseWriteExecutor.execute(() -> {
//            jokeDao.insertJoke(joke);
            // Optionally, sync with Firebase
//            firebaseDatabase.getReference("jokes").child(String.valueOf(joke.jokeId)).setValue(joke);
//        });
    }

    public void deleteJoke(int jokeId) {
//        JokerDB.databaseWriteExecutor.execute(() -> {
//            jokeDao.deleteJokeById(jokeId);
//            // Optionally, remove from Firebase
////            firebaseDatabase.getReference("jokes").child(String.valueOf(jokeId)).removeValue();
//        });
    }
}
