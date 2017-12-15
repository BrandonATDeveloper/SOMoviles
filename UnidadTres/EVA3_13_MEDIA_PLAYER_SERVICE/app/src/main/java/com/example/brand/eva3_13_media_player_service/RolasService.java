package com.example.brand.eva3_13_media_player_service;

/**
 * Created by Brand on 13/12/2017.
 */

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class RolasService extends Service {

    MediaPlayer mediaReproductor;

    public RolasService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaReproductor = MediaPlayer.create(getApplicationContext(), R.raw.diehouse);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (mediaReproductor != null) {
            mediaReproductor.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaReproductor != null) {
            mediaReproductor.stop();
            mediaReproductor.release();
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}