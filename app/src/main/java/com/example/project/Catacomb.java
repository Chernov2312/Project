package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import com.example.project.databinding.CatacombBinding;

public class Catacomb extends MainActivity{
    CatacombBinding binding;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CatacombBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(8);
        intent = new Intent(Catacomb.this, MyService.class);
        startService(intent);
        binding.return4.setOnClickListener(v -> {
            if(Character_Settings.getFood() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            if(Character_Settings.getWater() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            Intent i = new Intent(Catacomb.this, Gildia.class);
            startActivity(i);
            finish();
        });
        binding.easyandmedium.setOnClickListener(v -> {
            if(Character_Settings.getFood() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            if(Character_Settings.getWater() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            Intent i = new Intent(Catacomb.this, Easyandmedium.class);
            startActivity(i);
            finish();
        });
        binding.Boss.setOnClickListener(v -> {
            Character_Settings.setWater(Character_Settings.getWater() - 4);
            Character_Settings.setFood(Character_Settings.getFood() - 2);
            if(Character_Settings.getFood() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            if(Character_Settings.getWater() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            Intent i = new Intent(Catacomb.this, BossFight.class);
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
