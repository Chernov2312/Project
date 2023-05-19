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
            finish();
        });
        binding.minmaxnet.setText(getResources().getString(R.string.dontopen));
        binding.middlemaxnet.setText(getResources().getString(R.string.dontopen));
        binding.goldnet.setText(getResources().getString(R.string.dontopen));
        binding.earlykiller.setText(getResources().getString(R.string.dontopen));
        binding.middlekiller.setText(getResources().getString(R.string.dontopen));
        binding.prokiller.setText(getResources().getString(R.string.dontopen));
        binding.netvors.setText( getResources().getString(R.string.netv) + getTotal_money() + getResources().getString(R.string.$));
        if(getMaxmoney() > 2000) binding.minmaxnet.setText(getResources().getString(R.string.maxnetvors2000));
        if(getMaxmoney() > 5000) binding.middlemaxnet.setText(getResources().getString(R.string.maxnetvors5000));
        if(getMaxmoney() > 2000) binding.goldnet.setText(getResources().getString(R.string.maxnetvors10000));
        if(getKilledmobs() > 10) binding.earlykiller.setText(getResources().getString(R.string.killed10mobs));
        if(getKilledmobs() > 50) binding.middlekiller.setText(getResources().getString(R.string.killed50mobs));
        if(getKilledmobs() > 100) binding.prokiller.setText(getResources().getString(R.string.killed100mobs));
    }
}
