package com.jokerapp.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.jokerapp.model.JokeItem;
import com.jokerapp.model.JokeRepository;
import com.jokerapp.model.User;
import com.jokerapp.model.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class AllJokesViewModel extends AndroidViewModel {
    private MutableLiveData<List<JokeItem>> allJokes;
    private JokeRepository jokeRepo;

    public AllJokesViewModel(Application application) {
        super(application);
        jokeRepo = new JokeRepository(application);
    }

    public LiveData<List<JokeItem>> getAllJokes() {
        if (allJokes == null) {
            allJokes = new MutableLiveData<>();
            loadJokes();
        }
        return allJokes;
    }

    public void deleteJoke(String jokeID) {
        List<JokeItem> currentList = allJokes.getValue();
        if (currentList != null) {
            currentList.removeIf(joke -> joke.getId() == jokeID);
            allJokes.setValue(currentList);
        }
    }

    private void loadJokes() {
//        List<JokeItem> allItems = new ArrayList<>();
//        allItems.add(new JokeItem( 1, "https://example.com/image1.jpg", "Title 1", "Owner 1"));
//        allItems.add(new JokeItem(2,"https://example.com/image2.jpg", "Title 5", "Owner 2"));
//        allItems.add(new JokeItem(3,"https://example.com/image1.jpg", "Title 1", "Owner 1"));
//        allItems.add(new JokeItem(4, "https://example.com/image2.jpg", "Title 5", "Owner 2"));
//        allJokes.setValue(allItems);
        allJokes =jokeRepo.getAllJokes();
//



    }
}

