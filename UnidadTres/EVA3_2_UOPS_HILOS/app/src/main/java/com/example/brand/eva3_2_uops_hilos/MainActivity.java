package com.example.brand.eva3_2_uops_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        for (int i  = 0; i < 1000; i ++){
//            try{
//                Log.e("Aqui","arondo al usario");
//                Thread.sleep(20);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }
        MiConteo count = new MiConteo();
        count.start();

        MiConteo2 count2 = new MiConteo2();
        Thread hilo = new Thread(count2);
        hilo.start();
    }
}
