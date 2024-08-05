package com.jokerapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jokerapp.R;

public class JokeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        TextView titleView = view.findViewById(R.id.detail_title);
        TextView ownerView = view.findViewById(R.id.detail_owner);

        if (getArguments() != null) {
            String title = getArguments().getString("title");
            String ownerName = getArguments().getString("ownerName");

            titleView.setText(title);
            ownerView.setText(ownerName);
        }

        return view;
    }
}
