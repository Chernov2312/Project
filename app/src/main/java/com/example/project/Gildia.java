package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import com.example.project.databinding.GildiaBinding;

import java.util.ArrayList;

public class Gildia extends Character_Settings{
    Intent intent;
    GildiaBinding binding;
    ArrayList<String> inventory2 = getInventoryy();
    private static volatile boolean k = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = GildiaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(7);
        intent = new Intent(Gildia.this, MyService.class);
        startService(intent);
        binding.Return.setOnClickListener(v -> {
            Intent i = new Intent(Gildia.this, City.class);
            startActivity(i);
        });
        setMenu(5);
        binding.person.setOnClickListener(v -> {
            Intent i = new Intent(Gildia.this, Character_Settings.class);
            startActivity(i);
            finish();
        });
        if(!k){
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
        binding.podz.setOnClickListener(v -> {
            Intent i = new Intent(Gildia.this, Catacomb.class);
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
