package com.example.brand.eva3_2_uops_hilos;

import android.util.Log;

/**
 * Created by Brand on 31/10/2017.
 */

public class MiConteo extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++){
            try{
                Log.e("Aqui", "Atorando al Usuario");
                Thread.sleep(20);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
