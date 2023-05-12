package com.example.project;

import static com.example.project.MainActivity.setM;
import static com.example.project.MainActivity.setMenu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.databinding.MagazinBinding;

public class magazin extends AppCompatActivity {
    MagazinBinding binding;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MagazinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(6);
        intent = new Intent(magazin.this, MyService.class);
        startService(intent);
        binding.person.setOnClickListener(v -> {
            setMenu(4);
            Intent i = new Intent(magazin.this, Character_Settings.class);
            startActivity(i);
        });
        binding.Return.setOnClickListener(v -> {
            Character_Settings.setWater(Character_Settings.getWater() - 2);
            Character_Settings.setFood(Character_Settings.getFood() - 1);
            Intent i = new Intent(magazin.this, Gorod.class);
            startActivity(i);
        });
        binding.foodotdel.setOnClickListener(v -> {
            Intent i = new Intent(magazin.this, Buyproduct.class);
            startActivity(i);
        });
        binding.weaponotdel.setOnClickListener(v -> {
            Intent i = new Intent(magazin.this, Weapon.class);
            startActivity(i);
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
