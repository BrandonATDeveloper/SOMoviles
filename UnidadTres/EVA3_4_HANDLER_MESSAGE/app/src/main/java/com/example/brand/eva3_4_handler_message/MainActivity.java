package com.example.brand.eva3_4_handler_message;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    boolean fin = false;
    Handler hnManejador = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            String sMensa = (String)msg.obj;
            int iWhat = msg.what;
            txt.append(iWhat + " - " + sMensa);
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
                        String sMensa = i + " - ";
                        Message msg = hnManejador.obtainMessage(1, sMensa);
                        hnManejador.sendMessage(msg);
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

