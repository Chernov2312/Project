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
        binding.moneyhave.setText(getResources().getString(R.string.youhavecrat) + getGolds() + getResources().getString(R.string.dolar));
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
                Snackbar.make(binding.smallfood, getResources().getString(R.string.youhave) + foodd[0] + getResources().getString(R.string.small), Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhavecrat) + getGolds() + getResources().getString(R.string.dolar));
            }

        });
        binding.sredfood.setOnClickListener(v -> {
            if (getGolds() >= 100) {
                setGolds(Character_Settings.getGolds() - 100);
                foodd[1] += 1;
                Snackbar.make(binding.sredfood, getResources().getString(R.string.youhave) + foodd[1] + getResources().getString(R.string.sred), Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhavecrat) + getGolds() + getResources().getString(R.string.dolar));
            }
        });
        binding.bigfood.setOnClickListener(v -> {
            if (getGolds() >= 200) {
                setGolds(getGolds() - 200);
                foodd[2] += 1;
                Snackbar.make(binding.bigfood, getResources().getString(R.string.youhave) + foodd[2] + getResources().getString(R.string.big), Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhavecrat) + getGolds() + getResources().getString(R.string.dolar));
            }
        });
        binding.smallwater.setOnClickListener(v -> {
            if (getGolds() >= 50) {
                setGolds(getGolds() - 50);
                waterr[0] += 1;
                Snackbar.make(binding.smallwater, getResources().getString(R.string.youhave) + waterr[0] +getResources().getString(R.string.small), Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhavecrat) + getGolds() + getResources().getString(R.string.dolar));
            }
        });
        binding.sredwater.setOnClickListener(v -> {
            if (getGolds() >= 100) {
                setGolds(getGolds() - 100);
                waterr[1] += 1;
                Snackbar.make(binding.smallwater, getResources().getString(R.string.youhave) + waterr[1] + getResources().getString(R.string.sred), Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhavecrat) + getGolds() + getResources().getString(R.string.dolar));
            }
        });
        binding.bigwater.setOnClickListener(v -> {
            if (getGolds() >= 200) {
                setGolds(getGolds() - 200);
                waterr[2] += 1;
                Snackbar.make(binding.smallwater, getResources().getString(R.string.youhave) + waterr[2] + getResources().getString(R.string.big), Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhavecrat) + getGolds() + getResources().getString(R.string.dolar));
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
