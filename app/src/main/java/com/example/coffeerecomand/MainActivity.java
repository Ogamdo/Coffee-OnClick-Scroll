package com.example.coffeerecomand;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeerecomand.R;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {
    private LinkedHashMap<Integer, Boolean> imageClickStatus = new LinkedHashMap<>();
    private RecyclerView recyclerView; //Image wiil showed here
    private ImageAdapter adapter;
    public String[] drinks;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        drinks = new String[]{
                getString(R.string.icetea_peach),
                getString(R.string.hot_choco),
                getString(R.string.hand_drip),
                getString(R.string.latte),
                getString(R.string.americano),
                getString(R.string.decaffeined), // Decaffeinated Coffee
                getString(R.string.cold_brew),   // Cold Brew
                getString(R.string.milk)         // Milk
        };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 세로 스크롤 설정


        adapter = new ImageAdapter(drinks, images);
        recyclerView.setAdapter(adapter);
        setupItemTouchHelper();

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
                adapter.notifyItemMoved(fromPosition, toPosition);
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