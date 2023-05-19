package com.example.project;

import static com.example.project.MainActivity.setM;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.databinding.BossBinding;

public class BossFight extends AppCompatActivity {
    BossBinding binding;
    private static int BossXitpoints = 10000;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = BossBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bossXp.setText("BOSS XP: " + BossXitpoints);
        setM(11);
        intent = new Intent(BossFight.this, MyService.class);
        startService(intent);
        binding.attack.setOnClickListener(v -> {
           BossXitpoints -= Character_Settings.getDamage();
           Character_Settings.setXit_points((int) (Character_Settings.getXit_points() - 700 * (1 - (float)Character_Settings.getBlockdamage()/100)));
           binding.bossXp.setText("BOSS XP: " + BossXitpoints);
           if(Character_Settings.getXit_points() < 0){
               Intent i = new Intent(BossFight.this, GameLose.class);
               startActivity(i);
               finish();
           }
           if(BossXitpoints <= 0){
               Intent i = new Intent(BossFight.this, WinGame.class);
               startActivity(i);
               finish();
           }
            binding.fightxitPoints.setText("Ваше здоровье: " + Character_Settings.getXit_points());
        });
        binding.fightxitPoints.setText("Ваше здоровье: " + Character_Settings.getXit_points());
        binding.person.setOnClickListener(v -> {
            MainActivity.setMenu(6);
            Intent i = new Intent(BossFight.this, Character_Settings.class);
            startActivity(i);
            finish();
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }

    public static int getBossXitpoints() {
        return BossXitpoints;
    }

    public static void setBossXitpoints(int bossXitpoints) {
        BossXitpoints = bossXitpoints;
    }
}
