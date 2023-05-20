package com.example.project;

import static com.example.project.MainActivity.setM;
import static com.example.project.MainActivity.setMenu;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.databinding.StartgameBinding;

public class Startgame extends AppCompatActivity {
    StartgameBinding binding;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = StartgameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(4);
        intent = new Intent(Startgame.this, MyService.class);
        startService(intent);
        binding.goHome.setOnClickListener(v -> {
            Character_Settings.setWater(Character_Settings.getWater() - 4);
            Character_Settings.setFood(Character_Settings.getFood() - 2);
            Intent i = new Intent(Startgame.this, Home.class);
            startActivity(i);
            finish();
        });
        setMenu(1);
        binding.person.setOnClickListener(v -> {
            Intent i = new Intent(Startgame.this, Character_Settings.class);
            startActivity(i);
            finish();
        });
        binding.gocity.setOnClickListener(v -> {
            Character_Settings.setWater(Character_Settings.getWater() - 4);
            Character_Settings.setFood(Character_Settings.getFood() - 2);
            Intent i = new Intent(Startgame.this, City.class);
            startActivity(i);
            finish();
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
