package com.example.coffeerecomand;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
;import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String[] questions = {getString(R.string.question0),getString(R.string.question1),getString(R.string.question2), getString(R.string.question3), getString(R.string.question4)};
    View menuView;
    Button yesBtn;
    Button noBtn;
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
            Toast.makeText(this, getString(R.string.menuRestart), Toast.LENGTH_SHORT).show();

            return true;
        }
        else if (id == R.id.coffeMenus) {
            Toast.makeText(this, getString(R.string.menus), Toast.LENGTH_SHORT).show();
        } else if (id==R.id.justSee) {
            Toast.makeText(this, getString(R.string.menus), Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}