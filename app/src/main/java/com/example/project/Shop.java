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
        setMenu(4);
        binding.moneyhave.setText(getResources().getString(R.string.youhave) + getGolds() + getResources().getString(R.string.dolar));
        binding.person.setOnClickListener(v -> {
            Intent i = new Intent(Shop.this, Character_Settings.class);
            startActivity(i);
            finish();
        });
        binding.Return.setOnClickListener(v -> {
            setWater(getWater() - 2);
            setFood(getFood() - 1);
            Character_Settings.setWater(Character_Settings.getWater() - 4);
            Character_Settings.setFood(Character_Settings.getFood() - 2);
            if(Character_Settings.getFood() <= 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            if(Character_Settings.getWater() <= 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            if(Character_Settings.getXit_points() <= 0){
                Intent ig = new Intent(Shop.this, GameLose.class);
                startActivity(ig);
            }else{
            Intent i = new Intent(Shop.this, City.class);
            startActivity(i);}
            finish();
        });
        binding.foodotdel.setOnClickListener(v -> {
            Intent i = new Intent(Shop.this, Buyproduct.class);
            startActivity(i);
            finish();
        });
        binding.weaponotdel.setOnClickListener(v -> {
            Intent i = new Intent(Shop.this, Weapon.class);
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
