package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import com.example.project.databinding.CatacombBinding;

public class Catacomb extends MainActivity{
    CatacombBinding binding;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CatacombBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(8);
        intent = new Intent(Catacomb.this, MyService.class);
        startService(intent);
        binding.return4.setOnClickListener(v -> {
            Intent i = new Intent(Catacomb.this, gildia.class);
            startActivity(i);
        });
        binding.easyandmedium.setOnClickListener(v -> {
            Intent i = new Intent(Catacomb.this, easyandmedium.class);
            startActivity(i);
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
