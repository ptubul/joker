package com.jokerapp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.jokerapp.R;

import org.w3c.dom.Text;

public class JokeFragment extends Fragment {


    private ImageView photoView;
    private EditText titleView;
    private EditText ownerNameView;
    private EditText textView;
    private boolean isEditMode = true;
    private Button saveButton;
    private Button cancelButton;
    private  ImageButton editButton;
    private  ImageButton addImageButton;
    private  ImageButton generateMemeButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);
        final NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        photoView = view.findViewById(R.id.photo);
        titleView = view.findViewById(R.id.edit_title);
        ownerNameView = view.findViewById(R.id.edit_owner_name);
        textView = view.findViewById(R.id.edit_text);
        saveButton = view.findViewById(R.id.save_button);
        cancelButton = view.findViewById(R.id.cancel_button);
        editButton = view.findViewById(R.id.edit_button);
        addImageButton = view.findViewById(R.id.add_image_button);
        generateMemeButton = view.findViewById(R.id.generate_meme_button);

        if (getArguments() != null) {

            String title = getArguments().getString("title");
            String ownerName = getArguments().getString("ownerName");
            String text = getArguments().getString("text");
            isEditMode = getArguments().getBoolean("editMode", false);
            titleView.setText(title);
            ownerNameView.setText(ownerName);
            textView.setText(text);
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle save action
                // e.g., save changes and exit edit mode
                navController.popBackStack();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleEditMode();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleEditMode();
            }
        });

        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add image from gallery
            }
        });

        generateMemeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate meme action
            }
        });

        return view;
    }

    private void toggleEditMode() {
        isEditMode = !isEditMode;
        titleView.setEnabled(isEditMode);
        ownerNameView.setEnabled(isEditMode);
        textView.setEnabled(isEditMode);
        saveButton.setVisibility(isEditMode ? View.VISIBLE : View.GONE);
        cancelButton.setVisibility(isEditMode ? View.VISIBLE : View.GONE);
    }
}
