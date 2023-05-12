package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import com.example.project.databinding.GildiaBinding;

import java.util.ArrayList;

public class gildia extends Character_Settings{
    Intent intent;
    GildiaBinding binding;
    ArrayList<String> inventory2 = getInventoryy();
    private boolean k = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = GildiaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(7);
        intent = new Intent(gildia.this, MyService.class);
        startService(intent);
        binding.Return.setOnClickListener(v -> {
            Intent i = new Intent(gildia.this, Gorod.class);
            startActivity(i);
        });
        binding.person.setOnClickListener(v -> {
            setMenu(5);
            Intent i = new Intent(gildia.this, Character_Settings.class);
            startActivity(i);
        });
        if(k == false){
            binding.nachsnar.setVisibility(View.INVISIBLE);
        }
        binding.nachsnar.setOnClickListener(v -> {
            k = false;
            binding.nachsnar.setVisibility(View.INVISIBLE);
            inventory2.remove(0);
            inventory2.add("Короткий меч 1lvl");
            inventory2.add("Нагрудник из кольчуги 1lvl");
            inventory2.add("Кожаные сапоги 1lvl");
            inventory2.add("Круглый щит 1lvl");
            inventory2.add("Магический артефакт 1lvl");
            setDamage(getDamage() + 50);
            setBlockdamage(getBlockdamage() + 15);
            setInventoryy(inventory2);
        });
        binding.Boss.setOnClickListener(v -> {
            Intent i = new Intent(gildia.this, BossFight.class);
            startActivity(i);
        });
        binding.podz.setOnClickListener(v -> {
            Intent i = new Intent(gildia.this, Catacomb.class);
            startActivity(i);
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
