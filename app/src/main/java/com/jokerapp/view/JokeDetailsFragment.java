package com.jokerapp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import  com.jokerapp.R;

public class JokeDetailsFragment extends Fragment {

    private ImageView photoView;
    private EditText titleView;
    private EditText ownerNameView;
    private EditText textView;
    private boolean isEditMode;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke_details, container, false);

        photoView = view.findViewById(R.id.photo);
        titleView = view.findViewById(R.id.edit_title);
        ownerNameView = view.findViewById(R.id.edit_owner_name);
        textView = view.findViewById(R.id.edit_text);
        Log.d("MYTAG", "testttttttttttttttttt ");
        if (getArguments() != null) {

            String title = getArguments().getString("title");
            String ownerName = getArguments().getString("ownerName");
            String text = getArguments().getString("text");
            boolean editMode = getArguments().getBoolean("editMode", false);

            titleView.setText(title);
            ownerNameView.setText(ownerName);
            textView.setText(text);
            setEditMode(editMode);
        }

        return view;
    }

    private void setEditMode(boolean editMode) {
        isEditMode = editMode;
        titleView.setEnabled(editMode);
        ownerNameView.setEnabled(editMode);
        textView.setEnabled(editMode);
    }
}
