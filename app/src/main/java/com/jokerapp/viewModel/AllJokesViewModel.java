package com.jokerapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jokerapp.model.JokeItem;

import java.util.ArrayList;
import java.util.List;

public class AllJokesViewModel extends ViewModel {
    private MutableLiveData<List<JokeItem>> allJokes;

    public LiveData<List<JokeItem>> getAllJokes() {
        if (allJokes == null) {
            allJokes = new MutableLiveData<>();
            loadJokes();
        }
        return allJokes;
    }

    public void deleteJoke(int jokeID) {
        List<JokeItem> currentList = allJokes.getValue();
        if (currentList != null) {
            currentList.removeIf(joke -> joke.getId() == jokeID);
            allJokes.setValue(currentList);
        }
    }

    private void loadJokes() {
        List<JokeItem> allItems = new ArrayList<>();
        allItems.add(new JokeItem( 1, "https://example.com/image1.jpg", "Title 1", "Owner 1"));
        allItems.add(new JokeItem(2,"https://example.com/image2.jpg", "Title 5", "Owner 2"));
        allItems.add(new JokeItem(3,"https://example.com/image1.jpg", "Title 1", "Owner 1"));
        allItems.add(new JokeItem(4, "https://example.com/image2.jpg", "Title 5", "Owner 2"));
        allJokes.setValue(allItems);
    }
}

