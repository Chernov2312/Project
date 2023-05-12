package com.example.project;

import static com.example.project.MainActivity.setM;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project.databinding.DeathBinding;

public class GameLose extends AppCompatActivity {
    DeathBinding binding;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DeathBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(12);
        intent = new Intent(GameLose.this, MyService.class);
        startService(intent);
        binding.returnplay.setOnClickListener(v -> {
            Intent i = new Intent(GameLose.this, MainActivity.class);
            startActivity(i);
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
