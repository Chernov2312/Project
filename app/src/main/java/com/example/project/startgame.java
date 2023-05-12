package com.example.project;

import static com.example.project.MainActivity.setM;
import static com.example.project.MainActivity.setMenu;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.databinding.StartgameBinding;

public class startgame extends AppCompatActivity {
    StartgameBinding binding;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = StartgameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(4);
        intent = new Intent(startgame.this, MyService.class);
        startService(intent);
        binding.goHome.setOnClickListener(v -> {
            Character_Settings.setWater(Character_Settings.getWater() - 2);
            Character_Settings.setFood(Character_Settings.getFood() - 1);
            Intent i = new Intent(startgame.this, Home.class);
            startActivity(i);
        });
        binding.person.setOnClickListener(v -> {
            setMenu(1);
            Intent i = new Intent(startgame.this, Character_Settings.class);
            startActivity(i);
        });
        binding.gocity.setOnClickListener(v -> {
            Character_Settings.setWater(Character_Settings.getWater() - 2);
            Character_Settings.setFood(Character_Settings.getFood() - 1);
            Intent i = new Intent(startgame.this, Gorod.class);
            startActivity(i);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
