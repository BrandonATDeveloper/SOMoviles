package com.example.brand.eva3_3_oups_hilos2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView)findViewById(R.id.textView);
        txt.setText("");
        Runnable rnDatos = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(true){
                    try{
                        txt.append(i + " - ");
                        Thread.sleep(1000);
                        i++;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thHilo = new Thread(rnDatos);
        thHilo.start();
    }
}
