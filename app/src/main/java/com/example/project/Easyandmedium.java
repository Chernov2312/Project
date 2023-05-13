package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.project.databinding.LowandmediumBinding;

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
        binding.mob.setText("Кол-во жизни у монстра: " + mob_xit_points);
        if(mob_xit_points < -1 || mob_xit_points == 0){
            binding.mob.setText("Вы победили этого монстра");
            binding.attack.setVisibility(View.INVISIBLE);
            binding.gonext.setVisibility(View.VISIBLE);
            binding.Return.setVisibility(View.VISIBLE);
        }
        binding.attack.setOnClickListener(v -> {
            mob_xit_points -= getDamage();
            setXit_points((int) (getXit_points() - mob_damage * (1 - (float) getBlockdamage() / 100)));
            binding.mob.setText("Кол-во жизни у монстра: " + mob_xit_points);
            if (getXit_points() <= 0) {
                Intent i = new Intent(Easyandmedium.this, GameLose.class);
                startActivity(i);
            }
            ArrayList<String> strings = getInventoryy();
            if (mob_xit_points <= 0) {
                setKilledmobs(getKilledmobs() + 1);
                binding.mob.setText("Вы победили этого монстра");
                binding.attack.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),
                        "Ваше снаряжение улучшенно", Toast.LENGTH_SHORT).show();
                int y = Home.Randomlut();
                if (y == 0) {
                    setLvlmech(getLvlmech() + 1);
                    setDamage(getDamage() + 15);
                    strings.set(0, "Короткий меч " + lvlmech + "lvl");
                } else if (y == 1) {
                    setLvlmag(getLvlmag() + 1);
                    setDamage(getDamage() + 10);
                    strings.set(4, "Магический артефакт " + getLvlmag() + "lvl");
                } else if (y == 2) {
                    setBlockdamage(getBlockdamage() + 5);
                    setLvlshield(getLvlshield() + 1);
                    strings.set(3, "Круглый щит " + getLvlshield() + "lvl");
                } else if (y == 3) {
                    setLvlarmor(getLvlarmor() + 1);
                    setBlockdamage(getBlockdamage() + 10);
                    strings.set(2, "Кожаные сапоги " + getLvlarmor() + "lvl");
                    strings.set(1, "Нагрудник из кольчуги " + getLvlarmor() + "lvl");
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
        binding.person.setOnClickListener(v -> {
            setMenu(7);
            Intent i = new Intent(Easyandmedium.this, Character_Settings.class);
            startActivity(i);
        });
        binding.Return.setOnClickListener(v -> {
            Intent i = new Intent(Easyandmedium.this, Catacomb.class);
            startActivity(i);
        });
        binding.gonext.setOnClickListener(v -> {
            mob_xit_points = -1;
            recreate();
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
