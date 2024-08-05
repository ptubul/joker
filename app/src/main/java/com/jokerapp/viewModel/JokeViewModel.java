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

    public LiveData<List<JokeItem>> getItems() {
        if (items == null) {
            items = new MutableLiveData<>();
            loadItems();

        }
        return items;
    }

    private void loadItems() {
        List<JokeItem> itemList = new ArrayList<>();
        itemList.add(new JokeItem( 1, "https://example.com/image1.jpg", "Title 1", "Owner 1"));
        itemList.add(new JokeItem(2,"https://example.com/image2.jpg", "Title 5", "Owner 2"));
        itemList.add(new JokeItem(3,"https://example.com/image1.jpg", "Title 1", "Owner 1"));
        itemList.add(new JokeItem(4, "https://example.com/image2.jpg", "Title 5", "Owner 2"));
        items.setValue(itemList);
    }
}
