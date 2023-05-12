package com.example.project;

import static com.example.project.MainActivity.setM;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project.databinding.WingameBinding;

public class WinGame extends AppCompatActivity {
    WingameBinding binding;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = WingameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(13);
        intent = new Intent(WinGame.this, MyService.class);
        startService(intent);
        binding.menu.setOnClickListener(v -> {
            Intent intent = new Intent(WinGame.this, MainActivity.class);
            startService(intent);
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
