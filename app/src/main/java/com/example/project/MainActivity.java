package com.example.project;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static int menu = 0;
    private static int m = 1;
    static int d = 0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        m = 1;
        intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);
        binding.person.setOnClickListener(v -> {
            menu = 0;
            Intent i = new Intent(MainActivity.this, Character_Settings.class);
            startActivity(i);
        });
        binding.exit.setOnClickListener(v -> {
            this.finishAffinity();
        });
        binding.load.setOnClickListener(v -> {
            load2();
            Snackbar.make(binding.load, getResources().getString(R.string.loadsave), Snackbar.LENGTH_SHORT).show();
            d = 1;
            recreate();
        });
        if (d == 1) {
            binding.play.setText(getResources().getString(R.string.played));
        }
        binding.play.setOnClickListener(v -> {
            if (d != 1) {
                setMenu(0);
                newGame();
            }
            game();
        });
    }

    public static int getM() {
        return m;
    }

    public static void setM(int m) {
        MainActivity.m = m;
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }

    public static int getMenu() {
        return menu;
    }

    public static void setMenu(int menu2) {
        menu = menu2;
    }

    public void newGame() {
        Character_Settings.setGolds(1000);
        Character_Settings.setLevel(1);
        Character_Settings.setXit_points(100);
        Character_Settings.setMaxXit_points(100);
        Character_Settings.setFood(50);
        Character_Settings.setWater(60);
        Character_Settings.setFoodd(new int[]{0, 0, 0});
        Character_Settings.setWaterr(new int[]{0, 0, 0});
        Character_Settings.setHill(new int[]{4, 2, 3});
        Character_Settings.damage = 20;
        Character_Settings.blockdamage = 1;
        Character_Settings.setLvlmech(1);
        Character_Settings.setLvlshield(1);
        Character_Settings.setLvlmag(1);
        Character_Settings.setLvlarmor(1);
        Character_Settings.setS(true);
        Character_Settings.setInventoryy(new ArrayList<String>());
    }

    public void game() {
        if (getMenu() == 1 || getMenu() == 0) {
            Intent i = new Intent(MainActivity.this, Startgame.class);
            startActivity(i);
        } else if (getMenu() == 2) {
            Intent i = new Intent(MainActivity.this, Home.class);
            startActivity(i);
        } else if (getMenu() == 3) {
            Intent i = new Intent(MainActivity.this, City.class);
            startActivity(i);
        } else if (getMenu() == 4) {
            Intent i = new Intent(MainActivity.this, Shop.class);
            startActivity(i);
        } else if (getMenu() == 5) {
            Intent i = new Intent(MainActivity.this, Gildia.class);
            startActivity(i);
        } else if (getMenu() == 6) {
            Intent i = new Intent(MainActivity.this, BossFight.class);
            startActivity(i);
        } else if (getMenu() == 7) {
            Intent i = new Intent(MainActivity.this, Easyandmedium.class);
            startActivity(i);
        } else if (getMenu() == 8) {
            Intent i = new Intent(MainActivity.this, WinGame.class);
            startActivity(i);
        } else if (getMenu() == 9) {
            Intent i = new Intent(MainActivity.this, GameLose.class);
            startActivity(i);
        }
    }

    public void load2() {
        Character_Settings.setGolds(Settings.sharedPreferences.getInt(Settings.GOLDS_PREFERENCE, Character_Settings.getGolds()));
        Toast.makeText(this, ""+Character_Settings.getGolds(),
                Toast.LENGTH_LONG).show();
        Character_Settings.setLevel(Settings.sharedPreferences.getInt(Settings.LEVEL_PREFERENCE, Character_Settings.getLevel()));
        Character_Settings.setXit_points(Settings.sharedPreferences.getInt(Settings.XIT_POINTS_PREFERENCE, Character_Settings.getXit_points()));
        Character_Settings.setMaxXit_points(Settings.sharedPreferences.getInt(Settings.MAXXITPOINTS_PREFERENCE, Character_Settings.getMaxXit_points()));
        Character_Settings.setFood(Settings.sharedPreferences.getInt(Settings.FOOD_PREFERENCE, Character_Settings.getFood()));
        Character_Settings.setWater(Settings.sharedPreferences.getInt(Settings.WATER_PREFERENCE, Character_Settings.getWater()));
        Character_Settings.setMaxmoney(Settings.sharedPreferences.getInt(Settings.MAXMONEY_PREFERENCE, Character_Settings.getMaxmoney()));
        Character_Settings.setKilledmobs(Settings.sharedPreferences.getInt(Settings.kILLEDMOBS_PREFERENCE, Character_Settings.getKilledmobs()));
        Character_Settings.setTotal_money(Settings.sharedPreferences.getInt(Settings.TOTAL_MONEY_PREFERENCE, Character_Settings.getTotal_money()));
        Character_Settings.setDamage(Settings.sharedPreferences.getInt(Settings.DAMAGE_PREFERENCE, Character_Settings.getDamage()));
        Character_Settings.setBlockdamage(Settings.sharedPreferences.getInt(Settings.BLOCKDAMAGE_PREFERENCE, Character_Settings.getBlockdamage()));
        Character_Settings.setLvlmech(Settings.sharedPreferences.getInt(Settings.LVLMECH_PREFERENCE, Character_Settings.getLvlmech()));
        Character_Settings.setLvlshield(Settings.sharedPreferences.getInt(Settings.LVLSHIELD_PREFERENCE, Character_Settings.getLvlshield()));
        Character_Settings.setLvlmag(Settings.sharedPreferences.getInt(Settings.LVLMAG_PREFERENCE, Character_Settings.getLvlmag()));
        Character_Settings.setLvlarmor(Settings.sharedPreferences.getInt(Settings.LVLARMOR_PREFERENCE, Character_Settings.getLvlarmor()));
        Settings.Foodff[0] = Settings.sharedPreferences.getInt(Settings.FOODF1_PREFERENCE, Character_Settings.getFoodf()[0]);
        Settings.Foodff[1] = Settings.sharedPreferences.getInt(Settings.FOODF2_PREFERENCE, Character_Settings.getFoodf()[1]);
        Settings.Foodff[2] = Settings.sharedPreferences.getInt(Settings.FOODF3_PREFERENCE, Character_Settings.getFoodf()[2]);
        Settings.Waterff[0] = Settings.sharedPreferences.getInt(Settings.WATER1_PREFERENCE, Character_Settings.getWaterr()[0]);
        Settings.Waterff[1] = Settings.sharedPreferences.getInt(Settings.WATER2_PREFERENCE, Character_Settings.getWaterr()[1]);
        Settings.Waterff[2] = Settings.sharedPreferences.getInt(Settings.WATER3_PREFERENCE, Character_Settings.getWaterr()[2]);
        Settings.Hillff[0] = Settings.sharedPreferences.getInt(Settings.HILL1_PREFERENCE, Character_Settings.getHill()[0]);
        Settings.Hillff[1] = Settings.sharedPreferences.getInt(Settings.HILL2_PREFERENCE, Character_Settings.getHill()[1]);
        Settings.Hillff[2] = Settings.sharedPreferences.getInt(Settings.HILL3_PREFERENCE, Character_Settings.getHill()[2]);
        setMenu(Settings.sharedPreferences.getInt(Settings.MENU_PREFERENCE, getMenu()));
        Character_Settings.setS(Settings.sharedPreferences.getBoolean(Settings.S_PREFERENCE, Character_Settings.getS()));
        Home.setBoxcheked(Settings.sharedPreferences.getInt(Settings.BOXCHEKED, Home.getBoxcheked()));
        BossFight.setBossXitpoints(Settings.sharedPreferences.getInt(Settings.BOSS_XIT_POINTS, BossFight.getBossXitpoints()));
        Easyandmedium.setMob_xit_points(Settings.sharedPreferences.getInt(Settings.MOB_XIT_POINTS, Easyandmedium.getMob_xit_points()));
        Easyandmedium.setMob(Settings.sharedPreferences.getInt(Settings.MOB, Easyandmedium.getMob()));
        Easyandmedium.setMob_damage(Settings.sharedPreferences.getInt(Settings.MOB_DAMAGE, Easyandmedium.getMob_damage()));
        Character_Settings.setFoodd(Settings.Foodff);
        Settings.music = Settings.sharedPreferences.getBoolean(Settings.MUSIC, Settings.music);
        Character_Settings.setWaterr(Settings.Waterff);
        Character_Settings.setHill(Settings.Hillff);
        Character_Settings.setInventoryy(new ArrayList<>(Settings.sharedPreferences.getStringSet(Settings.INVENTORYY_PREFERENCE, Settings.set)));
    }
}