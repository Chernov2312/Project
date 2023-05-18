package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project.databinding.HomeBinding;
import com.google.android.material.snackbar.Snackbar;

public class Home extends Character_Settings {
    HomeBinding binding;
    volatile static int boxcheked = 0;
    int[] foodd = getFoodf();
    int[] waterd = getWaterr();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(3);
        intent = new Intent(Home.this, MyService.class);
        startService(intent);
        binding.Return3.setOnClickListener(v -> {
            setWater(Character_Settings.getWater() - 2);
            setWater(Character_Settings.getWater() - 5);
            setFood(Character_Settings.getFood() - 1);
            Intent i = new Intent(Home.this, Startgame.class);
            startActivity(i);
            finish();
        });
        setMenu(2);
        binding.person.setOnClickListener(v -> {
            Intent i = new Intent(Home.this, Character_Settings.class);
            startActivity(i);
            finish();
        });
        binding.box.setOnClickListener(v -> {
            int s = Randomlut();
            if (s == 0) {
                Snackbar.make(binding.box, "Вы ничего не нашли", Snackbar.LENGTH_SHORT).show();
            } else if (s == 1) {
                Snackbar.make(binding.box, "Вы нашли 100 монет", Snackbar.LENGTH_SHORT).show();
                setGolds(getGolds() + 100);
                setTotal_money(getTotal_money() + 100);
            } else if (s == 2) {
                Snackbar.make(binding.box, "Вы нашли 500 монет и 3 больших пайка", Snackbar.LENGTH_SHORT).show();
                setGolds(getGolds() + 500);
                setTotal_money(getTotal_money() + 500);
                foodd[2] += 3;
            } else if (s == 3) {
                Snackbar.make(binding.box, "Вы нашли 500 монет,4 больших пайка и бутыль воды", Snackbar.LENGTH_SHORT).show();
                setGolds(getGolds() + 500);
                setTotal_money(getTotal_money() + 500);
                foodd[2] += 3;
                waterd[2] += 1;
            }
            setWater(getWater() - 2);
            setFood(getFood() - 1);
            setFoodd(foodd);
            setWaterr(waterd);
            setWater(getWater() - 5);
            setFood(getFood() - 1);

            boxcheked = 1;
            binding.box.setVisibility(View.INVISIBLE);
        });
        if (boxcheked == 1) binding.box.setVisibility(View.INVISIBLE);

    }

    public static int Randomlut() {
        int a = (int) (Math.random() * 100);
        if (a <= 10) return 0;
        else if (a <= 50) return 1;
        else if (a <= 75) return 2;
        else return 3;
    }

    public static int Randomlut2() {
        int a = (int) (Math.random() * 100);
        if (a <= 25) return 0;
        else if (a <= 50) return 1;
        else if (a <= 75) return 2;
        else return 3;
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }

    public static int getBoxcheked() {
        return boxcheked;
    }

    public static void setBoxcheked(int boxcheked) {
        Home.boxcheked = boxcheked;
    }
}
