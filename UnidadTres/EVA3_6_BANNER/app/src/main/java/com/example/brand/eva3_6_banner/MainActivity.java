package com.example.brand.eva3_6_banner;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    int iNoImg = 0;
    Handler hnBanner = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (iNoImg){
                case 0:
                    img.setImageResource(R.drawable.f1);
                    iNoImg++;
                    break;
                case 1:
                    img.setImageResource(R.drawable.f2);
                    iNoImg++;
                    break;
                case 2:
                    img.setImageResource(R.drawable.f3);
                    iNoImg = 0;
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.imageView);
        Thread thMiHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try{
                        Message msg = hnBanner.obtainMessage();
                        hnBanner.sendMessage(msg);
                        Thread.sleep(700);
                    }catch (InterruptedException e){
                    }
                }
            }
        };
        thMiHilo.start();
    }
}
