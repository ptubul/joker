package com.jokerapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jokerapp.R;
import com.jokerapp.model.JokeItem;
import com.jokerapp.viewModel.JokeViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class JokeListAdapter extends RecyclerView.Adapter<JokeListAdapter.JokeViewHolder> {

    private List<JokeItem> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(JokeItem item);
    }

    public JokeListAdapter(List<JokeItem> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_item_list, parent, false);
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

        ImageView imageView;
        TextView titleView;
        TextView ownerView;

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            titleView = itemView.findViewById(R.id.item_title);
            ownerView = itemView.findViewById(R.id.item_owner);
        }

        public void bind(final JokeItem joke, final OnItemClickListener listener) {
            Picasso.get().load(joke.getImageUrl()).into(imageView);
            ownerView.setText(joke.getOwnerName() + ":");
            titleView.setText(joke.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(joke);
                }
            });
        }

        public void filterItemsByOwner(String ownerName) {
//            JokeViewModel.filterItemsByOwner(ownerName);
        }

        public void resetItems() {
//            JokeViewModel.resetItems();
        }
    }
}
