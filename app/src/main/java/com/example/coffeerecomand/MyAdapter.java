package com.example.coffeerecomand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    String[] questionList; // 질문 텍스트 배열
    Integer[] questionImageList; // 질문 이미지 배열
    OnItemClickListner listener; // 클릭 리스너

    // 생성자
    public MyAdapter(String[] questionList, Integer[] questionImageList, OnItemClickListner listener) {
        this.questionList = questionList; // 질문 텍스트 초기화
        this.questionImageList = questionImageList; // 질문 이미지 초기화
        this.listener = listener; // 리스너 초기화
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 리스트 항목 레이아웃 연결
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_item, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // ViewHolder에 데이터 바인딩
        holder.imageView.setImageResource(questionImageList[position]); // 이미지 설정
        holder.questionText.setText(questionList[position]); // 질문 텍스트 설정
    }

    @Override
    public int getItemCount() {
        return questionList.length; // 질문 개수 반환
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView; // 질문 이미지를 표시할 뷰
        TextView questionText; // 질문 텍스트를 표시할 뷰
        View yesButton; // 예 버튼
        View noButton; // 아니오 버튼

        public ViewHolder(@NonNull View itemView, OnItemClickListner listener) {
            super(itemView);

            // 레이아웃에서 뷰 초기화
            imageView = itemView.findViewById(R.id.image);
            questionText = itemView.findViewById(R.id.questionText);
            yesButton = itemView.findViewById(R.id.yesBtn);
            noButton = itemView.findViewById(R.id.noBtn);

            // 예 버튼 클릭 이벤트 설정
            yesButton.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onYesClick(position); // 예 클릭 이벤트 전달
                }
            });

            // 아니오 버튼 클릭 이벤트 설정
            noButton.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onNoClick(position); // 아니오 클릭 이벤트 전달
                }
            });
        }
    }
}
