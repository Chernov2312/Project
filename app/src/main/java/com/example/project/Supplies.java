package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.project.databinding.RasxodnBinding;
import com.google.android.material.snackbar.Snackbar;

public class Supplies extends Character_Settings {
    RasxodnBinding binding;
    Intent intent;
    int[] foodr = getFoodf();
    int[] waterf = getWaterr();
    int[] hillrasx = getHill();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RasxodnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(2);
        intent = new Intent(Supplies.this, MyService.class);
        startService(intent);
        String[] rasxodn2 = {"Маленький пайков: " + foodr[0],
                "Средних пайков: " + foodr[1],
                "Больших пайков: " + foodr[2],
                "Маленьких бутылок: " + waterf[0],
                "Фляг: " + waterf[1],
                "Больших бутылок: " + waterf[2],
                "Маленьких хилок: " + hillrasx[0],
                "Средних хилок: " + hillrasx[1],
                "Больших хилок: " + hillrasx[2]
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, rasxodn2);
        binding.listrasx.setAdapter(adapter);
        binding.listrasx.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0 && foodr[0] != 0) {
                    setFood(getFood() + 30);
                    foodr[0] -= 1;
                    rasxodn2[0] = "Маленький пайков: " + foodr[0];
                } else if (position == 1 && foodr[1] != 0) {
                    setFood(getFood() + 50);
                    foodr[1] -= 1;
                    rasxodn2[1] = "Средних пайков: " + foodr[1];
                } else if (position == 2 && foodr[2] != 0) {
                    setFood(getFood() + 80);
                    foodr[2] -= 1;
                    rasxodn2[2] = "Больших пайков: " + foodr[2];
                }
                else if (position == 3 && waterf[0] != 0) {
                    setWater(getWater() + 30);
                    waterf[0] -= 1;
                    rasxodn2[3] = "Маленьких бутылок: " + waterf[0];
                }
                else if (position == 4 && waterf[1] != 0) {
                    setWater(getWater() + 50);
                    waterf[1] -= 1;
                    rasxodn2[4] = "Фляг: " + waterf[1];
                }
                else if (position == 5 && waterf[2] != 0) {
                    setWater(getWater() + 80);
                    waterf[2] -= 1;
                    rasxodn2[5] = "Больших бутылок: " + waterf[2];
                }
                else if (position == 6 && hillrasx[0] != 0) {
                    setXit_points(getXit_points() + 10);
                    hillrasx[0] -= 1;
                    rasxodn2[6] = "Маленьких хилок: " + hillrasx[0];
                }
                else if (position == 7 && hillrasx[1] != 0) {
                    setXit_points(getXit_points() + 20);
                    hillrasx[1] -= 1;
                    rasxodn2[7] = "Средних хилок: " + hillrasx[1];
                }
                else if (position == 8 && hillrasx[2] != 0) {
                    setXit_points(getXit_points() + 30);
                    hillrasx[2] -= 1;
                    rasxodn2[8] = "Больших хилок: " + hillrasx[2];
                }
                Snackbar.make(binding.listrasx, "Жажда " + getWater() + " голод " + getFood() + " кол-во жизни " + getXit_points(), Snackbar.LENGTH_SHORT).show();
                recreate();
            }
        });
        if (getXit_points() > getMaxXit_points()){
            setXit_points(getMaxXit_points());
        }
        if (getFood() > 100){
            setFood(100);
        }
        if (getWater() > 100){
            setWater(100);
        }
        setFoodd(foodr);
        setWaterr(waterf);
        setHill(hillrasx);
        binding.return2.setOnClickListener(v -> {
            Intent i = new Intent(Supplies.this, InventoryActivity.class);
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
