package com.example.brand.eva3_1_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Runnable rnMyRun = new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        Log.e("MI HILO", "MI MENSAJE");
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thMyThread = new Thread(rnMyRun);
        thMyThread.start();

        //THRAD
        Thread thMyThread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try{
                        Log.e("MI THREAD", "MI MENSAJE DESDE THREAD");
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
        thMyThread2.start();
    }
}
