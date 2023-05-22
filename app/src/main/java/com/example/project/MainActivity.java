package com.example.project;

import static com.example.project.Character_Settings.getInventoryy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.project.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static int menu = 0;
    private static int m = 1;
    public static SharedPreferences sharedPreferences;
    Intent intent;
    public static Set<String> set = new HashSet<>(getInventoryy());
    public static int[] Foodff = {0, 0, 0};
    public static int[] Waterff = {0, 0, 0};
    public static int[] Hillff = {0, 0, 0};
    private static ArrayList<String> strings = new ArrayList<>();

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
        binding.save.setOnClickListener(v -> {
            savegame();
            Snackbar.make(binding.save, getResources().getString(R.string.savesuccesfull), Snackbar.LENGTH_SHORT).show();
        });
        binding.exit.setOnClickListener(v -> {
            this.finishAffinity();
        });
        binding.load.setOnClickListener(v -> {
            load2();
            game();
        });
        binding.goplay.setOnClickListener(v -> {
            game();
        });
        binding.play.setOnClickListener(v -> {
            setMenu(0);
            newGame();
            game();
        });
    }

    private void savegame() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putInt(Settings.GOLDS_PREFERENCE, Character_Settings.getGolds());
        ed.putInt(Settings.MOB_DAMAGE, Easyandmedium.getMob_damage());
        ed.putInt(Settings.MOB, Easyandmedium.getMob());
        ed.putInt(Settings.MOB_XIT_POINTS, Easyandmedium.getMob_xit_points());
        ed.putInt(Settings.LEVEL_PREFERENCE, Character_Settings.getLevel());
        ed.putInt(Settings.XIT_POINTS_PREFERENCE, Character_Settings.getXit_points());
        ed.putInt(Settings.MAXXITPOINTS_PREFERENCE, Character_Settings.getMaxXit_points());
        ed.putInt(Settings.FOOD_PREFERENCE, Character_Settings.getFood());
        ed.putInt(Settings.WATER_PREFERENCE, Character_Settings.getWater());
        ed.putInt(Settings.BOXCHEKED, Home.getBoxcheked());
        ed.putInt(Settings.MAXMONEY_PREFERENCE, Character_Settings.getMaxmoney());
        ed.putInt(Settings.kILLEDMOBS_PREFERENCE, Character_Settings.getKilledmobs());
        ed.putInt(Settings.TOTAL_MONEY_PREFERENCE, Character_Settings.getTotal_money());
        ed.putInt(Settings.DAMAGE_PREFERENCE, Character_Settings.getDamage());
        ed.putInt(Settings.BLOCKDAMAGE_PREFERENCE, Character_Settings.getBlockdamage());
        ed.putBoolean(Settings.MUSIC, Settings.music);
        ed.putInt(Settings.LVLMECH_PREFERENCE, Character_Settings.getLvlmech());
        ed.putInt(Settings.LVLSHIELD_PREFERENCE, Character_Settings.getLvlshield());
        ed.putInt(Settings.LVLMAG_PREFERENCE, Character_Settings.getLvlmag());
        ed.putInt(Settings.LVLARMOR_PREFERENCE, Character_Settings.getLvlarmor());
        ed.putInt(Settings.FOODF1_PREFERENCE, Character_Settings.getFoodf()[0]);
        ed.putInt(Settings.FOODF2_PREFERENCE, Character_Settings.getFoodf()[1]);
        ed.putInt(Settings.FOODF3_PREFERENCE, Character_Settings.getFoodf()[2]);
        ed.putInt(Settings.WATER1_PREFERENCE, Character_Settings.getWaterr()[0]);
        ed.putInt(Settings.WATER2_PREFERENCE, Character_Settings.getWaterr()[1]);
        ed.putInt(Settings.WATER3_PREFERENCE, Character_Settings.getWaterr()[2]);
        ed.putInt(Settings.HILL1_PREFERENCE, Character_Settings.getHill()[0]);
        ed.putInt(Settings.HILL2_PREFERENCE, Character_Settings.getHill()[1]);
        ed.putInt(Settings.HILL3_PREFERENCE, Character_Settings.getHill()[2]);
        ed.putInt(Settings.MENU_PREFERENCE, getMenu());
        ed.putInt(Settings.BOSS_XIT_POINTS, BossFight.getBossXitpoints());
        ed.putStringSet(Settings.INVENTORYY_PREFERENCE, set);
        ed.putBoolean(Settings.S_PREFERENCE, Character_Settings.getS());
        ed.putBoolean(Settings.K, Gildia.isK());
        ed.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        savegame();
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
        Home.setBoxcheked(0);
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
        Gildia.setK(true);
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
        sharedPreferences = getPreferences(MODE_PRIVATE);
        Character_Settings.setGolds(sharedPreferences.getInt(Settings.GOLDS_PREFERENCE, Character_Settings.getGolds()));
        Character_Settings.setLevel(sharedPreferences.getInt(Settings.LEVEL_PREFERENCE, Character_Settings.getLevel()));
        Character_Settings.setXit_points(sharedPreferences.getInt(Settings.XIT_POINTS_PREFERENCE, Character_Settings.getXit_points()));
        Character_Settings.setMaxXit_points(sharedPreferences.getInt(Settings.MAXXITPOINTS_PREFERENCE, Character_Settings.getMaxXit_points()));
        Character_Settings.setFood(sharedPreferences.getInt(Settings.FOOD_PREFERENCE, Character_Settings.getFood()));
        Character_Settings.setWater(sharedPreferences.getInt(Settings.WATER_PREFERENCE, Character_Settings.getWater()));
        Character_Settings.setMaxmoney(sharedPreferences.getInt(Settings.MAXMONEY_PREFERENCE, Character_Settings.getMaxmoney()));
        Character_Settings.setKilledmobs(sharedPreferences.getInt(Settings.kILLEDMOBS_PREFERENCE, Character_Settings.getKilledmobs()));
        Character_Settings.setTotal_money(sharedPreferences.getInt(Settings.TOTAL_MONEY_PREFERENCE, Character_Settings.getTotal_money()));
        Character_Settings.setDamage(sharedPreferences.getInt(Settings.DAMAGE_PREFERENCE, Character_Settings.getDamage()));
        Character_Settings.setBlockdamage(sharedPreferences.getInt(Settings.BLOCKDAMAGE_PREFERENCE, Character_Settings.getBlockdamage()));
        Character_Settings.setLvlmech(sharedPreferences.getInt(Settings.LVLMECH_PREFERENCE, Character_Settings.getLvlmech()));
        Character_Settings.setLvlshield(sharedPreferences.getInt(Settings.LVLSHIELD_PREFERENCE, Character_Settings.getLvlshield()));
        Character_Settings.setLvlmag(sharedPreferences.getInt(Settings.LVLMAG_PREFERENCE, Character_Settings.getLvlmag()));
        Character_Settings.setLvlarmor(sharedPreferences.getInt(Settings.LVLARMOR_PREFERENCE, Character_Settings.getLvlarmor()));
        Foodff[0] = sharedPreferences.getInt(Settings.FOODF1_PREFERENCE, Character_Settings.getFoodf()[0]);
        Foodff[1] = sharedPreferences.getInt(Settings.FOODF2_PREFERENCE, Character_Settings.getFoodf()[1]);
        Foodff[2] = sharedPreferences.getInt(Settings.FOODF3_PREFERENCE, Character_Settings.getFoodf()[2]);
        Waterff[0] = sharedPreferences.getInt(Settings.WATER1_PREFERENCE, Character_Settings.getWaterr()[0]);
        Waterff[1] = sharedPreferences.getInt(Settings.WATER2_PREFERENCE, Character_Settings.getWaterr()[1]);
        Waterff[2] = sharedPreferences.getInt(Settings.WATER3_PREFERENCE, Character_Settings.getWaterr()[2]);
        Hillff[0] = sharedPreferences.getInt(Settings.HILL1_PREFERENCE, Character_Settings.getHill()[0]);
        Hillff[1] = sharedPreferences.getInt(Settings.HILL2_PREFERENCE, Character_Settings.getHill()[1]);
        Hillff[2] = sharedPreferences.getInt(Settings.HILL3_PREFERENCE, Character_Settings.getHill()[2]);
        setMenu(sharedPreferences.getInt(Settings.MENU_PREFERENCE, getMenu()));
        Gildia.setK(sharedPreferences.getBoolean(Settings.K, Gildia.isK()));
        Character_Settings.setS(sharedPreferences.getBoolean(Settings.S_PREFERENCE, Character_Settings.getS()));
        Home.setBoxcheked(sharedPreferences.getInt(Settings.BOXCHEKED, Home.getBoxcheked()));
        BossFight.setBossXitpoints(sharedPreferences.getInt(Settings.BOSS_XIT_POINTS, BossFight.getBossXitpoints()));
        Easyandmedium.setMob_xit_points(sharedPreferences.getInt(Settings.MOB_XIT_POINTS, Easyandmedium.getMob_xit_points()));
        Easyandmedium.setMob(sharedPreferences.getInt(Settings.MOB, Easyandmedium.getMob()));
        Easyandmedium.setMob_damage(sharedPreferences.getInt(Settings.MOB_DAMAGE, Easyandmedium.getMob_damage()));
        Character_Settings.setFoodd(Foodff);
        Settings.music = sharedPreferences.getBoolean(Settings.MUSIC, Settings.music);
        Character_Settings.setWaterr(Waterff);
        Character_Settings.setHill(Hillff);
        Character_Settings.setInventoryy(new ArrayList<>(sharedPreferences.getStringSet(Settings.INVENTORYY_PREFERENCE, set)));
        Snackbar.make(binding.save, getResources().getString(R.string.loadsave), Snackbar.LENGTH_SHORT).show();
        if (Character_Settings.getDamage() != 20) {
            strings.set(0,getResources().getString(R.string.sword) + Character_Settings.getLvlmech() + getResources().getString(R.string.lvl));
            strings.add(1,getResources().getString(R.string.nagr) + Character_Settings.getLvlarmor() + getResources().getString(R.string.lvl));
            strings.add(2,getResources().getString(R.string.boots) + Character_Settings.getLvlarmor() + getResources().getString(R.string.lvl));
            strings.add(3,getResources().getString(R.string.shield) + Character_Settings.getLvlshield() + getResources().getString(R.string.lvl));
            strings.add(4,getResources().getString(R.string.magagrt) + Character_Settings.getLvlmag() + getResources().getString(R.string.lvl));
            Character_Settings.setInventoryy(strings);
        }
    }
}