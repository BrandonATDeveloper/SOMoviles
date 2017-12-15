package com.example.brand.eva3_12_media_player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaReproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaReproductor = MediaPlayer.create(getApplicationContext(), R.raw.diehouse);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mediaReproductor != null) {
            mediaReproductor.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaReproductor != null) {
            mediaReproductor.stop();
            mediaReproductor.release();
        }

    }
}
