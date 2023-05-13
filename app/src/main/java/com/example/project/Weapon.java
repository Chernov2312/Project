package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.project.databinding.WeaponBinding;

public class Weapon extends Character_Settings {
    WeaponBinding binding;
    Intent intent;
    int[] hillrasx = getHill();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = WeaponBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(6);
        intent = new Intent(Weapon.this, MyService.class);
        startService(intent);
        binding.smalbottlexit.setOnClickListener(v -> {
            if (getGolds() >= 50) {
                setGolds(getGolds() - 50);
                hillrasx[0] += 1;
                Toast.makeText(getApplicationContext(),
                        "У вас есть " + hillrasx[0] + " маленьких хилок", Toast.LENGTH_SHORT).show();
            }
        });
        binding.mediumbottlexit.setOnClickListener(v -> {
            if(getGolds() >= 100){
                setGolds(getGolds() - 100);
            hillrasx[1] += 1;
            Toast.makeText(getApplicationContext(),
                    "У вас есть " + hillrasx[1] + " средних хилок", Toast.LENGTH_SHORT).show();}
        });
        binding.bigbottlexit.setOnClickListener(v -> {
            if(getGolds() >= 200) {
                setGolds(getGolds() - 200);
                hillrasx[2] += 1;
                Toast.makeText(getApplicationContext(),
                        "У вас есть " + hillrasx[2] + " больших хилок", Toast.LENGTH_SHORT).show();
            }});
        binding.shieldbuy.setOnClickListener(v -> {
            if(getGolds() >= 250) {
                setLvlshield(getLvlshield() + 1);
                setBlockdamage(getBlockdamage() + 5);
                Toast.makeText(getApplicationContext(),
                        "Ваша защита увеличена на " + 5, Toast.LENGTH_SHORT).show();
            }});
        binding.swordbuy.setOnClickListener(v -> {
            if(getGolds() >= 300) {
                setGolds(getGolds() - 300);
                setLvlmech(getLvlmech() + 1);
                setDamage(getDamage() + 15);
                Toast.makeText(getApplicationContext(),
                        "Ваш урон увеличен на " + 15, Toast.LENGTH_SHORT).show();
            }});
        binding.clothescreate.setOnClickListener(v -> {
            if(getGolds() >= 250) {
                setGolds(getGolds() - 250);
                setLvlarmor(getLvlarmor() + 1);
                setBlockdamage(getBlockdamage() + 10);
                Toast.makeText(getApplicationContext(),
                        "Ваша защита увеличена на " + 10, Toast.LENGTH_SHORT).show();
            }});
        binding.Return.setOnClickListener(v -> {
            setHill(hillrasx);
            Intent i = new Intent(Weapon.this, Shop.class);
            startActivity(i);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
