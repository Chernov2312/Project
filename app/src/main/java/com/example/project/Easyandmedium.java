package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.project.databinding.LowandmediumBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Easyandmedium extends Character_Settings {
    LowandmediumBinding binding;
    static int mob_xit_points = -1;
    static int mob;
    static int mob_damage;
    int k;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LowandmediumBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        k = Home.Randomlut();
        if (mob_xit_points > 0 || mob_xit_points == -1) {
            binding.Return.setVisibility(View.INVISIBLE);
            binding.gonext.setVisibility(View.INVISIBLE);
        }
        if (getLevel() == 1 || getLevel() == 2 || getLevel() == 3) {
            k = 2;
            mob = 1;
        }
        if (k == 0 && mob_xit_points == -1) {
            mob = 0;
            mob_xit_points = 600;
            mob_damage = 60;
        } else if (k == 2 && mob_xit_points == -1) {
            mob_xit_points = 200;
            mob = 1;
            mob_damage = 20;
        } else if (k == 1 && mob_xit_points == -1) {
            mob_xit_points = 500;
            mob_damage = 25;
            mob = 2;
        } else if (k == 3 && mob_xit_points == -1) {
            mob_xit_points = 800;
            mob_damage = 65;
            mob = 3;
        }
        switch (mob) {
            case 0:
                binding.background.setBackgroundResource(R.drawable.hard);
                setM(10);
                break;
            case 1:
                binding.background.setBackgroundResource(R.drawable.easy);
                setM(9);
                break;
            case 2:
                binding.background.setBackgroundResource(R.drawable.medium);
                setM(9);
                break;
            case 3:
                binding.background.setBackgroundResource(R.drawable.hard2);
                setM(10);
                break;
        }
        binding.mob.setText(getResources().getString(R.string.monstxitpoints) + mob_xit_points);
        if(mob_xit_points < -1 || mob_xit_points == 0){
            binding.mob.setText(getResources().getString(R.string.winmonster));
            binding.attack.setVisibility(View.INVISIBLE);
            binding.gonext.setVisibility(View.VISIBLE);
            binding.Return.setVisibility(View.VISIBLE);
        }
        binding.fightxitPoints.setText(getResources().getString(R.string.your_xit_points) + getXit_points());
        binding.attack.setOnClickListener(v -> {
            mob_xit_points -= getDamage();
            setXit_points((int) (getXit_points() - mob_damage * (1 - (float) getBlockdamage() / 100)));
            binding.mob.setText(getResources().getString(R.string.monstxitpoints) + mob_xit_points);
            binding.fightxitPoints.setText(getResources().getString(R.string.your_xit_points) + Character_Settings.getXit_points());
            if (getXit_points() <= 0) {
                Intent i = new Intent(Easyandmedium.this, GameLose.class);
                startActivity(i);
                finish();
            }
            ArrayList<String> strings = getInventoryy();
            if (mob_xit_points <= 0) {
                setKilledmobs(getKilledmobs() + 1);
                binding.mob.setText(getResources().getString(R.string.winmonster));
                binding.attack.setVisibility(View.INVISIBLE);
                Snackbar.make(binding.attack, getResources().getString(R.string.yoursnaruppgrade), Snackbar.LENGTH_SHORT).show();
                int y = Home.Randomlut();
                if (y == 0) {
                    setLvlmech(getLvlmech() + 1);
                    setDamage(getDamage() + 15);
                    strings.set(0, getResources().getString(R.string.sword) + lvlmech + getResources().getString(R.string.lvl));
                } else if (y == 1) {
                    setLvlmag(getLvlmag() + 1);
                    setDamage(getDamage() + 10);
                    strings.set(4, getResources().getString(R.string.magagrt) + getLvlmag() + getResources().getString(R.string.lvl));
                } else if (y == 2) {
                    setBlockdamage(getBlockdamage() + 5);
                    setLvlshield(getLvlshield() + 1);
                    strings.set(3, getResources().getString(R.string.shield) + getLvlshield() + getResources().getString(R.string.lvl));
                } else if (y == 3) {
                    setLvlarmor(getLvlarmor() + 1);
                    setBlockdamage(getBlockdamage() + 10);
                    strings.set(2, getResources().getString(R.string.boots) + getLvlarmor() + getResources().getString(R.string.lvl));
                    strings.set(1, getResources().getString(R.string.nagr) + getLvlarmor() + getResources().getString(R.string.lvl));
                }
                setLevel(getLevel() + 1);
                setDamage(getDamage() + 15);
                setMaxXit_points(getMaxXit_points() + 20);
                setInventoryy(strings);
                if (mob == 0) {
                    setGolds(getGolds() + 500);
                    setTotal_money(getTotal_money() + 500);
                } else if (mob == 1) {
                    setGolds(getGolds() + 200);
                    setTotal_money(getTotal_money() + 200);
                } else if (mob == 2) {
                    setGolds(getGolds() + 350);
                    setTotal_money(getTotal_money() + 350);
                } else if (mob == 3) {
                    setGolds(getGolds() + 700);
                    setTotal_money(getTotal_money() + 700);
                }
                binding.Return.setVisibility(View.VISIBLE);
                binding.gonext.setVisibility(View.VISIBLE);
                this.invalidateOptionsMenu();
            }
        });
        intent = new Intent(Easyandmedium.this, MyService.class);
        startService(intent);
        setMenu(7);
        binding.person.setOnClickListener(v -> {
            Intent i = new Intent(Easyandmedium.this, Character_Settings.class);
            startActivity(i);
            finish();
        });
        binding.Return.setOnClickListener(v -> {
            Character_Settings.setWater(Character_Settings.getWater() - 4);
            Character_Settings.setFood(Character_Settings.getFood() - 2);
            if(Character_Settings.getFood() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            if(Character_Settings.getWater() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            Intent i = new Intent(Easyandmedium.this, Catacomb.class);
            startActivity(i);
            finish();
        });
        binding.gonext.setOnClickListener(v -> {
            mob_xit_points = -1;
            Character_Settings.setWater(Character_Settings.getWater() - 4);
            Character_Settings.setFood(Character_Settings.getFood() - 2);
            if(Character_Settings.getFood() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            if(Character_Settings.getWater() == 0) Character_Settings.setXit_points(Character_Settings.getXit_points() - 10);
            recreate();
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        switch (mob) {
            case 0:
                binding.background.setBackgroundResource(R.drawable.hard);
                setM(10);
                break;
            case 1:
                binding.background.setBackgroundResource(R.drawable.easy);
                setM(9);
                break;
            case 2:
                binding.background.setBackgroundResource(R.drawable.medium);
                setM(9);
                break;
            case 3:
                binding.background.setBackgroundResource(R.drawable.hard2);
                setM(10);
                break;}
    }

    public static int getMob_xit_points() {
        return mob_xit_points;
    }

    public static void setMob_xit_points(int mob_xit_points) {
        Easyandmedium.mob_xit_points = mob_xit_points;
    }

    public static int getMob() {
        return mob;
    }

    public static void setMob(int mob) {
        Easyandmedium.mob = mob;
    }

    public static int getMob_damage() {
        return mob_damage;
    }

    public static void setMob_damage(int mob_damage) {
        Easyandmedium.mob_damage = mob_damage;
    }

}
