package com.example.project;

import static com.example.project.MainActivity.setM;
import static com.example.project.MainActivity.setMenu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project.databinding.GorodBinding;

public class City extends AppCompatActivity {
    GorodBinding binding;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = GorodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(5);
        intent = new Intent(City.this, MyService.class);
        startService(intent);
        setMenu(3);
        binding.person.setOnClickListener(v -> {
            Intent i = new Intent(City.this, Character_Settings.class);
            startActivity(i);
            finish();
        });
        binding.Return.setOnClickListener(v -> {
            Character_Settings.setWater(Character_Settings.getWater() - 2);
            Character_Settings.setFood(Character_Settings.getFood() - 1);
            Intent i = new Intent(City.this, Startgame.class);
            startActivity(i);
            finish();
        });
        binding.magazin.setOnClickListener(v -> {
            Character_Settings.setWater(Character_Settings.getWater() - 2);
            Character_Settings.setFood(Character_Settings.getFood() - 1);
            Intent i = new Intent(City.this, Shop.class);
            startActivity(i);
            finish();
        });
        binding.gild.setOnClickListener(v -> {
            Intent i = new Intent(City.this, Gildia.class);
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

