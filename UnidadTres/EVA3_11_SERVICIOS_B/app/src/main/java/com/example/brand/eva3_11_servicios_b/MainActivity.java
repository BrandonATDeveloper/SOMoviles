package com.example.brand.eva3_11_servicios_b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        IntentFilter intentFilter = new IntentFilter("MI_SERVICIOTE");
        bcrMyBroadcast = new myBroadcastReceiver();
        registerReceiver(bcrMyBroadcast, intentFilter);
    }

    public class myBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String sCade = intent.getStringExtra("MI_MENSAJE");
            txt.append(sCade + "\n");
        }
    }

}
