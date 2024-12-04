package com.example.coffeerecomand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private final String[] drinks;
    private final int[] imageList;

    public ImageAdapter(String[] drinks, int[] imageList) {
        this.drinks = drinks;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int index) {
        holder.itemText.setText(drinks[index]);
        holder.itemImage.setImageResource(imageList[index]);
    }

    @Override
    public int getItemCount() {
        return drinks.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.Images);
            itemText = itemView.findViewById(R.id.drinks);
        }
    }
}
