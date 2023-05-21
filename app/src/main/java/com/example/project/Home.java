package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project.databinding.HomeBinding;
import com.google.android.material.snackbar.Snackbar;

public class Home extends Character_Settings {
    HomeBinding binding;
    public static int boxcheked = 0;
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
            Character_Settings.setWater(Character_Settings.getWater() - 4);
            Character_Settings.setFood(Character_Settings.getFood() - 2);
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
                Snackbar.make(binding.box, getResources().getString(R.string.nothing), Snackbar.LENGTH_SHORT).show();
            } else if (s == 1) {
                Snackbar.make(binding.box, getResources().getString(R.string.money100), Snackbar.LENGTH_SHORT).show();
                setGolds(getGolds() + 100);
                setTotal_money(getTotal_money() + 100);
            } else if (s == 2) {
                Snackbar.make(binding.box, getResources().getString(R.string.money500), Snackbar.LENGTH_SHORT).show();
                setGolds(getGolds() + 500);
                setTotal_money(getTotal_money() + 500);
                foodd[2] += 3;
            } else if (s == 3) {
                Snackbar.make(binding.box, getResources().getString(R.string.money5004), Snackbar.LENGTH_SHORT).show();
                setGolds(getGolds() + 500);
                setTotal_money(getTotal_money() + 500);
                foodd[2] += 3;
                waterd[2] += 1;
            }
            Character_Settings.setWater(Character_Settings.getWater() - 4);
            Character_Settings.setFood(Character_Settings.getFood() - 2);
            if(Character_Settings.getFood() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            if(Character_Settings.getWater() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            setFoodd(foodd);
            setWaterr(waterd);

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
