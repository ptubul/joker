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
        allJokes = new MutableLiveData<>();
    }

    public MutableLiveData<List<JokeItem>> getAllJokes() {
        if (allJokes == null) {
            allJokes = new MutableLiveData<>();

        }
        loadJokes();
        return allJokes;
    }

    public void addJoke(JokeItem joke){
        List<JokeItem> currentJokes = allJokes.getValue();
        currentJokes.add(joke);
        allJokes.setValue(currentJokes);
    }

    public void deleteJoke(String jokeID) {
        List<JokeItem> currentList = allJokes.getValue();
        if (currentList != null) {
            currentList.removeIf(joke -> joke.getId() == jokeID);
            allJokes.setValue(currentList);
        }
    }

    private void loadJokes() {
        allJokes =jokeRepo.getAllJokes();
//



    }
}

