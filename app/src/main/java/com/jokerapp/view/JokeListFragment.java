package com.jokerapp.view;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jokerapp.R;
import com.jokerapp.model.JokeItem;
import com.jokerapp.model.User;
import com.jokerapp.model.UserRepository;
import com.jokerapp.viewModel.AllJokesViewModel;
import com.jokerapp.viewModel.JokeViewModel;

import java.util.List;

public class JokeListFragment extends Fragment {

    private AllJokesViewModel allJokesViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        allJokesViewModel = new ViewModelProvider(this).get(AllJokesViewModel.class);
        allJokesViewModel.getAllJokes().observe(getViewLifecycleOwner(), new Observer<List<JokeItem>>() {
            @Override
            public void onChanged(List<JokeItem> items) {
                JokeListAdapter adapter = new JokeListAdapter(items, new JokeListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(JokeItem item) {
                        Bundle bundle = new Bundle();
                        bundle.putString("title", item.getTitle());
                        bundle.putString("ownerName", item.getOwnerName());
                        Navigation.findNavController(view).navigate(R.id.action_jokeListFragment_to_jokeFragment    , bundle);
                    }
                });
                recyclerView.setAdapter(adapter);
            }
        });

        return view;
    }
}

