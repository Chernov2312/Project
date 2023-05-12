package com.example.project;


import static com.example.project.MainActivity.setM;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project.databinding.FoodOtdelBinding;

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
        intent = new Intent(Buyproduct.this, MyService.class);
        startService(intent);
        binding.Return.setOnClickListener(v -> {
            Intent i = new Intent(Buyproduct.this, magazin.class);
            startActivity(i);
        });
        binding.smallfood.setOnClickListener(v -> {
            if (getGolds() >= 50) {
                setGolds(getGolds() - 50);
                foodd[0] += 1;
                Toast.makeText(getApplicationContext(),
                        "У вас есть " + foodd[0] + " маленьких пайка", Toast.LENGTH_SHORT).show();
            }
        });
        binding.sredfood.setOnClickListener(v -> {
            if (getGolds() >= 100) {
                setGolds(Character_Settings.getGolds() - 100);
                foodd[1] += 1;
                Toast.makeText(getApplicationContext(),
                        "У вас есть " + foodd[1] + " средних пайков", Toast.LENGTH_SHORT).show();
            }
        });
        binding.bigfood.setOnClickListener(v -> {
            if (getGolds() >= 200) {
                setGolds(getGolds() - 200);
                foodd[2] += 1;
                Toast.makeText(getApplicationContext(),
                        "У вас есть " + foodd[2] + " больших пайков", Toast.LENGTH_SHORT).show();
            }
        });
        binding.smallwater.setOnClickListener(v -> {
            if (getGolds() >= 50) {
                setGolds(getGolds() - 50);
                waterr[0] += 1;
                Toast.makeText(getApplicationContext(),
                        "У вас есть " + waterr[0] + " маленьких бутылок с водой", Toast.LENGTH_SHORT).show();
            }
        });
        binding.sredwater.setOnClickListener(v -> {
            if (getGolds() >= 100) {
                setGolds(getGolds() - 100);
                waterr[1] += 1;
                Toast.makeText(getApplicationContext(),
                        "У вас есть " + waterr[1] + " фляг", Toast.LENGTH_SHORT).show();
            }
        });
        binding.bigwater.setOnClickListener(v -> {
            if (getGolds() >= 200) {
                setGolds(getGolds() - 200);
                waterr[2] += 1;
                Toast.makeText(getApplicationContext(),
                        "У вас есть " + waterr[2] + " бутылей с водой", Toast.LENGTH_SHORT).show();
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
