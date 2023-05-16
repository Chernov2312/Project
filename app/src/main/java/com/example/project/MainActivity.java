package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.example.project.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static int menu = 0;
    private static int m = 1;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        m = 1;
        intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);
        binding.person.setOnClickListener(v -> {
            menu = 0;
            Intent i = new Intent(MainActivity.this, Character_Settings.class);
            startActivity(i);
        });
        binding.exit.setOnClickListener(v -> {
            this.finishAffinity();
        });
        binding.play.setOnClickListener(v -> {
            if (getMenu() == 1 || getMenu() == 0) {
                Intent i = new Intent(MainActivity.this, Startgame.class);
                startActivity(i);
            } else if (getMenu() == 2) {
                Intent i = new Intent(MainActivity.this, Home.class);
                startActivity(i);
            } else if (getMenu() == 3) {
                Intent i = new Intent(MainActivity.this, City.class);
                startActivity(i);
            } else if (getMenu() == 4) {
                Intent i = new Intent(MainActivity.this, Shop.class);
                startActivity(i);
            } else if (getMenu() == 5) {
                Intent i = new Intent(MainActivity.this, Gildia.class);
                startActivity(i);
            }
            else if (getMenu() == 6) {
                Intent i = new Intent(MainActivity.this, BossFight.class);
                startActivity(i);
            }
            else if (getMenu() == 7) {
                Intent i = new Intent(MainActivity.this, Easyandmedium.class);
                startActivity(i);
            }
            else if (getMenu() == 8) {
                Intent i = new Intent(MainActivity.this, WinGame.class);
                startActivity(i);
            }
        });
    }

    public static int getM() {
        return m;
    }

    public static void setM(int m) {
        MainActivity.m = m;
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
    public static int getMenu() {
        return menu;
    }

    public static void setMenu(int menu2) {
        menu = menu2;
    }
}