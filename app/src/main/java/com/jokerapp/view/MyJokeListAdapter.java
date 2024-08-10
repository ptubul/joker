package com.jokerapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jokerapp.R;
import com.jokerapp.model.JokeItem;

import java.util.List;

public class MyJokeListAdapter extends RecyclerView.Adapter<MyJokeListAdapter.JokeViewHolder> {

    private List<JokeItem> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(JokeItem item);
        void onEditClick(JokeItem item);
        void onDeleteClick(JokeItem item);
    }

    public MyJokeListAdapter(List<JokeItem> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_jokes_item, parent, false);
        return new JokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        JokeItem item = items.get(position);
        holder.bind(item, listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class JokeViewHolder extends RecyclerView.ViewHolder {

        TextView titleView;
        ImageButton editButton;
        ImageButton deleteButton;
        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.item_title);
            deleteButton = itemView.findViewById(R.id.delete_button);
            editButton = itemView.findViewById(R.id.edit_button);
        }

        public void bind(final JokeItem joke, final OnItemClickListener listener) {
      //      Picasso.get().load(joke.getImageUrl()).into(imageView);
            titleView.setText(joke.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(joke);
                }
            });

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onEditClick(joke);
                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDeleteClick(joke);
                }
            });
        }

    }
}
