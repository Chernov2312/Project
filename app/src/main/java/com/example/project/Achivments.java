package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.project.databinding.AchivmentsBinding;

public class Achivments extends Character_Settings{
    AchivmentsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AchivmentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.Return.setOnClickListener(v -> {
            Intent i = new Intent(Achivments.this, Character_Settings.class);
            startActivity(i);
        });
        binding.minmaxnet.setText("Неоткрыто");
        binding.middlemaxnet.setText("Неоткрыто");
        binding.goldnet.setText("Неоткрыто");
        binding.earlykiller.setText("Неоткрыто");
        binding.middlekiller.setText("Неоткрыто");
        binding.prokiller.setText("Неоткрыто");
        binding.netvors.setText("Всего денег было: " + getTotal_money() + " $");
        if(getMaxmoney() > 2000) binding.minmaxnet.setText("Максимальное кол-во денег 2000$");
        if(getMaxmoney() > 5000) binding.middlemaxnet.setText("Максимальное кол-во денег 5000$");
        if(getMaxmoney() > 2000) binding.goldnet.setText("Максимальное кол-во денег 10000$");
        if(getKilledmobs() > 10) binding.earlykiller.setText("Убито 10 монстров");
        if(getKilledmobs() > 50) binding.middlekiller.setText("Убито 50 монстров");
        if(getKilledmobs() > 100) binding.prokiller.setText("Убито 100 монстров");
    }
}
