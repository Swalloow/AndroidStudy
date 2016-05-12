package com.swalloow.mysharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Call onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "Call onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "Call onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "Call onPause", Toast.LENGTH_SHORT).show();
        saveScore();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "Call onResume", Toast.LENGTH_SHORT).show();
        loadScore();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "Call onStart", Toast.LENGTH_SHORT).show();
    }

    private void saveScore() {
        SharedPreferences pref = getSharedPreferences("Game", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("score", 10000);
        editor.commit();
    }

    private void loadScore() {
        SharedPreferences pref = getSharedPreferences("Game", Activity.MODE_PRIVATE);
        int score = pref.getInt("score", 0);
        Toast.makeText(MainActivity.this, "score : " + score, Toast.LENGTH_LONG).show();
    }
}
