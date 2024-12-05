package com.example.coffeerecomand;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {
    private LinkedHashMap<Integer, Boolean> imageClickStatus = new LinkedHashMap<>();
    private RecyclerView recyclerView; // RecyclerView 선언
    private ImageAdapter adapter;
    private String[] drinks;
    private int[] images = {
            R.drawable.icetea_peach,
            R.drawable.hot_choco,
            R.drawable.hand_drip,
            R.drawable.latte,
            R.drawable.americano,
            R.drawable.decaffeined,
            R.drawable.cold_brew,
            R.drawable.milk
    };
    private Button upBtn, downBtn;
    private int currentScrollPosition = 0; //버튼 현재 위치 추적


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 음료 이름 초기화
        drinks = new String[]{
                getString(R.string.icetea_peach),
                getString(R.string.hot_choco),
                getString(R.string.hand_drip),
                getString(R.string.latte),
                getString(R.string.americano),
                getString(R.string.decaffeined),
                getString(R.string.cold_brew),
                getString(R.string.milk)
        };

        // LinkedHashMap 초기화
        initializeImageClickStatus();

        // RecyclerView 설정
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 어댑터 설정
        adapter = new ImageAdapter(drinks, images, imageClickStatus);
        recyclerView.setAdapter(adapter);
        upBtn = (Button) findViewById(R.id.upBtn);
        downBtn = (Button) findViewById(R.id.downBtn);
        upBtn.setOnClickListener(v -> {
            if (currentScrollPosition > 0) {
                currentScrollPosition--; // 위치 감소
                recyclerView.smoothScrollToPosition(currentScrollPosition); // 위로 스크롤
            }
        });

        downBtn.setOnClickListener(v -> {
            if (currentScrollPosition < images.length - 1) {
                currentScrollPosition++; // 위치 증가
                recyclerView.smoothScrollToPosition(currentScrollPosition); // 아래로 스크롤
            }
        });
        // ItemTouchHelper 설정
        setupItemTouchHelper();
    }

    private void initializeImageClickStatus() {
        for (int image : images) {
            imageClickStatus.put(image, false); // 초기 상태는 false
        }
    }

    private void setupItemTouchHelper() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();

                // 데이터 스왑
                String tempQuestion = drinks[fromPosition];
                int tempImage = images[fromPosition];
                drinks[fromPosition] = drinks[toPosition];
                images[fromPosition] = images[toPosition];
                drinks[toPosition] = tempQuestion;
                images[toPosition] = tempImage;

                // 어댑터에 변경 알림
                adapter.notifyItemMoved(fromPosition, toPosition); //
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // 스와이프 동작 비활성화
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
