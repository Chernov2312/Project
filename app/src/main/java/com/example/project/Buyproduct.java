package com.example.project;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.project.databinding.FoodOtdelBinding;
import com.google.android.material.snackbar.Snackbar;

public class Buyproduct extends Character_Settings {
    FoodOtdelBinding binding;
    int[] foodd = getFoodf();
    int[] waterr = getWaterr();
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FoodOtdelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(6);
        binding.moneyhave.setText("У вас: " + getGolds() + "$");
        intent = new Intent(Buyproduct.this, MyService.class);
        startService(intent);
        binding.Return.setOnClickListener(v -> {
            Intent i = new Intent(Buyproduct.this, Shop.class);
            startActivity(i);
            finish();
        });
        binding.smallfood.setOnClickListener(v -> {
            if (getGolds() >= 50) {
                setGolds(getGolds() - 50);
                foodd[0] += 1;
                Snackbar.make(binding.smallfood, "У вас есть " + foodd[0] + " маленьких пайка", Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText("У вас: " + getGolds() + "$");
            }

        });
        binding.sredfood.setOnClickListener(v -> {
            if (getGolds() >= 100) {
                setGolds(Character_Settings.getGolds() - 100);
                foodd[1] += 1;
                Snackbar.make(binding.sredfood, "У вас есть " + foodd[1] + " средних пайков", Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText("У вас: " + getGolds() + "$");
            }
        });
        binding.bigfood.setOnClickListener(v -> {
            if (getGolds() >= 200) {
                setGolds(getGolds() - 200);
                foodd[2] += 1;
                Snackbar.make(binding.bigfood, "У вас есть " + foodd[2] + " больших пайков", Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText("У вас: " + getGolds() + "$");
            }
        });
        binding.smallwater.setOnClickListener(v -> {
            if (getGolds() >= 50) {
                setGolds(getGolds() - 50);
                waterr[0] += 1;
                Snackbar.make(binding.smallwater, "У вас есть " + waterr[0] + " маленьких бутылок с водой", Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText("У вас: " + getGolds() + "$");
            }
        });
        binding.sredwater.setOnClickListener(v -> {
            if (getGolds() >= 100) {
                setGolds(getGolds() - 100);
                waterr[1] += 1;
                Snackbar.make(binding.smallwater, "У вас есть " + waterr[1] + " фляг", Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText("У вас: " + getGolds() + "$");
            }
        });
        binding.bigwater.setOnClickListener(v -> {
            if (getGolds() >= 200) {
                setGolds(getGolds() - 200);
                waterr[2] += 1;
                Snackbar.make(binding.smallwater, "У вас есть " + waterr[2] + " бутылей с водой", Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText("У вас: " + getGolds() + "$");
            }
        });
        setWaterr(waterr);
        setFoodd(foodd);
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
