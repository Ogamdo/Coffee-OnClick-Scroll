package com.example.coffeerecomand;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity implements OnItemClickListner {

    LinkedHashMap<String, Boolean> questionMap; // 질문의 상태를 저장하는 LinkedHashMap
    String[] questionList; // 질문 텍스트 배열
    Integer[] questionImageList = { // 질문 이미지 배열
            R.drawable.question0,
            R.drawable.question1,
            R.drawable.question2,
            R.drawable.question3,
            R.drawable.question4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 레이아웃 설정

        // 질문 목록 초기화
        questionList = new String[]{
                getString(R.string.question0),
                getString(R.string.question1),
                getString(R.string.question2),
                getString(R.string.question3),
                getString(R.string.question4)
        };

        // LinkedHashMap 초기화
        questionMap = new LinkedHashMap<>();
        for (String question : questionList) {
            questionMap.put(question, false); // 기본 값은 false
        }

        // RecyclerView 설정
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 세로 방향 레이아웃

        // 어댑터 설정
        MyAdapter adapter = new MyAdapter(questionList, questionImageList, this);
        recyclerView.setAdapter(adapter); // RecyclerView와 어댑터 연결
    }

    @Override
    public void onRequestLinkedHashMap(LinkedHashMap<String, Boolean> map) {
        // LinkedHashMap 요청 처리
        map.putAll(questionMap); // 현재 상태를 호출한 쪽에 전달
    }

    @Override
    public void onYesClick(int position) {
        // 예 버튼 클릭 처리
        String question = questionList[position];
        questionMap.put(question, true); // 상태를 true로 설정
        Toast.makeText(this, question + "가 선택되었습니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNoClick(int position) {
        // 아니오 버튼 클릭 처리
        String question = questionList[position];
        questionMap.put(question, false); // 상태를 false로 설정
        Toast.makeText(this, question + "가 선택되지 않았습니다.", Toast.LENGTH_SHORT).show();
    }
}
