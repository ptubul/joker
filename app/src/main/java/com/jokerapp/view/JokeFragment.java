package com.jokerapp.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import  android.graphics.Color;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.jokerapp.R;
import com.jokerapp.model.JokeItem;
import com.jokerapp.viewModel.MyJokesViewModel;

import org.w3c.dom.Text;

import java.io.IOException;

public class JokeFragment extends Fragment {

    private ImageView photoView;
    private EditText titleView;
    private EditText ownerNameView;
    private EditText textView;
    private boolean isEditMode = true;
    private Button saveButton;
    private Button cancelButton;
    private  ImageButton addImageButton;
    private  ImageButton generateMemeButton;
    private MyJokesViewModel myJokesViewModel;

    private final ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == getActivity().RESULT_OK && result.getData() != null) {
                    Uri selectedImageUri = result.getData().getData();
                    if (selectedImageUri != null) {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImageUri);
                            photoView.setImageBitmap(bitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    );


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
        addImageButton = view.findViewById(R.id.add_image_button);
        generateMemeButton = view.findViewById(R.id.generate_meme_button);
        myJokesViewModel = new ViewModelProvider(this).get(MyJokesViewModel.class);
        if (getArguments() != null) {

            String title = getArguments().getString("title");
            String ownerName = getArguments().getString("ownerName");
            String text = getArguments().getString("text");
            isEditMode = getArguments().getBoolean("editMode", false);
            setEditMode();
            titleView.setText(title);
            ownerNameView.setText(ownerName);
            textView.setText(text);
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = titleView.getText().toString().trim();
                String ownerName = ownerNameView.getText().toString().trim();
                String text = textView.getText().toString().trim();


                // Handle save action
                // e.g., save changes and exit edit mode
                JokeItem joke = new JokeItem("", title,ownerName, "2222",text);
                String jokeId = getArguments().getString("jokeId");
//                `Log.d("MYTAG", jokeId);`
                if (jokeId == null || jokeId.equals("")){
                    Log.d("MYTAG", "aaaaaaaaaaaaaa");
                    myJokesViewModel.addJoke(joke);

                }
                navController.popBackStack();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.popBackStack();
            }
        });

        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openGallery();// Add image from gallery
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

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        galleryLauncher.launch(intent);
    }

    private void setEditMode() {
        titleView.setEnabled(isEditMode);
        ownerNameView.setEnabled(isEditMode);
        textView.setEnabled(isEditMode);
        saveButton.setVisibility(isEditMode ? View.VISIBLE : View.GONE);
        cancelButton.setVisibility(isEditMode ? View.VISIBLE : View.GONE);
        generateMemeButton.setEnabled(isEditMode);
        addImageButton.setEnabled(isEditMode);

        if (isEditMode){
            generateMemeButton.clearColorFilter();
            addImageButton.clearColorFilter();
        }
        else {
            generateMemeButton.setColorFilter(Color.GRAY);
            addImageButton.setColorFilter(Color.GRAY);
        }
        isEditMode = !isEditMode;
    }
}
