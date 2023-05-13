package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.project.databinding.MagazinBinding;

public class Shop extends Character_Settings {
    MagazinBinding binding;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MagazinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(6);
        intent = new Intent(Shop.this, MyService.class);
        startService(intent);
        binding.person.setOnClickListener(v -> {
            setMenu(4);
            Intent i = new Intent(Shop.this, Character_Settings.class);
            startActivity(i);
        });
        binding.Return.setOnClickListener(v -> {
            setWater(getWater() - 2);
            setFood(getFood() - 1);
            Intent i = new Intent(Shop.this, City.class);
            startActivity(i);
        });
        binding.foodotdel.setOnClickListener(v -> {
            Intent i = new Intent(Shop.this, Buyproduct.class);
            startActivity(i);
        });
        binding.weaponotdel.setOnClickListener(v -> {
            Intent i = new Intent(Shop.this, Weapon.class);
            startActivity(i);
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
