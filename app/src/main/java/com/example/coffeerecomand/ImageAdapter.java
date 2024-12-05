package com.example.coffeerecomand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedHashMap;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private  String[] drinks;
    private  int[] imageList;
    private  LinkedHashMap<Integer, Boolean> imageClickStatus; // 클릭 상태 관리

    public ImageAdapter(String[] drinks, int[] imageList, LinkedHashMap<Integer, Boolean> imageClickStatus) {
        this.drinks = drinks;
        this.imageList = imageList;
        this.imageClickStatus = imageClickStatus;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int index) {
        int imageResId = imageList[index];//클린된 이미지의 번호
        holder.itemText.setText(drinks[index]);
        holder.itemImage.setImageResource(imageResId);

        // 클릭 상태에 따라 이미지 크기 조정
        if (imageClickStatus.get(imageResId)) {
            holder.itemImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE); // 확대
            holder.itemImage.setLayoutParams(new LinearLayout.LayoutParams(600, 600)); // 크기 조정

        } else {
            holder.itemImage.setScaleType(ImageView.ScaleType.CENTER_CROP); // 기본 크기
            holder.itemImage.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
        }

        // 이미지 클릭 리스너
        holder.itemImage.setOnClickListener(v -> {
            boolean isClicked = imageClickStatus.get(imageResId);

            imageClickStatus.put(imageResId, !isClicked); // 상태 반전


            notifyItemChanged(index); // UI 업데이트
        });

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
