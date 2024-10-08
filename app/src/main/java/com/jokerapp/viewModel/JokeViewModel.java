package com.jokerapp.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jokerapp.model.JokeItem;

import java.util.ArrayList;
import java.util.List;

public class JokeViewModel extends ViewModel {
    private MutableLiveData<List<JokeItem>> items;
    private MutableLiveData<List<JokeItem>> myItems;

    public LiveData<List<JokeItem>> getItems() {

        if (items == null) {
            items = new MutableLiveData<>();
            loadItems();
            Log.d("MYTAG", "tesssssssssssssssssttt");
        }
        return items;
    }

    public LiveData<List<JokeItem>> getMyItems(int userID) {
        if (myItems == null) {
            myItems = new MutableLiveData<>();
            loadItems();
        }
        return myItems;
    }


    public void deleteItem(int jokeID) {
        if (items != null && items.getValue() != null) {
            List<JokeItem> currentItems = new ArrayList<>(items.getValue());
            for (int i = 0; i < currentItems.size(); i++) {
                if (currentItems.get(i).getId().equals(jokeID)) {
                    currentItems.remove(i);
                    break;
                }
            }
            items.setValue(currentItems); // Trigger LiveData update
        }

        if (myItems != null && myItems.getValue() != null) {
            List<JokeItem> currentMyItems = new ArrayList<>(myItems.getValue());
            for (int i = 0; i < currentMyItems.size(); i++) {
                if (currentMyItems.get(i).getId().equals(jokeID)) {
                    currentMyItems.remove(i);
                    break;
                }
            }
            myItems.setValue(currentMyItems); // Trigger LiveData update
        }
//        allItems.remove();
//        items.setValue(new ArrayList<>(allItems)); // Trigger LiveData update
    }

    public void editItem(JokeItem jokeItem) {
//        for (int i = 0; i < allItems.size(); i++) {
//            if (allItems.get(i).getId() == jokeItem.getId()) {
//                allItems.set(i, jokeItem);
//                break;
//            }
//        }
//        items.setValue(new ArrayList<>(allItems));
    }

    private void loadItems() {
//        List<JokeItem> allItems = new ArrayList<>();
//        allItems.add(new JokeItem( 1, "https://example.com/image1.jpg", "Title 1", "Owner 1"));
//        allItems.add(new JokeItem(2,"https://example.com/image2.jpg", "Title 5", "Owner 2"));
//        allItems.add(new JokeItem(3,"https://example.com/image1.jpg", "Title 1", "Owner 1"));
//        allItems.add(new JokeItem(4, "https://example.com/image2.jpg", "Title 5", "Owner 2"));
//        items.setValue(allItems);

    }
}
