package com.example.project;

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
    }
}
