package com.jokerapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jokerapp.R;
import com.jokerapp.model.JokeItem;
import com.jokerapp.viewModel.JokeViewModel;
import com.jokerapp.viewModel.MyJokesViewModel;

import java.util.List;


public class MyJokesFragment extends Fragment {
    private MyJokesViewModel myJokesViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_jokes, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        myJokesViewModel = new ViewModelProvider(this).get(MyJokesViewModel.class);
        myJokesViewModel.getMyJokes().observe(getViewLifecycleOwner(), new Observer<List<JokeItem>>() {
            @Override
            public void onChanged(List<JokeItem> items) {
                MyJokeListAdapter adapter = new MyJokeListAdapter(items, new MyJokeListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(JokeItem item) {
                        Bundle bundle = new Bundle();
                        bundle.putString("title", item.getTitle());
                        bundle.putString("ownerName", item.getOwnerName());
                        Navigation.findNavController(view).navigate(R.id.action_jokeListFragment_to_jokeFragment    , bundle);
                    }

                    @Override
                    public void onDeleteClick(JokeItem item) {
                        myJokesViewModel.deleteJoke(item.getId());
                    }

                    @Override
                    public void onEditClick(JokeItem item) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("id", item.getId());
                        bundle.putBoolean("editMode", true);
                        Navigation.findNavController(view).navigate(R.id.action_jokeListFragment_to_jokeFragment    , bundle);
                    }
                });
                recyclerView.setAdapter(adapter);
            }
        });

        return view;
    }
}