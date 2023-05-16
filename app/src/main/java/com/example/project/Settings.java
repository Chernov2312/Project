package com.example.project;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.project.databinding.SettingsBinding;

public class Settings extends Character_Settings{
    SettingsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
