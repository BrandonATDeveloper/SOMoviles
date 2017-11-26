package com.example.brand.eva3_11_servicios_a;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    Intent intentF;
    boolean bandera = false;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        intentF = new Intent("MI_SERVICIOTE");
        intentF.putExtra("MI_MENSAJE", "MiServicio - Creado");
        sendBroadcast(intentF);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Thread thMiHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try{
                        intentF = new Intent("MI_SERVICIOTE");
                        intentF.putExtra("MI_MENSAJE", "MiServicio - Corriendo");
                        sendBroadcast(intentF);
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                    if (bandera)
                        break;
                }
            }
        };
        thMiHilo.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bandera = true;
    }
}
