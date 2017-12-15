package com.example.brand.eva3_9_banner_post;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    int img = 0;
    ImageView image;
    SeekBar sk;
    boolean destruir = false;
    int delay;
    Handler hnBanner = new Handler();
    Runnable rnUI = new Runnable() {
        @Override
        public void run() {
            banner();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView)findViewById(R.id.img);
        sk = (SeekBar)findViewById(R.id.seek);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                delay = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        delay = sk.getProgress();
        Runnable bannerTh = new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        hnBanner.post(rnUI);
                        Thread.sleep(1000 - delay*8);
                        if(destruir) break;
                    }catch(Exception e){}
                }
            }
        };
        Thread thHilo = new Thread(bannerTh);
        thHilo.start();
    }


    public void banner() {
        switch (img) {
            case 0:
                img++;
                image.setImageResource(R.drawable.f1);
                break;
            case 1:
                img++;
                image.setImageResource(R.drawable.f2);
                break;
            default:
                img = 0;
                image.setImageResource(R.drawable.f3);
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        destruir = true;
    }
}
