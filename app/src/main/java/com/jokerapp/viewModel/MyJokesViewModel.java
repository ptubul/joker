package com.jokerapp.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.app.Application;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.jokerapp.model.Joke;
import com.jokerapp.model.JokeItem;
import com.jokerapp.model.JokeItemDb;
import com.jokerapp.model.JokeRepository;
import com.jokerapp.model.JokeWithOwner;
import com.jokerapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class MyJokesViewModel extends AndroidViewModel {
    private MutableLiveData<List<JokeItem>> myJokes;
    private AllJokesViewModel allJokesViewModel;
    private JokeRepository jokeRepo;
//    public MyJokesViewModel(AllJokesViewModel allJokesViewModel) {
//        this.allJokesViewModel = allJokesViewModel;
//    }

    public MyJokesViewModel(Application application) {
        super(application);
        jokeRepo = new JokeRepository(application);
    }

    public LiveData<List<JokeItem>> getMyJokes() {
        if (myJokes == null) {
            myJokes = new MutableLiveData<>();
            loadMyJokes();
        }
        return myJokes;
    }

    public void deleteJoke(String jokeID) {
        List<JokeItem> currentList = myJokes.getValue();
        if (currentList != null) {
            currentList.removeIf(joke -> joke.getId() == jokeID);
            myJokes.setValue(currentList);
        }
//        jokeRepo.deleteJoke(jokeID);
//        allJokesViewModel.deleteJoke(jokeID);
    }

    private void loadMyJokes() {
//        List<JokeItem> allItems = new ArrayList<>();
//        allItems.add(new JokeItem( 1, "https://exaple.com/image1.jpg", "Title 1", "Owner 1"));
//        allItems.add(new JokeItem(2,"https://example.com/image2.jpg", "Title 5", "Owner 2"));
//        allItems.add(new JokeItem(3,"https://example.com/image1.jpg", "Title 1", "Owner 1"));
//        allItems.add(new JokeItem(4, "https://example.com/image2.jpg", "Title 5", "Owner 2"));
//        myJokes.setValue(allItems);
//        FirebaseFirestore db = FirebaseFirestore.getInstance();

            myJokes = jokeRepo.getJokesByOwner("2222");
//        MutableLiveData<List<JokeItem>> jokes = jokeRepo.getJokesByOwner("2222");
//        User user = nes
        // Load user-specific jokes logic
    }
}

