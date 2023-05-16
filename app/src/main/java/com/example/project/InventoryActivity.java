package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import com.example.project.databinding.InventoryBinding;

import java.util.ArrayList;

public class InventoryActivity extends Character_Settings {
    private InventoryBinding binding;
    ArrayList<String> inventory = getInventoryy();
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = InventoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(2);
        intent = new Intent(InventoryActivity.this, MyService.class);
        startService(intent);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, inventory);
        binding.predmets.setAdapter(adapter);
        startService(new Intent(this, MyService.class));
        binding.Return2.setOnClickListener(v -> {
            if (getInventory() == 0) {
                Intent i = new Intent(InventoryActivity.this, Character_Settings.class);
                startActivity(i);
                finish();
            }
        });
        binding.rasxodn.setOnClickListener(v -> {
            Intent i = new Intent(InventoryActivity.this, Supplies.class);
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

