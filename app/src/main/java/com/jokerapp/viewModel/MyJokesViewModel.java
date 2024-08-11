package com.jokerapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jokerapp.model.JokeItem;

import java.util.ArrayList;
import java.util.List;

public class MyJokesViewModel extends ViewModel {
    private MutableLiveData<List<JokeItem>> myJokes;
    private AllJokesViewModel allJokesViewModel;

//    public MyJokesViewModel(AllJokesViewModel allJokesViewModel) {
//        this.allJokesViewModel = allJokesViewModel;
//    }

    public LiveData<List<JokeItem>> getMyJokes() {
        if (myJokes == null) {
            myJokes = new MutableLiveData<>();
            loadMyJokes();
        }
        return myJokes;
    }

    public void deleteJoke(int jokeID) {
        List<JokeItem> currentList = myJokes.getValue();
        if (currentList != null) {
            currentList.removeIf(joke -> joke.getId() == jokeID);
            myJokes.setValue(currentList);
        }
//        allJokesViewModel.deleteJoke(jokeID);
    }

    private void loadMyJokes() {
        List<JokeItem> allItems = new ArrayList<>();
        allItems.add(new JokeItem( 1, "https://example.com/image1.jpg", "Title 1", "Owner 1"));
        allItems.add(new JokeItem(2,"https://example.com/image2.jpg", "Title 5", "Owner 2"));
        allItems.add(new JokeItem(3,"https://example.com/image1.jpg", "Title 1", "Owner 1"));
        allItems.add(new JokeItem(4, "https://example.com/image2.jpg", "Title 5", "Owner 2"));
        myJokes.setValue(allItems);
        // Load user-specific jokes logic
    }
}

