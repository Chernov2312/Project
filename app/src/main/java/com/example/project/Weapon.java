package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.project.databinding.WeaponBinding;
import com.google.android.material.snackbar.Snackbar;

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
        binding.moneyhave.setText(getResources().getString(R.string.youhave) + getGolds() + getResources().getString(R.string.$));
        binding.smalbottlexit.setOnClickListener(v -> {
            if (getGolds() >= 50) {
                setGolds(getGolds() - 50);
                hillrasx[0] += 1;
                Snackbar.make(binding.shieldbuy, getResources().getString(R.string.youhave) + hillrasx[0] + getResources().getString(R.string.smallhill), Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhave) + getGolds() + getResources().getString(R.string.$));
            }

        });
        binding.mediumbottlexit.setOnClickListener(v -> {
            if (getGolds() >= 100) {
                setGolds(getGolds() - 100);
                hillrasx[1] += 1;
                Snackbar.make(binding.shieldbuy, getResources().getString(R.string.youhave) + hillrasx[1] + getResources().getString(R.string.sredhill), Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhave) + getGolds() + getResources().getString(R.string.$));
            }
        });
        binding.bigbottlexit.setOnClickListener(v -> {
            if (getGolds() >= 200) {
                setGolds(getGolds() - 200);
                hillrasx[2] += 1;
                Snackbar.make(binding.shieldbuy, getResources().getString(R.string.youhave) + hillrasx[2] + getResources().getString(R.string.bighill), Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhave) + getGolds() + getResources().getString(R.string.$));
            }
        });
        binding.shieldbuy.setOnClickListener(v -> {
            if (getGolds() >= 250) {
                setLvlshield(getLvlshield() + 1);
                setBlockdamage(getBlockdamage() + 5);
                Snackbar.make(binding.shieldbuy, getResources().getString(R.string.yourarmoruppgrade) + 5, Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhave) + getGolds() + getResources().getString(R.string.$));
            }
        });
        binding.swordbuy.setOnClickListener(v -> {
            if (getGolds() >= 300) {
                setGolds(getGolds() - 300);
                setLvlmech(getLvlmech() + 1);
                setDamage(getDamage() + 15);
                Snackbar.make(binding.swordbuy, getResources().getString(R.string.yourdamageuppgrade) + 15, Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhave) + getGolds() + getResources().getString(R.string.$));
            }
        });
        binding.clothescreate.setOnClickListener(v -> {
            if (getGolds() >= 250) {
                setGolds(getGolds() - 250);
                setLvlarmor(getLvlarmor() + 1);
                setBlockdamage(getBlockdamage() + 10);
                Snackbar.make(binding.clothescreate, getResources().getString(R.string.yourarmoruppgrade) + 10, Snackbar.LENGTH_SHORT).show();
                binding.moneyhave.setText(getResources().getString(R.string.youhave) + getGolds() + getResources().getString(R.string.$));
            }
        });
        binding.Return.setOnClickListener(v -> {
            setHill(hillrasx);
            Intent i = new Intent(Weapon.this, Shop.class);
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
