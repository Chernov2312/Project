package com.example.project;

import static com.example.project.MainActivity.getM;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    private MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        if(getM()==1){player = MediaPlayer.create(this, R.raw.music_menu);}
        else if(getM()==2){player = MediaPlayer.create(this, R.raw.inventory2);}
        else if(getM()==3){ player = MediaPlayer.create(this, R.raw.pech);}
        else if(getM()==4){ player = MediaPlayer.create(this, R.raw.feld);}
        else if(getM()==5){ player = MediaPlayer.create(this, R.raw.gorod);}
        else if(getM()==6){ player = MediaPlayer.create(this, R.raw.magazin);}
        else if(getM()==7){ player = MediaPlayer.create(this, R.raw.bar);}
        else if(getM()==8){ player = MediaPlayer.create(this, R.raw.catacomb);}
        else if(getM()==9){ player = MediaPlayer.create(this, R.raw.slab);}
        else if(getM()==10){ player = MediaPlayer.create(this, R.raw.bigmonstr);}
        else if(getM()==11){ player = MediaPlayer.create(this, R.raw.bossfight);}
        else if(getM()==12){ player = MediaPlayer.create(this, R.raw.loose);}
        else if(getM()==13){ player = MediaPlayer.create(this, R.raw.bossdie);}
        if (player.isPlaying()) player.stop();
        player.setLooping(true);
        player.start();
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player.isPlaying()) player.stop();
    }
}