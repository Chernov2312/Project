package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.project.databinding.SettingsBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Settings extends Character_Settings {
    SettingsBinding binding;
    public final static String GOLDS_PREFERENCE = "golds";
    public final static String LEVEL_PREFERENCE = "level";
    public final static String XIT_POINTS_PREFERENCE = "xitpoints";
    public final static String MAXXITPOINTS_PREFERENCE = "maxxitpoints";
    public final static String FOOD_PREFERENCE = "food";
    public final static String BOXCHEKED = "boxcheked";
    public final static String WATER_PREFERENCE = "water";
    public final static String MAXMONEY_PREFERENCE = "maxmoney";
    public final static String kILLEDMOBS_PREFERENCE = "kelledmobs";
    public final static String TOTAL_MONEY_PREFERENCE = "totalmoney";
    public final static String DAMAGE_PREFERENCE = "damage";
    public final static String BLOCKDAMAGE_PREFERENCE = "blockdamage";
    public final static String LVLMECH_PREFERENCE = "lvlmech";
    public final static String LVLSHIELD_PREFERENCE = "lvlshield";
    public final static String LVLMAG_PREFERENCE = "lvlmag";
    public final static String LVLARMOR_PREFERENCE = "lvlarmor";
    public final static String BOSS_XIT_POINTS = "boss_xit_points";
    public final static String MENU_PREFERENCE = "menu";
    public static final String S_PREFERENCE = "s";
    public final static String INVENTORYY_PREFERENCE = "inventory";
    public final static String FOODF1_PREFERENCE = "foodf1";
    public final static String FOODF2_PREFERENCE = "foodf2";
    public final static String FOODF3_PREFERENCE = "foodf3";
    public final static String WATER1_PREFERENCE = "waterr1";
    public final static String WATER2_PREFERENCE = "waterr2";
    public final static String WATER3_PREFERENCE = "waterr3";
    public final static String HILL1_PREFERENCE = "hill1";
    public final static String HILL2_PREFERENCE = "hill2";
    public final static String HILL3_PREFERENCE = "hill3";
    public final static String MOB_XIT_POINTS = "mob_xit_points";
    public final static String MOB = "mob";
    public final static String MOB_DAMAGE = "mob_damage";
    public final static String MUSIC = "music";
    public static int[] Foodff = {0, 0, 0};
    public static int[] Waterff = {0, 0, 0};
    public static int[] Hillff = {0, 0, 0};
    public static boolean music = true;
    public static ArrayList<String>  strings= new ArrayList<>();
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.save.setOnClickListener(v -> {
            savePreference();
        });
        binding.music.setChecked(music);
        setM(2);
        intent = new Intent(Settings.this, MyService.class);
        startService(intent);
        binding.load.setOnClickListener(v -> {
            loadPreference();
            Snackbar.make(binding.load, getResources().getString(R.string.loadsave), Snackbar.LENGTH_SHORT).show();
            recreate();
        });
        binding.return32.setOnClickListener(v -> {
            Intent i = new Intent(Settings.this, Character_Settings.class);
            startActivity(i);
            finish();
        });
        binding.music.setOnClickListener(v -> {
            if (binding.music.isChecked()) {
                music = true;
                setM(2);
                startService(intent);
            } else {
                music = false;
                stopService(intent);
            }
        });
        if (binding.music.isChecked()) {
            music = true;
            setM(2);
            startService(intent);
        } else {
            music = false;
            stopService(intent);
        }
        binding.music.setChecked(music);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }

    public void loadPreference() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        setGolds(sharedPreferences.getInt(GOLDS_PREFERENCE, getGolds()));
        setLevel(sharedPreferences.getInt(LEVEL_PREFERENCE, getLevel()));
        setXit_points(sharedPreferences.getInt(XIT_POINTS_PREFERENCE, getXit_points()));
        setMaxXit_points(sharedPreferences.getInt(MAXXITPOINTS_PREFERENCE, getMaxXit_points()));
        setFood(sharedPreferences.getInt(FOOD_PREFERENCE, getFood()));
        setWater(sharedPreferences.getInt(WATER_PREFERENCE, getWater()));
        setMaxmoney(sharedPreferences.getInt(MAXMONEY_PREFERENCE, getMaxmoney()));
        setKilledmobs(sharedPreferences.getInt(kILLEDMOBS_PREFERENCE, getKilledmobs()));
        setTotal_money(sharedPreferences.getInt(TOTAL_MONEY_PREFERENCE, getTotal_money()));
        setDamage(sharedPreferences.getInt(DAMAGE_PREFERENCE, getDamage()));
        setBlockdamage(sharedPreferences.getInt(BLOCKDAMAGE_PREFERENCE, getBlockdamage()));
        setLvlmech(sharedPreferences.getInt(LVLMECH_PREFERENCE, getLvlmech()));
        setLvlshield(sharedPreferences.getInt(LVLSHIELD_PREFERENCE, getLvlshield()));
        setLvlmag(sharedPreferences.getInt(LVLMAG_PREFERENCE, getLvlmag()));
        setLvlarmor(sharedPreferences.getInt(LVLARMOR_PREFERENCE, getLvlarmor()));
        Foodff[0] = sharedPreferences.getInt(FOODF1_PREFERENCE, getFoodf()[0]);
        Foodff[1] = sharedPreferences.getInt(FOODF2_PREFERENCE, getFoodf()[1]);
        Foodff[2] = sharedPreferences.getInt(FOODF3_PREFERENCE, getFoodf()[2]);
        Waterff[0] = sharedPreferences.getInt(WATER1_PREFERENCE, getWaterr()[0]);
        Waterff[1] = sharedPreferences.getInt(WATER2_PREFERENCE, getWaterr()[1]);
        Waterff[2] = sharedPreferences.getInt(WATER3_PREFERENCE, getWaterr()[2]);
        Hillff[0] = sharedPreferences.getInt(HILL1_PREFERENCE, getHill()[0]);
        Hillff[1] = sharedPreferences.getInt(HILL2_PREFERENCE, getHill()[1]);
        Hillff[2] = sharedPreferences.getInt(HILL3_PREFERENCE, getHill()[2]);
        setMenu(sharedPreferences.getInt(MENU_PREFERENCE, getMenu()));
        setS(sharedPreferences.getBoolean(S_PREFERENCE, getS()));
        Home.setBoxcheked(sharedPreferences.getInt(BOXCHEKED, Home.getBoxcheked()));
        BossFight.setBossXitpoints(sharedPreferences.getInt(BOSS_XIT_POINTS, BossFight.getBossXitpoints()));
        Easyandmedium.setMob_xit_points(sharedPreferences.getInt(MOB_XIT_POINTS, Easyandmedium.getMob_xit_points()));
        Easyandmedium.setMob(sharedPreferences.getInt(MOB, Easyandmedium.getMob()));
        Easyandmedium.setMob_damage(sharedPreferences.getInt(MOB_DAMAGE, Easyandmedium.getMob_damage()));
        setFoodd(Foodff);
        music = sharedPreferences.getBoolean(MUSIC, music);
        setWaterr(Waterff);
        setHill(Hillff);
        strings.add(getResources().getString(R.string.sword) + Character_Settings.getLvlmech() + getResources().getString(R.string.lvl));
        strings.add(getResources().getString(R.string.nagr) + Character_Settings.getLvlarmor() + getResources().getString(R.string.lvl));
        strings.add(getResources().getString(R.string.boots) + Character_Settings.getLvlarmor() + getResources().getString(R.string.lvl));
        strings.add(getResources().getString(R.string.shield) + Character_Settings.getLvlshield() + getResources().getString(R.string.lvl));
        strings.add(getResources().getString(R.string.magagrt) + Character_Settings.getLvlmag() + getResources().getString(R.string.lvl));
    }

    private void savePreference() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putInt(GOLDS_PREFERENCE, getGolds());
        ed.putInt(MOB_DAMAGE, Easyandmedium.getMob_damage());
        ed.putInt(MOB, Easyandmedium.getMob());
        ed.putInt(MOB_XIT_POINTS, Easyandmedium.getMob_xit_points());
        ed.putInt(LEVEL_PREFERENCE, getLevel());
        ed.putInt(XIT_POINTS_PREFERENCE, getXit_points());
        ed.putInt(MAXXITPOINTS_PREFERENCE, getMaxXit_points());
        ed.putInt(FOOD_PREFERENCE, getFood());
        ed.putInt(WATER_PREFERENCE, getWater());
        ed.putInt(BOXCHEKED, Home.getBoxcheked());
        ed.putInt(MAXMONEY_PREFERENCE, getMaxmoney());
        ed.putInt(kILLEDMOBS_PREFERENCE, getKilledmobs());
        ed.putInt(TOTAL_MONEY_PREFERENCE, getTotal_money());
        ed.putInt(DAMAGE_PREFERENCE, getDamage());
        ed.putInt(BLOCKDAMAGE_PREFERENCE, getBlockdamage());
        ed.putBoolean(MUSIC, music);
        ed.putInt(LVLMECH_PREFERENCE, getLvlmech());
        ed.putInt(LVLSHIELD_PREFERENCE, getLvlshield());
        ed.putInt(LVLMAG_PREFERENCE, getLvlmag());
        ed.putInt(LVLARMOR_PREFERENCE, getLvlarmor());
        ed.putInt(FOODF1_PREFERENCE, getFoodf()[0]);
        ed.putInt(FOODF2_PREFERENCE, getFoodf()[1]);
        ed.putInt(FOODF3_PREFERENCE, getFoodf()[2]);
        ed.putInt(WATER1_PREFERENCE, getWaterr()[0]);
        ed.putInt(WATER2_PREFERENCE, getWaterr()[1]);
        ed.putInt(WATER3_PREFERENCE, getWaterr()[2]);
        ed.putInt(HILL1_PREFERENCE, getHill()[0]);
        ed.putInt(HILL2_PREFERENCE, getHill()[1]);
        ed.putInt(HILL3_PREFERENCE, getHill()[2]);
        ed.putInt(MENU_PREFERENCE, getMenu());
        ed.putInt(BOSS_XIT_POINTS, BossFight.getBossXitpoints());
        ed.putBoolean(S_PREFERENCE, getS());
        ed.apply();
        Snackbar.make(binding.save, getResources().getString(R.string.savesuccesfull), Snackbar.LENGTH_SHORT).show();
    }



    public static boolean isMusic() {
        return music;
    }

    public static void setMusic(boolean music) {
        Settings.music = music;
    }
}
