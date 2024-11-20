package com.example.coffeerecomand;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
;import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    View menuView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // defind menu items
        int id = item.getItemId();
        if (id == R.id.restart) {
            Toast.makeText(this, "커피 추천 테스트를 다시 시작합니다.", Toast.LENGTH_SHORT).show();

            return true;
        }
        else if (id == R.id.coffeMenus) {
            Toast.makeText(this, "추천 해주는 커피 메뉴의 후보군을 봅니다.", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.justSee) {
            Toast.makeText(this, "이 곳에는 뭔가 귀여운 것을 띄워보려고 합니다. 이 곳에 띄우는 이미지나 모델링의 캐릭터가, 커피 추천 테스트의 결과를 알려주게 할 것입니다.", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}