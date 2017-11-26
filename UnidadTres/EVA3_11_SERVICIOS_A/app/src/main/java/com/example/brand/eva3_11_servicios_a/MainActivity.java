package com.example.brand.eva3_11_servicios_a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent intServicios;
    Button btn;
    TextView txt;
    BroadcastReceiver bcrMyBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView)findViewById(R.id.txt);
        intServicios = new Intent(this, MyService.class);
        startService(intServicios);
        IntentFilter intentFilter = new IntentFilter("MI_SERVICIOTE");
        bcrMyBroadcast = new myBroadcastReceiver();
        registerReceiver(bcrMyBroadcast, intentFilter);
    }

    public void onClick(View v){
        try {
            stopService(intServicios);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public class myBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String sCade = intent.getStringExtra("MI_MENSAJE");
            txt.append(sCade + "\n");
        }
    }

}
