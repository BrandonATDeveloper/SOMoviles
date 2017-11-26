package com.example.brand.eva3_5_post;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    boolean fin = false;
    String sMensa;
    Handler hnMensaje = new Handler();
    Runnable rnUI = new Runnable() {
        @Override
        public void run() {
            txt.append(sMensa);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.txt);
        Runnable rnDatos = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(true){
                    try{
                        //txt.append(i + " - ");
                        sMensa = i + " - ";
                        hnMensaje.post(rnUI);
                        Log.e("HILO", "STILL WORKING");
                        Thread.sleep(1000);
                        i++;
                        if (fin){
                            break;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thHilo = new Thread(rnDatos);
        thHilo.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        fin = true;
    }
}
