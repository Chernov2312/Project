package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;


import com.example.project.databinding.CharacterSettingsBinding;

import java.util.ArrayList;

public class Character_Settings extends MainActivity {
    private CharacterSettingsBinding binding;
    Intent intent;
    private static String name_person = "";
    private static int golds = 1000;
    private static int inventory;
    private static int level = 1;
    private static int Xit_points = 100;
    private static int Mana = 1000;
    private static int maxXit_points = 100;
    private static int maxMana = 1000;
    private static int Food = 50;
    private static int Water = 60;
    private static int Maxmoney = 1000;
    private static int killedmobs = 0;
    private static int total_money = 1000;
    private static int[] foodf = {0, 0, 0};
    private static int[] waterr = {0, 0, 0};
    private static int[] hill = {4, 2, 3};
    public static int damage = 20000;
    public static int blockdamage = 10000;
    public static int lvlmech = 1;
    public static int lvlshield = 1;
    public static int lvlmag = 1;
    public static int lvlarmor = 1;
    private static final int mammaxxitpoints = 300;
    static boolean s = true;
    private static ArrayList<String> inventoryy = new ArrayList<>();
    {
        if (s)
            inventoryy.add(0, "Пусто");
        if (Xit_points > maxXit_points) Xit_points = maxXit_points;
        if (Food > 100) Food = 100;
        if (Water > 100) Water = 100;
        if(blockdamage > 90) blockdamage = 90;
        if(mammaxxitpoints < mammaxxitpoints) maxXit_points = mammaxxitpoints;
        s = false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CharacterSettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(2);
        intent = new Intent(Character_Settings.this, MyService.class);
        startService(intent);
        setInventory(0);
        if(Maxmoney < golds) Maxmoney = golds;
        binding.Return.setOnClickListener(v -> {
            if (getMenu() == 0) {
                Intent i = new Intent(Character_Settings.this, MainActivity.class);
                startActivity(i);
            } else if (getMenu() == 1) {
                Intent i = new Intent(Character_Settings.this, Startgame.class);
                startActivity(i);
            } else if (getMenu() == 2) {
                Intent i = new Intent(Character_Settings.this, Home.class);
                startActivity(i);
            } else if (getMenu() == 3) {
                Intent i = new Intent(Character_Settings.this, City.class);
                startActivity(i);
            } else if (getMenu() == 4) {
                Intent i = new Intent(Character_Settings.this, Shop.class);
                startActivity(i);
            } else if (getMenu() == 5) {
                Intent i = new Intent(Character_Settings.this, Gildia.class);
                startActivity(i);
            }
            else if (getMenu() == 6) {
                Intent i = new Intent(Character_Settings.this, BossFight.class);
                startActivity(i);
            }
            else if (getMenu() == 7) {
                Intent i = new Intent(Character_Settings.this, Easyandmedium.class);
                startActivity(i);
            }
        });
        binding.Inventory.setOnClickListener(v -> {
            Intent i = new Intent(Character_Settings.this, InventoryActivity.class);
            startActivity(i);
        });
        binding.achivments.setOnClickListener(v -> {
            Intent i = new Intent(Character_Settings.this, Achivments.class);
            startActivity(i);
        });
        binding.level.setText("Уровень: " + level);
        binding.xitPoints.setProgress(Xit_points);
        binding.Food.setProgress(Food);
        binding.water.setProgress(Water);
        binding.gold.setText("Gold: " + golds);
    }

    public static int getMaxmoney() {
        return Maxmoney;
    }

    public static void setMaxmoney(int maxmoney) {
        Maxmoney = maxmoney;
    }

    public static int getKilledmobs() {
        return killedmobs;
    }

    public static void setKilledmobs(int killedmobs) {
        Character_Settings.killedmobs = killedmobs;
    }

    public static int getTotal_money() {
        return total_money;
    }

    public static void setTotal_money(int total_money) {
        Character_Settings.total_money = total_money;
    }

    public static int[] getHill() {
        return hill;
    }

    public static void setHill(int[] hill) {
        Character_Settings.hill = hill;
    }

    public static int getLvlshield() {
        return lvlshield;
    }

    public static void setLvlshield(int lvlshield) {
        Character_Settings.lvlshield = lvlshield;
    }

    public static int getLvlmag() {
        return lvlmag;
    }

    public static void setLvlmag(int lvlmag) {
        Character_Settings.lvlmag = lvlmag;
    }

    public static boolean getS() {
        return s;
    }

    public static int getLvlarmor() {
        return lvlarmor;
    }

    public static void setLvlarmor(int lvlarmor) {
        Character_Settings.lvlarmor = lvlarmor;
    }

    public static int getLvlmech() {
        return lvlmech;
    }

    public static void setLvlmech(int lvlmech) {
        Character_Settings.lvlmech = lvlmech;
    }

    public static void setFoodf(int[] foodf) {
        Character_Settings.foodf = foodf;
    }


    public static int getDamage() {
        return damage;
    }

    public static void setDamage(int damage) {
        Character_Settings.damage = damage;
    }

    public static int getBlockdamage() {
        return blockdamage;
    }

    public static void setBlockdamage(int blockdamage) {
        Character_Settings.blockdamage = blockdamage;
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }

    public static void setS(boolean s) {
        Character_Settings.s = s;
    }

    public static int getMaxXit_points() {
        return maxXit_points;
    }

    public static void setMaxXit_points(int maxXit_points) {
        Character_Settings.maxXit_points = maxXit_points;
    }

    public static int getMaxMana() {
        return maxMana;
    }

    public static void setMaxMana(int maxMana) {
        Character_Settings.maxMana = maxMana;
    }

    public static ArrayList<String> getInventoryy() {
        return inventoryy;
    }

    public static void setInventoryy(ArrayList<String> inventoryy) {
        Character_Settings.inventoryy = inventoryy;
    }

    public static int getFood() {
        return Food;
    }

    public static void setFood(int food) {
        Food = food;
    }

    public static int getWater() {
        return Water;
    }

    public static void setWater(int water) {
        Water = water;
    }

    public static int getInventory() {
        return inventory;
    }

    public static void setInventory(int inventory) {
        Character_Settings.inventory = inventory;
    }

    public static String getName_person() {
        return name_person;
    }

    public static void setName_person(String name_person) {
        Character_Settings.name_person = name_person;
    }

    public static int getGolds() {
        return golds;
    }

    public static void setGolds(int golds2) {
        golds = golds2;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level2) {
        level = level2;
    }

    public static int getXit_points() {
        return Xit_points;
    }

    public static void setXit_points(int Xit_points2) {
        Xit_points = Xit_points2;
    }

    public static int getMana() {
        return Mana;
    }

    public static void setMana(int mana2) {
        Mana = mana2;
    }

    public static int[] getFoodf() {
        return foodf;
    }

    public static int[] getWaterr() {
        return waterr;
    }

    public static void setFoodd(int[] foodd) {
        Character_Settings.foodf = foodd;
    }

    public static void setWaterr(int[] waterr) {
        Character_Settings.waterr = waterr;
    }

}
